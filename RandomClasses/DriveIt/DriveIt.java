
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.io.*;


public class DriveIt implements Serializable
{
    private Map<String,Veiculo> veiculos;
    
    private boolean promocao;
    private double taxa;
   

    public DriveIt(){
        this.veiculos = new HashMap<>();
        this.promocao = false;
        this.taxa = 1;
       
    }

    public DriveIt(Map<String,Veiculo> vs,boolean p,double t){
        setVeiculos(vs);
        this.promocao = p;
        this.taxa = t;
        
    }
    
    public DriveIt(DriveIt d){
        this.veiculos = d.getVeiculosMap(); 
        this.promocao = d.getPromocao();
        this.taxa = d.getTaxa();
       
    }
    
    public void setVeiculos(Map<String,Veiculo> vs){
        this.veiculos = new HashMap<>();
        vs.entrySet().forEach( e -> { this.veiculos.put(e.getKey(),e.getValue().clone());});
    }
    
    public Map<String,Veiculo> getVeiculosMap(){
        Map<String,Veiculo> aux = new HashMap<>();
        for(Veiculo a: this.veiculos.values()){
         aux.put(a.getMatricula(),a.clone());   
        }
        return aux;
    }
    
    
    public boolean getPromocao()
    { return this.promocao; }
    
    public double getTaxa(){
      return this.taxa;
    }
   
    
    public void setPromocao(boolean p)
    { this.promocao = p; }
    
    public void setTaxa(double t)
    { this.taxa = t; }
    
    public boolean equals(Object o){
     if(o==this) return true;
     if(o==null || o.getClass()!=this.getClass()) return false;
     DriveIt t = (DriveIt) o;
     return this.veiculos.equals(t.getVeiculosMap());  
    }
    
    public String toString(){
     StringBuilder s = new StringBuilder();
        s.append("DriveIt: ")
        .append(" , ")
        .append(this.veiculos.toString());
       
     return s.toString();
    }
    
    public DriveIt clone(){
     return new DriveIt(this);   
    }
    
    //a
    public boolean existeVeiculo(String cod){ return this.veiculos.containsKey(cod);}
    
    //b
    public int quantos(){return this.veiculos.size();}
    //c
    public int quantosT(String tipo){
       int c=0;
       for(Veiculo v : this.veiculos.values()){
         String cn = v.getClass().getSimpleName();
         if(cn.equals(tipo)) c++;
        }
        return c;
    }
    
  
    public int quantos(String marca){
        int cont=0;
        for(Veiculo v : this.veiculos.values()){
            if(marca.equals(v.getMarca())) cont+=1;
        }
        return cont;
    }

  //d
    public Veiculo getVeiculo(String cod) 
    {
        Veiculo res = null;
        for(Veiculo v: this.veiculos.values()){
         cod.equals(v.getMatricula()); res=v.clone();
        }
        return res;
    }

   //e
    public void adiciona(Veiculo v) throws ExisteVeiculoException
    {  if(this.veiculos.containsKey(v.getMatricula()))
        throw new ExisteVeiculoException(v.getMatricula());
        else
        this.veiculos.put(v.getMatricula(), v.clone());
    }
    
    public void remove(String mat) throws VeiculoInexistenteException
    {   if(this.veiculos.containsKey(mat))
        this.veiculos.remove(mat);
        else
            throw new VeiculoInexistenteException(mat);
    }
    
    //f
    public List<Veiculo> getVeiculos(){
        List<Veiculo> aux = new ArrayList<>();
        for(Veiculo v: this.veiculos.values()){
            aux.add(v.clone());
        }
        return aux;
    }
    
    //g
    public List<Veiculo> veiculosOrdenadosCusto(){
        Set<Veiculo> res = new TreeSet<>(new ComparatorPrecoRealKmD());
        for(Veiculo v : this.veiculos.values()){
            res.add(v.clone());}
        return res.stream().collect(Collectors.toList());
    }

    
    //h
    public Veiculo veiculoMaisBarato(){
        List<Veiculo> l = veiculosOrdenadosCusto();
        int n = l.size()-1;
        Veiculo v = l.get(n);
        return v;
    }
    
        public List<Veiculo> veiculosOrdenadoskms(){
        Set<Veiculo> res = new TreeSet<>(new ComparatorKmsPercorridosA());
        for(Veiculo v : this.veiculos.values()){
            res.add(v.clone());}
        return res.stream().collect(Collectors.toList());
    }
    
    //i
    public Veiculo veiculoMenosUtilizado(){
        List<Veiculo> l = veiculosOrdenadoskms();
        Veiculo v = l.get(0);
        return v;
    }
    
    
    //j
    public void adiciona(Set<Veiculo> vs){
        for(Veiculo a: vs){
            this.veiculos.put(a.getMatricula(), a.clone());
        }
    }
    
