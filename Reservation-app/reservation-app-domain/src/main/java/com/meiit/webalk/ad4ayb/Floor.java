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
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Integer floorNumber;
	@ManyToOne
	private Hotel hotel;
	@OneToMany
	private List<Wing> wings;

	public Floor(){
		super();
	}

	public Floor(Integer floorNumber, Hotel hotel) {
		super();
		this.floorNumber = floorNumber;
		this.hotel = hotel;
		this.wings = new ArrayList<>();
	}
	
}
