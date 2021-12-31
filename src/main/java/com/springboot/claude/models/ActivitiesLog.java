package com.springboot.claude.models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ActivitiesLog {
	private String action;
	private int gold;
	
	public ActivitiesLog(String action, int gold) {
		this.action = action;
		this.gold = gold;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public String message() {
		Date dt = new Date();
		String str = new SimpleDateFormat("MMMM dd yyyy hh:mm aa").format(dt);
		
		int num = this.getGold();
		
		return (num < 0) ? String.format("You entered a %s and lost %d gold. Ouch.  (%s)", this.getAction(),Math.abs(num),str) :
			String.format("You entered a %s and earns %d gold. (%s)", this.getAction(),Math.abs(num),str);
	}
}
