package org.allobricole.web.app.io.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="sousservice")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  scope = String.class,
		  property = "idsd")
public class SousServiceEntity implements Serializable {
 
	private static final long serialVersionUID = -3271674134418020667L;
 
	@Id
	private String idsd;  
		
	@Column(nullable = false)
	private String nomsd;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ids", insertable = false, updatable = false)
	private ServiceEntity service; 
	private String ids;
	
	@ManyToMany(mappedBy = "sousservices")
	private List<BricoleurEntity> bricoleurs= new ArrayList<>(); 
	
	public SousServiceEntity() { 
  
	} 

	public SousServiceEntity(String idsd, String nomsd, ServiceEntity service, String ids) {
		super(); 
		this.idsd = idsd;
		this.nomsd = nomsd;
		this.service = service;
		this.ids = ids;
	}
	
	public void addBricoleur(BricoleurEntity bricoleur) {
		bricoleurs.add(bricoleur);
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getIdsd() {
		return idsd;
	}

	public void setIdsd(String idsd) {
		this.idsd = idsd;
	}

	public String getNomsd() {
		return nomsd;
	}

	public void setNomsd(String nomsd) {
		this.nomsd = nomsd;
	}
	@JsonBackReference(value = "se-so")
	public ServiceEntity getService() {
		return service;
	}
 
	public void setService(ServiceEntity service) {
		this.service = service;
	} 

	@JsonBackReference(value="br-so") 
	public List<BricoleurEntity> getBricoleurs() {
		return bricoleurs; 
	}

	public void setBricoleurs(List<BricoleurEntity> bricoleurs) {
		this.bricoleurs = bricoleurs;
	}
	
}
