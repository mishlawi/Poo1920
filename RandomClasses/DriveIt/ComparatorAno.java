
import java.util.Comparator;

public class ComparatorAno implements Comparator<Veiculo>
{
    public int compare(Veiculo v1, Veiculo v2)
    {
     if(v1.getAno()<v2.getAno()) return -1;
     else if(v1.getAno()>v2.getAno()) return 1;
     else return 0;
    }
}
