package com.ericomOs.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericomOs.helpdesk.domain.Chamado;
import com.ericomOs.helpdesk.domain.Cliente;
import com.ericomOs.helpdesk.domain.Tecnico;
import com.ericomOs.helpdesk.domain.enums.Perfil;
import com.ericomOs.helpdesk.domain.enums.Prioridade;
import com.ericomOs.helpdesk.domain.enums.Status;
import com.ericomOs.helpdesk.repositories.ChamadoRepository;
import com.ericomOs.helpdesk.repositories.ClienteRepository;
import com.ericomOs.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Leonardo Ribeiro COsta", "00661237125", "leonardo@ericom.com.br", "ericom3455");
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
		tec2.addPerfil(Perfil.ADMIN);
				
		Tecnico tec3 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");
		tec3.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Karina nunes", "87376660100", "karina@telefonica.com", "123");
		//cli1.addPerfil(Perfil.TECNICO);

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
