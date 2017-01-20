package com.im.heaven.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author bufoon
 * 
 */
public interface BaseDao<T> {

	/**
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	/**
	 * 
	 * @param c
	 * @param id
	 * @return Object
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	public T get(String hql, Object[] param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param);

	/**
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Object[] param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param);

	/**
	 * 
	 * @param hql
	 * @return 
	 */
	public Integer executeHql(String hql);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, Object[] param);

	/**
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param);

}
