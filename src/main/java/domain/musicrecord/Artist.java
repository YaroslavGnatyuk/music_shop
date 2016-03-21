package domain.musicrecord;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;


	@Column(nullable = false)
	private String name;

	@Embedded
	private Address address;

	@Column(nullable = false)
	private LocalDate birthday;

	@OneToMany(mappedBy = "artist")
	private List<Album> album;

	@Column(nullable = false)
	private String email;

	@OneToOne()
	private Category category;

	@OneToOne
	private Studio studio;

	public Artist() {

	}

	public Artist(String name, Address address, LocalDate birthday, List<Album> albums, String email, Category category, Studio studio) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.album = albums;
		this.email = email;
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
		return album;
	}

	public void setAlbums(List<Album> albums) {
		this.album = albums;
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

	public void setStudio(Studio studio_id) {
		this.studio = studio_id;
	}
}
