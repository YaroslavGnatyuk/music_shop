package domain.musicrecord;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private LocalDate releaseDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Artist artist;

	@OneToOne
	private Category category;

	@OneToOne
	private Studio studio;

	@Column(nullable = false)
	Byte rating;

	public Album() {

	}

	public Album(String name, LocalDate releaseDate, Artist artist, Category category, Studio studio, Byte rating) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.artist = artist;
		this.category = category;
		this.studio = studio;
		this.rating = rating;
	}

	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rate) {
		this.rating = rate;
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
