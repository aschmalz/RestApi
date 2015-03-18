package com.feedreader.services;

import java.util.List;

import com.feedreader.model.FeedSource;

public interface DataServices {
	public boolean addFeed(FeedSource feed) throws Exception;
	public FeedSource getFeedById(int id) throws Exception;
	public List<FeedSource> getFeedList() throws Exception;
	public boolean deleteFeed(int id) throws Exception;
}
