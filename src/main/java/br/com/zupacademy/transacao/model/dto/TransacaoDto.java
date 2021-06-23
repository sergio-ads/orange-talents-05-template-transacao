package br.com.zupacademy.transacao.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.transacao.model.Transacao;

public class TransacaoDto {
	private String id;
	private BigDecimal valor;
	private String efetivadaEm;
	private EstabelecimentoDto estabelecimento;

	public TransacaoDto(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.estabelecimento = new EstabelecimentoDto(transacao.getEstabelecimento());
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getEfetivadaEm() {
    	return efetivadaEm;
	}

	public EstabelecimentoDto getEstabelecimento() {
		return estabelecimento;
	}

    public static List<TransacaoDto> converter(List<Transacao> transacoes) {
        return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
    }
}
