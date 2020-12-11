package com.meiit.webalk.ad4ayb;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, unique = true)
	private String email;
	private String password;

	public User(){
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
}
