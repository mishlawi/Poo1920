import java.util.Comparator;

public class ComparatorQuantNumero implements Comparator<EncEficiente>
{
 public int compare(EncEficiente a1, EncEficiente a2){
     if(a1.calculaValorTotal()>(a2.calculaValorTotal())) return -1;
     if(a1.calculaValorTotal()<(a2.calculaValorTotal())) return 1;
     else return 0;
     
 }
    
    
}