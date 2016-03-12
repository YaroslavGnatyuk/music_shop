package model;

import java.time.LocalDate;
import java.util.List;

public class Artist {

	int id;
	String name;
	Address country;
	LocalDate birthday;
	List<Album> albums;
	String email;
	Category category;
	Studio studio;

	public Artist() {

	}

	public Artist(int id, String name, Address country, LocalDate birthday, List<Album> albums, String email, Category category, Studio studio) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.birthday = birthday;
		this.albums = albums;
		this.email = email;
		this.category = category;
		this.studio = studio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getCountry() {
		return country;
	}

	public void setCountry(Address country) {
		this.country = country;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}
}
