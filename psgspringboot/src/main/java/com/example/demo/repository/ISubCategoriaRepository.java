package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SubCategoria;

@Repository
public interface ISubCategoriaRepository extends JpaRepository<SubCategoria, Integer>{	
	List<SubCategoria>findByCategoriaID(int catid);
}

