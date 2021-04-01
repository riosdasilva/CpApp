package com.jp.cpProject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends AbstractEntity {
	private String date;
	private int price;
	private String time;
	private boolean used;
	
	@ManyToOne
	private Inspector inspector;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Station initialStation;

	@ManyToOne
	private Station finalStation;
	
	@ManyToOne
	private Seat seat;
	
	public Ticket(String date, int price, String time, boolean used, Inspector insp, Client cli, Station initialStat, Station finalStat, Seat sea) {
		this.date = date;
		this.price = price;
		this.time = time;
		this.used = used;
		this.inspector = insp;
		this.client = cli;
		this.initialStation = initialStat;
		this.finalStation = finalStat;
		this.seat = sea;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	

}
