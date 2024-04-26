package joaovitorlopes.com.github.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("Seja bem-vindo ao Conversor de Moeda =]\n");
        System.out.println("1) Dólar ==> Peso argentino");
        System.out.println("2) Peso argentino ==> Dólar");
        System.out.println("3) Dólar ==> Real brasileiro");
        System.out.println("4) Real brasileiro ==> Dólar");
        System.out.println("5) Dólar ==> Peso colombiano");
        System.out.println("6) Peso colombiano ==> Dólar");
        System.out.println("7) Sair");
        System.out.println("Escolha uma opção válida:");
        System.out.println("***********************************************\n");
        var entryOption = reading.nextLine();
        System.out.println(entryOption);
    }
}
