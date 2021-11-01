package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByDescricao(String descricao);

}
