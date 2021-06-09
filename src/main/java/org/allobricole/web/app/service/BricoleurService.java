package org.allobricole.web.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.allobricole.web.app.dao.BricoleurRepository;
import org.allobricole.web.app.dao.SousServiceRepository;
import org.allobricole.web.app.dao.VilleRepository;
import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.ClientEntity;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.allobricole.web.app.io.entity.UserEntity;
import org.allobricole.web.app.io.entity.VilleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BricoleurService{
	@Autowired
	BricoleurRepository bricoleurRepository;
	
	@Autowired
	SousServiceRepository sousServiceRepository;
	
	@Autowired
	UserService userService;
		
	@Autowired
	MissionService missionService;
	

	@Autowired
	VilleRepository villeRepository;
	
	
	private List<MissionEntity> missionsByVille;
	private List<MissionEntity> missionsByIdService;

	public void deleteBricoleur(BricoleurEntity bricoleurEntity){
		bricoleurRepository.delete(bricoleurEntity);	
	}
	
	public void deleteByIdb(Long bricoId) {
		bricoleurRepository.deleteById(bricoId);
	    }
	
	public BricoleurEntity updateBricoleurs(BricoleurEntity bricoleur){
		if(bricoleur!=null) { 
			BricoleurEntity oldBrico = bricoleurRepository.findById(bricoleur.getIdb()).get();
			bricoleur.setIdb(bricoleur.getIdb());
			return bricoleurRepository.save(bricoleur);
		}else return null;
	}
	
	public BricoleurEntity addBricoleur(BricoleurEntity bricoleur) throws NullPointerException{
		 missionsByIdService= new ArrayList(); 
		 missionsByVille= new ArrayList();
		//get id Sous Service and fin Entity SousService By Idsb
		String idsd = bricoleur.getIdsd();
		SousServiceEntity sousService = sousServiceRepository.findById(idsd).get();
		
		//Mapping data ManyToMany
		bricoleur.getSousservices().add(sousService);
		sousService.getBricoleurs().add(bricoleur);			
		
		//add Login Concept
		String userName = bricoleur.getEmail();
		String hasRole = "USER";
		String password = bricoleur.getMotpasseb();
		UserEntity user = new UserEntity(userName, password, hasRole);
		userService.addUser(user);
		//prepare List Mission 
		//filter missions By Id Service
		String ids = sousService.getIds();
		VilleEntity ville = villeRepository.findById(bricoleur.getIdv()).get();
		ville.getClients().forEach((client)->{
			client.getMissions().forEach((mission)->{
				if(ids.equalsIgnoreCase(mission.getIds())) missionsByIdService.add(mission);
			});
		});
		System.out.println(missionsByIdService);
		BricoleurEntity brico = bricoleurRepository.save(bricoleur);
		return brico;
//		return null;
	};  
	
	public BricoleurEntity getbricoleur(long idb) {
		return bricoleurRepository.findById(idb).get();
	}
	
	public List<BricoleurEntity> getbricoleurs(){
		 List<BricoleurEntity> bricoleurs = bricoleurRepository.findAll();
	return bricoleurs;
	}


	public List<SousServiceEntity> findSousservicesbricoleurs(Long id) {
		List<SousServiceEntity> sousservice = (List<SousServiceEntity>) bricoleurRepository.findById(id).get().getSousservices();
		return null;
	}

	public List<MissionEntity> viewMissons() {
		return missionsByIdService;
	}

	public BricoleurEntity getbricoleurByEmail(String username) {
		System.out.println(username);
		BricoleurEntity brico = new BricoleurEntity();
		List <BricoleurEntity> bricoleurs= bricoleurRepository.findAll();
		for (BricoleurEntity bricoleurEntity : bricoleurs) {
			if(bricoleurEntity.getEmail().equalsIgnoreCase(username)) {
				brico=bricoleurEntity;
				System.out.println("isPresent");
				System.out.println(brico);
			} 
		}
		System.out.println(bricoleurs);
		return brico;
	}

	public List<MissionEntity> viewMissonsByIdb(Long id) {
		List<MissionEntity> viewMissonsByIdb = new ArrayList<MissionEntity>();
		BricoleurEntity bricoleur = bricoleurRepository.findById(id).get();
		String idsd = bricoleur.getIdsd();
		SousServiceEntity sousService = sousServiceRepository.findById(idsd).get();
		String ids = sousService.getIds();
		VilleEntity ville = villeRepository.findById(bricoleur.getIdv()).get();
		ville.getClients().forEach((client)->{
			client.getMissions().forEach((mission)->{
				if(ids.equalsIgnoreCase(mission.getIds())) viewMissonsByIdb.add(mission);
			});
		});
		
		return viewMissonsByIdb;
	}  
}
