package com.marta.daw.project.model;

public class UserStats {
	private Trip cheaperTrip;
	private Trip moreExpensiveTrip;
	private int leisureTrip;
	private int businessTrip;
	
	public Trip getCheaperTrip() {
		return cheaperTrip;
	}
	public void setCheaperTrip(Trip cheaperTrip) {
		this.cheaperTrip = cheaperTrip;
	}
	public Trip getMoreExpensiveTrip() {
		return moreExpensiveTrip;
	}
	public void setMoreExpensiveTrip(Trip moreExpensiveTrip) {
		this.moreExpensiveTrip = moreExpensiveTrip;
	}
	public int getLeisureTrip() {
		return leisureTrip;
	}
	public void setLeisureTrip(int leisureTrip) {
		this.leisureTrip = leisureTrip;
	}
	public int getBusinessTrip() {
		return businessTrip;
	}
	public void setBusinessTrip(int businessTrip) {
		this.businessTrip = businessTrip;
	}
	
}
