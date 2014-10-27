package com.mx.popcorn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 14-9-12.
 */
public class WebUtils {

    public static String contentSubstring(String content, int size){
        Pattern pattern = Pattern.compile("<[^>]+>|&nbsp");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        if(content.length()<size)
            return content;
        return content.substring(0, size)+"···";
    }

}
