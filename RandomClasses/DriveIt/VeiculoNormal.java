
import java.time.LocalDate;
import java.io.*;

public class VeiculoNormal extends Veiculo implements Serializable
{
    
    
    public VeiculoNormal()
    { super();
    }
    
    public VeiculoNormal(String matricula, String marca, String modelo
                         , int ano, double velocidade, double preco)
    { super(matricula,marca,modelo,ano,velocidade,preco);
    }
       
    public VeiculoNormal(VeiculoNormal v)
    { super(v);
    }
    
    public VeiculoNormal clone()
    { return new VeiculoNormal(this); }
    
    public String toString()
    { StringBuilder s = new StringBuilder();
             s.append("Veiculo Normal: ")
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
             .append("O preço original é :"+getPreco())
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
             .append(getAlugado());
           
      return s.toString();
    }

    public double custoRealKm()
    {
      return (1.10 * getUltkms() * getPreco());
      
    }
}
