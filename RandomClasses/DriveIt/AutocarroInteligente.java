
import java.io.*;
import java.time.LocalDate;


public class AutocarroInteligente extends Veiculo implements BonificaKms , Serializable
{
    private double ocupacao;
    private int pontos;
    
    public AutocarroInteligente(){
    super();
    this.ocupacao = 0;
    this.pontos=0;
    }
    
    public AutocarroInteligente(AutocarroInteligente a){
    super(a);
    this.ocupacao = a.getOcupacao();
    this.pontos = a.getPontos();
    }
    
    public AutocarroInteligente(String matricula, String marca, String modelo
                                , int ano, double velocidade, double preco
                                , double oc,int pts){
     super(matricula,marca,modelo,ano,velocidade,preco);
      this.ocupacao = oc;
      this.pontos = pts;
                                }
    
     public int getPontos(){
        return this.pontos;
        }                           
     
     public void setPontos(int pts) throws PontosException
     {
         if(pts >= 0 )
       this.pontos = pts;
       else
       throw new PontosException();
        }
    
    public double getOcupacao()
    { return this.ocupacao; }
    
    public void setOcupacao(double ocup) throws OcupacaoException
    {
        if(ocup >= 0)
        this.ocupacao = ocup;
        else 
        throw new OcupacaoException();
    }
    
    public void setPromocao(double o)
    { this.ocupacao = o; }
                              
    public double getPrecoA()
    { if (this.ocupacao >= 0 && this.ocupacao <= 0.6) 
        return (super.getPreco()*0.5 + super.getPreco()*0.1 * this.ocupacao) ;
      else return (0.25 * (super.getPreco()*0.5 + super.getPreco()*0.1 * this.ocupacao));
    }
    
    public AutocarroInteligente clone()
    { return new AutocarroInteligente(this); }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
                    s.append("Autocarro Inteligente ")
                    .append(" , ")
                    .append("Preco por km autocarro ," + getPrecoA())
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
                    .append(getPreco())
                    .append(" , ")
                    .append(getClassificacao())
                    .append(" , ")
                    .append(getKms())
                    .append(" , ")
                    .append(getUltkms())
                    .append(" , ")
                    .append(getNumAlugueres())
                    .append(" , ")
                    .append(getNumClassificacoes())
                    .append(" , ")
                    .append(getAlugado())
                    .append(" , ")
                    .append("Ocupação = ")
                    .append(" , ")
                    .append(this.ocupacao)
                    .append(" , ")
                    .append("Pontos = ")
                    .append(" , ")
                    .append(totalPontos());
                    
        return s.toString();
    }
    
    public double custoRealKm()
    {
      return (1.10 * super.getUltkms() * getPrecoA());
    }
    
    public void defPontosKm(int Pontos){
     this.pontos = pontos;
    }
    
    public int obPontosKm(){
     return this.pontos;
    }
    
    public int totalPontos(){
     return (int) (obPontosKm()*getUltkms());
    }
   
}
