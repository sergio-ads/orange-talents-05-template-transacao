package br.com.zupacademy.transacao.consumer.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventoDeTransacao {
	private String id;
	private BigDecimal valor;
	private Estabelecimento estabelecimento;
	private Cartao cartao;
	private String efetivadaEm;
	
	@Deprecated
	public EventoDeTransacao() { }

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getEfetivadaEm() {
    	return efetivadaEm;
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
