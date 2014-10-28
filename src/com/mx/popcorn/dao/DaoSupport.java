package com.mx.popcorn.dao;

import com.mx.popcorn.domain.Page;
import com.mx.popcorn.exception.DaoException;
import com.mx.popcorn.utils.QueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 14-8-17.
 */
public interface DaoSupport<T> {

    /**
     * 保存
     * @param t
     */
    void save(T t) throws DaoException;

    /**
     * 删除，只是将exist字段改为0
     * @param id
     */
    @Deprecated
    void delete(Serializable id) throws DaoException;

    /**
     * 更新
     * @param t
     */
    void update(T t) throws DaoException;

    /**
     * 通过辅助类更新
     * @param helper
     */
    void update(QueryHelper helper) throws DaoException;

    /**
     * 通过id查找
     * @param id
     */
    T getById(Serializable id) throws DaoException;
    /**
     *
     * @param helper 辅助类
     * @param cacheable 是否缓存
     * @return
     */
    List find(QueryHelper helper, boolean cacheable) throws DaoException;
    /**
     *
     * @param helper
     * @param cacheable
     * @return
     */
    Object findUnique(QueryHelper helper, boolean cacheable) throws DaoException;
    /**
     * 物理上的删除
     * @param id
     */
    void absoluteDelete(Serializable id) throws DaoException;

    /**
     * 分页接口
     * @param pageNum
     * @param helper
     * @param pageSize
     * @return
     */
    Page getPage(int pageNum, QueryHelper helper, int pageSize) throws DaoException;

    /**
     * 数值自减1
     * @param id
     * @param clause
     */
    void autoDecrease(Serializable id, String clause) throws DaoException;

    /**
     * 得到记录数量
     * @param helper
     * @return
     */
    int getCount(QueryHelper helper) throws DaoException;


}
