package com.company;

public class Candidato {

    private int identidade;
    private String nome;
    private int idade;
    private char sexo;
    private String escolaridade;
    private String areaDeAtuacao;
    private float pretensaoSalarial;

    Candidato() {}

    Candidato(
        String identidade,
        String nome,
        String idade,
        String sexo,
        String escolaridade,
        String areaDeAtuacao,
        String pretensaoSalarial
    ) {
        setIdentidade(Integer.parseInt(identidade));
        setNome(nome);
        setEscolaridade(escolaridade);
        setAreaDeAtuacao(areaDeAtuacao);
        setPretensaoSalarial(Float.parseFloat(pretensaoSalarial));
        setIdade(Integer.parseInt(idade));
        setSexo(sexo.charAt(0));
    }

    public int getIdentidade() {
        return identidade;
    }

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public Float getPretensaoSalarial() {
        return pretensaoSalarial;
    }

    public void setPretensaoSalarial(Float pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%d;%c;%s;%s;%f", identidade, nome, idade, sexo, escolaridade, areaDeAtuacao, pretensaoSalarial);
    }

    public String toPrettyString() {
        return toString().replace(";", "\n");
    }
}
