package org.allobricole.web.app.ui.controller;

import java.util.List;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.service.MissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@ComponentScan
@RestController()
@RequestMapping("/missions")
@CrossOrigin//(origins = "http://localhost:3001") 
 
public class MissionController {
     
	@Autowired
	private MissionService missionService;
	
	
	@GetMapping("/getmissions")
	public List<MissionEntity> missions(){
		return missionService.findAll();
	}
	 
	@PostMapping("/save")
	public MissionEntity ajouterMission(@RequestBody MissionEntity mission){
		return missionService.save(mission);
	}
	
	@PutMapping("/updateMission")
	public MissionEntity modifierMission(@RequestBody MissionEntity mission){
		
		MissionEntity oldMission = missionService.findById(mission.getIdm());
		BeanUtils.copyProperties(mission, oldMission);
		missionService.save(mission);
		return oldMission;
		}
	
}
