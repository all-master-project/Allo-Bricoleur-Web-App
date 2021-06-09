package org.allobricole.web.app.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="ville")
@JsonIgnoreProperties("inspection")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  scope=String.class,
		  property = "idv")
public class VilleEntity implements Serializable {
	
	private static final long serialVersionUID = 5014481686436179795L;
	@Id
	private String idv;
	private String nomv;
	 
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idr", insertable = false, updatable = false)
	private RegionEntity region;
	private String idr;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "ville", cascade = CascadeType.ALL)
	private List<BricoleurEntity> bricoleurs;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "ville", cascade = CascadeType.ALL)
	private List<ClientEntity> clients; 
	
	public VilleEntity() {
		// TODO Auto-generated constructor stub
	}

	

	public VilleEntity(String idv, String nomv, RegionEntity region, String idr, List<BricoleurEntity> bricoleurs,
			List<ClientEntity> clients) {
		super();
		this.idv = idv;
		this.nomv = nomv;
		this.region = region;
		this.idr = idr;
		this.bricoleurs = bricoleurs;
		this.clients = clients;
	}

	@JsonBackReference(value = "re-vi")
	public RegionEntity getRegion() {
		return region;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}

	public String getIdr() {
		return idr;
	}

	public void setIdr(String idr) {
		this.idr = idr;
	}

	public String getIdv() {
		return idv;
	}

	public void setIdv(String idv) {
		this.idv = idv;
	}

	public String getNomv() {
		return nomv;
	}

	public void setNomv(String nomv) {
		this.nomv = nomv;
	}

	@JsonManagedReference(value="vi-br")
	public List<BricoleurEntity> getBricoleurs() {
		return bricoleurs;
	}
	
	public void setBricoleurs(List<BricoleurEntity> bricoleurs) {
		this.bricoleurs = bricoleurs;
	}
	 
	@JsonManagedReference(value = "vi-cl")
	public List<ClientEntity> getClients() {
		return clients;
	}

	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}
	 
} 
