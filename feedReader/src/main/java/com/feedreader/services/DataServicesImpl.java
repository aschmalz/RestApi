package com.feedreader.services;
/**
 * Service for data manipulation
 * 
 * @author Alexander Schmalz
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.feedreader.dao.Dao;
import com.feedreader.model.FeedSource;

public class DataServicesImpl implements DataServices {

	@Autowired
	Dao dataDao;

	public boolean addFeed(FeedSource feed) throws Exception {
		return dataDao.addFeed(feed);
	}

	public FeedSource getFeedById(int id) throws Exception {
		return dataDao.getFeedById(id);
	}

	public List<FeedSource> getFeedList() throws Exception {
		return dataDao.getFeedList();
	}

	public boolean deleteFeed(int id) throws Exception {
		return dataDao.deleteFeed(id);
	}
	


}
