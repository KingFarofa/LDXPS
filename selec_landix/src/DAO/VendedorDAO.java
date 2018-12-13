/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBD;
import LDXPS.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAO {
    private Connection con = null;

    public VendedorDAO() {
        con = ConectaBD.getConnection();
    }
    public boolean insert(Vendedor vendedor){
        
        String sql = "INSERT INTO vendedores (CDVEND,DSNOME,CDTAB,DTNASC) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, vendedor.getCdvend());
            stmt.setString(2, vendedor.getDsnome());
            stmt.setInt(3, vendedor.getCdtab());
            stmt.setString(4, vendedor.getDtnasc());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        }finally{
            ConectaBD.closeConnection(con, stmt);
        }
    }
    
           
    public List<Vendedor> select(){
        String sql = "SELECT * FROM vendedores";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendedor> vendedores = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Vendedor vendedor = new Vendedor();
                
                vendedor.setCdvend(rs.getString("CDVEND"));
                vendedor.setDsnome(rs.getString("DSNOME"));
                vendedor.setCdtab(rs.getInt("CDTAB"));
                vendedor.setDtnasc(rs.getString("DTNASC"));
                vendedores.add(vendedor);
            }
                
            
            
        } catch (SQLException ex) {
            System.err.println("Erro "  + ex);
        }finally{
            ConectaBD.closeConnection(con, stmt, rs);
        }
        
        return vendedores;
    }
    
    public boolean update(Vendedor vend){
        String sql = "UPDATE vendedores SET DSNOME = ?, CDTAB = ?, DTNASC = ? WHERE CDVEND = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, vend.getDsnome());
            stmt.setInt(2, vend.getCdtab());
            stmt.setString(3, vend.getDtnasc());
            stmt.setString(4, vend.getCdvend());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar" + ex);
            return false;
        }finally{
            ConectaBD.closeConnection(con, stmt);
        }
    }
    
    public boolean apaga(Vendedor vend){
        String sql = "DELETE FROM vendedores WHERE CDVEND = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, vend.getCdvend());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar " + ex);
            return false;
        }finally{
            ConectaBD.closeConnection(con, stmt);
        }
        
    }
    
    public String aleat(){
        String sql = "SELECT CDVEND FROM vendedores ORDER BY RAND () LIMIT 1";
        String cod = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                cod = rs.getString("CDVEND");
            }
        } catch (SQLException ex) {
            System.err.println("Erro "  + ex);
        }finally{
            ConectaBD.closeConnection(con, stmt, rs);
        }
     return cod; 
    }    
    
    
}
