/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBD;
import LDXPS.Cliente;
import LDXPS.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ClienteDao {
    private Connection con = null;

    public ClienteDao() {
        con = ConectaBD.getConnection();
    }
    
    public boolean insert(Cliente cliente){
        
        String sql = "INSERT INTO clientes (CDCL,DSNOME,IDTIPO,CDVEND,DSLIM) VALUES (?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getCdcl());
            stmt.setString(2, cliente.getDsnome());
            stmt.setString(3, cliente.getIdtipo());
            stmt.setString(4, cliente.getVendedor().getCdvend());
            stmt.setDouble(5, cliente.getDslim());
            stmt.executeUpdate();
            return true;
            } catch (SQLException ex) {
            System.err.println("Erro "+ ex);
            return false;
        }
    }
    
     public List<Cliente> select(){
        String sql = "SELECT cli.CDCL, cli.DSNOME, cli.IDTIPO, cli.CDVEND, cli.DSLIM, vend.CDVEND AS 'COD', vend.DSNOME as 'NOME', vend.CDTAB, vend.DTNASC from clientes cli, vendedores vend WHERE cli.CDVEND = vend.CDVEND ";
        PreparedStatement stmt = null;
        
         ResultSet rs = null;
        
        List<Cliente> cliente = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cli = new Cliente();
                
                cli.setCdcl(rs.getString("CDCL"));
                cli.setDslim(rs.getDouble("DSLIM"));
                cli.setDsnome(rs.getString("DSNOME"));
                cli.setIdtipo(rs.getString("IDTIPO"));
                
                Vendedor vend = new Vendedor();
                
                vend.setCdvend(rs.getString("COD"));
                vend.setDsnome(rs.getString("NOME"));
                vend.setCdtab(rs.getInt("CDTAB"));
                vend.setDtnasc(rs.getString("DTNASC"));
                
                cli.setVendedor(vend);
                
                cliente.add(cli);
            }
                
            
            
        } catch (SQLException ex) {
            System.err.println("Erro "  + ex);
        }finally{
            ConectaBD.closeConnection(con, stmt, rs);
        }
            
      
        return cliente;
    }
     
     public boolean update(Cliente cli){
        String sql = "UPDATE clientes SET DSNOME = ?, IDTIPO = ?, CDVEND = ? , DSLIM = ? WHERE CDCL = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cli.getDsnome());
            stmt.setString(2, cli.getIdtipo());
            stmt.setString(3, cli.getVendedor().getCdvend());
            stmt.setDouble(4, cli.getDslim());
            stmt.setString(5, cli.getCdcl());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar" + ex);
            return false;
        }finally{
            ConectaBD.closeConnection(con, stmt);
        }
    }
     
     public boolean apaga(Cliente cli){
        String sql = "DELETE FROM clientes WHERE CDCL = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,cli.getCdcl());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar " + ex);
            return false;
        }finally{
            ConectaBD.closeConnection(con, stmt);
        }
        
    }
    
}
