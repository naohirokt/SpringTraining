package com.springtraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.MSection;

@Repository
public interface MSectionRepository extends JpaRepository<MSection, String>{
	public MSection findBySectionId(String sectionId);
}
