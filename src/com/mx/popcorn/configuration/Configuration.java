package com.mx.popcorn.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 14-9-4.
 */
public class Configuration {

    /*=============================分页参数==============================*/
    private static int pageNavigate;
    private static int hotShowingMovieNumOfIndex;
    private static int newMovieNumOnCinema;

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
            hotShowingMovieNumOfIndex = Integer.parseInt(prop.getProperty("hotShowingMovieNumOfIndex"));
            newMovieNumOnCinema = Integer.parseInt(prop.getProperty("newMovieNumOnCinema"));

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

    public static int getNewMovieNumOnCinema() {
        return newMovieNumOnCinema;
    }

    public static int getHotShowingMovieNumOfIndex() {
        return hotShowingMovieNumOfIndex;
    }

    public static String getImageForm() {
        return imageForm;
    }

    public static int getPageNavigate() {
        return pageNavigate;
    }
}
