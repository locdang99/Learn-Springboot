package com.locdang.runnerz.run;

import java.time.LocalDateTime;
import java.util.Objects;

public class RunFirst {
	private Integer id;
	private String title;
	private LocalDateTime startedOn;
	private LocalDateTime completedOn;
	private Integer miles;
	private Location location;

	public RunFirst() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RunFirst(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles,
			Location location) {
		super();
		this.id = id;
		this.title = title;
		this.startedOn = startedOn;
		this.completedOn = completedOn;
		this.miles = miles;
		this.location = location;
		if (!completedOn.isAfter(startedOn)) {
			throw new IllegalArgumentException("Completed On must be after Started On");
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}

	public LocalDateTime getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalDateTime completedOn) {
		this.completedOn = completedOn;
	}

	public Integer getMiles() {
		return miles;
	}

	public void setMiles(Integer miles) {
		this.miles = miles;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(completedOn, id, location, miles, startedOn, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunFirst other = (RunFirst) obj;
		return Objects.equals(completedOn, other.completedOn) && Objects.equals(id, other.id)
				&& location == other.location && Objects.equals(miles, other.miles)
				&& Objects.equals(startedOn, other.startedOn) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Run [id=" + id + ", title=" + title + ", startedOn=" + startedOn + ", completedOn=" + completedOn
				+ ", miles=" + miles + ", location=" + location + "]";
	}

}
