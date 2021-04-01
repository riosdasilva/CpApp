package com.jp.cpProject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Seat extends AbstractEntity {
	private String date;
   
	@ManyToOne
	private Stop stop;
	
	public Seat(String date, Stop sto) {
		this.date = date;
		this.stop = sto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	public Stop getStop() {
		return stop;
	}

	public void setStop(Stop stop) {
		this.stop = stop;
	}
	

}
