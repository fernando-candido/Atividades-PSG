package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer>{
	List<Produto> findBySubCategoriaID(int pro);
	}



