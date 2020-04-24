
/**
 * Escreva a descrição da classe AlunoTE aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class AlunoTE extends Aluno
{
    private String empresa;
    
    public AlunoTE(){
    super(); //invoca construtor por defeito da superclasse    
    this.empresa = new String();
    }
    
    public AlunoTE(String numero, String nome,String empresa){
    super(numero, nome);
    this.empresa = empresa;
    }
    
    public AlunoTE(AlunoTE al){
        super(al.getNumero(),al.getNome());
        this.empresa = al.getEmpresa();
        
    }
    
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append("empresa:").append(this.empresa).append("\n");
    return sb.toString();
    }
    
    public String getEmpresa() {
        
        return this.empresa;
    }

    public AlunoTE clone(){
    return new AlunoTE(this);    
    }
    
}
