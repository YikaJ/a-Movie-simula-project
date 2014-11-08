package com.mx.popcorn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        return content.length()<size
                ? content
                : content.substring(0, size)+"···";
    }

    public static String simpleSubstring(String content, int begin, int end){
        return content.length()<=(end - begin)
                ?content.substring(begin, content.length()-begin)
                : content.substring(begin, end - begin);
    }

    public static Date getSpecialTime(Date date, int scope){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + scope);
        return calendar.getTime();
    }

    public static String getSpecialDate(Date date, String formatString) throws ParseException {
        //EEEE格式化为星期数
        SimpleDateFormat format  = new SimpleDateFormat(formatString);
        return format.format(date);
    }

    public static Date getSpecialFormToDate(Date date) throws ParseException {
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(format.format(date));
    }

}
