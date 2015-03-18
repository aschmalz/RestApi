package com.feedreader.apimodel;
/**
 * Model for JAXB, call return
 * @author Alexander Schmalz
 *
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"title",
		"guid",
		"link",
		"pubDate",
		"description",
		"content"
})

@XmlRootElement(name="message")
public class Message {

	@XmlElement(required = true)
	private String title;
	
	@XmlElement(required = true)
	private String guid;
	
	@XmlElement(required = true)
	private String link;
	
	@XmlElement(required = true)
	private String description;
	
	@XmlElement(required = true)
	public String content;

	@XmlElement(required = true)
	private String pubDate;

	/**
	 * @return String title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return String guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * @param guid the guid to set
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * @return String link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return String pubDate
	 */
	public String getPubDate() {
		return pubDate;
	}

	/**
	 * @param pubDate the pubDate to set
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
}