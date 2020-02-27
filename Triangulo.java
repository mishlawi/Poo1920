
/**
 * Escreva a descrição da classe Triangulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Triangulo
{
private Ponto v1;
private Ponto v2;
private Ponto v3;


public Triangulo(){
this.v1=new Ponto();
this.v2=new Ponto();
this.v3=new Ponto();
}

public Triangulo (Ponto a1, Ponto a2, Ponto a3){
this.v1 = a1.clone();
this.v2 = a2.clone();
this.v3 = a3.clone();
    
}

public Triangulo (Triangulo t){
this.v1 = t.v1;
this.v2 = t.v2;
this.v3 = t.v3;
    
}

public Ponto getV1(){
 return this.v1.clone();   
}

public Ponto getV2(){
 return this.v2.clone();   
}
public Ponto getV3(){
 return this.v3.clone();
}

public void setV3(Ponto v3){
   this.v3 = v3.clone();
}

public void setV2 (Ponto v2) {
    this.v2 = v2.clone();
}

public void setV1 (Ponto v1){
    this.v1 = v1.clone();
}


//metodos
    
/*area usando a formula de heron, que para qualquer tipo de triangulo
a sua area é dada por 
Area = sqrt(p*(p-a)(p-b)(p-c))
   sendo p = (a+b+c)/2
   onde a,b,c são as medidas dos lados do triangulo
   */ 
public double calculaAreaTriangulo(){
    double  p = (v1.distancia(v2)+v2.distancia(v3)+v3.distancia(v1))/2;
    double area = Math.sqrt(p*(p-v1.distancia(v2))*(v2.distancia(v3))*v3.distancia(v1));
    return area;
}

public double calculaPerimetro(){
double perimetro = v1.distancia(v2) + v1.distancia(v3) + v2.distancia(v3);    
return perimetro;
}

}
