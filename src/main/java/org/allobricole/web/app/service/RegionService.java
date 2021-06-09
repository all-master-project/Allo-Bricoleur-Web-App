package org.allobricole.web.app.service;

import java.util.List;
import org.allobricole.web.app.dao.RegionRepository;
import org.allobricole.web.app.io.entity.RegionEntity;
import org.codehaus.groovy.ast.tools.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class RegionService{

	@Autowired
	RegionRepository regionRepository;
	
	public RegionService() {
		
	}
	
	
	public void deleteRegion(RegionEntity regionEntity){
		regionRepository.delete(regionEntity);	
	}
	
	public void deleteByIdr(String idr){
		regionRepository.deleteById(idr);	
	}
	
	public RegionEntity addRegion(RegionEntity region) throws NullPointerException{
		RegionEntity brico = region != null? region:null;
		return regionRepository.save(brico);
	};
	
	public List<RegionEntity> regions(){
		return (List<RegionEntity>) regionRepository.findAll();
		}

	public RegionEntity getRegionByIdr(String idr){
		return  regionRepository.findById(idr).get();
		}
	
	public RegionEntity updateRegion(RegionEntity region) {
		RegionEntity old = regionRepository.findById(region.getIdr()).get();
		org.springframework.beans.BeanUtils.copyProperties(region, old);
		return regionRepository.save(old);
	}
}
