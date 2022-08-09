package com.lukejlackey.ninjagold.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NinjaModel {
	
	private Integer gold;
	private ArrayList<String> eventLog;

	public NinjaModel() {
		this.gold = 0;
		this.eventLog = new ArrayList<String>();
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public ArrayList<String> getEventLog() {
		return eventLog;
	}

	public void addEvent(String location) {
		int goldChange;
		String event = "You ";
		if(location.contentEquals("quest")) {
			goldChange = (int) Math.floor(Math.random()*(50+50+1)-50);
			if(goldChange >= 0) {
				event += "completed a quest and earned " + goldChange + " gold.";
			}else {
				event += "failed a quest and lost " + Math.abs(goldChange) + " gold. Ouch.";
			}
		}else {
			goldChange = (int) Math.floor(Math.random()*(20-10+1)+10);
			event += "entered a " + location + " and earned " + goldChange + " gold.";
		}
		this.gold += goldChange;
		String pattern = "MMMM d yyyy hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		this.eventLog.add(event + " (" + date + ")");
	}
	
}
