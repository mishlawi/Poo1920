import java.lang.System;
import java.time.LocalDate;
/**
 * 
 * 
 * @author Mish4k20 
 * 2k19/2k20
 * Programação Orientada aos Objetos
 * Miei Universidade do Minho
 */
public class Ficha1
{
    // pergunta  1
    public double CparaF(double graus){
    double farnheit = (graus*1.8+32);
    return farnheit;

    }
    
    // pergunta 2
    public int maximoNumero(int a, int b){
    if (a>=b) return a;
    else return b;
    }
    //pergunta 3
    public String criaDescricaoConta (String nome,double saldo){
    String s ="A conta " + nome + "tem um saldo de: " + saldo;
    return s;
    }
    //pergunta 4
    public double eurosParaLibras (double valor, double taxaConversao){
    double taxa = valor * taxaConversao;
    return taxa;
    }
    //pergunta 5
    public void DecMedia (int a, int b){
        int media;
        media= (a+b)/2;
        if (a>b) System.out.println("A = " + a + " B = " + b + "media= " + media);
        else 
        System.out.println( "B =" + b + "A ="+ a + "media= " + media); 
    }
    //pergunta 6
    public int fatorial (int valor){
        // 7! = 7*6*5*4*3*2*1
    int b=valor;
    valor--;
    while(valor>0){
    b=(b*valor);
    valor--;    
    }
    return b;
}
   //pergunta 7
   public long tempoGasto(){
    long TempoInicial = System.currentTimeMillis();
    int a=5000;
    int c=fatorial(5000);
    long TempoFinal=System.currentTimeMillis();
    long diferenca = TempoFinal - TempoInicial;
    return diferenca;
   }
    
}
    
    


    
    