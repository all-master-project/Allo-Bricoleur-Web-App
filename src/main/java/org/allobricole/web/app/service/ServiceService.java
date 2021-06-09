package org.allobricole.web.app.service;

import java.time.LocalDate;
import java.util.List;
import org.allobricole.web.app.dao.ServiceRepository;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.io.entity.ServiceEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService{
	
	@Autowired 
	ServiceRepository serviceRepository;	

	public ServiceEntity findById(String id) {
		return serviceRepository.findById(id).get();
	}

	public ServiceEntity save(ServiceEntity entity) {
		return serviceRepository.save(entity);
	}
	
	public void deleteById(String id) {
		serviceRepository.deleteById(id);
	}
	
	public void delete(ServiceEntity entity) {
		serviceRepository.delete(entity);
	}
	
	public void deleteAll() {
		serviceRepository.deleteAll();
	}
	
	public List<ServiceEntity> findAll() {
		return serviceRepository.findAll(); 
	}
	
	public ServiceEntity updateService(ServiceEntity service) {
		ServiceEntity old = serviceRepository.findById(service.getIds()).get();
		BeanUtils.copyProperties(service, old);
		serviceRepository.save(old);
		return old;
		
	}

	public List<SousServiceEntity> getSouServices(String ids) {
		List<SousServiceEntity> sousService = serviceRepository.findById(ids).get().getSouServices();
		return sousService ;
	}
	
	public List<MissionEntity> getMissionServices(String ids) {
		List<MissionEntity> missions = serviceRepository.findById(ids).get().getMissions();
		return missions ;
	}

}
