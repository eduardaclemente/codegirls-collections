package br.com.dio.exercicios2;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao, e ide.
Em seguida, crie um conjunto com as 3 linguagens e faça um programa que ordene esse conjunto por:
    A. Ordem de inserção
    B. Ordem Natural (nome)
    C. IDE
    D. Ano de criação e nome
    E. Nome, ano de criação e IDE
 */


import java.util.*;


public class ExercicioProposto2 {
    public static void main(String[] args) {

        System.out.println("--\tOrdem inserção: \t--");
        Set<LinguagemFavorita>  minhasLinguagens = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Java", 1991, "Eclipse"));
            add(new LinguagemFavorita("Python", 1989, "PyCharm"));
            add(new LinguagemFavorita("C", 1972, "DevC"));
        }};
        for (LinguagemFavorita linguagem:
             minhasLinguagens)
            System.out.println(linguagem.getNome() + " - " +
                    linguagem.getAnoCriacao() + " - " + linguagem.getIde());


        System.out.println("--\tOrdem Natural (IDE): \t--");
        Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(minhasLinguagens);
        for (LinguagemFavorita linguagem:
                minhasLinguagens2)
            System.out.println(linguagem.getNome() + " - " +
                    linguagem.getAnoCriacao() + " - " + linguagem.getIde());


        System.out.println("--\tOrdem IDE: \t--");
        Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<>(new ComparatorIde());
        minhasLinguagens3.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem :
                minhasLinguagens3)
            System.out.println(linguagem.getNome() + " - " +
                    linguagem.getAnoCriacao() + " - " + linguagem.getIde());


        System.out.println("--\tOrdem Ano de Criação e Nome: \t--");
        Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<>(new ComparatorAnoNome());
        minhasLinguagens4.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem :
                minhasLinguagens4)
            System.out.println(linguagem.getNome() + " - " +
                    linguagem.getAnoCriacao() + " - " + linguagem.getIde());


        System.out.println("--\tOrdem Nome, ano de criação e IDE: \t--");
        Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<>(new ComparatorNomeAnoIde());
        minhasLinguagens5.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem :
                minhasLinguagens5)
            System.out.println(linguagem.getNome() + " - " +
                    linguagem.getAnoCriacao() + " - " + linguagem.getIde());
    }
}

class LinguagemFavorita implements Comparable <LinguagemFavorita>{
    private String nome;
    private Integer anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome) && anoCriacao.equals(that.anoCriacao) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        int ide = CharSequence.compare(this.getIde(), linguagem.getIde());
        if (ide != 0) return ide;
        return this.getAnoCriacao().compareTo(linguagem.getAnoCriacao());
    }

}

class ComparatorIde implements Comparator <LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ide = l1.getIde().compareTo(l2.getIde());
        if (ide != 0) return ide;

        return CharSequence.compare(l1.getIde(), l2.getIde());
    }
}

class ComparatorAnoNome implements Comparator <LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ano = l1.getAnoCriacao().compareTo(l2.getAnoCriacao());
        if (ano != 0) return ano;

        return CharSequence.compare(l1.getNome(), l2.getNome());
    }
}

class  ComparatorNomeAnoIde implements Comparator <LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int ano = l1.getAnoCriacao().compareTo(l2.getAnoCriacao());
        if (ano != 0) return ano;

        return CharSequence.compare(l1.getIde(), l2.getIde());
    }
}