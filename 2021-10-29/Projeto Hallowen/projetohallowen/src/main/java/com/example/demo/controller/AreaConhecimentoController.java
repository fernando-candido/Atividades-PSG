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
import com.example.demo.model.AreaConhecimento;
import com.example.demo.repository.IAreaConhecimentoRepository;

@RestController
@RequestMapping(path = "/api")

public class AreaConhecimentoController {

	@Autowired
	private IAreaConhecimentoRepository repo;

	@GetMapping(path = "/areaconhecimento")
	public List<AreaConhecimento> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/areaconhecimento/{id}")
	public AreaConhecimento getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@PostMapping(path = "/areaconhecimento")
	public AreaConhecimento post(@RequestBody AreaConhecimento areaconhecimento) {
		return this.repo.save(areaconhecimento);
	}

	@GetMapping(path = "/areaconhecimento/paginado")
	public Page<AreaConhecimento> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<AreaConhecimento> lista = this.repo.findAll(pr);
		return lista;
	}

	@DeleteMapping("/areaconhecimento/{id}")
	public String delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			return "Deletado";
		} else {
			return "Não possui registro";
		}

	}

	@PutMapping("/areaconhecimento")
	public AreaConhecimento put(@RequestBody AreaConhecimento novoArea) {
		return this.repo.findById(novoArea.getAreaConhecimentoID()).map(a -> {
			a.setDescricao(novoArea.getDescricao());
			return this.repo.save(a);
		}).orElse(null);

	}

	@GetMapping(path = "/areaconhecimento/consulta/{descricao}")
	public List<AreaConhecimento> getProcurarPorDescricao(@PathVariable String descricao) {
		return this.repo.findByDescricao(descricao);
	}

}
