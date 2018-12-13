package LDXPS;

public class Vendedor {
    private String cdvend;
    private String dsnome;
    private int cdtab;
    private String dtnasc;

        
    public Vendedor(){
        
    }
    
    public Vendedor(String cdvend, String dsnome, int cdtab, String dtnasc) {
        this.cdvend = cdvend;
        this.dsnome = dsnome;
        this.cdtab = cdtab;
        this.dtnasc = dtnasc;
    }

    public String getCdvend() {
        return cdvend;
    }

    public void setCdvend(String cdvend) {
        this.cdvend = cdvend;
    }

    public String getDsnome() {
        return dsnome;
    }

    public void setDsnome(String dsnome) {
        this.dsnome = dsnome;
    }

    public int getCdtab() {
        return cdtab;
    }

    public void setCdtab(int cdtab) {
        this.cdtab = cdtab;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }
    
}
