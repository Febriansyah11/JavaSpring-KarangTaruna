package com.karang.taruna.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_event", unique = true)
	private String id;

	@Column(nullable = false, length = 64)
	private String tittle;

	@Column(nullable = false, length = 100)
	private String purpose;

	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column(name = "end_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column(name = "total", length = 15)
	private BigDecimal moneyOwned;

	private String valdate;

	@OneToMany
	@JoinColumn(name = "id_event")
	private Set<EventDetail> event_detail;

	@ManyToOne
	@JoinColumn(name = "id_institution")
	private Institution institution;

	@Column(name = "institution_id")
	private String idInstitution;

	@OneToMany
	@JoinColumn(name = "id_event")
	private List<EventBank> eventBanks;

	@OneToMany
	@JoinColumn(name = "id_event")
	private List<WithdrawalHistory> withdrawalHistories;

	public Event() {
	}

	public Event(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getMoneyOwned() {
		return moneyOwned;
	}

	public void setMoneyOwned(BigDecimal moneyOwned) {
		this.moneyOwned = moneyOwned;
	}

	public String getValdate() {
		return valdate;
	}

	public void setValdate(String valdate) {
		this.valdate = valdate;
	}

	public Set<EventDetail> getEvent_detail() {
		return event_detail;
	}

	public void setEvent_detail(Set<EventDetail> event_detail) {
		this.event_detail = event_detail;
	}

	public String getInstitution() {
		return institution.getId();
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(String idInstitution) {
		this.idInstitution = idInstitution;
	}

	public List<EventBank> getEventBanks() {
		return eventBanks;
	}

	public void setEventBanks(List<EventBank> eventBanks) {
		this.eventBanks = eventBanks;
	}

	public BigDecimal add(BigDecimal arg0) {
		return moneyOwned.add(arg0);
	}

	public BigDecimal subtract(BigDecimal arg0) {
		return moneyOwned.subtract(arg0);
	}

	public List<WithdrawalHistory> getWithdrawalHistories() {
		return withdrawalHistories;
	}

	public void setWithdrawalHistories(List<WithdrawalHistory> withdrawalHistories) {
		this.withdrawalHistories = withdrawalHistories;
	}

}
