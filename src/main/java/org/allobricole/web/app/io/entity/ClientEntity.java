 package org.allobricole.web.app.io.entity;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="client")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  scope=Long.class,
		  property = "idcl")
public class ClientEntity implements Serializable {
 
	private static final long serialVersionUID = -3271674134418020667L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idcl;
		
	private String nomcl;
	
    private String prenomcl; 
	
    private String emailcl;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idv", insertable = false, updatable = false)
    private VilleEntity ville;
    private String idv;
    
    @OneToMany( mappedBy = "client", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MissionEntity> missions;
    
    public ClientEntity() {
		// TODO Auto-generated constructor stub
	}

	public ClientEntity(String nomcl, String prenomcl, String emailcl, VilleEntity ville, String idv,
			List<MissionEntity> missions) {
		super();
		this.nomcl = nomcl;
		this.prenomcl = prenomcl;
		this.emailcl = emailcl;
		this.ville = ville;
		this.idv = idv;
		this.missions = missions;
	}

	public String getIdv() {
		return idv;
	}

	public void setIdv(String idv) {
		this.idv = idv;
	}



	public Long getIdcl() {
		return idcl;
	}

	public void setIdcl(Long idcl) {
		this.idcl = idcl; 
	}

	public String getNomcl() {
		return nomcl;
	}

	public void setNomcl(String nomcl) {
		this.nomcl = nomcl;
	}

	public String getPrenomcl() {
		return prenomcl;
	}

	public void setPrenomcl(String prenomcl) {
		this.prenomcl = prenomcl;
	}

	public String getEmailcl() {
		return emailcl;
	}

	public void setEmailcl(String emailcl) {
		this.emailcl = emailcl;
	}

    @JsonBackReference(value = "vi-cl")
	public VilleEntity getVille() {
		return ville;
	}

	public void setVille(VilleEntity ville) {
		this.ville = ville;
	}

    @JsonManagedReference(value = "mi-cl")
	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}
    
	
    
}
