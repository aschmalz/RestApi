package com.feedreader.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feedreader.model.FeedSource;
import com.feedreader.model.Status;
import com.feedreader.services.DataServices;

@Controller
@RequestMapping("/feedList")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addFeed(@RequestBody FeedSource feed) {
		try {
			dataServices.addFeed(feed);
			return new Status(1, "feed added Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody FeedSource getFeed(@PathVariable("id") int id) {
		FeedSource feed = new FeedSource();
		try {
			feed = dataServices.getFeedById(id);
			logger.info("getFeed" + " ok");
		} catch (Exception e) {
			logger.info("getFeed");
			e.printStackTrace();
		}
		return feed;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<FeedSource> getFeed() {

		List<FeedSource> feedList = null;
		try {
			feedList = dataServices.getFeedList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return feedList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteFeed(@PathVariable("id") int id) {

		try {
			dataServices.deleteFeed(id);
			return new Status(1, "feed deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, "feed failed Successfully !");
		}

	}
}
