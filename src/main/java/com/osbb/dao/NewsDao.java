package com.osbb.dao;

import java.util.List;

import com.osbb.model.News;

public interface NewsDao {
	News getNewsById(int id);

	void save(News news);

	void deleteById(int id);

	List<News> getAllOsbbNews(int osbbId);

}
