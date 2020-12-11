package com.meiit.webalk.ad4ayb;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
public class BookingPerson extends User{

	private String name;
	private Integer accountNumber;
	private BigDecimal balance;
	private LocalDate birth;
	@Enumerated(EnumType.STRING)
	private Currency currency;

	public BookingPerson(){
		super();
	}

	public BookingPerson(String email, String password, String name, Integer accountNumber, BigDecimal balance, LocalDate birth, Currency currency) {
		super(email, password);
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.birth = birth;
		this.currency = currency;
	}
	
}
