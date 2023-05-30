package com.ericomOs.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ericomOs.helpdesk.domain.Chamado;
import com.ericomOs.helpdesk.domain.Cliente;
import com.ericomOs.helpdesk.domain.Tecnico;
import com.ericomOs.helpdesk.domain.enums.Perfil;
import com.ericomOs.helpdesk.domain.enums.Prioridade;
import com.ericomOs.helpdesk.domain.enums.Status;
import com.ericomOs.helpdesk.repositories.ChamadoRepository;
import com.ericomOs.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Administrador", "550.482.150-95", "admin@ericom.com.br", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", ""
				+ ""
				+ ""
				, encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.EM_ATENDIMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		
		pessoaRepository.saveAll(Arrays.asList(tec1, cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
