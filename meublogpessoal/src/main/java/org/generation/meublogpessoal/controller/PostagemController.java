package org.generation.meublogpessoal.controller;

import org.generation.meublogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informa ao spring que essa classe e um controlador
@RequestMapping ("/postagens") //
@CrossOrigin("*") //vai aceitar qualquer origien da class
public class PostagemController {

	@Autowired //altomação do spring 
	private PostagemRepository reposioty;
}
