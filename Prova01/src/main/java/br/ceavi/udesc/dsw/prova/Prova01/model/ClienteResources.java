/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ceavi.udesc.dsw.prova.Prova01.model;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gabriel Soares
 */

@Controller
@RequestMapping("/clientes")
public class ClienteResources {
    
    @Autowired
    private ClienteRepository cr;
    
    @GetMapping
    public List<Cliente> listarClientes(){
        return cr.findAll();
    }
    
    @GetMapping("/{id}")
    public Cliente buscarClienteID(@PathVariable long id){
        Optional<Cliente> cli = cr.findById(id);
        Cliente clienteBuscado = cli.get();
        return clienteBuscado;
    }
    
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente c){
        return cr.save(c);
    }
    
    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente c, @PathVariable long id){
       
        Optional<Cliente> cli = cr.findById(id);
        Cliente cli2= cli.get();
        BeanUtils.copyProperties(cli2, cli, "id");
        cr.save(cli2);
        
        return cli2;
    }
    
    
}
