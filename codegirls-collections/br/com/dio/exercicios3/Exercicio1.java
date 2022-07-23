package br.com.dio.exercicios3;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265

 - Crie um dicionário e relacione os estados e populações
 - Substitua a população do RN por 3.534.165
 - Confira se o estado de PB está no dicionário, caso não adicione: PB - 4.039.277
 - Exiba a população de PE
 - Exiba todos os estados e suas populações na ordem que foi informado
 - Exiba os estados e suas populações em ordem alfabética
 - Exiba o estado com a menor população e sua quantidade.
 - Exiba o estado com a maior população e sua quantidade.
 - Exiba a soma da população desses estados
 - Exiba a média da população desse dicionário de estado.
 - Remova os estados com a população menor que 4.000.000
 - Apague o dicionário
 - Confira se está vazio
 */

import java.util.*;

public class Exercicio1 {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário e relacione os estados e populações: ");
        Map<String, Double> estadosPopulacao = new HashMap<>(){{
            put("PE", 9.616_621);
            put("AL", 3.351_543);
            put("CE", 9.187_103);
            put("RN", 3.534_265);
        }};
        System.out.println(estadosPopulacao.toString());

        System.out.println("Substitua a população do RN por 3.534.165: ");
        estadosPopulacao.put("RN", 3.534_165);
        System.out.println(estadosPopulacao);

        Map<String, Double> estadosPopulacao2 = new HashMap<>(){{
            put("PE", 9.616_621);
            put("AL", 3.351_543);
            put("CE", 9.187_103);
            put("RN", 3.534_265);
        }};
        estadosPopulacao2.put("PB", 4.039_277);
        System.out.println("Confira se o estado de PB está no dicionário, caso não adicione PB - 4.039.277: " +
                estadosPopulacao2.containsKey("PB"));
        System.out.println(estadosPopulacao2);


        System.out.println("Exiba a população de PE: " + estadosPopulacao.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado: ");
        Map<String, Double> estadosPopulacao1 = new LinkedHashMap<>(){{
            put("PE", 9.616_621);
            put("AL", 3.351_543);
            put("CE", 9.187_103);
            put("RN", 3.534_265);
        }};
        System.out.println(estadosPopulacao1);

        System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Double> estadoPopulacao2 = new TreeMap<>(estadosPopulacao1);
        System.out.println(estadoPopulacao2.toString());


        System.out.println("Exiba o estado com a menor população e sua quantidade: ");
        Double estadoMenorPopulacao = Collections.min(estadosPopulacao.values());
        Set<Map.Entry<String, Double>> entries = estadosPopulacao.entrySet();
        String menorQuantidade = ""; // variavel de controle

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(estadoMenorPopulacao)) {
                menorQuantidade = entry.getKey();
                System.out.println("Estado menor população: " + estadoMenorPopulacao + " - " + menorQuantidade);
            }
        }

        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Double estadoMaiorPopulacao = Collections.max(estadosPopulacao.values());
        Set<Map.Entry<String, Double>> entries1 = estadosPopulacao.entrySet();
        String maiorQuantidade = "";

        for (Map.Entry<String, Double> entry: entries1) {
            if (entry.getValue().equals(estadoMaiorPopulacao)){
                maiorQuantidade = entry.getKey();
                System.out.println("Estado maior população: " + estadoMaiorPopulacao + " - " + maiorQuantidade);
            }
        }


        Iterator<Double> iterator = estadosPopulacao1.values().iterator();
        Double soma  = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " +soma);


        System.out.println("Exiba a média da população desse dicionário de estado: " +
                (soma/estadosPopulacao1.size()));


        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Double> iterator1 = estadosPopulacao2.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4.000_000) iterator1.remove();
        }
        System.out.println(estadosPopulacao2);

        System.out.println("Apague o dicionário: ");
        estadosPopulacao.clear();


        System.out.println("Confira se está vazio: " +estadosPopulacao.isEmpty());


    }
}

