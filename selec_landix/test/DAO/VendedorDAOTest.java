/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LDXPS.Vendedor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author lucas
 */
public class VendedorDAOTest {
    
    public VendedorDAOTest() {
    }

    @Test
    @Ignore
    public void insere(){
        Vendedor vend = new Vendedor("Teste", "Teste2",2,"2000-12-12");
        VendedorDAO dao = new VendedorDAO();
        
        if(dao.insert(vend)){
            System.out.println("Boa garoto!");
        }else{
            fail("Erro ao salvar");
        }
    }
    @Test
    @Ignore
    public void aleatorio(){
        VendedorDAO dao = new VendedorDAO();
        System.out.println(dao.aleat());
    }
    
    
    @Test
    @Ignore
    public void listar(){
        VendedorDAO dao = new VendedorDAO();
        
        for(Vendedor vend: dao.select()){
            System.out.println(vend.getCdvend());
            System.out.println(vend.getDsnome());
            System.out.println(vend.getCdtab());
            System.out.println(vend.getDtnasc());
        }
    }
    
        
    @Test
    @Ignore
    public void update(){
        Vendedor vend = new Vendedor("Teste", "Teste6", 3, "2009-05-05");
        VendedorDAO dao = new VendedorDAO();
        
        if(dao.update(vend)){
            System.out.println("Boa mano!");
        }else{
            fail("Deu nao");
        }
    }
    
    @Test
    @Ignore
    public void delete(){
        Vendedor vend = new Vendedor("Teste", "Teste6", 3, "2009-05-05");
        VendedorDAO dao = new VendedorDAO();
        
        if(dao.apaga(vend)){
            System.out.println("Boa moço");
        }else{
            fail("Fiquei triste agora");
        }
    }
 
    
}
