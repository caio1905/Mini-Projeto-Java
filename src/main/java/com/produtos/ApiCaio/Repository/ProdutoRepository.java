package com.produtos.ApiCaio.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.ApiCaio.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Optional<Produto> findById(Long id);
	
}
