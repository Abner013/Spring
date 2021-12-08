package br.org.generation.blogpessoal.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> { 
	    //heranca de jpaRepository, com o objeto da classe principal postagem, com o atributo Long (chave primaria) 

	    public List <Postagem> findAllByTituloContainingIgnoreCase(String Titulo);
	    // é o mesmo no mysql que: select * from tb_postagens where titulo like "%titulo%";
	}

