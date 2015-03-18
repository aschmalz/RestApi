package com.feedreader.jaxbmodel;
/**
 * Model for JAXB
 * @author Alexander Schmalz
 *
 */
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "title", "link", "description", "encoded",
		"pubDate" })
@XmlRootElement(name = "item")
public class Item {

	@XmlElement(required = true)
	private String title;

	@XmlElement(required = true)
	private String guid;

	@XmlElement(required = true)
	private String link;

	@XmlElement(required = true)
	private String description;

	@XmlElement(namespace = "http://purl.org/rss/1.0/modules/content/")
	public String encoded;

	@XmlElement(required = true)
	private String pubDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return encoded;
	}

	public void setContent(String encoded) {
		this.encoded = encoded;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

}