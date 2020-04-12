import java.time.LocalDate;
import java.util.ArrayList;

public class EncEficiente implements Comparable<EncEficiente>
{
    private String nome;
    private String nif;
    private String morada;
    private int numero;
    private LocalDate data;
    private ArrayList <LinhaEncomenda> linha;

    public EncEficiente(String nome, String nif, String morada, int numero, ArrayList<LinhaEncomenda> linha) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numero = numero;
        this.data = LocalDate.now();
        this.linha = new ArrayList<> ();
    }
    
    public EncEficiente(){
    this.nome= "";
    this.nif= "";
    this.morada = "";
    this.numero =0;
    this.data = LocalDate.now();
    this.linha = new ArrayList<>();    
    }
    
    
    public EncEficiente(EncEficiente enc){
    this.nome = enc.getNome();
    this.nif = enc.getNif();
    this.morada = enc.getMorada();
    this.numero = enc.getNumero();
    this.data = enc.getData();
    this.linha = enc.getLinha();
        
    }
    
    public EncEficiente clone(){
    return new EncEficiente(this);    
    }
    
    
     public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EncEficiente enc = (EncEficiente) object;
        return numero == enc.numero &&
                nome.equals(enc.nome) &&
                nif.equals(enc.nif) &&
                morada.equals(enc.morada) &&
                data.equals(enc.data) &&
                linha.equals(enc.linha);
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncEficiente{");
                sb.append("nome=" + nome + "\n");
                sb.append("nif=" + nif + "\n");
                sb.append("morada=" + morada + "\n");
                sb.append("numero=" + numero + "\n"); 
                sb.append("data=" + data + "\n");
                sb.append ("linha=" + linha + "\n");
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public String getMorada() {
        return morada;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getData() {
        return data;
    }

     public ArrayList <LinhaEncomenda> getLinha(){
        ArrayList <LinhaEncomenda> aux = new ArrayList <>();
        for( LinhaEncomenda l : this.linha)
            aux.add(l);
        return aux;
    }
      public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

  public void setLinha(ArrayList <LinhaEncomenda> linha){
    this.linha = new ArrayList<>();
        for(LinhaEncomenda l: linha)
            this.linha.add(l);
        }
        
    public int compareTo(EncEficiente a)
    { return this.nome.compareTo(a.getNome());
    }
        
   
    
    public double calculaValorTotal(){
    double valor=0;
    for(int i=0;i<(this.linha).size();i++){
    valor+=this.linha.get(i).getPreco();    
    }
    return valor;   
    }
    
    public double calculaValorDesconto(){
    double valor=0;
    for(int i=0;i<(this.linha).size();i++){
    valor+=this.linha.get(i).getDesconto();    
    }
    return valor;
        
    }
    
    
    public int numeroTotalProdutos(){
    int nr=0;
    for(int i=0;i<(this.linha).size();i++){
    nr+=this.linha.get(i).getQuantidade();    
    }
    return nr;    
    }
    
    public boolean existeProdutoEncomenda(String refProduto){
    boolean existe=false;
        for(int i=0;i<(this.linha).size();i++){
    if ((this.linha.get(i).getReferencia()).equals(refProduto))
    existe=true;
    }
    return existe;    
    }
    
    public void adicionaLinha(LinhaEncomenda lin){
    this.linha.add(lin);    
    }

    public void removeProduto(String codProd){
    int i;
    for( i=0;i<(this.linha).size() && !(this.linha.get(i).getReferencia().equals(codProd));i++);
    this.linha.remove(i);    
    
    }
    
  
}
            
            
        
