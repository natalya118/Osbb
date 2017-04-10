package com.osbb.service;

import java.util.List;

import com.osbb.model.News;

public interface NewsService {
	News getNewsById(int id);
	void saveNews(News news);
	void deleteNews(int id);
	List<News> getAllNewsByOsbb(int osbbId);
}
