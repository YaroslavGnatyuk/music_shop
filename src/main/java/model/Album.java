package model;


import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
@Table(name = "album")
public class Album {
	@Id
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	LocalDate releaseDate;
	@ManyToOne
	Artist artist;
	@ManyToOne
	Category category;
	@ManyToOne
	Studio studio;

	public Album() {

	}

	public Album(Long id, String name, LocalDate releaseDate, Artist artist, Category category, Studio studio) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.artist = artist;
		this.category = category;
		this.studio = studio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
