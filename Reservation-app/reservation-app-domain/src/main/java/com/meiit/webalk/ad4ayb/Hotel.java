package com.meiit.webalk.ad4ayb;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String address;
	private int stars;
	@OneToMany
	private List<Floor>floors;
}
