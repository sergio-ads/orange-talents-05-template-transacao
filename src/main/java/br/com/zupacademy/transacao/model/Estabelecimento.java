package br.com.zupacademy.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Estabelecimento {
	@Id @GeneratedValue
	private long id;
	private String nome;
	private String cidade;
	private String endereco;
	
	@Deprecated
	public Estabelecimento() {
	}
	
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "Erro ao mapear!";
		}		
	}
		
}
