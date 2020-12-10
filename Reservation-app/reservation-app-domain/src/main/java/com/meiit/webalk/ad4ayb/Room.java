package com.meiit.webalk.ad4ayb;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int number;
	private int beds;
	private boolean balcon;
	private BigDecimal price;
	@ManyToOne
	private Wing wing;
	
}
