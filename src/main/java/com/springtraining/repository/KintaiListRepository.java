package com.springtraining.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.KintaiListEntity;

@Repository
public interface KintaiListRepository extends JpaRepository<KintaiListEntity, String>{
//	@Query("SELECT "
//			+ "u.user_id, u.name, t.attendance_date, t.attendance_type "
//			+ "FROM "
//			+ "m_user u, t_time t "
//			+ "WHERE "
//			+ "u.user_id = t.user_id "
//			+ "AND u.section_id = :sectionId ")
//	public List<KintaiListEntity> findKintaiList(@Param("sectionId") String sectionId);
}
