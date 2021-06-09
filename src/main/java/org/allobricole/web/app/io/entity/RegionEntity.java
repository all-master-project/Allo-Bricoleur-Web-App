package org.allobricole.web.app.io.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="region")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  scope=String.class,
		  property = "idr")
public class RegionEntity {

	@Id
	private String idr;
	private String nomr;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "region")
	private List<VilleEntity> villes;

	public RegionEntity() {
 
	}

	public RegionEntity(String idr, String nomr, List<VilleEntity> villes) {
		super();
		this.idr = idr;
		this.nomr = nomr;
		this.villes = villes;
	}

	
	public String getIdr() { 
		return idr;
	}

	public void setIdr(String idr) {
		this.idr = idr;
	}

	public String getNomr() {
		return nomr;
	}

	public void setNomr(String nomr) {
		this.nomr = nomr;
	}

	@JsonManagedReference(value = "re-vi")
	public List<VilleEntity> getVilles() {
		return villes;
	}

	public void setVilles(List<VilleEntity> villes) {
		this.villes = villes;
	}
	
	
}
