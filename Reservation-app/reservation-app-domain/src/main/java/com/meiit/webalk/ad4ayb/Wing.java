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
public class Wing {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	@ManyToOne
	private Floor floor;
	@OneToMany
	private List<Room> rooms;
	@Enumerated(EnumType.STRING)
	private WingType wingType;

	public Wing(){
		super();
	}

	public Wing(String description, Floor floor, WingType wingType) {
		super();
		this.description = description;
		this.floor = floor;
		this.rooms = new ArrayList<>();
		this.wingType = wingType;
	}
	
}
