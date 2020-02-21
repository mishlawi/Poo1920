import java.util.Scanner;
import java.util.Arrays;
/**
 * Escreva a descrição da classe Ficha2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Ficha2
{
 /* ESTA PARTE NAO ESTÁ TOTALMENTE CERTA, APENAS O EXERCICIO DO EUROMILHOES ESTÁ VERIFICADO 
       public int minArray (int [] a){
        int i=0;
        int menor=0;
            for(i=0;i<a.length;i++){      
                if (a[i]<=menor){
                    menor=a[i];       
                }
            }
            return menor;   
        }      
    
    public int[] indices(int [] a,int size,int i1,int i2){
    int b[];
    b= new int[size];
    int i=0;
    int j=0;
        
        for(i=0;i<size;i++){
            while(i<i1) i++;
            while(i1<i2){
            b[j]=a[i];
            i++;
            j++;
            }
        }
        return b;
    }
    
    public int [] comuns ( int [] a, int [] b){
       
    int i=0;
    int j=0;
    int y=0;
    while(a[i]!='\0') i++;
    int sizea = i;
    while(b[j]!='\0')j++;
    int sizeb= j;
    int size = Math.min(sizeb,sizea);
    
    
    int [] comum = new int[size];
    int c=0;
    int d=0;
    while( c < a.length || d<b.length) {
        
            if (a[c]< b[d]) {
             c++;
            }
             else
            if (a[c]==b[d]){
                comum[y++]=a[c];
                j++;
                i++;             
            }
            else{ i++;
                j++;
            }
            
     
    }

    return comum;
}
*/
//EXERCICIO EUROMILHOES
    
public int numeros[] = new int [5];
public int estrelas[] = new int [2];

public void euromilions(){
gera_jogo();
verify_keys();
}


public void gera_jogo (){
for(int i=0;i<numeros.length;i++){
    numeros[i]=(int) (Math.random()*50)+1;        
}

for (int i=0; i<estrelas.length;i++){
estrelas[i]=(int) (Math.random()*10)+1;
}
}


public void verify_keys() {
 int [] nrJog = new int [5];
 int [] esJog = new int [2];
 Scanner sc = new Scanner (System.in);

    //INSERÇÃO DE NUMEROS E ESTRELAS 
 System.out.println("Insira os seus numeros (1-50), ENTER PARA IR ADICIONANDO: \n");
 int verif=1;   
 for(int i=0; i<5 && verif!=0; i++){
        int numero = sc.nextInt();
        if (numero>50 || numero<0){
        System.out.println("Erro! \n Tente de novo");
        verif=0;
    }
        nrJog[i] = numero;
    }
 verif=1;   

 System.out.println("Insira as suas estrelas (1-10): \n");
    for(int i=0; i<2 && verif!=0 ;i++){       
 int estrela = sc.nextInt();
         if (estrela>10 || estrela<0){
        System.out.println("Erro! \n Tente de novo");
        verif=0;
    }
         else
        esJog[i]= estrela;
 
    }
//PRINT DOS NRS E ESTRELAS SORTEADOS
   System.out.println("Os numeros: \n");
    for(int i =0; i < numeros. length ; i ++)
System . out . println ( numeros[ i ]) ;

System.out.println("As estrelas: \n");
    for(int i =0; i < estrelas. length ; i ++)
System . out . println ( estrelas[ i ]);
// VERIFICAÇÃO DA APOSTA

if(Arrays.equals(nrJog,numeros) && Arrays.equals(esJog,estrelas)) System.out.println ("Acertou");
    else System.out.println("Errou \n");
}

//fim exercicio euromilhoes
}

