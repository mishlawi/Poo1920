
/**
 * Escreva a descrição da classe LinhaEncomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class LinhaEncomenda2
{
   private String nome;
   private String desc;
   private double preco;
   private double qtd;
   private double taxa;
   private double desconto;
//construtor por omissao
   public LinhaEncomenda2(){
   this.nome = new String();
   this.desc = new String();
   this.preco= 0.0;
   this.qtd  = 0.0;
   this.taxa = 0.0;
   this.desconto = 0.0;
}
//construtor parameterizado
    public LinhaEncomenda2 ( String n, String d, double p, double q, double t, double des){
    this.nome = n;
    this.desc = d;
    this.preco = p;
    this.qtd = q;
    this.taxa = t;
    this.desconto = des;
}        


//construtor por cópia

    public LinhaEncomenda2 (LinhaEncomenda2 le){
    this.nome= le.getNome();
    this.desc= le.getDescricao();
    this.preco=le.getPreco();
    this.qtd = le.getQuantidade();
    this.taxa = le.getTaxa();
    this.desconto = le.getDesconto();
}
        
//getters

public String getNome(){
return this.nome;
}    
    
public double getPreco(){    
return this.preco;    
}

public String getDescricao(){
return this.desc;
}
public double getQuantidade(){
return this.qtd;
}
public double getTaxa(){
return this.taxa;    
    
}
public double getDesconto(){
    
return this.desconto;    
}


public double calculaValorLinhaEnc(){
double valor;
valor = this.qtd*((this.preco-(this.preco*this.desconto))+this.preco*this.taxa);

return valor;
}

public double calculaValorDesconto(){
return this.qtd*(this.preco*this.desconto);    
}

}   
       
       

   
   
   
