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

import com.example.demo.model.Idioma;
import com.example.demo.repository.IIdiomaRepository;

@RestController
@RequestMapping(path = "/api")

public class IdiomaController {

	@Autowired
	private IIdiomaRepository repo;

	@GetMapping(path = "/idioma")
	public List<Idioma> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/idioma/{id}")
	public Idioma getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/idioma/paginado")
	public Page<Idioma> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<Idioma> lista = this.repo.findAll(pr);
		return lista;
	}

	@PostMapping(path = "/idioma")
	public Idioma post(@RequestBody Idioma idioma) {
		return this.repo.save(idioma);
	}

	@DeleteMapping("/idioma/{id}")
	public String delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			return "Deletado";
		} else {
			return "Não possui registro";
		}

	}

	@PutMapping(path = "/idioma")
	public Idioma put(@RequestBody Idioma novoIdioma) {
		return this.repo.findById(novoIdioma.getIdiomaID()).map(i -> {
			i.setDescricao(novoIdioma.getDescricao());
			i.setAbreviado(novoIdioma.getAbreviado());

			return this.repo.save(i);
		}).orElse(null);
	}

	@GetMapping(path = "/idioma/consulta/{descricao}")
	public List<Idioma> getProcurarPorDescricao(@PathVariable String descricao) {
		return this.repo.findByDescricao(descricao);
	}

}
