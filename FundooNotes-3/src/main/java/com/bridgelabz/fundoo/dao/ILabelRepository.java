package com.bridgelabz.fundoo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Label;

@Repository
public interface ILabelRepository extends JpaRepository<Label, Long>{

	//List<Label> findByUserId(long userId);
	@Query(value = "select * from userlabel where label_id=?", nativeQuery = true)
	List<Label> findByUserId(long userId);


}
