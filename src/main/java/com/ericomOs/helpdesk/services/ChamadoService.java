package com.ericomOs.helpdesk.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericomOs.helpdesk.domain.Chamado;
import com.ericomOs.helpdesk.domain.Cliente;
import com.ericomOs.helpdesk.domain.Tecnico;
import com.ericomOs.helpdesk.domain.dtos.ChamadoDTO;
import com.ericomOs.helpdesk.domain.enums.Prioridade;
import com.ericomOs.helpdesk.domain.enums.Status;
import com.ericomOs.helpdesk.repositories.ChamadoRepository;
import com.ericomOs.helpdesk.services.exception.ObjectnotFoundException;

@Service
public class ChamadoService {


	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(ChamadoDTO obj) {
		return repository.save(newChamado(obj));
	}

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		
		return repository.save(oldObj);
	}

	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
			
		}
		if (obj.getDataAbertura() == null)  {
			chamado.setDataAbertura(LocalDateTime.now());
		
			
		}else {
			chamado.setDataAbertura(obj.getDataAbertura());
			
		}
		
		if(obj.getStatus().equals(3)) {
			chamado.setDataFechamento(LocalDateTime.now());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}

}










