package com.bridgelabz.fundoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundoo.model.Label;

public interface UserDao extends JpaRepository<Label, Long>{

}
