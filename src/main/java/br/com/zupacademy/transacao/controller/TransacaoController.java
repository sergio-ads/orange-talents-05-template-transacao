package br.com.zupacademy.transacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.transacao.model.Cartao;
import br.com.zupacademy.transacao.model.Transacao;
import br.com.zupacademy.transacao.model.dto.TransacaoDto;
import br.com.zupacademy.transacao.repository.CartaoRepository;
import br.com.zupacademy.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private CartaoRepository cartaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> listar(@PathVariable String idCartao) {
    	Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
    	
    	if(!cartao.isPresent()) {
    		return ResponseEntity.notFound().build();
    	} else {
    		List<Transacao> transacoes = transacaoRepository.findByCartao(cartao.get(), 
    				PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "efetivadaEm")));
        	return ResponseEntity.ok(TransacaoDto.converter(transacoes));
    	}
    }

}
