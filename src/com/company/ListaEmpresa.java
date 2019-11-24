package com.company;

public class ListaEmpresa {
    private CelulaEmpresa primeiro;
    private CelulaEmpresa ultimo;

    public ListaEmpresa() {
        primeiro = new CelulaEmpresa();
        ultimo = primeiro;
    }

    public void inserirFinal(Empresa ce) {
        CelulaEmpresa aux = new CelulaEmpresa();
        ultimo.proximo = aux;
        aux.item = ce;
        ultimo = ultimo.proximo;
    }

    public Empresa retirar(String nomeEmpresa) {
        CelulaEmpresa aux, anterior;
        anterior = primeiro;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNome().equals(nomeEmpresa)) {
                anterior.proximo = aux.proximo;

                if (aux == ultimo) {
                   ultimo = anterior;
                }

                return aux.item;
            } else {
                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }

    public Empresa localizar(String nomeEmpresa) {
        CelulaEmpresa aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getNome().equals(nomeEmpresa)) {
                return aux.item;
            } else {
                aux = aux.proximo;
            }
        }

        return null;
    }

    public boolean listaVazia() {
        return primeiro == ultimo;
    }

    public String serializarLista() {
        StringBuilder dados = new StringBuilder();

        CelulaEmpresa aux;
        aux = primeiro.proximo;

        while (aux != null) {
            dados.append(aux.item.toString());
            if (aux.proximo != null) {
                dados.append("\n");
            }
            aux = aux.proximo;
        }

        return dados.toString();
    }
}
