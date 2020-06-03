
import java.util.Comparator;

public class ComparatorPrecoRealKmA implements Comparator<Veiculo>
{
    public int compare(Veiculo v1, Veiculo v2)
    {
     if (v1.custoRealKm() < v2.custoRealKm()) return -1;
     if (v1.custoRealKm() > v2.custoRealKm()) return 1;
     return 0;
    }
}
