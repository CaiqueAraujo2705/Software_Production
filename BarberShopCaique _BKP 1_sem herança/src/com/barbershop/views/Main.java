/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbershop.views;

import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author caiqu
 */
public class Main {
    
    
    public static void main(String[] args){
    
    String nome = "caique";
    System.out.println(nome);
    
    Servico servico = new Servico(1, "barba", 20);
    
    System.out.println(servico.getDescricao());
    System.out.println(servico.getValor());
    
    Cliente cliente = new Cliente(1, "caique", 'M', "40028922", "alameda dos anjos 192");
    System.out.println(cliente);
    
    Usuario usuario = new Usuario(1, "barbeiro", "senha");
    System.out.println(usuario);
   
    
  }
   
}
