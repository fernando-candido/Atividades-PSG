package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.AreaConhecimento;

@Repository
public interface IAreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Integer> {

	List<AreaConhecimento> findByDescricao(String descricao);

}
