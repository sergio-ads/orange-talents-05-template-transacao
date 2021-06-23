package br.com.zupacademy.transacao.consumer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cartao {
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
