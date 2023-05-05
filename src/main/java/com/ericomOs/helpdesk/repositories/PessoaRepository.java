package com.ericomOs.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericomOs.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
