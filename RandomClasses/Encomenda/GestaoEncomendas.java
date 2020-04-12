import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;



public class GestaoEncomendas
{
private Map <String,EncEficiente> gestao;

public GestaoEncomendas(){

this.gestao = new HashMap <>();    
    
}

public GestaoEncomendas(Map<String,EncEficiente> gst){

setGestao(gst);    
    
}

public GestaoEncomendas(GestaoEncomendas g){
setGestao(g.getGestao());
}
    
public Map <String,EncEficiente> getGestao(){
Map <String,EncEficiente> aux = new HashMap<>();
    for(Map.Entry<String,EncEficiente> e: this.gestao
                                                 .entrySet())
    aux.put(e.getValue().getNif(),e.getValue().clone());
return aux;                                            
}

public void setGestao(Map<String,EncEficiente> asd){
this.gestao= new HashMap<>();
    asd.entrySet().forEach(e->this.gestao.put(e.getValue().getNif(),e.getValue().clone()));

  }
     
public Set<String> todosCodigosEnc(){
        return this.gestao.keySet();
}    


public void addEncomenda (EncEficiente a){
        this.gestao.put(a.getNif(), a.clone());
    }

public EncEficiente getEncomenda(String codEnc){
       return this.gestao.get(codEnc).clone();
}

public void removeEncomenda (String codEnc){
this.gestao.remove(codEnc);
    
}

 public String encomendaComMaisProdutos() {
    TreeSet<EncEficiente> ecmp = 
     new TreeSet<>((e1,e2) -> (e1.numeroTotalProdutos())-(e2.numeroTotalProdutos()));
   
    for (EncEficiente e: this.gestao.values())
      ecmp.add(e);
    return (ecmp.last()).getNif();
  }



 
public Set<String> encomendasComProduto(String codProd){
Set<String> s = new TreeSet<>();
 for(Map.Entry<String,EncEficiente> e : this.gestao.entrySet())
    if(e.getValue().getNif().equals(codProd))
    s.add(e.getKey());
    return s;
}

public Set<String> encomendasAposData(LocalDate d){
    Set<String> s = new TreeSet<>();    
    for(Map.Entry<String,EncEficiente> e : this.gestao.entrySet())
    if(e.getValue().getData().isAfter(d))
    s.add(e.getKey());
    return s;
}

public Set<EncEficiente> encomendasValorDecrescente(){
    Set<EncEficiente> aux = new TreeSet<>(new ComparatorQuantNumero());
    for(EncEficiente a :this.gestao.values())
    aux.add(a.clone());
    return aux;
}
 public Map<String,List<String>> encomendasDeProduto() {
      Map<String,List<String>> glp = new HashMap<>();
     
     for (EncEficiente e: this.gestao.values()) {
        List<String> lp = e.getLinha().stream()
                                      .map(a->a.getReferencia())
                                      .collect(Collectors.toList());
        for (String codProd: lp) {
           if (!glp.containsKey(codProd))
             glp.put(codProd, new ArrayList<String>());
           glp.get(codProd).add(e.getNif());
        }   
     }
     return glp;
   }
   
   
   
   public String toString() {
     StringBuffer sb = new StringBuffer();
     for (EncEficiente e: this.gestao.values())
       sb.append(e.toString() + "\n");
     return sb.toString(); 
   }
   
   
   public boolean equals(Object o) {
      if (this == o) 
        return true;
      if ((o == null) || (this.getClass() != o.getClass()))
        return false;
      GestaoEncomendas ge = (GestaoEncomendas) o;
      return this.gestao.equals(ge.getGestao());
       
   }    

   public GestaoEncomendas clone() {
     return new GestaoEncomendas(this); 
   }
   

}
