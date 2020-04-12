    import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * Escreva a descrição da classe CasaInteligente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CasaInteligente
{
    private String nome;
    private List<Lampada> lampadas;
/*usar o List dà para usar qualquer tipo 
* de estrutura de dados do tipo List(como por exemplo ArrayList)
*/
    public CasaInteligente(){
    this.nome= new String(); // ou "";
    this.lampadas = new ArrayList<>(); //aqui tenho que escolher que tipo de lista;  
    }
    
    public CasaInteligente(String n, List <Lampada> lps){
    this.nome= n;
    setLampadas(lps);
    
    }
    
    public CasaInteligente(CasaInteligente ci){
    this.nome = ci.getNome();    
    setLampadas(ci.getLampadas());    
    }
    
    public String getNome(){
        return this.nome;        
    }
    
    public List<Lampada> getLampadas(){
    ArrayList<Lampada> aux = new ArrayList<>();
        for(Lampada l : this.lampadas)
            aux.add(l.clone());
            return aux;
    }
    
    public void setLampadas(List<Lampada> lampadas){
    this.lampadas=new ArrayList<>();
        for (Lampada l:lampadas)
            this.lampadas.add(l.clone());
        }
        
    public void addLampada(Lampada l){
     this.lampadas.add(l.clone());
    }
    
    public void ligaLampadaNormal(int index){
    this.lampadas.get(index).lampON();    
        
    }
    
    public void ligaLampadaEco(int index){
    this.lampadas.get(index).lampECO();
    }
    
    public int qtEmEco(){
    int qt=0;
        for(Lampada l : this.lampadas){
        if(l.getModo()==2) qt++;
        }
    return qt;    
    }
    
    public int qtEmEcoIt (){
    int qt =0;
    Iterator<Lampada> it = this.lampadas.iterator();
    while(it.hasNext())
        { Lampada l = it.next();
          if (l.getModo()==2) qt++;
            
        }
     return qt;   
    }
    
    public int qtEmEcoStreams(){
    return (int) this.lampadas.stream()
                              .filter(l -> l.getModo()==2)
                              .count();
    }
    
    
    public void ligaTodosEco(){
    this.lampadas.stream()
                 .forEach(l->l.lampECO()); //aplica a cada uma das lampadas
        
    }
    //fazer o consumo total com outros iteradores
    public double consumoTotal(){ 
        return this.lampadas.stream()
                            .mapToLong(Lampada::getTotal)
                            .sum();
        
    }
    
    public boolean equals(Object o){
    if(o==this) return true;    
    if(o ==null || o.getClass()!= this.getClass()) return false;    
    CasaInteligente ci = (CasaInteligente) o;
    return this.nome.equals(ci.getNome()) &&
            this.lampadas.equals(ci.getLampadas());
    }
    
     public Lampada lampadaMaisConsumo(){
     TreeSet <Lampada> lps = new TreeSet<>();
     
     for(Lampada l : this. lampadas)
        lps.add(l);
     return lps.first().clone();
         
        }
}
    


    
     

    

