/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author Caique
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    
    
    
     public void entrarNoSistema(){
        //pegar usuario da view
    Usuario usuario = helper.obterModelo();
    
     // pesquisa usuario no Banco
     UsuarioDAO usuarioDAO = new UsuarioDAO();
     Usuario UsuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);    
     //verifica login
     if(UsuarioAutenticado != null){
         MenuPrincipal menu = new MenuPrincipal();
         menu.setVisible(true);
         this.view.dispose();
     }else{
         view.exibeMensagem("Usuario ou senha invalidos");
     }
       
    }
    
    public void fizTarefa(){
    System.out.println("Executada busca no BD");
    
    this.view.exibeMensagem("Tarefa executada");
    
    }
  
   
}
