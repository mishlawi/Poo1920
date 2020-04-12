import java.time.LocalDate;
import java.util.Arrays;

/**
 * Escreva a descrição da classe Encomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Encomenda
{
private String nome;
private String nif;
private String morada;
private int numero;    
private LocalDate data;
private LinhaEncomenda [] linhas;
private int linhasUsadas;

private int nMaxLinhas;
private int usedLinhas;

public Encomenda(){
    this.nome = new String();
    this.nif = new String();
    this.morada = new String();
    this.numero= 0;
    this.data =LocalDate.now();
    this.linhas= new LinhaEncomenda[0];
    this.linhasUsadas = 0;
    
}

public Encomenda (String n, String nif, String m, int en, LinhaEncomenda[] l,int nMax){
this.nome = n;
this.nif = nif;
this.morada = m;
this.numero = en;
this.data = LocalDate.now();
this.linhas = new LinhaEncomenda [nMax];
int i;
for(i=0;i<l.length;i++)
    this.linhas[i] = l[i];
this.linhasUsadas = i;    
}


public Encomenda (Encomenda e){
e.nome = this.getNome();
e.nif = this.getNif();    
e.morada = this.getMorada();
e.numero = this.getNumero();
e.data = this.getDate();
e.linhas = this.getLinEncomenda();
e.linhasUsadas = this.getLinhasUsadas();
    
}
public void setLinhasUsadas(int a){
    this.linhasUsadas = a;    
}

public int getLinhasUsadas(){
return this.linhasUsadas;

}


private LinhaEncomenda[] getLinEncomenda(){

return this.linhas;
    
}

public LocalDate getDate(){
    return LocalDate.now();
}

public int getNumero(){
return this.numero;    
    
}

public String getMorada(){
return this.morada;    
    

}
public String getNome(){
return this.nome;    
    
}

public String getNif(){
return this.nif;    
    
}
public double calculaValorTotal(){
double valor=0;
int i=0;
    while(i<this.getLinhasUsadas()){
        valor += (this.linhas[i]).calculaValorLinhaEnc();
        i++;
}

return valor;
}

public double calculaValorDesconto(){
double valor=0;

for(int i=0;i<this.getLinhasUsadas() ; i++){
    valor += (this.linhas[i].calculaValorDesconto());
    i++;
}
    
return valor;    
}

public int numeroTotalProdutos(){
int i;
int conta=0;
for(i=0;i<this.getLinhasUsadas();i++){
conta+= (this.linhas[i].getQuantidade());
    
}
    
return conta;    
}

public boolean existeProdutoEncomenda (String refProduto){
boolean v=false;
int i=0;

for(i=0; i<this.getLinhasUsadas() && v!=true;i++){
    if (refProduto.equals(this.linhas[i].getNome())){
    v=true;
    }
        
        
    }
return v;
}


public void adicionaLinha (LinhaEncomenda linha){
int i;

for(i=0; i<this.getLinhasUsadas();i++);
this.getLinEncomenda()[i]= linha;    
setLinhasUsadas(i);    
    
}
    
public void removeProduto ( String codProd){
int i;
  for(i=0;!codProd.equals((this.linhas[i]).getNome());i++);
  while(i<this.getLinhasUsadas()){
  int j=i+1;
      this.getLinEncomenda()[i]=this.getLinEncomenda()[j];     
  i++;
}
}
    
    
}








