package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Funcionario;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	@Query(value = "SELECT MIN(FuncionarioID) FROM Funcionario", nativeQuery = true)
	Integer findByFuncionarioIDMIN();
	
	@Query(value = "SELECT MAX(FuncionarioID) FROM Funcionario", nativeQuery = true)
	Integer findByFuncionarioIDMAX();
	
	@Query(value = "SELECT Nome FROM Funcionario WHERE FuncionarioID between (10001) and (11099)", nativeQuery = true)
	List<Funcionario> findByFuncionarioID();
	//List<String> findByFuncionarioID();

}
