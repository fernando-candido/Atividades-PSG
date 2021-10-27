package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DepartamentoPorFuncionario;
import com.example.demo.model.Produto;

@Repository
public interface IDepartamentoPorFuncionarioRepository extends JpaRepository<DepartamentoPorFuncionario, Integer> {

	List<DepartamentoPorFuncionario> findByDepartamentoID(int dep);
	List<DepartamentoPorFuncionario> findByFuncionarioID(int fun);
	
}
