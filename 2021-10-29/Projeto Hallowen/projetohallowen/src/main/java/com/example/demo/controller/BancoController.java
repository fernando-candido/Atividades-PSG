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
import com.example.demo.model.Banco;
import com.example.demo.repository.IBancoRepository;

@RestController
@RequestMapping(path = "/api")

public class BancoController {

	@Autowired
	private IBancoRepository repo;

	@GetMapping(path = "/banco")
	public List<Banco> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/banco/{id}")
	public Banco getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/banco/paginado")
	public Page<Banco> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<Banco> lista = this.repo.findAll(pr);
		return lista;
	}

	@PostMapping(path = "/banco")
	public Banco post(@RequestBody Banco banco) {
		return this.repo.save(banco);
	}

	@DeleteMapping("/banco/{id}")
	public String delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
			return "Deletado";
		} else {
			return "Não possui registro";
		}

	}

	@PutMapping("/banco")
	public Banco put(@RequestBody Banco novoBanco) {
		return this.repo.findById(novoBanco.getBancoID()).map(b -> {
			b.setDescricao(novoBanco.getDescricao());
			b.setCodigoBanco(novoBanco.getBancoID());
			b.setSite(novoBanco.getSite());

			return this.repo.save(b);
		}).orElse(null);

	}

	@GetMapping(path = "/banco/consulta/{descricao}")
	public List<Banco> getProcurarPorDescricao(@PathVariable String descricao) {
		return this.repo.findByDescricao(descricao);
	}

}
