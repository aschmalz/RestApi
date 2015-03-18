package com.feedreader.apimodel;
/**
 * Create ObjectFactory Object of {@link Message}, {@link Messages} for JAXB Annotation
 * 
 * @author Alexander Schmalz
 *
 */
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	
	}

	public Messages createMessages() {
		return new Messages();
	}

	public Message createMessage() {
		return new Message();
	}
}