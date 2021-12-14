package org.generation.LojaDeJogos.repository;

import java.util.List;
import java.util.Optional;

import org.generation.LojaDeJogos.model.Usuario;
import org.generation.LojaDeJogos.service.UsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);
	
	public List<UsuarioService> findAllByNomeContainigIgnoreCase (String string);
}
