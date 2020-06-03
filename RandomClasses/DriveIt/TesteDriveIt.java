import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.time.LocalDate;
import java.io.*;


public class TesteDriveIt
{
    public static void main (String[] ss)
    { 
      
        
      VeiculoNormal v1 = new VeiculoNormal("aa-11-bb","bmw","s3",2020,56.5,1);
      VeiculoOcasiao v2 = new VeiculoOcasiao("aa-22-bb","ford","focus",2018,50.0,2,false);
      VeiculoPremium v3 = new VeiculoPremium("aa-33-bb","opel","corsa",2010,60.0,3,1.5,4);
      VeiculoOcasiao v4 = new VeiculoOcasiao("aa-44-bb","citroen","c4",2015,70.0,3,true);
      VeiculoPremium v5 = new VeiculoPremium("bb-55-aa","audi","a1",2019,53.5,3,1.5,2);
      AutocarroInteligente v6 = new AutocarroInteligente("bb-66-aa","mercedes","cls",2017,86.5,3,0.5,3);
                     
      DriveIt avis = new DriveIt();
      try{  
      avis.adiciona(v1);
      avis.adiciona(v2);
      avis.adiciona(v3);
      avis.adiciona(v4);
      avis.remove("aa-44-xx");
      avis.adiciona(v5);
      avis.adiciona(v6);
    }catch (ExisteVeiculoException m)
    {
     System.out.println("Já existe o veículo " + m.getMessage());
    }
    catch(VeiculoInexistenteException m)
    {
     System.out.println("Não existe o veículo " + m.getMessage());
    }
    System.out.println("   ");

      System.out.println("é feito um aluguer do v1 onde foram percorridos 500 kms");
      avis.registarAluguer("aa-11-bb", 500);
      System.out.println("Ultimos kms realizados pelo veiculo v1 :" + v1.getUltkms());
      System.out.println("Total kms realizados pelo veiculo v1 :" + v1.getKms());
      System.out.println("Total alugueres realizados pelo veiculo v1 :" + v1.getNumAlugueres());
      System.out.println("   ");

      
      System.out.println("é feito um segundo aluguer do v1 onde foram percorridos 100 kms");
      avis.registarAluguer("aa-11-bb", 100);
      System.out.println("Ultimos kms realizados pelo veiculo v1 :" + v1.getUltkms());
      System.out.println("Total kms realizados pelo veiculo v1 :" + v1.getKms());
      System.out.println("Total alugueres realizados pelo veiculo v1 :" + v1.getNumAlugueres());
      System.out.println("   ");
      
      System.out.println("São atribuidas duas classificações ao v1, de 10 e 6 respetivamente");
      try{avis.classificarVeiculo("aa-11-bb", 10);} catch(ClassificacaoException e){e.getMessage();}
      try{avis.classificarVeiculo("aa-11-bb", 6);} catch(ClassificacaoException e){e.getMessage();}
      System.out.println("Classificação do veiculo v1 :" + v1.getClassificacao());
      System.out.println("Numero de Classificações do veiculo v1 :" + v1.getNumClassificacoes());
      System.out.println("   ");


    
      
      System.out.println("Avis" + avis.toString());
      
      System.out.println("Todos os veiculos terminam a promoção");
      avis.terminaPromocao();
      System.out.println("Avis" + avis.toString());
      
      System.out.println("Todos os veiculos entram em promoção");
      avis.entraEmPromocao();
      System.out.println("Avis" + avis.toString());
     

      


      Set<Veiculo> s = avis.ordenarVeiculos();
      System.out.println("-------- set ordenado por ordem natural primeiro pela marca e se igual pelo modelo -----");
      System.out.println(s);
      System.out.println("   ");
      
       List<Veiculo> l = avis.ordenarVeiculos2();
      System.out.println("-------- Lista ordenada por ordem natural primeiro pela marca e se igual pelo modelo -----");
      System.out.println(l);
      System.out.println("   ");
    
      
      Set<Veiculo> list = avis.ordenarVeiculos3(new ComparatorKmsPercorridosA());
      System.out.println("-------- set ordenado de forma ascendente de acordo com o nº de kms percorridos -----");
      System.out.println(list);
      System.out.println("   ");
      
      Set<Veiculo> list1 = avis.ordenarVeiculos3(new ComparatorKmsPercorridosD());
      System.out.println("-------- set ordenado de forma descendente de acordo com o nº de kms percorridos -----");
      System.out.println(list1);
      System.out.println("   "); 
      
      Set<Veiculo> list2 = avis.ordenarVeiculos3(new ComparatorPrecoRealKmA());
      System.out.println("-------- set ordenado de forma ascendente de acordo com o custo real km -----");
      System.out.println(list2);
      for(Veiculo v : list2){
      System.out.println(v.custoRealKm());}
      System.out.println("   ");

      
      Set<Veiculo> list3 = avis.ordenarVeiculos3(new ComparatorPrecoRealKmD());
      System.out.println("-------- set ordenado de forma descendente de acordo com o custo real km -----");
      System.out.println(list3);
      for(Veiculo v : list3){
      System.out.println(v.custoRealKm());}
      System.out.println("   ");
      
      
      avis.adicionaOrdem("comparadorAnoAscendente",new ComparatorAno());
       
      Iterator<Veiculo> it = avis.ordenarVeiculo("comparadorAnoAscendente");
      System.out.println("Iterar o resultado da ordenação conforme o comparador comparadorAnoAscendente: ");
      while (it.hasNext())
        System.out.println(it.next()); 
        
        List<Veiculo> r = avis.veiculosOrdenadosCusto();
        System.out.println("-------- set ordenado de forma descendente de acordo com o custo-----");
        System.out.println(r);
        for(Veiculo v : r){
        System.out.println(v.custoRealKm());}
        System.out.println("   ");
        
      
      Veiculo v = avis.veiculoMaisBarato();
      System.out.println(v.toString());
      System.out.println(v.custoRealKm());
      System.out.println("   ");
      
      
      Veiculo vk = avis.veiculoMenosUtilizado();
      System.out.println(vk.toString());
      System.out.println(vk.getKms());
      System.out.println("   ");
      
      try {
            avis.gravarObj("AVIS");
        }catch (IOException m)
        {
            System.out.println("Erro a gravar!");
        }

        DriveIt avis2 = new DriveIt();
        try{
            avis2 = avis.lerObj("AVIS");
        }catch(IOException m)
        {
            System.out.println("Erro a ler!");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println(" AVIS 2: " + avis2);
    }
}