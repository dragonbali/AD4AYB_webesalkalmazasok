package com.meiit.webalk.ad4ayb;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Integer number;
	private Integer beds;
	private boolean balcon;
	@ManyToOne
	private Wing wing;
	private BigDecimal price;
	private Currency currency;

	public Room(){
		super();
	}

	public Room(Integer number, Integer beds, boolean balcon, Wing wing, BigDecimal price, Currency currency) {
		super();
		this.number = number;
		this.beds = beds;
		this.balcon = balcon;
		this.wing = wing;
		this.price = price;
		this.currency = currency;
	}
	
}
