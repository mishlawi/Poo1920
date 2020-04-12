
/**
 * Escreva a descrição da classe TesteTurma aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteTurma
{
  public static void main(String[] opt){
  Aluno a1 = new Aluno("1", "Zé");
  Aluno a2 = new Aluno ("2", "Ana");
  Aluno a3 = new Aluno ("3", "Tó");

  Turma t = new Turma();
  t.insereAluno(a1);
  t.insereAluno(a2);
  t.insereAluno(a3);
  
  System.out.println("Ordem coleção");
  System.out.print(t.toString());
  System.out.println("Ordem coleção");
  System.out.println(t.alunosOrdemAlfabetica());
  System.out.println("Ordem coleção");
  System.out.println(t.alunosOrdemAlfabeticaStream());
  System.out.println("Ordem coleção");
  System.out.println(t.alunosOrdemDecrescenteNumero());
}    
      
}
