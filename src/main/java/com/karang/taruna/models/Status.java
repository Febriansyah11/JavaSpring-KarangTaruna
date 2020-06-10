package com.karang.taruna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true)
	private String id;

	private String idInstitution;

	private String status;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users users;

	public Status() {}

	public Status(String idInstitution, String status, Users users) {
		this.idInstitution = idInstitution;
		this.status = status;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(String idInstitution) {
		this.idInstitution = idInstitution;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
