package org.allobricole.web.app.ui.controller;

import java.util.List;

import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.allobricole.web.app.io.entity.ClientEntity;
import org.allobricole.web.app.io.entity.VilleEntity;
import org.allobricole.web.app.service.VilleService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 

@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping("/villes")
@RestController()
public class VilleController {
     
	@Autowired
	private VilleService villeService;
	 
	
	@GetMapping("/getvilles")
	public List<VilleEntity> villes(){ 
		return villeService.findAll();
	}
	
	@GetMapping("/{id}")
	public VilleEntity villeById(@PathVariable String id){ 
		return villeService.findById(id);
	}
	
	@GetMapping("/clientsVille/{id}")
	public List<ClientEntity> getClientsVille(@PathVariable String idv){ 
		return villeService.getClientsVille(idv);
	}
	
	@GetMapping("/getAllClientByVille/{id}")
	public List<ClientEntity> getAllClientByVille(@PathVariable String idv){ 
		return villeService.getAllClientByVille(idv);
	}
	
	
	@GetMapping("/bricoleursVille/{id}")
	public List<BricoleurEntity> getBricoleursVille(@RequestParam(name = "id", required = false, defaultValue="Casa") String id){ 
		return villeService.getBricoleursVille(id);
	}
	
	@PostMapping("/save")
	public VilleEntity ajouterVille(@RequestBody VilleEntity ville){
		return villeService.save(ville);
	}
	
	@PutMapping("/modifierVille")
	public VilleEntity modifierVilles(@RequestBody VilleEntity ville){
		 
		VilleEntity Newville = new VilleEntity();
		Newville.setIdv(ville.getIdv());
		BeanUtils.copyProperties(ville, Newville);
		return Newville;
		}
	
} 
