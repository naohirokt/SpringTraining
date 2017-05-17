package com.springtraining.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.Kbnch;

@Repository
public interface KbnchRepository extends JpaRepository<Kbnch, String>{
	public Kbnch findById(String kbnch, Object kbnchCd);
	public List<Kbnch> findByIdKbnchOrderBySortNo(String kbnch);
}
