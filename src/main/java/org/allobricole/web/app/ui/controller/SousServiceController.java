package org.allobricole.web.app.ui.controller;

import java.util.List;

import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.allobricole.web.app.service.SousServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@ComponentScan
@RestController()
@RequestMapping("/sousservices")
@CrossOrigin//(origins = "http://localhost:3000") 

public class SousServiceController {
     
	@Autowired
	private SousServiceService sousServiceService;
	
	
	@GetMapping("/getsousservices")
	public List<SousServiceEntity> getSousServices(){
		return sousServiceService.findAll();
	}
	
	@GetMapping("/{id}")
	public SousServiceEntity getSousServiceById(@PathVariable String idsd){
		return sousServiceService.findById(idsd);
	}
	
	@GetMapping("/sousservicesBricole/{id}")
	public List<BricoleurEntity> getSousServicesBricole(@PathVariable String idsd){
		return sousServiceService.getSousServicesBricole(idsd);
	}
	 
	@PostMapping("/save")
	public SousServiceEntity ajouterService(@RequestBody SousServiceEntity service){
		return sousServiceService.save(service);
	}
	
	@PutMapping("/updateService")
	public SousServiceEntity modifierService(@RequestBody SousServiceEntity service){
		
		SousServiceEntity oldService = sousServiceService.findById(service.getService().getIds());
		BeanUtils.copyProperties(service, oldService);
		sousServiceService.save(service);
		return oldService;
		}
	
}
