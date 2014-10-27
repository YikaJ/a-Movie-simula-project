package com.mx.popcorn.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 14-8-18.
 */
public class Security {

    /**
     * simple 只有数字的验证码
     * medium 有数字和小写字母的验证码
     * hard 数字和大小写字母的验证码
     */
    public static enum SecurityCodeLevel{Simple, Medium, Hard};

    /**
     * 字体集
     */
    private static int fontSize = 25;

    private static int[] colors = {0X990066, 0XFF6600, 0X333333, 0XFF6600, 0X99CC00, 0X009966, 0X003366,0X663300 };

    private static char[] securityCodes={'0','1','2','3','4','5','6','7','8','9',
                                                        'a','b','c','d','e','f','g','h','i',
                                                        'j','k','l','m','n','o','p','q','r','s','t',
                                                        'u','v','w','x','y','z','A','B','C',
                                                        'D','E','F','G','H','I','J','K','L',
                                                        'M','N','O','P','Q','R','S','T','U','V',
                                                        'W','X','Y','Z'};


    /**
     * 创建随机验证码
     * @param length
     * @param level
     * @return
     */
    public static String createSecurityCode(int length, SecurityCodeLevel level){
        char[] codes;
        if (level== SecurityCodeLevel.Simple){
            codes = Arrays.copyOfRange(securityCodes, 0, 10);
        }else if (level== SecurityCodeLevel.Medium){
            codes = Arrays.copyOfRange(securityCodes, 0, 37);
        }else{
            codes = securityCodes;
        }
        int codesLength = codes.length;
        StringBuffer codeString = new StringBuffer();

        for (int i = 0 ; i< length; i++){
            char codeChar = codes[new Random().nextInt(codesLength)];
            codeString.append(codeChar);
        }

        return codeString.toString();
    }


    /**
     * 将验证码转换为BufferedImage
     * @param codeString
     * @return
     */
    public static BufferedImage createSecurityBufferedImage(String codeString){
        Random random = new Random();

        //验证码长度
        int codeLength = codeString.length();

        //图片宽度
        int imgWidth = codeLength * fontSize + 6 ;
        //图片高度
        int imgHeight =  fontSize + 5;

        //图片
        BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        //画笔
        Graphics2D graphics = image.createGraphics();

        //绘制背景
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, imgWidth, imgHeight);

        //绘制噪点
        graphics.setColor(new Color(0X003366));
        for(int i = 0; i<20; i++){
            int x =random.nextInt(imgWidth);
            int y = random.nextInt(imgHeight);
            int x1 = random.nextInt(imgWidth);
            int y1 = random.nextInt(imgHeight);
            graphics.drawLine(x, y, x1, y1);
        }

        Font font;
        //获得字体
        try {
            font = Font.createFont(0, Security.class.getClassLoader().getResourceAsStream("AccoladeShadow-Italic.ttf")).deriveFont(Font.PLAIN, fontSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        graphics.setColor(Color.BLACK);
        graphics.setFont(font);
        for(int i = 0; i<codeLength; i++){
            graphics.setColor(new Color(colors[random.nextInt(colors.length)]));
            graphics.drawString(String.valueOf(codeString.charAt(i)), i*fontSize+2, fontSize-2);
        }
        graphics.dispose();
        return image;
    }

    /**
     * 将BufferedImage转换为ByteArrayInputStream
     * @param bufferedImage
     * @return
     */
    public static ByteArrayInputStream convertBufferedImage(BufferedImage bufferedImage){
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(outputStream);
        try {
            jpegEncoder.encode(bufferedImage);
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }

}
