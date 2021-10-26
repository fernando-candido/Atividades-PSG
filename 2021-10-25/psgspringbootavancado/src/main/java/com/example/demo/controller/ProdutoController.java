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
	public Produto getById(@PathVariable int id){
		return this.repo.findById(id).orElse(null);
		
	}
	
	@GetMapping(path = "/produtos/{pro}/subcategorias")
	public List<Produto> getProdutosPorSubCategoria(@PathVariable int pro){
		return this.repo.findBySubCategoriaID(pro);
	}
	
	@GetMapping(path = "/produtos/{cat}/categorias")
		List<Produto> findByCategoriaID(@PathVariable int cat){
			return this.repo.findByCategoriaID(cat);    
    }
	
	
//    @GetMapping(path = "/categorias/{pro}/subcategorias/{subCat}")
//    	List<Produto> findByCategoriaIDAndSubCategoriaID (@PathVariable int cat, int subCat){
//   	 		return this.repo.findByCategoriaIDAndSubCategoriaID(cat, subCat);
//    }


	
	
	
	
	@PostMapping("/produtos")
	public Produto post(@RequestBody Produto produto) {
		return this.repo.save(produto);
	}
	
	
	@DeleteMapping("/produtos/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			
		}
	}
	
	@PutMapping("/produtos")
	public Produto put(@RequestBody Produto novaProduto) {
		return this.repo.findById(novaProduto.getProdutoID())
				.map(pro -> {
					pro.setProdutoID(novaProduto.getProdutoID());
					pro.setSubCategoriaID(novaProduto.getSubCategoriaID());
					pro.setCategoriaID(novaProduto.getCategoriaID());
					pro.setDescricao(novaProduto.getDescricao());
					pro.setDataDeInsercao(novaProduto.getDataDeInsercao());
					return this.repo.save(pro);
				})
				.orElse(null);
		
	}
	

}