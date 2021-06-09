package org.allobricole.web.app.io.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import groovy.transform.Generated;

@Entity()
@Table(name="service")
@JsonIdentityInfo(
		  scope=String.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "ids")
public class ServiceEntity implements Serializable {

	private static final long serialVersionUID = -3271674134418020667L;
	
	@Id
	private String ids; 
		
	@Column(nullable = false)
	private String noms;
	
	@OneToMany(mappedBy = "service", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MissionEntity> missions;
	 
	@OneToMany(mappedBy = "service", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List <SousServiceEntity> souServices;

	public ServiceEntity(String ids, String noms, List<MissionEntity> missions, List<SousServiceEntity> souServices) {
		super();
		this.ids = ids;
		this.noms = noms;
		this.missions = missions;
		this.souServices = souServices;
	}
	
	public ServiceEntity() {
		// TODO Auto-generated constructor stub 
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getNoms() {
		return noms;
	}

	public void setNoms(String noms) {
		this.noms = noms;
	}

	@JsonManagedReference(value = "se-mi")
	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}

	@JsonManagedReference(value = "se-so")
	public List<SousServiceEntity> getSouServices() {
		return souServices;
	}

	public void setSouServices(List<SousServiceEntity> souServices) {
		this.souServices = souServices;
	}
	
	
	
}
