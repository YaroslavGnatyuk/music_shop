package domain.musicrecord;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private LocalDate releaseDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Artist artist_id;

	@OneToOne
	private Category category_id;

	@OneToOne
	private Studio studio_id;

	public Album() {

	}

	public Album(String name, LocalDate releaseDate, Artist artist, Category category, Studio studio) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.artist_id = artist;
		this.category_id = category;
		this.studio_id = studio;
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
		return artist_id;
	}

	public void setArtist(Artist artist) {
		this.artist_id = artist;
	}

	public Category getCategory() {
		return category_id;
	}

	public void setCategory(Category category) {
		this.category_id = category;
	}

	public Studio getStudio() {
		return studio_id;
	}

	public void setStudio(Studio studio) {
		this.studio_id = studio;
	}
}
