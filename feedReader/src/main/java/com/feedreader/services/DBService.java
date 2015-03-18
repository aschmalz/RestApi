package com.feedreader.services;

import java.util.List;

import com.feedreader.model.FeedSource;
import com.feedreader.model.News;

public interface DBService {

	public boolean addNews(News employee) throws Exception;
	public News getNewsById(int id) throws Exception;
	public List<News> getNewsList() throws Exception;
	public boolean deleteNews(int id) throws Exception;
	
	public boolean addFeedSource(FeedSource feed) throws Exception;
	public FeedSource getFeedSourceById(int id) throws Exception;
	public List<FeedSource> getFeedSourceList() throws Exception;
	public boolean deleteFeedSource(int id) throws Exception;
}
