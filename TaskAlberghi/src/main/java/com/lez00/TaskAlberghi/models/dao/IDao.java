package com.lez00.TaskAlberghi.models.dao;

import java.util.List;

public interface IDao<T> {
	
	boolean insert(T t);
	List<T> findAll();
	T findById(Integer id);
	boolean delete(Integer id);
	boolean update(T t);

}
