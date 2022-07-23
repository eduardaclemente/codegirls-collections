package br.com.dio.map;

/*
dado os modelos dos carros e seus consumos respectivos na estrada, faça:
modelo = gol - consumo = 14,4km/l
modelo = uno - consumo = 15,6km/l
modelo = mobi - consumo = 16,1km/l
modelo = hb20 - consumo = 14,5km/l
modelo = kwid -  consumo = 15, 6km/l
 */

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        // Map carrosPopulares2020 = new HashMap(); // antes do java 5
        // Map<String, Double> carrosPopulares2020 = new HashMap<>(); //Generics (jdk 5) - Diamonds
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares2020 = Map.of(lista dos modelos e consumo);

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos:");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
           put("Gol", 14.4);
           put("Uno", 15.6);
           put("Mobi", 16.1);
           put("HB20", 14.5);
           put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());


        System.out.println("Substitua o consumo do gol por 15,2km/l: ");
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("Tucson"));

        System.out.println("Exiba o consumo do Uno: " + carrosPopulares.get("Uno"));

        // System.out.println("Exiba o terceiro modelo adicionado");

        System.out.println("Exiba modelos:");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o carro mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = ""; // variavel de controle

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o carro menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry: entries1) {
            if (entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma  = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " +soma);

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " +
                (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual a 15,6km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem que foi informada:: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazia: " +carrosPopulares.isEmpty());



    }
}
