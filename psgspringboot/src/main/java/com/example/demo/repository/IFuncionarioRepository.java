package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Funcionario;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query(value = "select MAX(FuncionarioID) AS MAXID from Funcionario", nativeQuery = true)
	Integer findByFuncionarioIDMAX();

	List<Funcionario> findByFuncionarioID(int funid);

	List<Funcionario> findByNome(String nome);

	List<Funcionario> findBySobrenome(String sobrenome);

	List<Funcionario> findByNomeAndSobrenome(String nome, String sobrenome);

}
