package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.BaseAction;
import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.utils.Security;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 14-8-19.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/support")
public class SupportAction extends BaseAction {

    private String ueditorConfig;
    private File _img;
    private String _imgFileName;
    private String _imgContentType;
    private String imgPath;
    private String message;
    private int x = -1;
    private int y = -1;
    private int width = -1;
    private int height = -1;

    /*==========================验证码支持=============================*/

    private  ByteArrayInputStream securityStream;


    public String securityImage(){
        String securityCode = Security.createSecurityCode(5, Security.SecurityCodeLevel.Hard);
        BufferedImage bufferedImage = Security.createSecurityBufferedImage(securityCode);
        securityStream = Security.convertBufferedImage(bufferedImage);
        ServletActionContext.getRequest().getSession().setAttribute("security", securityCode);
        return SUCCESS;
    }
    /*=========================图片上传==============================*/
    /**
     * 存储上传的图片，每个月换一次文件夹，返回url
     * @return
     */
    @Action(value = "uploadImage",
            results = {@Result(name = SUCCESS, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"}),
                                @Result(name = FORM_ERROR, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"}),
                                @Result(name = ERROR, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"})})
    public String uploadImage(){
        try {
        String imageForm = _imgFileName.substring(_imgFileName.lastIndexOf(".")+1);
        if (!Arrays.asList(Configuration.getImageForm().split(",")).contains(imageForm)){
            jsonMap.put("msg", "上传格式错误");
            jsonMap.put(JSON_STATUS_HEADER, false);
            return FORM_ERROR;
        }
        String path = getImagePath(_imgFileName);
        if (path==null)
            return null;
            FileUtils.copyFile(_img, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
        jsonMap.put("msg", imgPath);
        jsonMap.put(JSON_STATUS_HEADER, true);
        return SUCCESS;
    }
    /*==============================截图支持=====================================*/
    @Action(value = "imageShot",
            results = {@Result(name = SUCCESS, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"}),
                    @Result(name = FAILURE, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"}),
                    @Result(name = ERROR, type = JSON, params = {"contentType", "text/html", "root", "jsonMap"})})
    public String imageShot(){
        ImageInputStream imageInput = null;
        try {
            if (imgPath==null){
                jsonMap.put("msg", "路径不正确");
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FAILURE;
            }
            String imageForm = imgPath.substring(imgPath.lastIndexOf(".")+1);
            if (!Arrays.asList(Configuration.getImageForm().split(",")).contains(imageForm)){
                jsonMap.put("msg", "上传格式错误");
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FAILURE;
            }
            String imagePath = ServletActionContext.getServletContext().getRealPath(imgPath);
            File imageFile = new File(imagePath);
            if (x==-1 || y==-1 || width==-1 || height==-1 ||!imageFile.exists()){
                jsonMap.put("msg", "上传数据失误");
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FAILURE;
            }
            ImageReader reader = ImageIO.getImageReadersByFormatName(imageForm).next();
            imageInput = ImageIO.createImageInputStream(imageFile);
            reader.setInput(imageInput, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Dimension dimension = param.getSourceRenderSize();
            double sWidth = dimension.getWidth();
            double sHeight = dimension.getHeight();
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            BufferedImage buffer = reader.read(0, param);
            String path = getImagePath(imgPath);
            ImageIO.write(buffer, imageForm, new File(path));
            jsonMap.put("url", imgPath);
            jsonMap.put("width", sWidth);
            jsonMap.put("height", sHeight);
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }finally {
            if (imageInput!=null)
                try {
                    imageInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    jsonMap.put(JSON_STATUS_HEADER, ERROR);
                    return ERROR;
                }
        }
    }

    /*==============================获取保存图片的路径=====================================*/
    public String getImagePath(String imageFileName){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String basePath = ServletActionContext.getServletContext().getRealPath("/images/upload");
        String datePath = format.format(new Date());
        File direction = new File(basePath+"/"+datePath);
        if (!direction.exists()){
            direction.mkdirs();
        }
        String name = UUID.randomUUID().toString() + imageFileName.substring(imageFileName.lastIndexOf("."));
        imgPath = "/images/upload/"+datePath +"/"+ name;
        return basePath +"/"+ datePath +"/"+ name;
    }

    /*==============================get/set=====================================*/

    public File get_img() {
        return _img;
    }

    public void set_img(File _img) {
        this._img = _img;
    }

    public String get_imgFileName() {
        return _imgFileName;
    }

    public void set_imgFileName(String _imgFileName) {
        this._imgFileName = _imgFileName;
    }

    public String get_imgContentType() {
        return _imgContentType;
    }

    public void set_imgContentType(String _imgContentType) {
        this._imgContentType = _imgContentType;
    }

    public String getUeditorConfig() {
        return ueditorConfig;
    }

    public void setUeditorConfig(String ueditorConfig) {
        this.ueditorConfig = ueditorConfig;
    }

    public ByteArrayInputStream getSecurityStream() {
        return securityStream;
    }

    public void setSecurityStream(ByteArrayInputStream inputStream) {
        this.securityStream = inputStream;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
