package com.feedreader.jaxbmodel;
/**
 * Model for JAXB
 * @author Alexander Schmalz
 *
 */
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"channel" })

@XmlRootElement(name = "rss")
public class Rss {

	@XmlElement(required = true)
	private String lastBuildDate;
	@XmlElement(required = true)
	private Channel channel;
	
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
