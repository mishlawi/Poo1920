
public class VeiculoOcasiao extends Veiculo
{
    private boolean promocao;
    
    public VeiculoOcasiao()
    {
        super();
        this.promocao = false;
    }

    public VeiculoOcasiao(String codigo, String marca, String modelo, int ano, double media, double base, int classificacao, int users, double kms,boolean promocao){
      super(codigo,marca,modelo,ano,media,base,classificacao,users,kms);  
      this.promocao = promocao;
    }
    
    public VeiculoOcasiao(VeiculoOcasiao vo){
    super(vo);
    this.promocao = vo.getPromocao();
    }
    
    public boolean getPromocao(){
        return this.promocao;
    }
    
    public void setPromocao(boolean promocao){
    this.promocao=promocao;        
    }
    
    public double getPrecoKm(){
    return this.promocao ? 0.75 * super.getBase() : super.getBase();     
        //se tiver em promocao  ? faz isto        se for falso :  faz isto                  
    }
  
    public String toString()
    {StringBuilder s = new StringBuilder();
        s.append(super.toString());
        if (this.promocao) s.append("Em promoção").append(getPrecoKm());
        else s.append("Sem promocao\n\n");
        return s.toString();
    }
    
    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }
    
    public double custoRealKm(){
    return 1.18*getKms()*getBase();
    }
}
