package com.feedreader.dao;
/**
 * dao Service
 * 
 * @author Alexander Schmalz
 *
 */
import java.util.List;

import com.feedreader.model.FeedSource;

public interface Dao {

	public boolean addFeed(FeedSource feed) throws Exception;
	public FeedSource getFeedById(int id) throws Exception;
	public List<FeedSource> getFeedList() throws Exception;
	public boolean deleteFeed(int id) throws Exception;
}
