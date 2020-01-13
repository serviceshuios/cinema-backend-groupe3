package com.montparnasse.cinema.service;

import java.util.List;

public interface IService<T> {

	public T create(T t);
	public T update(T t);
	public boolean deleteById(Long id);
	public T getById(Long id);
	public List<T> getAll();
}
