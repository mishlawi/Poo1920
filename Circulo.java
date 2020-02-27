
/**
 * Escreva a descrição da classe Circulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Circulo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double x;
    private double y;
    private double raio;

    /**
     * COnstrutor por defeito
     */
    public Circulo()
    {
        // inicializa variáveis de instância
    this.x = 0.0;
    this.y= 0.0;
    this.raio = 0.0;
    }
    //Construtur pârameterizado
    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
        
}

    //Construtor de objeto

    public Circulo (Circulo c) {
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();

}
//getters setters
public double getX(){
return this.x;    
}

public double getY(){
return this.y;
    
}
public double getRaio(){
return this.raio;
}

public void setRaio(double raio){
    this.raio = raio;
    
}
public void setX (double x){
    this.x = x;
}

public void setY (double y){
    this.y = y;
}

//métodos 
//e)
public void alteraCentro ( double x, double y) {
setX(x);    
setY(y);
}


public double calculaArea() {
double area;

area = Math.PI * (getRaio()*getRaio());

return area;
}

public double calculaPerimetro(){
double perimetro;    
    
perimetro = 2 * Math.PI * getRaio();
return perimetro;
}
}