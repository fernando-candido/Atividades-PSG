package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Nome;
import com.example.demo.repository.INomeRepository;

@RestController
@RequestMapping(path = "/api")
public class NomeController {

	@Autowired
	private INomeRepository repo;

	@GetMapping(path = "/nome")
	public List<Nome> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/nome/{id}")
	public Nome getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/nome/paginado")
	public Page<Nome> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<Nome> lista = this.repo.findAll(pr);
		return lista;
	}

	@PostMapping(path = "/nome")
	public Nome post(@RequestBody Nome nome) {
		return this.repo.save(nome);
	}

	@DeleteMapping("/nome/{id}")
	public String delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			return "Deletado";
		} else {
			return "Não possui registro";
		}

	}

	@PutMapping("/nome")
	public Nome put(@RequestBody Nome novoNome) {
		return this.repo.findById(novoNome.getNomeID()).map(n -> {
			n.setNome(novoNome.getNome());
			n.setSexo(novoNome.getSexo());
			return this.repo.save(n);
		}).orElse(null);

	}

	@GetMapping(path = "/nome/consulta/{nome}")
	public List<Nome> getProcurarPorNome(@PathVariable String nome) {
		return this.repo.findByNome(nome);
	}

}
