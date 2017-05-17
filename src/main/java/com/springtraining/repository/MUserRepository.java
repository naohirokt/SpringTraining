package com.springtraining.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.MUser;

@Repository
public interface MUserRepository extends JpaRepository<MUser, String>{

	public MUser findByUserId(String userId);

	public MUser findByUserIdAndPassword(String userId, String loginPassword);

}
