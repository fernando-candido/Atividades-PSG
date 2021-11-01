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
import com.example.demo.model.Curso;

import com.example.demo.repository.ICursoRepository;

@RestController
@RequestMapping(path = "/api")

public class CursoController {

	@Autowired
	private ICursoRepository repo;

	@GetMapping(path = "/curso")
	public List<Curso> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/curso/{id}")
	public Curso getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/curso/paginado")
	public Page<Curso> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<Curso> lista = this.repo.findAll(pr);
		return lista;
	}

	@PostMapping(path = "/curso")
	public Curso post(@RequestBody Curso curso) {
		return this.repo.save(curso);
	}

	@DeleteMapping("/curso/{id}")
	public String delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			return "Deletado";
		} else {
			return "Não possui registro";
		}

	}

	@PutMapping("/curso")
	public Curso put(@RequestBody Curso novoCurso) {
		return this.repo.findById(novoCurso.getCursoID()).map(c -> {
			c.setDescricao(novoCurso.getDescricao());

			return this.repo.save(c);
		}).orElse(null);

	}

	@GetMapping(path = "/curso/consulta/{descricao}")
	public List<Curso> getProcurarPorDescricao(@PathVariable String descricao) {
		return this.repo.findByDescricao(descricao);
	}

}
