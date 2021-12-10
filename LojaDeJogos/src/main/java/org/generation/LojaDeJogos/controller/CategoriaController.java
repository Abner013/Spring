package org.generation.LojaDeJogos.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.LojaDeJogos.model.Categoria;
import org.generation.LojaDeJogos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping ("/categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	private static final ResponseEntity<List<String>> ReposeEntity = null;
	private static final ResponseEntity<List<String>> RepositoryEntity = null;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<String>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return categoriaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity <Categoria> putCategoria(@Valid @RequestBody Categoria categoria){
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(categoriaRepository.save(categoria));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> deleteCategoria (@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(reposta ->{
					categoriaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NOT_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
