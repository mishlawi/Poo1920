import java.time.LocalDate;
import java.io.*;




public abstract class Veiculo implements Comparable<Veiculo>, Serializable
{
   private String matricula;
   private String marca;
   private String modelo;
   private int ano;
   private double velocidade; 
   private double preco;
   private int classificacao;
   private double kmsPercorridos;
   private double ultkms;
   private int numAlugueres;
   private int numClassificacoes;
   private boolean alugado;
   
 
   public Veiculo(){
       this.matricula = new String();
       this.marca = new String();
       this.modelo= new String();
       this.ano = 0;
       this.velocidade = 0;
       this.preco = 0;
       this.classificacao = 0; 
       this.kmsPercorridos=0;
       this.ultkms=0;
       this.numAlugueres=0;
       this.numClassificacoes=0;
       this.alugado = false;
   }

   public Veiculo(String matricula, String marca, String modelo, int ano, double velocidade, double preco){
       this.matricula=matricula;
       this.marca=marca;
       this.modelo=modelo;
       this.ano=ano;
       this.velocidade=velocidade;
       this.preco=preco;
   }

   public Veiculo(Veiculo v){
       this.matricula = v.getMatricula();
       this.marca = v.getMarca();
       this.modelo = v.getModelo();
       this.ano = v.getAno();
       this.velocidade = v.getVelocidade();
       this.preco = v.getPreco();
       this.classificacao = v.getClassificacao();
       this.kmsPercorridos=v.getKms();
       this.ultkms=v.getUltkms();
       this.numAlugueres=v.getNumAlugueres();
       this.numClassificacoes=v.getNumClassificacoes();  
       this.alugado = v.getAlugado();
   }

   public String getMatricula(){return this.matricula;}
   public String getMarca(){return this.marca;}
   public String getModelo(){return this.modelo;}
   public int getAno(){return this.ano;}
   public double getVelocidade(){return this.velocidade;}
   public double getPreco(){return this.preco;}
   public int getClassificacao(){return this.classificacao;}
   public double getKms(){return this.kmsPercorridos;}
   public double getUltkms(){return this.ultkms;}
   public int getNumAlugueres(){return this.numAlugueres;}
   public int getNumClassificacoes(){return this.numClassificacoes;}
   public boolean getAlugado(){ return this.alugado;}
   
   public void setMatricula(String matricula){this.matricula=matricula;}
   public void setMarca(String marca){this.marca=marca;}
   public void setModelo(String modelo){this.modelo=modelo;}
   
   public void setAno(int ano) throws AnoException 
   {if(ano>=2000 && ano <=2020)
       this.ano=ano; 
       else
       throw new AnoException();}
       
   public void setVelocidade(double velocidade) throws VelocidadeException
   {if(velocidade<0)
       throw new VelocidadeException();
       else
       this.velocidade=velocidade;}
       
   public void setPreco(double preco) throws PrecoException
   {if(preco<0)
       throw new PrecoException();
       else
       this.preco=preco;}
       
   public void setClassificacao(int classificacao) throws ClassificacaoException
   {if(classificacao<0 || classificacao >10)
       throw new ClassificacaoException();
       else
       this.classificacao=classificacao;}
       
   public void setKms(double kmsPercorridos) 
   {   
       this.kmsPercorridos = kmsPercorridos;
    }
       
   public void setUltkms(double ultkms) 
   {   
       this.ultkms = ultkms;
    } 
       
   public void setNumAlugueres(int numAlugueres)
   {   
       this.numAlugueres = numAlugueres;
    }  
    
   public void setNumClassificacoes(int numClassificacoes)
   {   
       this.numClassificacoes = numClassificacoes;
    }
    
    public void setAlugado(boolean b) { this.alugado = b;}
   
   public abstract Veiculo clone(); 

   public abstract double custoRealKm();
   
   public boolean equals(Object o){
       if (o == this) return true;
       if (o == null || o.getClass() != this.getClass()) return false;
       Veiculo a = (Veiculo) o;
       return this.matricula.equals(a.getMatricula()) && this.marca.equals(a.getMarca()) && this.modelo.equals(a.getModelo())
           && this.ano ==(a.getAno()) && this.velocidade==(a.getVelocidade()) && this.preco==(a.getPreco()) && this.classificacao==(a.getClassificacao())
           && this.kmsPercorridos==(a.getKms()) && this.ultkms==(a.getUltkms()) && this.numAlugueres==(a.getNumAlugueres()) && this.numClassificacoes==(a.getNumClassificacoes()); 
     
   }

   public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("Veiculo: ").append(" , ")
                            .append(this.matricula)
                            .append(" , ")
                            .append(this.marca)
                            .append(" , ")
                            .append(this.modelo)
                            .append(" , ")
                            .append(this.ano)
                            .append(" , ")
                            .append(this.velocidade)
                            .append(" , ")
                            .append(this.preco)
                            .append(" , ")
                            .append(this.classificacao)
                            .append(" , ")
                            .append(this.kmsPercorridos)
                            .append(" , ")
                            .append(this.ultkms)
                            .append(" , ")
                            .append(this.numAlugueres)
                            .append(" , ")
                            .append(this.numClassificacoes)
                            .append(" , ")
                            .append(this.alugado);
                             
      return sb.toString();
    }


   public int compareTo(Veiculo a){
       if (this.marca.equals(a.getMarca()))
          return this.modelo.compareTo(a.getModelo());
       return this.marca.compareTo(a.getMarca()); 
   }

   public void realizaAluguer(int kms){
       this.kmsPercorridos+=kms;
       this.numAlugueres++;
       this.ultkms=kms; 
       this.alugado = true;
   }
   

}