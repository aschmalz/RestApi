package com.feedreader.services;

import java.util.List;

import com.feedreader.apimodel.Message;


public interface RSSService {
	List<Message> getBlogList();
	List<Message> getNewsList();
	List<Message> getBlog(String guid);
	boolean isConnected();
	List<Message> getNews(String guid);
	List<Message> getMedienList();
}
