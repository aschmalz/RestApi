package com.feedreader.dao;

/**
 * dao Service
 * 
 * @author Alexander Schmalz
 *
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.feedreader.model.FeedSource;

public class DaoImpl implements Dao {

	static final Logger logger = Logger.getLogger(DaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addFeed(FeedSource feed) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(feed);
		tx.commit();
		session.close();

		return false;
	}

	public FeedSource getFeedById(int id) throws Exception {
		session = sessionFactory.openSession();
		FeedSource feed = null;
		try {
			feed = (FeedSource) session.load(FeedSource.class, new Integer(id));
			logger.info("not failed" + feed.getName());
			tx = session.getTransaction();
			session.beginTransaction();
			tx.commit();
		} catch (Exception e) {
			feed = new FeedSource();
			// e.printStackTrace();
		}
		return feed;
	}

	@SuppressWarnings("unchecked")
	public List<FeedSource> getFeedList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<FeedSource> feedList = session.createCriteria(FeedSource.class)
				.list();
		tx.commit();
		session.close();
		return feedList;
	}

	public boolean deleteFeed(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(FeedSource.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
