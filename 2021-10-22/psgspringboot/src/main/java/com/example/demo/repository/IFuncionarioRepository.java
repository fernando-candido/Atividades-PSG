package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Funcionario;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
