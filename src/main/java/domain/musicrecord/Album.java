package domain.musicrecord;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
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

	public Album() {

	}

	public Album(String name, LocalDate releaseDate, Artist artist, Category category, Studio studio) {
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
