import java.time.LocalDate;
import java.util.ArrayList;

public class TesteEnc {
  public static void main(String[] opts) {
      LinhaEncomenda e1 = new LinhaEncomenda("aa","medina",3,30,2,0);
      LinhaEncomenda e2 = new LinhaEncomenda("bb","italo",20,40,2,0);
      LinhaEncomenda e3 = new LinhaEncomenda("cc","Toledo",15,20,2,0);
      EncEficiente e = new EncEficiente("nel da tina","12345","casa",12,LocalDate.now(),new ArrayList<>());
      e.adicionaLinha(e1);
      e.adicionaLinha(e2);
      e.adicionaLinha(e3);
      
      LinhaEncomenda e4 = new LinhaEncomenda("dd","foley",4,56,2,0);
      LinhaEncomenda e5 = new LinhaEncomenda("ee","anderson",50,32,2,0);
      LinhaEncomenda e6 = new LinhaEncomenda("ff","tinoco",78,45,2,0);
      EncEficiente en = new EncEficiente("ze da tina","123456","casa1",15,LocalDate.now(),new ArrayList<>());
      en.adicionaLinha(e4);
      en.adicionaLinha(e5);
      en.adicionaLinha(e6);
      
      LinhaEncomenda e7 = new LinhaEncomenda("gg","furioso",43,32,2,0);
      LinhaEncomenda e8 = new LinhaEncomenda("hh","nelito",56,82,2,0);
      LinhaEncomenda e9 = new LinhaEncomenda("ii","gervasio",21,5,2,0);
      EncEficiente enc = new EncEficiente("chico da tina","1234567","casa2",11,LocalDate.now(),new ArrayList<>());
      enc.adicionaLinha(e7);
      enc.adicionaLinha(e8);
      enc.adicionaLinha(e9);
      
      GestaoEncomendas gest = new GestaoEncomendas();
      gest.addEncomenda(e);
      gest.addEncomenda(en);
      gest.addEncomenda(enc);

      System.out.println("Encomenda");
      System.out.println(gest.toString());

      System.out.println("Encomenda com Mais Produtos:");
      System.out.println(gest.encomendaComMaisProdutos());

      System.out.println("Encomendas com produto :");
      System.out.println(gest.encomendasComProduto("123456"));
      
      System.out.println("Encomendas valor decrescente :");
      System.out.println(gest.encomendasValorDecrescente());
      
      
      
  }
}