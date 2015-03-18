package com.feedreader.apimodel;
/**
 * Model for JAXB, call return
 * @author Alexander Schmalz
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"message",
		"errorcode",
		"errortext"
})
@XmlRootElement(name = "news")
public class Messages {

	@XmlElement(required = true)
	private List<Message> message;
	@XmlElement(required = true)
	private String errorcode;
	@XmlElement(required = true)
	private String errortext;

	/**
	 * @return the message
	 */
	public List<Message> getMessage() {
		if (message == null) {
			message = new ArrayList<Message>();
		}
		return message;
	}

	/**
	 * @return the errorcode
	 */
	public String getErrorcode() {
		return errorcode;
	}

	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	/**
	 * @return the errortext
	 */
	public String getErrortext() {
		return errortext;
	}

	/**
	 * @param errortext the errortext to set
	 */
	public void setErrortext(String errortext) {
		this.errortext = errortext;
	}
}
