package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Idioma;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Integer> {

	List<Idioma> findByDescricao(String descricao);

}
