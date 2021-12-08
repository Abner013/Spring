package br.org.generation.blogpessoal.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table (name = "tb_tema")
public class Tema {
	
	@Id  /// ejklsdflnsdlfnalç
	@GeneratedValue (strategy = GenerationType.IDENTITY ) 
	private Long id;
	
	@NotBlank
	@Size (min = 5, max = 100) 
	private String tema;
	
	@NotBlank
	@Size (min = 10, max = 200)
	private String texto;
	
	@UpdateTimestamp 
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	
	

}
