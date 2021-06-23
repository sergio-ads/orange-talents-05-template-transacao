package br.com.zupacademy.transacao.consumer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.consumer.model.EventoDeTransacao;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
    	String horario = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS").format(LocalDateTime.now());
    	System.out.println("------------------------------------------------------------------------");
        System.out.println("eventoDeTransacao recebido às " +horario +":\n" 
        		+eventoDeTransacao);
    	System.out.println("------------------------------------------------------------------------");
    }

}