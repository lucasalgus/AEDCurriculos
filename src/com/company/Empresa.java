package com.company;

public class Empresa {
    String nome;
    String areaAtuacao;
    int quantVagas;
    String escolaridadeMin;
    float salarioMax;

    Empresa() {}

    Empresa(
            String nome,
            String areaAtuacao,
            String quantVagas,
            String escolaridadeMin,
            String salarioMax
    ) {
        setNome(nome);
        setAreaAtuacao(areaAtuacao);
        setQuantVagas(Integer.parseInt(quantVagas));
        setEscolaridadeMin(escolaridadeMin);
        setSalarioMax(Float.parseFloat(salarioMax.replace(",", ".")));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public int getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(int quantVagas) {
        this.quantVagas = quantVagas;
    }

    public String getEscolaridadeMin() {
        return escolaridadeMin;
    }

    public void setEscolaridadeMin(String escolaridadeMin) {
        this.escolaridadeMin = escolaridadeMin;
    }

    public Float getSalarioMax() {
        return salarioMax;
    }

    public void setSalarioMax(Float salarioMax) {
        this.salarioMax = salarioMax;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%s;%f", nome, areaAtuacao, quantVagas, escolaridadeMin, salarioMax);
    }

    public String toPrettyString() {
        return toString().replace(";", "\n");
    }
}
