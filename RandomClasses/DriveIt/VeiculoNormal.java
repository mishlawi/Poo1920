
public class VeiculoNormal extends Veiculo
{

    
    public VeiculoNormal()
    {
        super();

    }

    public VeiculoNormal(String codigo, String marca, String modelo, int ano, double media, double base, int classificacao, int users, double kms,boolean promocao){
      super(codigo,marca,modelo,ano,media,base,classificacao,users,kms);  

    }
    
    public VeiculoNormal(VeiculoNormal vn){
    super(vn);

    }      
   
    public String toString()
    {StringBuilder s = new StringBuilder();
        s.append(super.toString());
       s.append("\n");
        return s.toString();
    }
    
    public VeiculoNormal clone(){
        return new VeiculoNormal(this);
    }
    
    public double custoRealKm(){
    return 1.18*getKms()*getBase();
    }
}
