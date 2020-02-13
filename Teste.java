import java.util.Scanner;
/**
 * Basicamente todos os metodos desenvolvidos nas fichas são aqui implementados
 * 
 * Mish4k20 
 * Ano de2k19/2k20
 * Programação Orientada aos Objetos
 * Miei Universidade do Minho
 */
public class Teste
{
    public static void main (){
   
    Ficha1 f = new Ficha1();
    System.out.println("Exercicios parte 5 ficha 1");
    
    //exercicio 1
    System.out.println("Exercicio 1: Escreve um valor em graus Celsius (Ex:20,4)");
    Scanner ler = new Scanner(System.in);
    double a = ler.nextDouble();
    ler.close();
    // a funcao CparaF e do tipo double, b fica com o valor retornado dessa função
    double b= f.CparaF(a);
    System.out.println("Valor em fahrenheit:" + b); 
    
    /*
     * A mesma logica aplica se aos restantes exercicios
     */
}


    
}    