package domain.musicrecord;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
	private Address address;

	@Column(nullable = false)
	private LocalDate birthday;

	@OneToMany(mappedBy = "artist_id")
	private List<Album> album_id;

	@Column(nullable = false)
	private String email;

	@OneToOne
	private Category category_id;

	@OneToOne
	private Studio studio;

	public Artist() {

	}

	public Artist(String name, Address address, LocalDate birthday, List<Album> albums, String email, Category category, Studio studio) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.album_id = albums;
		this.email = email;
		this.category_id = category;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<Album> getAlbums() {
		return album_id;
	}

	public void setAlbums(List<Album> albums) {
		this.album_id = albums;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category_id;
	}

	public void setCategory(Category category) {
		this.category_id = category;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}
}
