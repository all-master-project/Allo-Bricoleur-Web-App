package org.allobricole.web.app.io.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="bricoleur")
public class BricoleurEntity implements Serializable {

	private static final long serialVersionUID = -3271674134418020667L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idb;
		
	private String nomb;
	 
    private String prenomb;

    private String cinb; 
	
    private String adresseb;
	
    private String telb;
	
    private String motpasseb; 
	
    private String email;
	 
    private int anneexperienceb; 
	  
    private String aproposb;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="idv", insertable = false, updatable = false)
    private VilleEntity ville; 
    private String idv;
     
    @ManyToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Bricoleur_sousservice",
    joinColumns = @JoinColumn(name = "idbricoleur", referencedColumnName = "idb"),
    inverseJoinColumns = @JoinColumn(name = "idsousservice", referencedColumnName = "idsd"))
    private List<SousServiceEntity> sousservices= new ArrayList<>();
    private String  idsd ;
    public BricoleurEntity() {   

    }
    
    
    	public BricoleurEntity(String nomb, String prenomb, String cinb, String adresseb, String telb, String motpasseb,
			String email, int anneexperienceb, String aproposb, VilleEntity ville, String idv, String idsd) {
		super();
		this.nomb = nomb;
		this.prenomb = prenomb;
		this.cinb = cinb;
		this.adresseb = adresseb;
		this.telb = telb;
		this.motpasseb = motpasseb;
		this.email = email;
		this.anneexperienceb = anneexperienceb;
		this.aproposb = aproposb;
		this.ville = ville;
		this.idv = idv;
		this.idsd= idsd;
	}

    	

	public String getIdsd() {
			return idsd;
		}


		public void setIdsd(String idsd) {
			this.idsd = idsd;
		}


	public String getIdv() {
		return idv;
	}

	public void setIdv(String idv) {
		this.idv = idv;
	}
	
	@JsonBackReference(value="br-so") 
	public List<SousServiceEntity> getSousservices() {
		return sousservices;
	}

	public void setSousservices(List<SousServiceEntity> sousservices) {
		this.sousservices = sousservices;
	}

	public Long getIdb() {
		return idb;
	}

	public void setIdb(Long idb) {
		this.idb = idb;
	}

	public String getNomb() {
		return nomb;
	}

	public void setNomb(String nomb) {
		this.nomb = nomb;
	}

	public String getPrenomb() {
		return prenomb;
	}

	public void setPrenomb(String prenomb) {
		this.prenomb = prenomb;
	}

	public String getCinb() {
		return cinb;
	}

	public void setCinb(String cinb) {
		this.cinb = cinb;
	}

	public String getAdresseb() {
		return adresseb;
	}

	public void setAdresseb(String adresseb) {
		this.adresseb = adresseb;
	}

	public String getTelb() {
		return telb;
	}

	public void setTelb(String telb) {
		this.telb = telb;
	}

	public String getMotpasseb() {
		return motpasseb;
	}

	public void setMotpasseb(String motpasseb) {
		this.motpasseb = motpasseb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnneexperienceb() {
		return anneexperienceb;
	}

	public void setAnneexperienceb(int anneexperienceb) {
		this.anneexperienceb = anneexperienceb;
	}

	public String getAproposb() {
		return aproposb; 
	}

	public void setAproposb(String aproposb) {
		this.aproposb = aproposb;
	}

    @JsonBackReference(value = "vi-br")
	public VilleEntity getVille() {
		return ville;
	}

	public void setVille(VilleEntity ville) {
		this.ville = ville;
	}


}
