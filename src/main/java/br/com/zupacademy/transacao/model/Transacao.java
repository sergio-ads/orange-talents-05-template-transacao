package br.com.zupacademy.transacao.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Transacao {
	@Id
	private String id;
	private BigDecimal valor;
	private String efetivadaEm;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private Estabelecimento estabelecimento;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private Cartao cartao;
	
	@Deprecated
	public Transacao() { }

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getEfetivadaEm() {
    	return efetivadaEm;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
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
