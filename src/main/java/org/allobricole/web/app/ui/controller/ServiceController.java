package org.allobricole.web.app.ui.controller;

import java.util.List;
import org.allobricole.web.app.io.entity.ServiceEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.allobricole.web.app.service.ServiceService;
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
@RequestMapping("/services")
@CrossOrigin//(origins = "http://localhost:3000") 

public class ServiceController {
     
	@Autowired
	private ServiceService serviceService;
	
	
	@GetMapping("/getservices")
	public List<ServiceEntity> services(){
		return serviceService.findAll();
	}
	
	@GetMapping(path="/getservicesById/{id}")
	public ServiceEntity services(@PathVariable String ids ){
		return serviceService.findById(ids);
	}
	
	@GetMapping(path="/getSouServices/{id}")
	public  List<SousServiceEntity> getSouServices(@PathVariable String ids ){
		return serviceService.getSouServices(ids);
	}
	 
	@PostMapping("/save")
	public ServiceEntity ajouterService(@RequestBody ServiceEntity service){
		return serviceService.save(service);
	}
	
	@PutMapping("/updateService")
	public ServiceEntity modifierService(@RequestBody ServiceEntity service){
		
		ServiceEntity oldService = serviceService.findById(service.getIds());
		BeanUtils.copyProperties(service, oldService);
		serviceService.save(service);
		return oldService;
		}
	
}
