package com.jp.cpProject.model;

import javax.persistence.Entity;

@Entity
public class Review extends AbstractEntity {
	private String description;
	private float rating;

	public Review(String description, float rating) {
		this.description = description;
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
