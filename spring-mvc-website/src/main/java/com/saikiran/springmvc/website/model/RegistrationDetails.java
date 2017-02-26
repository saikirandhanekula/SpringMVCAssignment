package com.saikiran.springmvc.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class RegistrationDetails {
	
	@Size(min=4, max=15)
	private String name;
	private String course;
	@Min(100)
    private int fee;
	@Min(2017)
    private int year;
    private String CurDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCurDate() {
		return CurDate;
	}
	public void setCurDate(String curDate) {
		CurDate = curDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CurDate == null) ? 0 : CurDate.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + fee;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationDetails other = (RegistrationDetails) obj;
		if (CurDate == null) {
			if (other.CurDate != null)
				return false;
		} else if (!CurDate.equals(other.CurDate))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (fee != other.fee)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}