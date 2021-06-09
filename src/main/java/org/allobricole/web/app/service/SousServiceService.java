package org.allobricole.web.app.service;

import java.util.List;
import org.allobricole.web.app.dao.SousServiceRepository;
import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SousServiceService{
	
	@Autowired 
	SousServiceRepository sousSericeRepository;	

	public SousServiceEntity findById(String id) {
		return sousSericeRepository.findById(id).get();
	}

	public SousServiceEntity save(SousServiceEntity entity) {
		return sousSericeRepository.save(entity);
	}
	
	public void deleteById(String id) {
		sousSericeRepository.deleteById(id);
	}
	
	public void delete(SousServiceEntity entity) {
		sousSericeRepository.delete(entity);
	}
	
	public void deleteAll() {
		sousSericeRepository.deleteAll();
	}
	
	public List<SousServiceEntity> findAll() {
		return sousSericeRepository.findAll(); 
	}
	
	public SousServiceEntity updateService(SousServiceEntity sousSerice) {
		SousServiceEntity old = sousSericeRepository.findById(sousSerice.getIdsd()).get();
		BeanUtils.copyProperties(sousSerice, old);
		sousSericeRepository.save(old); 
		return old;
		
	}

	public List<BricoleurEntity> getSousServicesBricole(String idsd) {
		 List<BricoleurEntity> bricoleurs = sousSericeRepository.findById(idsd).get().getBricoleurs();
		return bricoleurs;
	}

}
