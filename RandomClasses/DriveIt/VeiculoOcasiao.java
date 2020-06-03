
/**
 * Write a description of class VeiculoOcasiao here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.time.LocalDate;
public class VeiculoOcasiao extends Veiculo
{
    private boolean promocao;
    
    public VeiculoOcasiao()
    { super();
      this.promocao = false;
    }
    
    public VeiculoOcasiao(String matricula, String marca, String modelo
                         , int ano, double velocidade, double preco, boolean p)
    { super(matricula,marca,modelo,ano,velocidade,preco);
      this.promocao = p;
    }
       
    public VeiculoOcasiao(VeiculoOcasiao v)
    { super(v);
      this.promocao = v.getPromocao();
        //super(v.getMatricula(),v.getMarca(),v.getModelo(),v.getAno()
      //     ,v.getVelocidade(),v.getPreco(),v.getClassificacao(),v.getKms()
      //     ,v.getUltkms(),v.getNumAlugueres(),v.getNumClassificacoes());
      //this.promocao = v.getPromocao();
    }

    public boolean getPromocao()
    { return this.promocao; }
    
    public void setPromocao(boolean p)
    { this.promocao = p; }
    
    public double getPrecoO()
    { return this.promocao ?  0.75 * super.getPreco() :  super.getPreco() ;
    }
    
    public VeiculoOcasiao clone()
    { return new VeiculoOcasiao(this); }
    
    public String toString()
    { StringBuilder s = new StringBuilder();
     s.append("Veiculo de Ocasião: ")
              .append(" , ")
              .append("o preco veiculo ocasiao é :" + getPrecoO())
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
              .append("O preço orignal é"+ getPreco())
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
             .append(" , ");
      if (this.promocao) s.append(" EM PROMOCAO! "); 
      else s.append(" SEM PROMOCAO! ");
      return s.toString();
    }

    public double custoRealKm()
    {
      return (1.10 * getUltkms() * getPrecoO());
      
    }
}







