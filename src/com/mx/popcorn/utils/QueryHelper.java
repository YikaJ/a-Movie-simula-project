package com.mx.popcorn.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 辅助拼接HQL语句的工具类
 * Created by Administrator on 14-9-3.
 */
public class QueryHelper {

    //Form子句
    private String headClause;
    //Update子句
    private String setClause = "";
    //Where子句
    private String whereClause = "";
    //OrderBy子句
    private String orderByClause = "";
    //参数列表
    private List<Object> params = new ArrayList<Object>();

    private String type = " FROM ";

    public static String UPDATE = " UPDATE ";
    public static String SELECT = " FROM ";


    public QueryHelper(Class clazz, String alias){
        headClause = " FROM " + clazz.getSimpleName() + " " + alias;
    }

    public QueryHelper(Class clazz, String type, String alias){
        this.type = type;
        if (type.equals(QueryHelper.SELECT)){
            headClause = " FROM " + clazz.getSimpleName() + " " + alias;
        }else {
            this.type = QueryHelper.UPDATE;
            headClause = " UPDATE " + clazz.getSimpleName() + " " + alias;
        }
    }

    /**
     * 拼接where子句
     * @param propertyName
     * @param param
     * @return
     */
    public QueryHelper addWhereClause(String propertyName, Object param){
        if (whereClause.equals("")){
            whereClause = " WHERE " + propertyName + " =? ";
        }else {
            whereClause += " AND " + propertyName + " =? ";
        }
        if (param != null){
            params.add(param);
        }
        return this;
    }

    /**
     * 拼接between子句
     * @param propertyName
     * @param param1
     * @param param2
     * @return
     */
    public QueryHelper addWhereClause(String propertyName, Object param1, Object param2){
        if (whereClause.equals("")){
            whereClause = " WHERE " + propertyName + " BETWEEN ? AND ? ";
        }else {
            whereClause += " AND " + propertyName + " BETWEEN ? AND ? ";
        }
        if (param1 != null){
            params.add(param1);
        }
        if (param2 != null){
            params.add(param2);
        }
        return this;
    }

    /**
     * 拼接特殊条件的where子句
     * @param condition
     * @return
     */
    public QueryHelper addWhereClause(String condition){
        if (whereClause.equals("")){
            whereClause = " WHERE " + condition;
        }else{
            whereClause += " AND " + condition;
        }
        return this;
    }

    /**
     * 拼接order by子句
     * @param propertyName
     * @param asc
     * @return
     */
    public QueryHelper addOrderByClause(String propertyName, boolean asc){
        if (orderByClause.equals("")){
            orderByClause = " ORDER BY " + propertyName + (asc? " ASC " : " DESC ");
        }else {
            orderByClause += " , " + propertyName + (asc? " ASC " : " DESC ");
        }
        return this;
    }

    /**
     * 拼接set子句
     * @param propertyName
     * @param param
     * @return
     */
    public QueryHelper addSetClause(String propertyName, Object param){
        if (setClause.equals("")){
            setClause = " SET " + propertyName + " =? ";
        }else{
            setClause += ", " + propertyName + " =? ";
        }
        if (param!=null)
            params.add(param);
        return this;
    }

    /**
     * 条件拼接set子句
     * @param condition
     * @param propertyName
     * @param param
     * @return
     */
    public QueryHelper addSetClause(boolean condition, String propertyName, Object param){
        if (!condition)
            return this;
        else if (setClause.equals("")){
            setClause = " SET " + propertyName + " =? ";
        }else{
            setClause += ", " + propertyName + " =? ";
        }
        if (param!=null)
            params.add(param);
        return this;
    }

    /**
     * 获得查询总记录的HQL语句（没有order by）
     * @return
     */
    public String getQueryCountHql(){
        return " SELECT COUNT(*) " + headClause + whereClause;
    }

    /**
     * 获得查询的HQL语句
     * @return
     */
    public String getQueryHql(){
        if (type.equals(QueryHelper.SELECT)){
            return headClause + whereClause + orderByClause;
        }else{
            return headClause + setClause + whereClause;
        }

    }

    /**
     * 获得参数列表
     * @return
     */
    public List<Object> getParams() {
        return params;
    }

    public String getType() {
        return type;
    }
}
