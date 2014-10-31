package com.mx.popcorn.base;

import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 14-8-16.
 */
public class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {


    protected T model;

    public ModelDrivenBaseAction() {
        try{
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            model = clazz.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public T getModel() {
        return model;
    }


}
