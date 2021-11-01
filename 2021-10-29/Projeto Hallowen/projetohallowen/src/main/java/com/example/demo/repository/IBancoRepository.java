package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Banco;

@Repository
public interface IBancoRepository extends JpaRepository<Banco, Integer> {

	List<Banco> findByDescricao(String descricao);

}
