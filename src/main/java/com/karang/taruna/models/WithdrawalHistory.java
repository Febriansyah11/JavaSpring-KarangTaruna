package com.karang.taruna.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "withdrawal_history")
public class WithdrawalHistory {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true)
	private String id;

	@Column(name = "message_function")
	private String messageFunction;
	
	private BigDecimal moneys;

	private String date;
		
	private String adminName;
	
	@ManyToOne
	@JoinColumn(name = "id_event")
	private Event event;

	public WithdrawalHistory() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessageFunction() {
		return messageFunction;
	}

	public void setMessageFunction(String messageFunction) {
		this.messageFunction = messageFunction;
	}

	public BigDecimal getMoneys() {
		return moneys;
	}

	public void setMoneys(BigDecimal moneys) {
		this.moneys = moneys;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getEvent() {
		return event.getId();
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
