package br.org.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.org.generation.blogpessoal.model.Tema;
import br.org.generation.blogpessoal.repostory.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin (origins = "*" , allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
    public ResponseEntity <List<Tema>> getAll(){
        return ResponseEntity.ok( temaRepository.findAll());    
	}
	 
	@GetMapping("/{id}")
    public ResponseEntity <Tema> getById(@PathVariable Long id){
        return temaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping("/tema/{tema}")
    public ResponseEntity <List <Tema>> getByTema(@PathVariable String tema){
        return ResponseEntity.ok( temaRepository.findAllByTemaContainingIgnoreCase(tema));
	}
	
	@PostMapping
    public ResponseEntity <Tema> postTema(@Valid @RequestBody Tema tema){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }
	
	@PutMapping
    public ResponseEntity <Tema> putTema(@Valid @RequestBody Tema tema){
        return temaRepository.findById(tema.getId())
                .map(resp -> ResponseEntity.ok(temaRepository.save(tema)))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTema(@PathVariable Long id) {
        
        Optional <Tema> tema = temaRepository.findById(id);
        
        if (tema.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        temaRepository.deleteById(id);
	}
}