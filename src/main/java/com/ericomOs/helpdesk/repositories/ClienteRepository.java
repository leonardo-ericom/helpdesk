package com.ericomOs.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericomOs.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