    //k
    public void registarAluguer(String codVeiculo, int numKms){ 
        this.veiculos.get(codVeiculo).realizaAluguer(numKms);
    }   
    
    //l
    public void classificarVeiculo(String cod, int classificacao) throws ClassificacaoException{
        try{    
        Veiculo v = veiculos.get(cod);
        int tot = v.getClassificacao() + classificacao;
        v.setNumAlugueres(v.getNumAlugueres() + 1);
        v.setClassificacao(tot / v.getNumAlugueres());
        v.setNumClassificacoes(v.getNumClassificacoes() + 1);
    }
        catch (ClassificacaoException e){ e.getMessage();}
       
        
    }
    //m
    public double custoRealKm(String cod){
        return this.veiculos.get(cod).custoRealKm();   
    } 
    
    
    //n
    // A empresa entra em promocao
    public void entraEmPromocao()
    { setPromocao(true); 
      for (Veiculo v : this.veiculos.values())
         if (v instanceof VeiculoOcasiao)
           { VeiculoOcasiao vo = (VeiculoOcasiao) v; 
              vo.setPromocao(true);
            }
    }  
    
    public void terminaPromocao()
    { setPromocao(false); 
      for (Veiculo v : this.veiculos.values())
         if (v instanceof VeiculoOcasiao)
           { VeiculoOcasiao vo = (VeiculoOcasiao) v; 
              vo.setPromocao(false);
            }
    }
    
    public long total85(){
     long total = 0;
     for(Veiculo v : veiculos.values()){
        total+=v.getUltkms()*v.getPreco();
        }
        return total;
    }
    
    /*(a) Obter um Set<Veiculo>, ordenado de acordo com a 
     *ordem natural dos hotéis (assuma que a ordem natural dos 
     *veículos é a ordem alfabética da sua marca e caso esta
     *seja igual o segundo factor é o modelo)
     ** */
    public Set<Veiculo> ordenarVeiculos() 
    {
        Set<Veiculo> s = new TreeSet<>();
          for(Veiculo v : this.veiculos.values())
              s.add(v.clone());
          return s;
    }

     
    //b mesmo que na A mas para list
    public List<Veiculo> ordenarVeiculos2()
    {
     return this.veiculos.values().stream()
                              .sorted()
                              .map(v -> v.clone())
                              .collect(Collectors.toList());
    }
     
     /* Experimente criar ordenações em função do número de kms
      * percorridos e em função do preço real por km (experimente
      * comparadores por ordem crescente e decrescente).*/
    public Set<Veiculo> ordenarVeiculos3(Comparator<Veiculo> c)
    {
        Set<Veiculo> s = new TreeSet<>(c);
          for(Veiculo v : this.veiculos.values())
              s.add(v.clone());
          return s;
    }
    
    /*(d) Guardar (de forma a que sejam identificáveis por nome) comparadores na classe DriveIt, permitindo assim ter disponíveis diferentes
     * critérios de ordenação.*/
   
     private static Map<String, Comparator<Veiculo>> ordenacao = new TreeMap<>();

     public void adicionaOrdem(String nome, Comparator<Veiculo> c)
     {
        ordenacao.put(nome,c);
     }

    
     /* Obter um iterador de Veiculo, ordenado de acordo com o critério
      * indicado*/

    public Iterator<Veiculo> ordenarVeiculo(String criterio)
    {
        Set<Veiculo> aux = new TreeSet<Veiculo>(ordenacao.get(criterio));
        for (Veiculo v : this.veiculos.values())
           aux.add(v.clone());
        return aux.iterator();
    }
    
    public List<BonificaKms> daoPontos(){
        List<BonificaKms> res = new ArrayList<>();
      for(Veiculo v : this.veiculos.values())
        if(v instanceof VeiculoPremium || v instanceof AutocarroInteligente){
         BonificaKms bk = (BonificaKms) v.clone();
         res.add(bk);
        }
        return res;        
    }
    
   public void gravarObj (String filename) throws IOException    
    {
        ObjectOutputStream o =
                new ObjectOutputStream(new FileOutputStream(filename)); 
        o.writeObject(this); 
        o.flush(); 
        o.close(); 
    }

    public DriveIt lerObj (String filename) throws IOException ,
                                          ClassNotFoundException
    {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
        DriveIt t = (DriveIt) o.readObject();
        o.close();
        return t;
    }
    
    public void gravaTxt(String fn) throws IOException
    {PrintWriter pw = new PrintWriter(fn);
        pw.print(this); 
        pw.flush();
        pw.close();
    }

}