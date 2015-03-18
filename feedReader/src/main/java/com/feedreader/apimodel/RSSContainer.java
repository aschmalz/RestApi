package com.feedreader.apimodel;
/**
 * Create an List of {@link RSSServiceResult} data
 * 
 * @author Alexander Schmalz
 *
 */
import java.util.ArrayList;

public class RSSContainer {
	
	private ArrayList<RSSServiceResult> container;
	
	/**
	 * standard constructor
	 */
	public RSSContainer() {
		container = new ArrayList<RSSServiceResult>();
	}
	
	/**
	 * save a given {@link RSSServiceResult} object
	 * @param csr one single result
	 */
	public void addRssData(RSSServiceResult csr) {
		container.add(csr);
	}
	
	/**
	 * size of List
	 * @return size
	 */
	public int getSize() {
		return container.size();
	}
	
	/**
	 * search a result with the given index
	 * @param index
	 * @return
	 */
	public RSSServiceResult getElement(int index) {
		return container.get(index);
	}
	
	/**
	 * clear List
	 */
	public void clearData() {
		this.container.clear();
	}
	
	public void setData(ArrayList<RSSServiceResult> data){
		this.container = data;
	}
	
	public ArrayList<RSSServiceResult> getData(){
		return container;	
		
	}
}