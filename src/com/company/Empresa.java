package com.company;

public class Empresa {
    String nome;
    String areaAtuacao;
    int quantVagas;
    int escolaridadeMin;
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

    public int getEscolaridadeMin() {
        return escolaridadeMin;
    }

    public void setEscolaridadeMin(String escolaridadeMin) {
        this.escolaridadeMin = convertEscolaridadeMin(escolaridadeMin);
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

    public int convertEscolaridadeMin(String escolaridade){
        switch (escolaridade){
            case "Analfabeto":
                return 1;
            case "Ensino Fundamental":
                return 2;
            case "Ensino Médio":
                return 3;
            case "Graduação":
                return 4;
            case "Pós-Graduação":
                return 5;
            case "Mestrado":
                return 6;
            case "Doutorado":
                return 7;
        }
        return 0;
    }

    public String convertEscolaridadeMin(int escolaridade){
        switch (escolaridade){
            case 1:
                return "Analfabeto";
            case 2:
                return "Ensino Fundamental";
            case 3:
                return "Ensino Médio";
            case 4:
                return "Graduação";
            case 5:
                return "Pós-Graduação";
            case 6:
                return "Mestrado";
            case 7:
                return "Doutorado";
        }
        return " ";
    }
}
