package com.ericomOs.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ericomOs.helpdesk.domain.Chamado;
import com.ericomOs.helpdesk.domain.Cliente;
import com.ericomOs.helpdesk.domain.Tecnico;
import com.ericomOs.helpdesk.domain.enums.Perfil;
import com.ericomOs.helpdesk.domain.enums.Prioridade;
import com.ericomOs.helpdesk.domain.enums.Status;
import com.ericomOs.helpdesk.repositories.ChamadoRepository;
import com.ericomOs.helpdesk.repositories.ClienteRepository;
import com.ericomOs.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Tecnico tec1 = new Tecnico(null, "Leonardo Ribeiro", "00661237125", "leonardo@ericom.com.br", "ericom3455");
		tec1.addPerfil(Perfil.ADMIN);
		
		
		Cliente cli1 = new Cliente(null, "Karina nunes", "87376660100", "karina@telefonica.com", "123");
		cli1.addPerfil(Perfil.TECNICO);
		
		Chamado c1 = new Chamado (null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
