package org.allobricole.web.app.ui.controller;

import java.util.List;
import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.allobricole.web.app.service.BricoleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@ComponentScan
@RequestMapping("/bricoleurs")
@CrossOrigin
@JsonIgnoreProperties("inspection") 
public class BricoleurController {

	private BricoleurService bricoleurService2;
	@Autowired
	BricoleurService bricoleurService;
	
	 
	@GetMapping(path="/{id}") 
	public BricoleurEntity bricoleur(@PathVariable Long id) 
	{
		return bricoleurService.getbricoleur(id);
	}
	
	@GetMapping("/getbricoleurs")
	public List<BricoleurEntity> bricoleurs() 
	{
		return bricoleurService.getbricoleurs();
	}
	
		@GetMapping(path="/getbricoleurByEmail/{id}")
//		@ResponseBody
	public BricoleurEntity getbricoleurByEmail
	           (@PathVariable(name="id") String id) 
	{
			System.out.println(id);
		return bricoleurService.getbricoleurByEmail(id);
	}
	
	@GetMapping(path="/sousservicesbricoleurs/{id}")
	public List<SousServiceEntity> sousservicesbricoleurs(@PathVariable Long id) 
	{
		return bricoleurService.findSousservicesbricoleurs(id);
	} 
	
	@GetMapping("/viewMissons")
	public List<MissionEntity> viewMissons() 
	{
		return bricoleurService.viewMissons();
	}
	
	@GetMapping(path="/viewMissonsByIdb/{id}")
	public List<MissionEntity> viewMissonsByIdb(@PathVariable Long id) 
	{
		return bricoleurService.viewMissonsByIdb(id);
	}
	
	@PostMapping("/addBricoleur")
	public BricoleurEntity createBricoleurs(@RequestBody BricoleurEntity brico) 
	{
		return bricoleurService.addBricoleur(brico);
	} 
	
	@PutMapping()
	public BricoleurEntity updateBricoleurs(@RequestBody BricoleurEntity brico) 
	{
		return bricoleurService.updateBricoleurs(brico);
	}
	
	@DeleteMapping()
	public void deleteBricoleurs(@RequestBody BricoleurEntity brico) 
	{
		 bricoleurService.deleteBricoleur(brico);
	}
}
