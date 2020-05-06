 

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] opts){

        VeiculoNormal v1 = new VeiculoNormal("AA00AA","Fiat","Punto",1996,30,6.0,20,10000,0,7);
        VeiculoNormal v2 = new VeiculoNormal("AA00AB","Fiat","Panda",2000,60,10.0,1,17000,0,3);
        VeiculoNormal v3 = new VeiculoNormal("AA00AC","Mercedes","A45",2020,100,20.0,5,10,0,10);
        VeiculoOcasiao v4 = new VeiculoOcasiao("AA00AD","Mercedes","ZZZ",2019,120,30,0,20000,0,10,false);
        VeiculoPremium v5 = new VeiculoPremium("AA00AE","Audi","A4",2019,120,30,0,20000,0,10, false,1.3);


        DriveIt d = new DriveIt();


        d.adiciona(v1);
        d.adiciona(v2);
        d.adiciona(v3);
        d.adiciona(v4);
        d.adiciona(v5);

        System.out.println("DriveIt: " + d.toString());

        d.entraEmPromocao();

        System.out.println("DriveIt: " + d.getVeiculos());


        System.out.println("O veiculo AA00AE existe? " + d.existeVeiculo("AA00AC"));

        System.out.println("Veiculos disponiveis para alugar: " + d.quantos());

        System.out.println("Veiculos de marca Fiat: " + d.quantos("Fiat"));

        System.out.println("Veiculo de matricula AA00AA: " + d.getVeiculo("AA00AA"));

        System.out.println("Todos os veiculos: " + d.getVeiculos());

        System.out.println("Registo de aluguer: ");

        d.registarAluguer("AA00AB",15);

        System.out.println(d.getVeiculos());

        System.out.println("Classificar o veiculo: ");

        d.classificarVeiculo("AA00AB",10);

        System.out.println("Todos os veiculos: " + d.getVeiculos());

        System.out.println("Custo real: " + d.custoRealKm("AA00AB"));

    }

}
