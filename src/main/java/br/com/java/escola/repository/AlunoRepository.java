package br.com.java.escola.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.java.escola.codecs.AlunoCodec;
import br.com.java.escola.models.Aluno;

@Repository
public class AlunoRepository {
	
	private MongoClient cliente;
	
	private MongoDatabase database;

	public void salvar(Aluno aluno) {
		MongoCollection<Aluno> alunos = criarConexao("alunos");
		alunos.insertOne(aluno);
		
		cliente.close();
	}

	public List<Aluno> findAll() {
		MongoCollection<Aluno> alunos = criarConexao("alunos");
		MongoCursor<Aluno> resultado = alunos.find().iterator();
		List<Aluno> alunosEncontrados = new ArrayList<>();
		while (resultado.hasNext()) {
			Aluno aluno = resultado.next();
			alunosEncontrados.add(aluno);
		}
		
		return alunosEncontrados;
	}

	private MongoCollection<Aluno> criarConexao(String collection) {
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		AlunoCodec alunoCodec = new AlunoCodec(codec);
		CodecRegistry registries = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromCodecs(alunoCodec));
		MongoClientOptions opcoes = MongoClientOptions.builder().codecRegistry(registries).build();
		
		this.cliente = new MongoClient("localhost:27017", opcoes);
		this.database = cliente.getDatabase("test");
		
		return database.getCollection(collection, Aluno.class);
	}

}
