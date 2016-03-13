package model;

import javax.persistence.*;

@Embeddable
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String country;
	@Column(nullable = false)
	String city;
	@Column(nullable = false)
	String street;
	@Column(nullable = false)
	String house;
	@Column(nullable = false)
	Integer flat;

	public Address() {

	}

	public Address(String country, String city, String street, String house, Integer flat) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setFlat(Integer flat) {
		this.flat = flat;
	}

	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
