package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.IFuncionarioRepository;

@RestController
@RequestMapping(path = "/api")
public class FuncionarioController {

	@Autowired
	private IFuncionarioRepository repo;

	@GetMapping(path = "/funcionarios/MAX")
	public Integer getMAX() {
		return this.repo.findByFuncionarioIDMAX();
	}

	@GetMapping(path = "/funcionarios")
	public List<Funcionario> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/funcionarios/paginado")
	public Page<Funcionario> getAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size
			){
		PageRequest pr = PageRequest.of(page, size, Sort.by("Nome"));
		Page<Funcionario> lista = this.repo.findAll(pr);			
		return lista;		
	}

	@GetMapping(path = "/funcionarios/{id}")
	public Funcionario getById(@PathVariable Integer id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/funcionarioschave/{funchave}/funcionarios")
	public List<Funcionario> getFuncionarioPorchave(@PathVariable Long funchave) {
		return this.repo.findByChave(funchave);
	}

	@GetMapping(path = "/funcionariosnome/{nome}/funcionarios")
	public List<Funcionario> getFuncionarioPorNome(@PathVariable String nome) {
		return this.repo.findByNome(nome);
	}

	@GetMapping(path = "/funcionariossobrenome/{sobrenome}/funcionarios")
	public List<Funcionario> getFuncionarioPorSobrenome(@PathVariable String sobrenome) {
		return this.repo.findBySobrenome(sobrenome);
	}

	@GetMapping(path = "/funnome/{nome}/funsobrenome/{sobrenome}/funcionarios")
	public List<Funcionario> getFuncionarioPorNomeAndSobrenome(@PathVariable String nome,
			@PathVariable String sobrenome) {
		return this.repo.findByNomeAndSobrenome(nome, sobrenome);
	}

	@PostMapping(path = "/funcionarios")
	public Funcionario post(@RequestBody Funcionario funcionario) {
		funcionario.setFuncionarioID(repo.findByFuncionarioIDMAX() + 1);
		return this.repo.save(funcionario);
	}

	@DeleteMapping(path = "/funcionarios/{id}")
	public void delete(@PathVariable Integer id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/funcionarios")
	public Funcionario put(@RequestBody Funcionario novoFuncionario) {
		return this.repo.findById(novoFuncionario.getFuncionarioID()).map(fun -> {
			fun.setChave(novoFuncionario.getChave());
			fun.setFuncionarioID(novoFuncionario.getFuncionarioID());
			fun.setNome(novoFuncionario.getNome());
			fun.setSobrenome(novoFuncionario.getSobrenome());
			fun.setDataDeAdmissao(novoFuncionario.getDataDeAdmissao());
			fun.setSexo(novoFuncionario.getSexo());
			fun.setDataDeNascimento(novoFuncionario.getDataDeNascimento());
			fun.setEmail(novoFuncionario.getEmail());
			fun.setCtps(novoFuncionario.getCtps());
			fun.setCtpsNum(novoFuncionario.getCtpsNum());
			fun.setCtpsSerie(novoFuncionario.getCtpsSerie());
			fun.setPaisID(novoFuncionario.getPaisID());
			fun.setDataDeInclusao(novoFuncionario.getDataDeInclusao());
			return this.repo.save(fun);
		}).orElse(null);

	}
}
