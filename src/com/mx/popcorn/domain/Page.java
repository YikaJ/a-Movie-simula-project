package com.mx.popcorn.domain;



import com.mx.popcorn.configuration.Configuration;

import java.util.List;

/**
 * Created by Administrator on 14-8-17.
 */
public class Page {

    //配置参数
    private int currentPage;
    private int pageSize;
    //查询数据库
    private int recordCount;
    private List recordList;
    //计算得出
    private int pageCount;
    private int beginIndex;
    private int endIndex;



    /**
     *
     * @param currentPage    显示第几页
     * @param pageSize       一页显示几条
     * @param recordCount     总共多少记录
     * @param recordList     一页显示的数据
     */
    public Page(int currentPage, int pageSize, int recordCount, List recordList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        this.recordList = recordList;

        pageCount = (recordCount + pageSize - 1) / pageSize;

        if (pageCount <= Configuration.getPageNavigate()){
            beginIndex = 1;
            endIndex = pageCount;
        }else if (currentPage <= Configuration.getPageNavigate()/2){
            beginIndex = 1;
            endIndex = Configuration.getPageNavigate();
        }else if (currentPage + Configuration.getPageNavigate()/2 > pageCount){
            beginIndex = pageCount - (Configuration.getPageNavigate() - 1);
            endIndex = pageCount;
        }else {
            beginIndex = currentPage - Configuration.getPageNavigate()/2;
            endIndex = currentPage + Configuration.getPageNavigate()/2;
        }

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public List getRecordList() {
        return recordList;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
