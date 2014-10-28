package com.mx.popcorn.controller.web;

import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.utils.Security;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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
public class SupportAction extends ActionSupport {

    private String ueditorConfig;
    private File _img;
    private String _imgFileName;
    private String _imgContentType;
    private String imgPath;
    private String message;
    private int x;
    private int y;
    private int width;
    private int height;

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
    public String uploadImage(){
        System.out.println("======================_img");
        String imageForm = _imgFileName.substring(_imgFileName.lastIndexOf(".")+1);
        if (!Arrays.asList(Configuration.getImageForm().split(",")).contains(imageForm))
            return "imageFormError";
        String path = getImagePath();
        if (path==null)
            return null;
        try {
            FileUtils.copyFile(_img, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==========================imgPath");
        return SUCCESS;
    }
    /*==============================截图支持=====================================*/
    public String imageShot(){
        ImageInputStream imageInput = null;
        try {
            String imageForm = _imgFileName.substring(_imgFileName.lastIndexOf(".")+1);
            if (!Arrays.asList(Configuration.getImageForm().split(",")).contains(imageForm))
                return "imageFormError";
            ImageReader reader = ImageIO.getImageReadersByFormatName(imageForm).next();
            imageInput = ImageIO.createImageInputStream(_img);
            reader.setInput(imageInput, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            BufferedImage buffer = reader.read(0, param);
            String path = getImagePath();
            ImageIO.write(buffer, imageForm, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (imageInput!=null)
                try {
                    imageInput.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println("------------------------end-------------------------");
        return null;
    }

    /*==============================获取保存图片的路径=====================================*/
    public String getImagePath(){
        if (_img==null)
            return null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String basePath = ServletActionContext.getServletContext().getRealPath("/images/upload");
        String datePath = format.format(new Date());
        File direction = new File(basePath+"/"+datePath);
        if (!direction.exists()){
            direction.mkdirs();
        }
        String name = UUID.randomUUID().toString() + _imgFileName.substring(_imgFileName.lastIndexOf("."));
        imgPath = "/images/upload/"+datePath +"/"+ name;
        System.out.println("======imgPath========="+imgPath);
        return basePath +"/"+ datePath +"/"+ name;
    }
    /*==============================测试=====================================*/
    public String textUI(){
        return SUCCESS;
    }

    public String text(){
        System.out.println("=====================text running");
        return SUCCESS;
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
