package model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String name;

	public Category() {

	}

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
