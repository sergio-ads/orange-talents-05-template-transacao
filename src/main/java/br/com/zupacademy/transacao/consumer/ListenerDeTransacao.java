package br.com.zupacademy.transacao.consumer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.model.Transacao;
import br.com.zupacademy.transacao.repository.TransacaoRepository;

@Component
public class ListenerDeTransacao {
	@Autowired
	private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao transacao) {
    	String horario = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS").format(LocalDateTime.now());
    	System.out.println("------------------------------------------------------------------------");
        System.out.println("eventoDeTransacao recebido às " +horario +":\n" 
        		+transacao);
    	System.out.println("------------------------------------------------------------------------");
    	
    	transacaoRepository.save(transacao);
    }

}