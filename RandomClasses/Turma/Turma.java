import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Turma
{
    private String nome;
    private String codigo;
    private Map <String,Aluno> alunos;
    
    public Turma(){
    this.nome= new String();
    this.codigo = new String();
    this.alunos = new HashMap<>();
    }
    
    public Turma(String n,String c, Map<String,Aluno> als){
    this.nome = n;
    this.codigo = c;
    setAlunos(als);
    }
    
    public Turma(Turma t){
    this.nome = t.getNome();
    this.codigo = t.getCodigo();
    setAlunos(t.getAlunos());
    }    
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public Map<String,Aluno> getAlunos(){
    Map <String,Aluno> aux = new HashMap<>();
    for(Map.Entry<String,Aluno> e:this.alunos.entrySet())
        aux.put(e.getKey(),e.getValue().clone()); //este clone a da classe aluno
    return aux;
    }
    
    public void setAlunos(Map <String,Aluno> als){
    this.alunos = new HashMap<>();
    als.entrySet().forEach(e-> this.alunos.put(e.getKey(),
                                               e.getValue().clone()));
    }
    
    public void insereAluno(Aluno a){
    this.alunos.put(a.getNumero(),a.clone());      
    }
    
    public Aluno getAluno (String codAluno){
        return this.alunos.get(codAluno).clone();
    }
    
    public void removeAluno (String codAluno){
    this.alunos.remove(codAluno);    
    }
    
    public Set<String> todosOsCodigos(){
    return this.alunos.keySet();           
    }
    
    public int qtsAlunos(){    
    return this.alunos.size();    
    }
    
    public Set<Aluno> alunosOrdemAlfabetica(){
    Set<Aluno> s = new TreeSet<>();
    for ( Aluno a: this. alunos.values())
        s.add(a.clone());
    return s;    
    }
    
    //    c/streams
    public Set<Aluno> alunosOrdemAlfabeticaStream(){
    return this.alunos.values().stream()
                        .map(a-> a.clone())
                        .collect
                        (Collectors.toCollection(TreeSet::new));
    
    }
    
    public Set<Aluno> alunosOrdemDecrescenteNumero(){
    Set <Aluno> s = new TreeSet <>(new ComparatorAlunoNumero());    
    for(Aluno a :this.alunos.values())
    s.add(a.clone());
    return s;
}
    
    
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Turma: \n")
      .append(this.nome)
      .append("\n")
      .append(this.codigo).append("\n")
      .append(this.alunos);
                         
    return sb.toString();                        
    }
    
    public Turma clone(){
        return new Turma(this);
    }
    
    public boolean equals(Object o){
    if (o==this) return true;
        if (o==null || o.getClass()!=this.getClass()) 
        return false;
        Turma t = (Turma) o;
        return this.nome.equals(t.getNome()) &&
               this.codigo.equals(t.getCodigo()) &&
               this.alunos.equals(t.getAlunos());
    }

    public int compareTo(Turma t) {
        return this.nome.compareTo(t.getNome()); 
    }
}
