package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	Long id;
	@Column(nullable = false)
	String name;

	public Category() {

	}

	public Category(String name) {
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
