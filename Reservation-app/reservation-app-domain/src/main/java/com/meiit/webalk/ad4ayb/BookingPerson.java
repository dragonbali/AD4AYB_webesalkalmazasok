package com.meiit.webalk.ad4ayb;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
@EqualsAndHashCode(callSuper=false)
public class BookingPerson extends User {
	private String name;
	private int accountNumber;
	private BigDecimal balance;
	private LocalDate birth;
	@Column
	private Currency currency;
}
