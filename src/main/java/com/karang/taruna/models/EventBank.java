package com.karang.taruna.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event_bank")
public class EventBank {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_eventbank", unique = true)
	private String id;

	private String username;

	private BigDecimal pay;

	@Column(name = "payment_date")
	private String paymentDate;

	private BigDecimal total;

	@Column(name = "user_id")
	private String idUser;

	@ManyToOne
	@JoinColumn(name = "id_event")
	private Event event;

	public EventBank() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPay() {
		return pay;
	}

	public void setPay(BigDecimal pay) {
		this.pay = pay;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getEvent() {
		return event.getId();
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "EventBank [id=" + id + ", username=" + username + ", paymentDate=" + paymentDate + ", pay=" + pay
				+ ", total=" + total + ", idUser=" + idUser + "]";
	}

	public BigDecimal add(BigDecimal arg0) {
		return total.add(arg0);
	}

	public BigDecimal subtract(BigDecimal arg0) {
		return total.subtract(arg0);
	}

}
