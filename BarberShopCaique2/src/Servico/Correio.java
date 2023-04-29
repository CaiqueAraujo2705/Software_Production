/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servico;

import Model.Agendamento;

/**
 *
 * @author caiqu
 */
public class Correio {
    public void NotificarPorEmail(Agendamento agendamento){
        
        String emailformatado = formatarEmail(agendamento);
        String destiatario = agendamento.getCliente().getEmail();
        
        Email email = new Email("Agendamento BarberShop", emailformatado, destiatario);
        email.enviar();
    }

    private String formatarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        return "Olá" + nomeCliente + "Sua hora chegou....seu agendamento para" + servico +" o dia " + dataAgendamento + " ás " + horaAgendamento + "pelo valor de R$" + valor;
        

    }
    
}
