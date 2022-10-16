package com.michiko.profile.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String occupation;
	private LocalDate registeredSince;
	
	public User() {
		
	}
	
	public User(String username, String firstName, String lastName, int age, String occupation,
			LocalDate registeredSince) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.occupation = occupation;
		this.registeredSince = registeredSince;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public LocalDate getRegisteredSince() {
		return registeredSince;
	}

	public void setRegisteredSince(LocalDate registeredSince) {
		this.registeredSince = registeredSince;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, lastName, occupation, registeredSince, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(occupation, other.occupation)
				&& Objects.equals(registeredSince, other.registeredSince) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", occupation=" + occupation + ", registeredSince=" + registeredSince + "]";
	}
	
	

}
