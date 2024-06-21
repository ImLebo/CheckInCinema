package com.cinemaattendance.app.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_Check_In")
public class CheckIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "movie")
	private String movie; 

	@Column(name = "date")
	private String date;
	
	@Column(name = "checkhour")
	private String checkhour;

	@Column(name = "adults")
	private int adults; 

	@Column(name = "children")
	private int children;

	@Column(name = "seating")
	private String seating;
	
	@Column(name = "notifications")
	private boolean notifications;

	public CheckIn(Long id, String name, String lastname, String email, String movie, String date, String checkhour, int adults,
			int children, String seating, boolean notifications) {
		this.id = id; 
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.movie = movie;
		this.date = date;
		this.checkhour = checkhour;
		this.adults = adults;
		this.children = children;
		this.seating = seating;
		this.notifications = notifications;
	} 

	public CheckIn(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheckhour() {
		return checkhour;
	}

	public void setCheckhour(String checkhour) {
		this.checkhour = checkhour;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getSeating() {
		return seating;
	}

	public void setSeating(String seating) {
		this.seating = seating;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}
}
