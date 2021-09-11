package com.iptv.iptv;

import java.util.ArrayList;

public class DataEntity {
	//private ArrayList<String> line;
    private ArrayList<String> pictureLink;
    private ArrayList<String> groupName;
    private ArrayList<String> channelName;
    private ArrayList<String> link;
	
    
	public DataEntity(ArrayList<String> pictureLink, ArrayList<String> groupName, ArrayList<String> channelName,
			ArrayList<String> link) {
		super();
		this.pictureLink = pictureLink;
		this.groupName = groupName;
		this.channelName = channelName;
		this.link = link;
	}

	
	public ArrayList<String> getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(ArrayList<String> pictureLink) {
		this.pictureLink = pictureLink;
	}

	public ArrayList<String> getGroupName() {
		return groupName;
	}

	public void setGroupName(ArrayList<String> groupName) {
		this.groupName = groupName;
	}

	public ArrayList<String> getChannelName() {
		return channelName;
	}

	public void setChannelName(ArrayList<String> channelName) {
		this.channelName = channelName;
	}

	public ArrayList<String> getLink() {
		return link;
	}

	public void setLink(ArrayList<String> link) {
		this.link = link;
	}
    
}
