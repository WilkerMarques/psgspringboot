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

import com.example.demo.model.Departamento;
import com.example.demo.repository.IDepartamentoRepository;

@RestController
@RequestMapping(path = "/api")
public class DepartamentoController {

	@Autowired
	private IDepartamentoRepository repo;

	@GetMapping(path = "/departamentos")
	public List<Departamento> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/departamentos/{id}")
	public Departamento getById(@PathVariable Integer id) {
		return this.repo.findById(id).orElse(null);
	}

	@PostMapping(path = "/departamentos")
	public Departamento post(@RequestBody Departamento departamento) {
		return this.repo.save(departamento);
	}

	@DeleteMapping(path = "/departamentos/{id}")
	public void delete(@PathVariable Integer id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/departamentos")
	public Departamento put(@RequestBody Departamento novoDepartamento) {
		return this.repo.findById(novoDepartamento.getDepartamentoID()).map(dep -> {
			dep.setDepartamentoID(novoDepartamento.getDepartamentoID());
			dep.setNome(novoDepartamento.getNome());
			dep.setInclusao(novoDepartamento.getInclusao());
			return this.repo.save(dep);
		}).orElse(null);

	}
}
