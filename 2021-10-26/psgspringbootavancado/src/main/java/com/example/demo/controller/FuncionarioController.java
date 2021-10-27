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

import com.example.demo.model.Funcionario;
import com.example.demo.repository.IFuncionarioRepository;

@RestController
@RequestMapping(path = "/api")
public class FuncionarioController {
	
	@Autowired
	private IFuncionarioRepository repo;
	
	// Select em todos
	@GetMapping(path = "/funcionarios" )
	public List<Funcionario> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path = "/funcionarios/{id}")
	public Funcionario getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	} 
	
	@GetMapping(path = "/funcionario/min")
	public Integer getMIN() {
		return this.repo.findByFuncionarioIDMIN();
	}
	
	@GetMapping(path = "/funcionario/teste")
	public List<Funcionario> getTeste() {
		return this.repo.findByFuncionarioID();
	}
	
	
	@GetMapping(path = "/funcionario/max")
	public Integer getMAX() {
		return this.repo.findByFuncionarioIDMAX();
	}
	
	@PostMapping(path = "/funcionarios")
	public Funcionario post(@RequestBody Funcionario funcionario) {
		return this.repo.save(funcionario);
	}
	
	@DeleteMapping ("/funcionarios/{id}")
	public void delete(@PathVariable int id) {
			if (this.repo.findById(id).orElse(null) != null) {
				this.repo.deleteById(id);
			}
		
	}
	
	@PutMapping("/funcionarios")
	public Funcionario put(@RequestBody Funcionario novoFuncionario) {
		return this.repo.findById(novoFuncionario.getFuncionarioID())
				.map(fun -> {
					fun.setFuncionarioID(novoFuncionario.getFuncionarioID());
					fun.setChaveID(novoFuncionario.getChaveID());
					fun.setNome(novoFuncionario.getNome());
					fun.setSobreNome(novoFuncionario.getSobreNome());
					fun.setDataAdmissao(novoFuncionario.getDataAdmissao());
					fun.setSexo(novoFuncionario.getSexo());
					fun.setNascimento(novoFuncionario.getNascimento());
					fun.setEmail(novoFuncionario.getEmail());
					fun.setCtps(novoFuncionario.getCtps());
					fun.setCtpsnum(novoFuncionario.getCtpsnum());
					fun.setCtpsserie(novoFuncionario.getCtpsserie());
					fun.setDataDeInsercao(novoFuncionario.getDataDeInsercao());


					
					return this.repo.save(fun);
				})
				.orElse(null);
		
	}		

}



