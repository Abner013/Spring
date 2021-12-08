package br.org.generation.blogpessoal.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {
	
	public List<Tema> findAllByTemaContainingIgnoreCase (String Tema);
	
}
