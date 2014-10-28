package com.mx.popcorn.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 14-9-4.
 */
public class Configuration {

    /*=============================分页参数==============================*/

    /*=============================类型参数定义=============================*/

    /*=============================图片格式支持==============================*/
    private static String imageForm;

    static {
        InputStream input = null;
        try{
            Properties prop = new Properties();
            input = Configuration.class.getClassLoader().getResourceAsStream("default.properties");
            prop.load(input);

            imageForm =prop.getProperty("imageForm");

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if (input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static String getImageForm() {
        return imageForm;
    }
}
