package com.jp.cpProject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Stop extends AbstractEntity {

	private int seatsToNextStop;
	private String stopTime;
	
	@ManyToOne
	private Station station;
	@ManyToOne
	private Station nextStation;

	public Stop(int seatsToNextStop, String stopTime, Station stat, Station nextStat) {
		this.seatsToNextStop = seatsToNextStop;
		this.stopTime = stopTime;
		this.station = stat;
		this.nextStation = nextStat;
	}

	public int getSeatsToNextStop() {
		return seatsToNextStop;
	}

	public void setSeatsToNextStop(int seatsToNextStop) {
		this.seatsToNextStop = seatsToNextStop;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Station getNextStation() {
		return nextStation;
	}

	public void setNextStation(Station nextStation) {
		this.nextStation = nextStation;
	}
	
	

}
