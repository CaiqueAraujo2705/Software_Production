/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Servico.Correio;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author caiqu
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        //buscar Lista com aendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
       
        //exibir a lista na view
        helper.preencherTabeça(agendamentos);
        
    }
    
    public void atualizaCliente(){
    
        //buscar cientes do BD
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
                
                
                //Exibir clientes CB clientes
        helper.preencherClientes(clientes);      
    }

    public void atualizaServico(){
    
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
        
    }
    
    public void atualizaValor(){
    
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    
    }
  
    public void agendar(){
    //buscar objeto Agendamento da tela
    Agendamento agendamento = helper.obterModelo();
    //Salvar objeto no Banco de dados
    new AgendamentoDAO().insert(agendamento);
    
    
    Correio correio = new Correio();
    correio.NotificarPorEmail(agendamento);
    
    atualizaTabela();
    helper.limparTela();
    
    
    }
    
}
