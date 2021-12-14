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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping ("/categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	private ResponseEntity<List<Categoria>> getAll(){ 
		return ResponseEntity.ok(categoriaRepository.findAll());		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<List<Categoria>> getById (@PathVariable String tipo) {
		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainigIgnoreCase(tipo));
	}
	
	@GetMapping ("/tipo{tipo}")
	public ResponseEntity<List<Categoria>> GetByTipo (@PathVariable String tipo) {
		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainigIgnoreCase(tipo));
	}
	
	@PostMapping
	public ResponseEntity <Categoria> post (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	private ResponseEntity<Categoria> putCategoria (@Valid @RequestBody Categoria categoria) {
		
		return categoriaRepository.findById(categoria.getId())
				.map(reposta -> {
					return ResponseEntity.ok().body(categoriaRepository.save(categoria));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <?> deleteCategoria (@PathVariable long id) {
		
		return categoriaRepository.findById(id)
				.map(reposta -> {
					categoriaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
