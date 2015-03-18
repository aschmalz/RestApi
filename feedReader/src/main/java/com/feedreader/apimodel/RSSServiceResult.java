package com.feedreader.apimodel;
/**
 * Represents a newFeed record
 * @author Alexander Schmalz
 *
 */
public class RSSServiceResult {

	private String title;
	private String link;
	private String comment;
	private String content;
	private String pubDate;
	private String guid;
	
	public RSSServiceResult() {
	}
	
	/**
	 * @param title
	 * @param link
	 * @param comment
	 * @param content
	 * @param pubDate
	 * @param guid
	 */
	public RSSServiceResult(String title, String link, String comment,
			String content, String pubDate, String guid) {
		this.title = title;
		this.link = link;
		this.comment = comment;
		this.content = content;
		this.pubDate = pubDate;
		this.guid = guid;
	}
	
	
	/**
	 * @return String title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return String link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return String comment
	 */
	public String getDescription() {
		return comment;
	}

	/**
	 * @return String content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return String pubDate
	 */
	public String getPubDate() {
		return pubDate;
	}

	/**
	 * @return String guid
	 */
	public String getGuid() {
		return guid;
	}
}