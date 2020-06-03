import java.io.*;
import java.time.LocalDate;

public class VeiculoPremium extends Veiculo implements BonificaKms , Serializable
{
    private double taxa;
     private int pontos;
    
    public VeiculoPremium(){
    super();
    taxa = 1;
    this.pontos=0;
    }
    
    public VeiculoPremium(String matricula, String marca, String modelo
                         , int ano, double velocidade, double preco,
                         double t,int pts){
    super(matricula,marca,modelo
                         ,ano,velocidade,preco);
    this.taxa = t;
    this.pontos = pts;
    }
    
    public VeiculoPremium(VeiculoPremium v){
    super(v);
    this.taxa = v.getTaxa(); 
    this.pontos = v.getPontos();
}
 

    public double getTaxa(){
      return this.taxa;
    }
    
    public int getPontos(){
     return this.pontos;
    }
    
    public void setPontos(int pts){
      this.pontos = pts;
    }
    
    public void setTaxa(double t) throws TaxaException
    { if(t>=0)
        this.taxa = t; 
        else throw new TaxaException();
    }
    
    public double getPrecoP()
    { return (this.taxa * super.getPreco());
    }
    
    public VeiculoPremium clone(){
       return new VeiculoPremium(this);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Veiculo Premium ")
                .append(" , ")
                .append("O preco do veic premium é ")
                .append(" , ")
                .append(getPrecoP())
                .append(" , ")
                .append(getMatricula())
                .append(" , ")
                .append(getMarca())
                .append(" , ")
                .append(getModelo())
                .append(" , ")
                 .append(getAno())
                 .append(" , ")
                 .append(getVelocidade())
                 .append(" , ")
                 .append("O preco original é ")
                 .append(" , ")
                  .append(getPreco())
                  .append(" , ")
                 .append(getClassificacao())
                 .append(" , ")
                 .append(getAlugado())
                 .append(" , ")
                 .append(getKms())
                 .append(" , ")
                 .append(getUltkms())
                 .append(" , ")
                 .append(getNumAlugueres())
                 .append(" , ")
                 .append(getNumClassificacoes())
                 .append(" , ")
                 .append("Taxa = ")
                 .append(" , ")
                 .append(this.taxa)
                 .append(" , ")
                 .append("Pontos = ")
                 .append(" , ")
                 .append(getTotalPontos());
                 
             
        return s.toString();
    }
    
    public double custoRealKm()
    {
      return (1.10 * this.getUltkms() * getPrecoP());
      
    }
    
    // Fase 3
    
    public void defPontosKm(int Pontos){
      this.pontos=pontos;
    }
    
    public int obPontosKm(){
      return this.pontos;
    }
    
    public int getTotalPontos(){
     return ((int) (obPontosKm() * getUltkms()));
    }
}
