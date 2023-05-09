package com.ericomOs.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericomOs.helpdesk.domain.Tecnico;
import com.ericomOs.helpdesk.repositories.TecnicoRepository;
import com.ericomOs.helpdesk.services.exception.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow (() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
		
	}
}
