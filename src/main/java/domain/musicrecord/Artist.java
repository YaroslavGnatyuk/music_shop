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

	@Column(nullable = false)
	private Byte rating;

	@Column(nullable = false)
	private Integer countOfSales;

	public Artist() {

	}

	public Artist(String name, Address address, LocalDate birthday, List<Album> album,
				  String email, Category category, Studio studio, Byte rating)
	{
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.album = album;
		this.email = email;
		this.category = category;
		this.studio = studio;
		this.rating = rating;

		setCountOfSales(album);
	}

	public Integer getCountOfSales() {
		return countOfSales;
	}

	public void setCountOfSales(Integer countOfSales) {
		this.countOfSales = countOfSales;
	}

	public void setCountOfSales(List<Album> albums) {
		for (Album album:albums) {
			countOfSales += album.getCountOfSales();
		}
	}

	public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
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
