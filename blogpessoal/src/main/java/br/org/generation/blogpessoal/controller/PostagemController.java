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

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repostory.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
    
    @Autowired
    private PostagemRepository postagemRepository;
    
    @GetMapping
    public ResponseEntity <List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
        // é o mesmo no mysql que: select * from tb_postagens;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity <Postagem> getById(@PathVariable Long id){
        return postagemRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
        // é o mesmo no mysql que: select * from tb_postagens where id = id;
    }
    
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity <List <Postagem >> getByTilulo(@PathVariable String titulo){
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
        // é o mesmo no mysql que: select * from tb_postagens where titulo like "%titulo%";

    }
    
    @PostMapping
    public ResponseEntity <Postagem> postPostagem(@Valid @RequestBody Postagem postagem){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }
    
    @PutMapping
    public ResponseEntity <Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
        
//        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
        
        return postagemRepository.findById(postagem.getId())
                .map(resp -> ResponseEntity.ok(postagemRepository.save(postagem)))
                .orElse(ResponseEntity.notFound().build());
        
    }
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity <?> deletePostagem(@PathVariable Long id){
//        
//         return postagemRepository.findById(id)
//            .map(resp -> {
//                postagemRepository.deleteById(id);
//                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//                })
//            .orElse(ResponseEntity.notFound().build());
//    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable Long id) {
        
        Optional <Postagem> postagem = postagemRepository.findById(id);
        
        if (postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        postagemRepository.deleteById(id);
    }
    
}