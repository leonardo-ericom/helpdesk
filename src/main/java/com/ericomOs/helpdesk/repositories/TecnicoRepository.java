package com.ericomOs.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericomOs.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
