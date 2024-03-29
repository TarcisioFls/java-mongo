package br.com.java.escola.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
	
	private ObjectId id;
	
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	private List<Nota> notas;
	
	private Curso curso;
	
	private List<Habilidade> habilidades;
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", notas=" + notas
				+ ", curso=" + curso + ", habilidades=" + habilidades + "]";
	}

	public Aluno criarId() {
		setId(new ObjectId());
		return this;
	}

}
