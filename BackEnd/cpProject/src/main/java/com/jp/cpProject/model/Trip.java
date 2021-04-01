package com.jp.cpProject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Trip extends AbstractEntity {

	private String finalTime;
	private String initialTime;
	
	@ManyToOne
	private Station initialStation;
	@ManyToOne
	private Station finalStation;

	public Trip(String finalTime, String initialTime, Station initialStati, Station finalStati) {
		super();
		this.finalTime = finalTime;
		this.initialTime = initialTime;
		this.initialStation = initialStati;
		this.finalStation = finalStati;
	}
	
	public Station getInitialStation() {
		return initialStation;
	}


	public void setInitialStation(Station initialStation) {
		this.initialStation = initialStation;
	}


	public Station getFinalStation() {
		return finalStation;
	}

	public void setFinalStation(Station finalStation) {
		this.finalStation = finalStation;
	}

	public String getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(String finalTime) {
		this.finalTime = finalTime;
	}

	public String getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(String initialTime) {
		this.initialTime = initialTime;
	}

}
