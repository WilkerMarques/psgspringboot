package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FuncionarioPorDepartamento;
import com.example.demo.repository.IFuncionarioPorDepartamentoRepository;

@RestController
@RequestMapping(path = "/api")
public class FuncionarioPorDepartamentoController {

	@Autowired
	private IFuncionarioPorDepartamentoRepository repo;

	@GetMapping(path = "/funcionariospordeptos/MAX")
	public Integer getMAX() {
		return this.repo.findByFuncionarioPorDepartamentoIDMAX();
	}

	@GetMapping(path = "/funcionariospordeptos")
	public List<FuncionarioPorDepartamento> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/funcionariospordeptos/{id}")
	public FuncionarioPorDepartamento getById(@PathVariable Integer id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/departamentos/{dep}/funcionariospordeptos")
	public List<FuncionarioPorDepartamento> getDepartamentoID(@PathVariable int dep) {
		return this.repo.findByDepartamentoID(dep);
	}

	@GetMapping(path = "/funcionarios/{fun}/funcionariospordeptos")
	public List<FuncionarioPorDepartamento> getFuncionarioID(@PathVariable int fun) {
		return this.repo.findByFuncionarioID(fun);
	}
	
	
	
	@GetMapping(path = "/departamentos/{inicio}/{fim}")
	public List<FuncionarioPorDepartamento> getByFuncionarioPorDepartamentoIDBetween(@PathVariable Integer inicio,@PathVariable Integer fim){
		return this.repo.findByFuncionarioPorDepartamentoIDBetween(inicio, fim);
	}


	@PostMapping(path = "/funcionariospordeptos")
	public FuncionarioPorDepartamento post(@RequestBody FuncionarioPorDepartamento funcionarioPorDepartamento) {
		funcionarioPorDepartamento.setFuncionarioPorDepartamentoID(repo.findByFuncionarioPorDepartamentoIDMAX() + 1);
		return this.repo.save(funcionarioPorDepartamento);
	}

	@DeleteMapping(path = "/funcionariospordeptos/{id}")
	public void delete(@PathVariable Integer id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/funcionariospordeptos")
	public FuncionarioPorDepartamento put(@RequestBody FuncionarioPorDepartamento novoFuncionarioDepto) {
		return this.repo.findById(novoFuncionarioDepto.getFuncionarioPorDepartamentoID()).map(fun -> {
			fun.setFuncionarioPorDepartamentoID(novoFuncionarioDepto.getFuncionarioPorDepartamentoID());
			fun.setFuncionarioID(novoFuncionarioDepto.getFuncionarioID());
			fun.setDepartamentoID(novoFuncionarioDepto.getDepartamentoID());
			fun.setEntradaDepartamento(novoFuncionarioDepto.getEntradaDepartamento());
			fun.setSaidaDepartamento(novoFuncionarioDepto.getSaidaDepartamento());
			return this.repo.save(fun);
		}).orElse(null);

	}
}
