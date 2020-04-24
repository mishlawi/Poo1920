



import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Set;

//Duarte Oliveira miei

public class DriveIt 
{
Map<String,Veiculo> veiculos= new HashMap<>();
    

 public Map<String,Veiculo> getVeiculos(){
    Map <String,Veiculo> aux = new HashMap<>();
    for(Map.Entry<String,Veiculo> e:this.veiculos.entrySet())
        aux.put(e.getKey(),e.getValue().clone()); //este clone a da classe aluno
    return aux;
    }
 
 public void setVeiculos(Map<String,Veiculo> veic){
    this.veiculos = new HashMap<>();
    veic.entrySet().forEach(e-> this.veiculos.put(e.getKey(),
                                               e.getValue().clone()));
    }
      
 public boolean existeVeiculo(String cod){
    boolean a = false;
    for(Map.Entry<String,Veiculo> e: this.getVeiculos().entrySet())
        if (e.getKey().equals(cod)) return a=true;
    return a;
 }

 public int quantos(String marca){
     int quantos=0;
     for (Map.Entry<String,Veiculo> e: this.getVeiculos().entrySet())
     if (e.getValue().getMarca().equals(marca)) quantos++;
     
    return quantos;
 }

 public Veiculo getVeiculo(String cod){
 return this.veiculos.get(cod).clone();
    
 }

 public void adiciona(Veiculo a){
     Map<String,Veiculo> aux = this.getVeiculos();
    aux.put(a.getCodigo(),a.clone());      
    setVeiculos(aux);
 }
 
 public List<Veiculo> getVeiculosLista(){
 List<Veiculo> result = new ArrayList(this.getVeiculos().values());    
 return result;
     
 }
 
 public void adiciona(Set<Veiculo> vs){
     Map<String, Veiculo> aux = vs.stream().collect(Collectors.toMap(Veiculo::getCodigo, e -> e));

     
     aux.entrySet().forEach(e->this.getVeiculos().put(e.getKey(),e.getValue().clone()));
    }
 
 public void registarAluguer( String codVeiculo, double numKms){
 Map <String,Veiculo> aux = this.getVeiculos();
 
 Veiculo v = this.getVeiculos().get(codVeiculo);
 v.setKms(v.getKms()+numKms);
 v.setUsers(v.getUsers()+1);
 
if(aux.replace(codVeiculo,this.getVeiculos().get(codVeiculo),v))
this.setVeiculos(aux);
}

public void classificarVeiculo (String cod, int classificacao){
 Map <String,Veiculo> aux = this.getVeiculos();
 
 Veiculo v = this.getVeiculos().get(cod);
 v.setClassificacao((v.getClassificacao()+classificacao)/v.getUsers());

 
if(aux.replace(cod,this.getVeiculos().get(cod),v))
this.setVeiculos(aux);
}


public double custoRealKm(String cod){
return (((this.getVeiculos().get(cod).getKms())*
this.getVeiculos().get(cod).getBase())*1.1);  
}
}

    
