package com.osbb.service;

import java.util.List;

import com.osbb.model.News;

public interface NewsService {
	News getNewsById(String id);
	void createNews(News news);
	void updateNews(News news);
	void deleteNews(String id);
	List<News> getAllNews();
	List<News> getAllNewsByOsbb(String osbbId);
	List<News> getAllNewsByUser(String userId);
}
