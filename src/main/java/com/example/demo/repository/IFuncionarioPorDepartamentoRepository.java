package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FuncionarioPorDepartamento;

@Repository
public interface IFuncionarioPorDepartamentoRepository extends JpaRepository<FuncionarioPorDepartamento, Integer> {

	@Query(value = "select MAX(FuncionarioPorDepartamentoID) AS MAXID from FuncionarioPorDepartamento", nativeQuery = true)
	Integer findByFuncionarioPorDepartamentoIDMAX();

	List<FuncionarioPorDepartamento> findByDepartamentoID(int dep);

	List<FuncionarioPorDepartamento> findByFuncionarioID(int fun);

	List<FuncionarioPorDepartamento> findByFuncionarioPorDepartamentoIDBetween(Integer inicio, Integer fim);
	
}