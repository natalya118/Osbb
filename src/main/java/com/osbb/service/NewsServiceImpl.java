package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.NewsDao;
import com.osbb.model.News;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsDao newsDao;
	
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}

	@Override
	public void saveNews(News news) {
		newsDao.save(news);
		
	}

	@Override
	public void deleteNews(int id) {
		newsDao.deleteById(id);
		
	}

	@Override
	public List<News> getAllNewsByOsbb(int osbbId) {
		
		return newsDao.getAllOsbbNews(osbbId);
	}

}
