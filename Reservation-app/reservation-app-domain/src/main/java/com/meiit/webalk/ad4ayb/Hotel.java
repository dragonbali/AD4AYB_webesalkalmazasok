package com.meiit.webalk.ad4ayb;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String address;
	private Integer stars;
	@OneToMany
	private List<Floor> floors;

	public Hotel(){
		super();
	}

	public Hotel(String name, String address, Integer stars) {
		super();
		this.name = name;
		this.address = address;
		this.stars = stars;
		this.floors = new ArrayList<>();
	}
	
}
