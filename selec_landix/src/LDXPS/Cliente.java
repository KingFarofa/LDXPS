
package LDXPS;

public class Cliente {
    private String cdcl;
    private String dsnome;
    private String idtipo;
    private Vendedor vendedor;
    private double dslim;
    
    
    public Cliente(){
        
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente(String cdcl, String dsnome, String idtipo, Vendedor vendedor, double dslim) {
        this.cdcl = cdcl;
        this.dsnome = dsnome;
        this.idtipo = idtipo;
        this.vendedor = vendedor;
        this.dslim = dslim;
    }

   

    public String getCdcl() {
        return cdcl;
    }

    public void setCdcl(String cdcl) {
        this.cdcl = cdcl;
    }

    public String getDsnome() {
        return dsnome;
    }

    public void setDsnome(String dsnome) {
        this.dsnome = dsnome;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public double getDslim() {
        return dslim;
    }

    public void setDslim(double dslim) {
        this.dslim = dslim;
    }
    
}
