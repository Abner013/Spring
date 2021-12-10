package org.generation.LojaDeJogos.controller;

import java.util.List;

import org.generation.LojaDeJogos.model.Produto;
import org.generation.LojaDeJogos.repository.CategoriaRepository;
import org.generation.LojaDeJogos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	

}
