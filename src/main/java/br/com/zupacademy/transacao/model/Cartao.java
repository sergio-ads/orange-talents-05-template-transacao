package br.com.zupacademy.transacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Cartao {
	@Id
	private String id;
	private String email;
	
	@Deprecated
	public Cartao() {
	}
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
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
