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

import com.example.demo.model.Produto;
import com.example.demo.repository.IProdutoRepository;

@RestController
@RequestMapping(path = "/api")
public class ProdutoController {

	@Autowired
	private IProdutoRepository repo;
	
	@GetMapping(path = "/produtos")
	public List<Produto> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path = "/produtos/{id}")
	public Produto getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	
	@GetMapping(path = "/categorias/{catid}/{subcatid}/produtos")
	public List<Produto>getProdutoPorSubCategoriaID(@PathVariable int catid,@PathVariable int subcatid){
		return this.repo.findByCategoriaIDAndSubCategoriaID(catid, subcatid);
	}
	
	@GetMapping(path = "/categorias/{catid}/produtos")
	public List<Produto>getProdutoPorCategoriaID(@PathVariable int catid){
		return this.repo.findByCategoriaID(catid);
	}
	
	@GetMapping(path = "/subcategorias/{subcatid}/produtos")
	public List<Produto>getProdutoPorSubCategoriaID(@PathVariable int subcatid){
		return this.repo.findBySubCategoriaID(subcatid);
	}
	
	@PostMapping(path = "/produtos")
	public Produto post(@RequestBody Produto produto) {
		return this.repo.save(produto);
	}
	
	@DeleteMapping(path = "/produtos/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}
	
	@PutMapping(path = "/produtos")
	public Produto put(@RequestBody Produto novoProduto) {
		return this.repo.findById(novoProduto.getProdutoID())
				.map(pro -> {
					pro.setProdutoID(novoProduto.getProdutoID());
					pro.setSubCategoriaID(novoProduto.getSubCategoriaID());
					pro.setCategoriaID(novoProduto.getCategoriaID());
					pro.setDescricao(novoProduto.getDescricao());
					pro.setDataDeInsercao(novoProduto.getDataDeInsercao());
					return this.repo.save(pro);
				})
				.orElse(null);
		
	}
}








