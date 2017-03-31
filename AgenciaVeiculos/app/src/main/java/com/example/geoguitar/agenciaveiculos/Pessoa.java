package com.example.geoguitar.agenciaveiculos;

/**
 * Created by geoguitar on 25/05/15.
 */
public class Pessoa {

    private int id;
    private String nome;
    private String sobreNome;
    private String sexo;
    private int idade;

    public Pessoa(){

    }

    public Pessoa(int id, String nome, String sobreNome, String sexo, int idade){

        super();
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public int getID(){

        return id;
    }

    public void setId(int id){

        this.id = id;
    }

    public String getNome(){

        return nome;
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public String getSobreNome(){

        return sobreNome;
    }

    public void setSobreNome(String sobreNome){

        this.sobreNome = sobreNome;
    }

    public String getSexo(){

        return sexo;
    }

    public void setSexo(String sexo){

        this.sexo = sexo;
    }

    public int getIdade(){

        return idade;
    }

    public void setIdade(int idade){

        this.idade = idade;
    }
}
