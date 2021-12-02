package br.org.generation.minhaprimeiraaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aplicacao01")
public class MinhaPrimeriaAplicacao {
	
	@GetMapping
	public String OlaComoVai() {
		return "OLa como vai tudo?! ";
	}


}
