package org.allobricole.web.app.dao;

import java.util.List;

import org.allobricole.web.app.io.entity.BricoleurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BricoleurRepository extends JpaRepository<BricoleurEntity, Long>{
	BricoleurEntity findByEmail(String email);
} 
 