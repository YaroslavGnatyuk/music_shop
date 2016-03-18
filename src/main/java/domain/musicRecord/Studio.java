package domain.musicRecord;

import javax.persistence.*;

@Entity
@Table(name = "Studio")
public class Studio {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	private Address address;

	public Studio() {

	}

	public Studio(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
