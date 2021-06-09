package org.allobricole.web.app.service;

import java.util.List;

import org.allobricole.web.app.dao.VilleRepository;
import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.ClientEntity;
import org.allobricole.web.app.io.entity.VilleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VilleService{
	
	@Autowired 
	VilleRepository villeRepository;	

	public VilleEntity findById(String id) {
		return villeRepository.findById(id).get();
	}

	public VilleEntity save(VilleEntity entity) {
		return villeRepository.save(entity);
	}
	
	public void deleteById(String id) {
		villeRepository.deleteById(id);
	}
	
	public void delete(VilleEntity entity) {
		villeRepository.delete(entity);
	}
	
	public void deleteAll() {
		villeRepository.deleteAll();
	}
	
	public List<VilleEntity> findAll() {
		return villeRepository.findAll();
	}
	
	public VilleEntity updateVille(VilleEntity ville) {
		VilleEntity old = villeRepository.findById(ville.getIdv()).get();
		BeanUtils.copyProperties(ville, old);
		villeRepository.save(old);
		return old;
		
	}

	public List<BricoleurEntity> getBricoleursVille(String idv) {

		List<BricoleurEntity> bricoleurs = villeRepository.findById(idv).get().getBricoleurs();
		return bricoleurs;
	}

	public List<ClientEntity> getClientsVille(String idcl) {
		List<ClientEntity> clients = villeRepository.findById(idcl).get().getClients();
		return clients; 
	}

	public List<ClientEntity> getAllClientByVille(String idv) {
		List<ClientEntity> clientsVilleId= villeRepository.findById(idv).get().getClients();
		return clientsVilleId;
	} 

}
