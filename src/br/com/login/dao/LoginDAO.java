/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class LoginDAO {
    
    public void cadastrarUsuario(String nome,String email,String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO login (nome, email, senha) VALUES ('"+nome+"','"+email+"','"+senha+"')";
        System.out.println(sql);
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    }
    
    public void login(String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email,senha FROM login WHERE email = '"+email+"' AND senha = '"+senha+"'";
        System.out.println(sql);
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(); 
        
        if(rs.next()){
            System.out.println("Possui usuário cadastrado");
        }else{
            System.out.println("Não possui usuário cadastrado com esses dados");
        }
        
        conexao.close();
    }
}
