package ua.gnatyuk.yaroslav.music_shop.domain.musicrecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;


	@Column(nullable = false, unique = true)
	private String name;

	@Embedded
	private Address address;

	@Column(nullable = false)
	private LocalDate birthday;

	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
	private List<Album> albums  ;

	@Column(nullable = false)
	private String email;

	@OneToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne
	@JoinColumn(name = "studio_id")
	private Studio studio;

	@Column(nullable = false)
	private Byte rating;

	@Column(nullable = false)
	private Integer countOfSales ;

	public Artist() {

	}

	public Artist(String name, Address address, LocalDate birthday,
				  String email, Category category, Studio studio, Byte rating)
	{
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.category = category;
		this.studio = studio;
		this.rating = rating;
		countOfSales = new Integer(0);


	}

	public Integer getCountOfSales() {
		return countOfSales;
	}

	public void setCountOfSales(Integer countOfSales) {
		this.countOfSales = countOfSales;
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
		return albums;
	}

	public void setAlbums(Album album) {
		if(albums == null){
			albums = new ArrayList<>();
		}
		getAlbums().add(album);
		countOfSales += album.getCountOfSales();
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

	public void setStudio(Studio studio_id) {
		this.studio = studio_id;
	}

	public String getNameOfAllAlbums(){
		StringBuilder names = new StringBuilder();
		for (Album a:albums) {
			name.concat(a.getName() + " \n");
		}
		return names.toString();
	}

	@Override
	public String toString() {
		return "artist{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address=" + address +
				", birthday=" + birthday +
				/*", albums=" + getNameOfAllAlbums() +*/
				", email='" + email + '\'' +
				", category=" + category.toString() +
				", studio=" + studio.toString() +
				", rating=" + rating +
				", countOfSales=" + countOfSales + "\n" +
				'}';

			}
}
