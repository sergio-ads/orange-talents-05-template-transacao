package br.com.zupacademy.transacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransacaoApplication {

	public static void main(String[] args) {
		System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS").format(LocalDateTime.now()));
		SpringApplication.run(TransacaoApplication.class, args);
	}

}
