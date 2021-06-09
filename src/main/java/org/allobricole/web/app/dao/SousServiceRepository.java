package org.allobricole.web.app.dao;


import org.allobricole.web.app.io.entity.SousServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SousServiceRepository extends JpaRepository<SousServiceEntity, String> {
	
} 
