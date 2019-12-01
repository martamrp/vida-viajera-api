package com.marta.daw.project.model;

public class UserStats {
	private Trip cheapestTrip;
	private Trip mostExpensiveTrip;
	private int leisureTrips;
	private int businessTrips;
	private Trip shortestTrip;
	private Trip longestTrip;
	private Trip cheapestTripPerDay;
	private Trip mostExpensiveTripPerDay;
	
	public Trip getCheapestTrip() {
		return cheapestTrip;
	}
	public void setCheapestTrip(Trip cheapestTrip) {
		this.cheapestTrip = cheapestTrip;
	}
	public Trip getMostExpensiveTrip() {
		return mostExpensiveTrip;
	}
	public void setMostExpensiveTrip(Trip mostExpensiveTrip) {
		this.mostExpensiveTrip = mostExpensiveTrip;
	}
	public int getLeisureTrips() {
		return leisureTrips;
	}
	public void setLeisureTrips(int leisureTrips) {
		this.leisureTrips = leisureTrips;
	}
	public int getBusinessTrips() {
		return businessTrips;
	}
	public void setBusinessTrips(int businessTrips) {
		this.businessTrips = businessTrips;
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
