package model;

import javax.persistence.*;

@Entity
public class Studio {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String name;
	@Embedded
	Address address;

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
