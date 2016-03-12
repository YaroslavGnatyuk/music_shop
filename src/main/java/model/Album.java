package model;

import java.time.LocalDate;

public class Album {

	int id;
	String name;
	LocalDate releaseDate;
	Artist artist;
	Category category;
	Studio studio;

	public Album() {

	}

	public Album(int id, String name, LocalDate releaseDate, Artist artist, Category category, Studio studio) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.artist = artist;
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
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
