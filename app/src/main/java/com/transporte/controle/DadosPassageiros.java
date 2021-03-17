package com.transporte.controle;

import android.database.sqlite.SQLiteDatabase;

public class DadosPassageiros {

    private final String nome;
    //ver se há necessidade de alterar atributo das variaveis
    private final String sobrnome;
    private final String telefone;
    private final String idade;
    private final String valor;
    private final String carro;
    private final String ponto;
    private final String acento;




    private DadosPassageiros(String nome,String sobrnome, String telefone, String idade,
                             String valor, String carro,String ponto, String acento) {

        this.nome = nome;
        this.sobrnome = sobrnome;
        this.telefone = telefone;
        this.idade = idade;
        this.valor = valor;
        this.carro = carro;
        this.ponto = ponto;
        this.acento = acento;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrnome(){
        return sobrnome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getIdade() {
        return idade;
    }

    public String getValor() {
        return valor;
    }

    public String getCarro(){
        return carro;
    }

    public String getPonto() {
        return ponto;
    }

    public String getAcento() {
        return acento;
    }


    public static final DadosPassageiros[] lugar = {

            new DadosPassageiros("", "","", "",
                    "","1","","101"),

            new DadosPassageiros("fernanda", "soares mota belau", "7588558855", "10",
                    "12","1","santana", "102"),

            new DadosPassageiros("lisboa", "fachin", "87456448", "50",
                    "21","1","feira", "103"),

            new DadosPassageiros("marai custodia",  "","", "",
                    "","1","", "104"),

            new DadosPassageiros("Lane", "Maria Dirlane dos Santos de Menezes Freitas", "75982157717", "31",
                    "","1","Ssobral de baurana", "105"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "106"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "107"),

            new DadosPassageiros("",  "","", "",
                    "","1","", "108"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "109"),


            new DadosPassageiros("",  "","", "",
                    "","1","", "110"),

            new DadosPassageiros("", "",  "","",
                    "","1","", "111"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "112"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "113"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "114"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "115"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "116"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "117"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "118"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "119"),
            new DadosPassageiros("", "", "", "",
                    "","1","", "120"),
            new DadosPassageiros("", "", "", "",
                    "","1","", "121"),
            new DadosPassageiros("", "", "", "",
                    "","1","", "122"),
            new DadosPassageiros("", "", "", "",
                    "","1","", "123"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "124"),
            new DadosPassageiros("", "", "", "",
                    "","1","", "125"),

            new DadosPassageiros("", "", "", "",
                    "","1","", "126"),

    };

}


