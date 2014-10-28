package com.mx.popcorn.dao.imp;

import com.mx.popcorn.dao.DaoSupport;
import com.mx.popcorn.domain.Page;
import com.mx.popcorn.exception.DaoException;
import com.mx.popcorn.utils.QueryHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 14-8-17.
 */
public class DaoSupportImp<T> implements DaoSupport<T> {

    @Resource
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public DaoSupportImp() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T t) throws DaoException {
        getSession().save(t);
    }


    @Override
    @Deprecated
    public void delete(Serializable id)  throws DaoException{
        getSession().createSQLQuery("delete from "+clazz.getSimpleName()+" where id = ?")
                .setParameter(0, id)
                .executeUpdate();
    }

    @Override
    public void update(T t) throws DaoException {
        getSession().update(t);
    }

    @Override
    public void update(QueryHelper helper)  throws DaoException{
        List<Object> params = helper.getParams();
        Query query = getSession().createQuery(helper.getQueryHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        query.executeUpdate();
    }

    @Override
    public T getById(Serializable id)  throws DaoException{
        if (id==null)
            return null;
        return (T) getSession().load(clazz, id);

}

    @Override
    public List find(QueryHelper helper, boolean cacheable)  throws DaoException{
        List<Object> params = helper.getParams();
        Query query = getSession().createQuery(helper.getQueryHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        query.setCacheable(cacheable);
        return query.list();
    }

    @Override
    public Object findUnique(QueryHelper helper, boolean cacheable)  throws DaoException{
        List<Object> params = helper.getParams();
        Query query = getSession().createQuery(helper.getQueryHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        query.setCacheable(cacheable);
        return query.uniqueResult();
    }

    @Override
    public void absoluteDelete(Serializable id)  throws DaoException{
        getSession().createSQLQuery("DELETE FROM "+clazz.getSimpleName()+" WHERE id = ?")
                .setParameter(0, id)
                .executeUpdate();
    }

    /**
     * 分页
     * @param pageNum
     * @param helper
     * @param pageSize
     * @return
     */
    public Page getPage(int pageNum, QueryHelper helper, int pageSize)  throws DaoException{

        //查询分页数据
        List<Object> params = helper.getParams();
        Query query = getSession().createQuery(helper.getQueryHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        query.setFirstResult((pageNum - 1) * pageSize);
        query.setMaxResults(pageSize);
        query.setCacheable(true);
        List list = query.list();

        //查询分页的总记录
        query = getSession().createQuery(helper.getQueryCountHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        Long count = (Long) query.uniqueResult();

        return new Page(pageNum, pageSize, count.intValue(), list);
    }

    @Override
    public void autoDecrease(Serializable id, String clause)  throws DaoException{
        getSession().createQuery("update "+clazz.getSimpleName()+" set "+clause+"="+clause+"-1 where id=?")
                .setParameter(0, id)
                .executeUpdate();
    }

    @Override
    public int getCount(QueryHelper helper)  throws DaoException{
        List<Object> params = helper.getParams();
        Query query = getSession().createQuery(helper.getQueryCountHql());
        if (params != null && params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                query.setParameter(i, params.get(i));
            }
        }
        query.setCacheable(true);
        Long count = (Long) query.uniqueResult();
        if (count==null)
            return 0;
        return count.intValue();
    }


}
