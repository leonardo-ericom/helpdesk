package com.ericomOs.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericomOs.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
