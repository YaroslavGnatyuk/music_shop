package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

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
