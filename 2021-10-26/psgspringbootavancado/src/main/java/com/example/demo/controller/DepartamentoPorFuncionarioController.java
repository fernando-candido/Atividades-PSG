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
import com.example.demo.model.DepartamentoPorFuncionario;
import com.example.demo.model.Produto;
import com.example.demo.repository.IDepartamentoPorFuncionarioRepository;
import com.example.demo.repository.IDepartamentoRepository;

@RestController
@RequestMapping(path = "/api")
public class DepartamentoPorFuncionarioController {
	
	@Autowired
	private IDepartamentoPorFuncionarioRepository repo;
	
	@GetMapping(path = "/departamentosporfuncionario")
	public List<DepartamentoPorFuncionario> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path = "/departamentosporfuncionario/{id}")
	public DepartamentoPorFuncionario getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	
	@GetMapping(path = "/departamentosporfuncionario/{dep}/departamento")
	public List<DepartamentoPorFuncionario> getDepartamentoID(@PathVariable int dep){
		return this.repo.findByDepartamentoID(dep);
	}
	
	
	@GetMapping(path = "/departamentosporfuncionario/{fun}/funcionario")
	public List<DepartamentoPorFuncionario> getFuncionarioID(@PathVariable int fun){
		return this.repo.findByFuncionarioID(fun);
	}
	
	
	
	@PostMapping(path = "/departamentosporfuncionarios")
	public DepartamentoPorFuncionario post(@RequestBody DepartamentoPorFuncionario departamentoporfuncionario) {
		return this.repo.save(departamentoporfuncionario);
	}
	
	@DeleteMapping(path = "/departamentosporfuncionario/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
		}	
	}

	@PutMapping("departamentosporfuncionario")
	public DepartamentoPorFuncionario put(@RequestBody DepartamentoPorFuncionario novoDepartamentoPorFuncionario) {
		return this.repo.findById(novoDepartamentoPorFuncionario.getDepartamentoID())
				.map(depfun -> {
					depfun.setFuncionarioPorDepartamento(novoDepartamentoPorFuncionario.getFuncionarioPorDepartamento());
					depfun.setFuncionarioID(novoDepartamentoPorFuncionario.getFuncionarioID());
					depfun.setDepartamentoID(novoDepartamentoPorFuncionario.getDepartamentoID());
					depfun.setDataInicial(novoDepartamentoPorFuncionario.getDataInicial());
					depfun.setDataFinal(novoDepartamentoPorFuncionario.getDataFinal());
					return this.repo.save(depfun);
				}).orElse(null);

 
		// http://localhost:8080/swagger-ui/index.html#/
	}
	
}
