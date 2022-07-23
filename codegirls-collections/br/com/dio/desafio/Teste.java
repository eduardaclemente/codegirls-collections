package br.com.dio.desafio;

import java.io.IOException;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws IOException {
        System.out.println("Insira a quantiedade de nomes que deverá haver no vetor: ");
        int qtNomes = new Scanner(System.in).nextInt();
        String vetorNomes[] = new String[qtNomes];
        String nomes = "";
        for (int i = 0; i < vetorNomes.length; i++) {
            System.out.println("Insira os nomes: ");
            nomes = new Scanner(System.in).nextLine();
            vetorNomes[i] = nomes;
        }
        System.out.println("Insira o nome que deseja procurar!");
        String nomeP = new Scanner(System.in).nextLine();
        for (int j = 0; j < vetorNomes.length; j++) {
            if (nomeP.equals(vetorNomes[j])) {
                System.out.println("o nome é: " + nomeP + " e sua posição é: " + (j + 1));

            } else if ((j + 1) == qtNomes) {
                System.out.println("Seu nome não foi encontrado");
            }
        }
    }
}
