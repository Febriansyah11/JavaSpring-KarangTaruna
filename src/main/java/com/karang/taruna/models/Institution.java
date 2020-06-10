package com.karang.taruna.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "institutions")
public class Institution {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_institution", unique = true)
	private String id;

	@Column(name = "code", nullable = false, length = 25)
	private String institutionCode;

	@Column(name = "name", nullable = false, length = 64)
	private String institutionName;

	@Column(name = "rt_number", nullable = false, length = 5)
	private String rtNumber;

	@Column(name = "rw_number", nullable = false, length = 5)
	private String rwNumber;

	@Column(name = "village", nullable = false, length = 25)
	private String desa;

	@Column(name = "sub_district", nullable = false, length = 25)
	private String kecamatan;

	@Column(name = "district", nullable = false, length = 25)
	private String kabupatenKota;

	@Column(name = "province", nullable = false, length = 25)
	private String provinsi;

	@Column(name = "postal_code", nullable = false, length = 10)
	private String postalCode;

	@Column(name = "address", length = 100)
	private String alamat;

	@CreatedDate
	@Column(name = "created_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	@OneToOne(mappedBy = "institution", cascade = CascadeType.ALL)
	private Admin admin;

	@OneToMany
	@JoinColumn(name = "id_institution")
	private List<Event> event;

	@ManyToMany(mappedBy = "institution")
	private List<Users> users;

	public Institution() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getRtNumber() {
		return rtNumber;
	}

	public void setRtNumber(String rtNumber) {
		this.rtNumber = rtNumber;
	}

	public String getRwNumber() {
		return rwNumber;
	}

	public void setRwNumber(String rwNumber) {
		this.rwNumber = rwNumber;
	}

	public String getDesa() {
		return desa;
	}

	public void setDesa(String desa) {
		this.desa = desa;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getKabupatenKota() {
		return kabupatenKota;
	}

	public void setKabupatenKota(String kabupatenKota) {
		this.kabupatenKota = kabupatenKota;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Institution [id=" + id + ", institutionCode=" + institutionCode + ", institutionName=" + institutionName
				+ ", rtNumber=" + rtNumber + ", rwNumber=" + rwNumber + ", desa=" + desa + ", kecamatan=" + kecamatan
				+ ", kabupatenKota=" + kabupatenKota + ", provinsi=" + provinsi + ", postalCode=" + postalCode
				+ ", alamat=" + alamat + ", createdDate=" + createdDate + ", admin=" + admin + ", event=" + event
				+ ", users=" + users + "]";
	}

}
