package br.com.dio.exercicios2;

/*
Crie um conjunto contendo as cores do arco-iris e:
    A. Exiba todas as cores uma abaixo da outra
    B. A quantidade de cores que o arco-íris tem
    C. Exiba as cores em ordem alfabética
    D. Exiba as cores na ordem inversa da que foi informada
    E. Exiba todas as cores que começam com a letra "v"
    F. Remova todas as cores que não começam com a letra "v"
    G. Limpe o conjunto
    H. Confira se o conjunto está vazio

    cores: vermelha, laranja, amarela, verde, azul, anil e violeta
 */

import java.util.*;

public class ExercicioProposto1 {
    public static void main(String[] args) {

        System.out.println("Cores do arco-iris: ");
        Set<String> cores = new HashSet<>(Arrays.asList("\nVermelha", "\nLaranja", "\nAmarela",
                "\nVerde", "\nAzul", "\nAnil", "\nVioleta"));
        System.out.println(cores.toString());

        System.out.println("Quantidade de cores: ");
        System.out.println(cores.size());

        System.out.println("Ordem alfabética: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        System.out.println("Ordem reversa: ");
        Set<String> cores3 = new LinkedHashSet<>();
        cores3.add("Vermelha");
        cores3.add("Laranja");
        cores3.add("Amarela");
        cores3.add("Verde");
        cores3.add("Azul");
        cores3.add("Anil");
        cores3.add("Violeta");
        List<String> coresArco = new ArrayList<>(cores3);
        Collections.reverse(coresArco);
        System.out.println(coresArco);

        System.out.println("Exiba todas as cores que começam com a letra 'V': ");
        for (String cor: cores3) {
            if(cor.startsWith("V")) System.out.println(cor);
        }

        System.out.println("Remova todas as cores que não começam com a letra 'V'");
        Iterator<String> iterator1 = cores3.iterator();
        while (iterator1.hasNext()) {
            if (!iterator1.next().startsWith("V")) iterator1.remove();
        }
        System.out.println(cores3);

        System.out.println("Limpe o conjunto: ");
        cores.clear();


        System.out.println("Confirme se ele está vazio: " + (cores.isEmpty()));

    }
}


