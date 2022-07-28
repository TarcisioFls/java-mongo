package br.com.java.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.escola.models.Aluno;
import br.com.java.escola.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public void salvar(Aluno aluno) {
		alunoRepository.salvar(aluno);
		
	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}
	

}
