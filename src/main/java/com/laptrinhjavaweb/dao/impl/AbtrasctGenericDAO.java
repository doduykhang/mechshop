package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbtrasctGenericDAO<T>{
	private Class<T> clazz;
	 
    @Autowired
    SessionFactory sessionFactory;
 
    public void setClazz(Class< T > clazzToSet){
       this.clazz = clazzToSet;
    }
 
    public T findOne(String id){
    	T entity = (T) getCurrentSession().get(clazz, id);
    	return entity;
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T create(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(String entityId) {
    	getCurrentSession().createQuery("delete " + clazz.getName() + " where id = :id").setParameter("id", entityId).executeUpdate();
//        T entity = findOne(entityId);
//        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public List<T> listByPage(int page, int size, String orderBy) {
    	String hql = "from " + clazz.getName() +" ORDER BY " + orderBy;
    	Query query = getCurrentSession().createQuery(hql);
    	query.setFirstResult(page);
    	query.setMaxResults(size);
        return query.list();
    }
}
