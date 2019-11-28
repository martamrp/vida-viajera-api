package com.marta.daw.project.model;

public class UserStats {
	private Trip cheaperTrip;
	private Trip moreExpensiveTrip;
	private int leisureTrip;
	private int businessTrip;
	private Trip shortestTrip;
	private Trip longestTrip;
	private Trip cheapestTripPerDay;
	private Trip mostExpensiveTripPerDay;
	
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
	public Trip getShortestTrip() {
		return shortestTrip;
	}
	public void setShortestTrip(Trip shortestTrip) {
		this.shortestTrip = shortestTrip;
	}
	public Trip getLongestTrip() {
		return longestTrip;
	}
	public void setLongestTrip(Trip longestTrip) {
		this.longestTrip = longestTrip;
	}
	public Trip getCheapestTripPerDay() {
		return cheapestTripPerDay;
	}
	public void setCheapestTripPerDay(Trip cheapestTripPerDay) {
		this.cheapestTripPerDay = cheapestTripPerDay;
	}
	public Trip getMostExpensiveTripPerDay() {
		return mostExpensiveTripPerDay;
	}
	public void setMostExpensiveTripPerDay(Trip mostExpensiveTripPerDay) {
		this.mostExpensiveTripPerDay = mostExpensiveTripPerDay;
	}	
}
