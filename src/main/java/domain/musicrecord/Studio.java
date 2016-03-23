package domain.musicrecord;

import javax.persistence.*;

@Entity
@Table(name = "studio")
public class Studio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
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

	@Override
	public String toString() {
		return "Studio{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address=" + address.toString() +
				'}';
	}
}
