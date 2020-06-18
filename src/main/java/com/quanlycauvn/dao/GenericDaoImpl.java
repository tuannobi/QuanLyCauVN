package com.quanlycauvn.dao;

import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl<T ,K extends Serializable> implements GenericDao<T ,K> {

    private final Class<T> entity;

    public GenericDaoImpl() {
        this.entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public T findById(K id) {
        T t=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            t=session.get(this.entity, (Serializable) id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<T> findAll() {
        List<T> list=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            list=session.createQuery("from "+entity.getName()).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(T t) {
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(t);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.update(t);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(K id) {
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            T t = (T)session.load(this.entity, id);
            session.delete(t);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
