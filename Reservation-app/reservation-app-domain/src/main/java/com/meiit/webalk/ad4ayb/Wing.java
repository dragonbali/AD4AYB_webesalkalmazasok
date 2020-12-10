package com.meiit.webalk.ad4ayb;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
public class Wing {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	@ManyToOne
	private Floor floor;
	@OneToMany
	private List<Room> rooms;
	@Column
	private WingType wingType;
	
}
