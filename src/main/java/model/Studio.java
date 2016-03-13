package model;

import javax.persistence.*;

@Entity
@Table(name = "studio")
public class Studio {
	@Id
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String name;
	@OneToOne
	Address address;

	public Studio() {

	}

	public Studio(Long id, String name, Address address) {
		this.id = id;
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
