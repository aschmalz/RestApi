package com.feedreader.jaxbmodel;
/**
 * Model for JAXB
 * @author Alexander Schmalz
 *
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "title", "description", "pubDate",
		"lastBuildDate", "item" })
@XmlRootElement(name = "channel")
public class Channel {

	@XmlElement(required = true)
	private String title;

	@XmlElement(required = true)
	private String description;

	@XmlElement(required = true)
	private String pubDate;

	@XmlElement(required = true)
	private String lastBuildDate;

	@XmlElement(required = true)
	private List<Item> item;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

}
