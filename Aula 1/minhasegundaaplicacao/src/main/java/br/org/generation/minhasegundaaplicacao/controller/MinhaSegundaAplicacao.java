package br.org.generation.minhasegundaaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Aplicacao02")
public class MinhaSegundaAplicacao {
	
	@GetMapping
	public String metaPessoa() {
		return "Aprender mais, não procastina, ser o mais adiantado "; 
	}

}
