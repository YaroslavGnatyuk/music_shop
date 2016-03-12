package model;

public class Address {
	int id;
	String country;
	String city;

	public Address() {

	}

	public Address(int id, String country, String city) {
		this.id = id;
		this.country = country;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
