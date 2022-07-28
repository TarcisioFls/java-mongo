package br.com.java.escola.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {
	private String nome;

	public Curso(String nome) {
		this.nome = nome;
	}
}
