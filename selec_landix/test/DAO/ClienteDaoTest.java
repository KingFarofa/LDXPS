/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LDXPS.Cliente;
import LDXPS.Vendedor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author lucas
 */
public class ClienteDaoTest {
    
    
    
    @Test
    @Ignore
     public void listar(){
        ClienteDao dao = new ClienteDao();
        
        for(Cliente cli: dao.select()){
            System.out.println(cli.getCdcl());
            System.out.println(cli.getDsnome());
            System.out.println(cli.getDslim());
            System.out.println(cli.getIdtipo());
            System.out.println(cli.getVendedor().getCdvend());
        }
    }
     @Test
     public void insere(){
         ClienteDao dao = new ClienteDao();
         Vendedor vend = new Vendedor("chave", "Teste6", 3, "2009-05-05");
          Cliente cli = new Cliente("teste694", "Marcos Pontes","PF", vend , 200000.66);
          
          dao.insert(cli);
     }
     
    @Test
    @Ignore
     public void update(){
        Vendedor vend = new Vendedor("chave", "Teste6", 3, "2009-05-05");
        Cliente cli = new Cliente("teste", "josiane","PF", vend , 200000.66);
        ClienteDao dao = new ClienteDao();
        
        if(dao.update(cli)){
            System.out.println("Boa mano!");
        }else{
            fail("Deu nao");
        }
    }
     @Test
     @Ignore
      public void delete(){
        Vendedor vend = new Vendedor("chave", "Teste6", 3, "2009-05-05");
        Cliente cli = new Cliente("teste", "josiane","PF", vend , 200000.66);
        ClienteDao dao = new ClienteDao();
        
        if(dao.apaga(cli)){
            System.out.println("Boa moço");
        }else{
            fail("Fiquei triste agora");
        }
    }
    
}
