package org.allobricole.web.app.ui.controller;

import java.util.List;
import org.allobricole.web.app.io.entity.RegionEntity;
import org.allobricole.web.app.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@ComponentScan
@RestController()
@RequestMapping("/regions")
@CrossOrigin//(origins = "http://localhost:3001")
public class RegionController {
     
	@Autowired 
	private RegionService regionService;
	
	
	@GetMapping("/getregions") 
	public List<RegionEntity> getRegions(){ 
		return regionService.regions();
	}
	
	@GetMapping(path="/{id}")
	public RegionEntity getRegion(@PathVariable String id){
		return regionService.getRegionByIdr(id);
	}
	 
	@PostMapping("/save")
	public RegionEntity addRegion(@RequestBody RegionEntity region){
		return regionService.addRegion(region);
	}
	 
	@PutMapping("/updateRegion")
	public RegionEntity updateRegion(@RequestBody RegionEntity region){
		return regionService.updateRegion(region);
	} 
	
	@DeleteMapping("/deleteRegion")
	public void deleteRegion(@RequestBody RegionEntity region){
		 regionService.deleteRegion(region);
	}
}
