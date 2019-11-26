package com.company;

public class ListaAlocacaoVagas {
    private CelulaAlocacaoVagas primeiro;
    private CelulaAlocacaoVagas ultimo;

    public ListaAlocacaoVagas() {
        primeiro = new CelulaAlocacaoVagas();
        ultimo = primeiro;
    }

    public void inserirFinal(String c) {
    	CelulaAlocacaoVagas aux = new CelulaAlocacaoVagas();
        ultimo.proximo = aux;
        aux.item = c;
        ultimo = ultimo.proximo;
    }

    public boolean listaVazia() {
        return primeiro == ultimo;
    }

    public String serializarLista() {
        StringBuilder dados = new StringBuilder();

        CelulaAlocacaoVagas aux;
        aux = primeiro.proximo;

        while (aux != null) {
            dados.append(aux.item);
            if (aux.proximo != null) {
                dados.append("\n");
            }
            aux = aux.proximo;
        }

        return dados.toString();
    }
}
