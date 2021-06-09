package org.allobricole.web.app.service;

import java.time.LocalDate;
import java.util.List;

import org.allobricole.web.app.dao.MissionRepository;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionService{
	
	@Autowired 
	MissionRepository missionRepository;	

	public MissionEntity findById(long id) {
		return missionRepository.findById(id).get();
	}

	public MissionEntity save(MissionEntity entity) {
		entity.setDatedm(LocalDate.now());
		MissionEntity missionEntity= missionRepository.save(entity);
		return missionEntity;
	}
	
	public void deleteById(long id) {
		missionRepository.deleteById(id);
	}
	
	public void delete(MissionEntity entity) {
		missionRepository.delete(entity);
	}
	
	public void deleteAll() {
		missionRepository.deleteAll();
	}
	
	public List<MissionEntity> findAll() {
		return missionRepository.findAll(); 
	}
	
	public MissionEntity updateMission(MissionEntity mission) {
		MissionEntity old = missionRepository.findById(mission.getIdm()).get();
		BeanUtils.copyProperties(mission, old);
		missionRepository.save(old);
		return old;
		
	}
}
