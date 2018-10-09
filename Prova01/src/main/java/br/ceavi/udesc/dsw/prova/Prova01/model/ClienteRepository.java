/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ceavi.udesc.dsw.prova.Prova01.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gabriel Soares
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
