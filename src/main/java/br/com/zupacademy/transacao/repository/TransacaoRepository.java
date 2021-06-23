package br.com.zupacademy.transacao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.transacao.model.Cartao;
import br.com.zupacademy.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

	List<Transacao> findByCartao(Cartao cartao, Pageable pageRequest);
	
}
