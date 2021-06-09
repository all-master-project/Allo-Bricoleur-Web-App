package org.allobricole.web.app.io.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="mission")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  scope=String.class,
		  property = "idm")
public class MissionEntity implements Serializable {

	private static final long serialVersionUID = -3271674134418020667L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idm;  
		
	private String titrem;
	 
    private LocalDate datedm;
	
    private String descm;
	 
    private String prixpropose;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idcl", insertable = false, updatable = false)
    private ClientEntity client;
    private Long idcl;
         
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ids", insertable = false, updatable = false)
    private ServiceEntity service;
    private String ids;
    
    public MissionEntity() {
		// TODO Auto-generated constructor stub
	}


	public MissionEntity(String titrem, LocalDate datedm, String descm, String prixpropose, ClientEntity client,
			Long idcl, ServiceEntity service, String ids) {
		super();
		this.titrem = titrem;
		this.datedm = datedm;
		this.descm = descm;
		this.prixpropose = prixpropose;
		this.client = client;
		this.idcl = idcl;
		this.service = service;
		this.ids = ids;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getIdcl() {
		return idcl;
	}

	public void setIdcl(Long idcl) {
		this.idcl = idcl;
	}

	public Long getIdm() {
		return idm;
	}

	public void setIdm(Long idm) {
		this.idm = idm;
	}

	public String getTitrem() {
		return titrem;
	}

	public void setTitrem(String titrem) {
		this.titrem = titrem;
	}

	public LocalDate getDatedm() {
		return datedm;
	}

	public void setDatedm(LocalDate datedm) {
		this.datedm = datedm;
	}

	public String getDescm() {
		return descm;
	}

	public void setDescm(String descm) {
		this.descm = descm;
	}

	public String getPrixpropose() {
		return prixpropose;
	}

	public void setPrixpropose(String prixpropose) {
		this.prixpropose = prixpropose;
	}

	@JsonBackReference(value = "mi-cl")
	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

    @JsonBackReference(value="se-mi")
	public ServiceEntity getService() {
		return service;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}
    
    
}
