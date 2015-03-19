package com.feedreader.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.feedreader.apimodel.Message;
import com.feedreader.apimodel.ObjectFactory;
import com.feedreader.apimodel.RSSContainer;
import com.feedreader.apimodel.RSSServiceResult;
import com.feedreader.jaxbmodel.Item;
import com.feedreader.jaxbmodel.Rss;

public class RSSClient implements RSSService {

	private String newsUri = null;
	private String blogUri = null;
	private String medienUri = null;
	public Rss news = null;
	private RSSContainer container = null;
	HashMap<String, String> month = new HashMap<String, String>();

	public RSSClient() {
	}

	public RSSClient(Properties prop) {

		this.container = new RSSContainer();
		newsUri = prop.getProperty("rss.hsmwnews");
		blogUri = prop.getProperty("rss.blog");
		medienUri = prop.getProperty("rss.medien");
		month.put("Jan", "01");
		month.put("Feb", "02");
		month.put("Mar", "03");
		month.put("Apr", "04");
		month.put("May", "05");
		month.put("Jun", "06");
		month.put("Jul", "07");
		month.put("Aug", "08");
		month.put("Sep", "09");
		month.put("Oct", "10");
		month.put("Nov", "11");
		month.put("Dec", "12");

	}

	public List<Message> getBlogList() {

		container.clearData();
		List<Message> blogMessages = new ArrayList<Message>();
		this.createServiceResult(blogUri);
		if (this.news != null) {
			List<Item> items = news.getChannel().getItem();
			for (Item s : items) {
				s.setGuid(s.getGuid().replaceAll(".*p=", ""));
			}
			this.getRssplanData();
		}
		if (this.container.getSize() > 0) {

			for (int i = 0; i < this.container.getSize(); i++) {

				Message message = this.createRssXml(0, this.container
						.getElement(i).getTitle(), this.container.getElement(i)
						.getLink(), this.container.getElement(i)
						.getDescription(), this.container.getElement(i)
						.getContent(), this.container.getElement(i)
						.getPubDate(), this.container.getElement(i).getGuid());
				blogMessages.add(message);
			}
		}

		return blogMessages;
	}

	public List<Message> getNewsList() {

		container.clearData();
		List<Message> newsMessages = new ArrayList<Message>();
		this.createServiceResult(newsUri);
		if (this.news != null) {
			this.getRssplanData();
		}
		if (this.container.getSize() > 0) {

			for (int i = 0; i < this.container.getSize(); i++) {

				Message message = this.createRssXml(0, this.container
						.getElement(i).getTitle(), this.container.getElement(i)
						.getLink(), this.container.getElement(i)
						.getDescription(), this.container.getElement(i)
						.getContent(), this.container.getElement(i)
						.getPubDate(), this.container.getElement(i).getGuid());
				newsMessages.add(message);
			}
		}

		return newsMessages;
	}

	public List<Message> getMedienList() {

		container.clearData();
		List<Message> MedienMessages = new ArrayList<Message>();
		this.createServiceResult(medienUri);

		if (this.news != null) {
			this.getRssplanData();
		}
		if (this.container.getSize() > 0) {

			for (int i = 0; i < this.container.getSize(); i++) {

				Message message = this.createRssXml(0, this.container
						.getElement(i).getTitle(), this.container.getElement(i)
						.getLink(), this.container.getElement(i)
						.getDescription(), this.container.getElement(i)
						.getContent(), this.container.getElement(i)
						.getPubDate(), this.container.getElement(i).getGuid());
				MedienMessages.add(message);
			}
		}

		return MedienMessages;
	}

	public List<Message> getBlog(String guid) {

		List<Message> blogMessages = new ArrayList<Message>();
		Message message = new Message();
		boolean isGuidTrue = false;
		if (this.container.getSize() > 0) {

			for (int i = 0; i < this.container.getSize(); i++) {

				message = createRssXml(1, this.container.getElement(i)
						.getTitle(), this.container.getElement(i).getLink(),
						this.container.getElement(i).getDescription(),
						this.container.getElement(i).getContent(),
						this.container.getElement(i).getPubDate(),
						this.container.getElement(i).getGuid());
				if (guid.equals(message.getGuid())) {
					isGuidTrue = true;
					break;
				}
			}
			if (isGuidTrue)
				blogMessages.add(message);
			else {
				message = new Message();
				blogMessages.add(message);
			}
		}
		return blogMessages;
	}

	public List<Message> getNews(String guid) {

		List<Message> newsMessages = new ArrayList<Message>();
		Message message = new Message();
		boolean isGuidTrue = false;
		if (this.container.getSize() > 0) {

			for (int i = 0; i < this.container.getSize(); i++) {

				message = createRssXml(1, this.container.getElement(i)
						.getTitle(), this.container.getElement(i).getLink(),
						this.container.getElement(i).getDescription(),
						this.container.getElement(i).getContent(),
						this.container.getElement(i).getPubDate(),
						this.container.getElement(i).getGuid());
				if (Integer.parseInt(message.getGuid()) == Integer
						.parseInt(guid)) {
					isGuidTrue = true;
					break;
				}
			}
			if (isGuidTrue)
				newsMessages.add(message);
			else {
				message = new Message();
				newsMessages.add(message);
			}

		}
		return newsMessages;
	}

	private Message createRssXml(int version, String title, String link,
			String description, String content, String pubDate, String guid) {

		ObjectFactory obf = new ObjectFactory();

		Message message = obf.createMessage();
		String[] newPubDate = pubDate.split(" ");
		String temp = month.get(newPubDate[2]);
		newPubDate[2] = temp;
		String[] timesplit = newPubDate[4].split(":");
		newPubDate[4] = timesplit[0] + ":" + timesplit[1];
		pubDate = newPubDate[1] + "." + newPubDate[2] + "." + newPubDate[3]
				+ " " + newPubDate[4];
		switch (version) {
		case 0:

			message.setTitle(title);
			message.setGuid(guid);
			message.setDescription(description);
			message.setPubDate(pubDate);
			break;

		case 1:
			message.setTitle(title);
			message.setGuid(guid);
			message.setDescription(description);
			message.setContent(content);
			message.setLink(link);
			message.setPubDate(pubDate);
			break;
		default:
			break;
		}

		return message;
	}

	public void createServiceResult(final String url) {
		try {

			JAXBContext context = JAXBContext.newInstance(Rss.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			URL ParserUrl = new URL(url);
			news = (Rss) unmarshaller.unmarshal(ParserUrl);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getRssplanData() {

		List<Item> items = news.getChannel().getItem();
		for (Item s : items) {
			this.container.addRssData(new RSSServiceResult(s.getTitle(), s
					.getLink(), s.getDescription(), s.getContent(), s
					.getPubDate(), s.getGuid()));
		}

	}

	private boolean isWebRessourceConnected() {

		boolean isConnectedToWeb = true;
		URL url = null;
		HttpURLConnection huc;
		try {
			url = new URL(newsUri);
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("GET");
			huc.connect();
			if ((huc.getResponseCode() == HttpURLConnection.HTTP_UNAVAILABLE)
					|| (huc.getResponseCode() == HttpURLConnection.HTTP_CLIENT_TIMEOUT)
					|| (huc.getResponseCode() == HttpURLConnection.HTTP_GATEWAY_TIMEOUT)
					|| (huc.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
					|| (huc.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST))
				isConnectedToWeb = false;
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return isConnectedToWeb;
	}

	public boolean isConnected() {

		return isWebRessourceConnected();
	}
}
