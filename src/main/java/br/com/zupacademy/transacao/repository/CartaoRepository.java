package br.com.zupacademy.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.transacao.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

}
