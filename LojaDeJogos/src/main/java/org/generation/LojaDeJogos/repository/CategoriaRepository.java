package org.generation.LojaDeJogos.repository;

import java.util.List;

import org.generation.LojaDeJogos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <String, Long> {
	
	public List <Categoria> findAllByTipoContainigIgnoreCase (String tipo);

}
