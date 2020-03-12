
/**
 * Escreva a descrição da classe Carro aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Carro
{
    
    
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String marca;
    private String modelo;
    private int ano;
    private double consumo;
    private double km;
    private double media;
    private double ultmKm;
    private double mediaConsumo;
    private double regEnergia;
    private boolean ligado; //?
    
    
    
    public Carro(){
    this.marca = "";
    this.modelo = "";
    this.ano = 0;
    this.consumo = 0.0;
    this.km = 0.0;
    this.media = 0.0;
    this.ultmKm = 0.0;
    this.mediaConsumo= 0.0;
    this.regEnergia = 0.0;
    this.ligado = false;
        
    }
    
    public Carro (String a, String b, int c, double d, int e, double f, int g, double h, double i, boolean j){
    this.marca =a;
    this.modelo =b;
    this.ano =c;
    this.consumo =d;
    this.km =e;
    this.media =f;
    this.ultmKm =g;
    this.mediaConsumo =h;
    this.regEnergia =i;
    this.ligado =j;
    }
    
    public Carro(Carro e){
    this.marca = e.getMarca();
    this.modelo = e.getModelo();
    this.ano = e.getAno();
    this.consumo = e.getConsumo();
    this.km = e.getKm();
    this.media = e.getMedia();
    this.ultmKm = e.getUltmKm();
    this.mediaConsumo = e.getMediaConsumo();
    this.regEnergia = e.getRegEnergia();

    //criei esta variavel de instancia pq nao sei realmente
    //oq devo fazer no metodo ligarCarro() 
    
    this.ligado = e.getLigado();
    }
    //setters e getters
    public boolean getLigado(){
    return this.ligado; 
    }
    public void setLigado ( boolean a){
    this.ligado = a;    
    }
    public String getMarca (){
        return this.marca;    
    }
    
    public void setMarca(String s){
        this.marca = s;
    }
    
    public String getModelo(){
    return this.modelo;    
    }
    
    public void setModelo(String s){
        this.modelo = s;
    }
    
    public int getAno(){
    return this.ano;    
    }
    
    public void setAno( int a){
    this.ano= a;    
        
    }
    
    public double getConsumo(){
       return this.consumo; 
    }
    
    public void setConsumo( double c){
    this.consumo=c;    
    }
    
    public double getKm() {
        return this.km;
    }
    
    public void setKm(double k){
        this.km =k;
        
    }
    
    public double getMedia(){
    return this.media;    
        
    }
    
    public void setMedia (double m){
    this.media = m;
    
    }
    
    public double getUltmKm(){
    return this.ultmKm;
    }
    
    public void setUltmKm(double a){
    this.ultmKm = a;
    }
    
    public double getMediaConsumo(){
    return this.mediaConsumo;    
    }
    
    public void setMediaConsumo(double a){
        this.mediaConsumo = a;
        
    }
    
    public double getRegEnergia(){
    return this.regEnergia;    
    }
    
    public void setRegEnergia(double c){ 
    this.regEnergia = c;    
    }
    // metodos toString, equals e clone ---> nao extritamente necessarios neste contexto
    public String toString(){
    
        StringBuilder sb = new StringBuilder();
        sb.append ("Marca do Carro: ");
        sb.append (this.marca + "\n");
        sb.append ("modelo: ");
        sb.append (this.modelo + "\n");
        sb.append ("ano: ");
        sb.append (this.ano + "\n");
        sb.append ("consumo/km a 100km/h: ");
        sb.append (this.consumo + "\n");
        sb.append ("Kms feitos: ");
        sb.append (this.km + "\n");
        sb.append ("media kms: ");
        sb.append (this.media);
        sb.append ("kms ultima viagem: ");
        sb.append (this.ultmKm);
        sb.append ("media de consumo : ");
        sb.append (this.mediaConsumo + "\n");
        sb.append ("regeneração de energia: ");
        sb.append (this.regEnergia);
        
        return sb.toString();
        
    }
    
    public boolean equals (Carro a){
    if (this==a) return true;
    if ((a==null)||(this.getClass()!= a.getClass()))
    return false;
    Carro umCarro = (Carro) a;
    return (this.marca.equals(umCarro.getMarca())&&
    this.modelo.equals(umCarro.getModelo()) &&
    this.ano== umCarro.getAno() &&
    this.consumo == umCarro.getConsumo() &&
    this.km == umCarro.getKm() &&
    this.media == umCarro.getMedia() &&
    this.ultmKm == umCarro.getUltmKm() &&
    this.mediaConsumo == umCarro.getMediaConsumo() &&
    this.regEnergia == umCarro.getRegEnergia());
    }
    
    public Carro clone(){
        return new Carro(this);
    
    }
    
    //metodos
    public void ligaCarro(){
    this.setLigado(true);
    this.setUltmKm(0);
    }
    
    public void desligaCarro(){
    this.setLigado(false);    
    }
    
    public void resetUltimaViagem(){
    this.setUltmKm(0);
    this.setMediaConsumo(0);
    }
    
    public void avancaCarro (double metros, double velocidade){
    this.setMediaConsumo((this.getConsumo()*velocidade)/100);
}

    public void travaCarro(double metros){
    this.setMediaConsumo(this.getMediaConsumo()-(this.getRegEnergia()*(metros/1000)));
    
    }
    
    
    
}
    
    
    
    

