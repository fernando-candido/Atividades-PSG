package com.example.demo.repository;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
	
//	List<Categoria> findBySubCategoriaID(int subCatid);
//	
}
