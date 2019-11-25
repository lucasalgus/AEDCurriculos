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

    public ListaEmpresa localizarVagas(String areaAtuacao, int escolaridadeMax) {
        CelulaEmpresa aux;
        aux = primeiro.proximo;
        ListaEmpresa listaVagas = new ListaEmpresa();

        while (aux != null) {
            if (aux.item.getAreaAtuacao().equals(areaAtuacao) && aux.item.getEscolaridadeMin() <= escolaridadeMax) {
                listaVagas.inserirFinal(aux.item);
            }
            aux = aux.proximo;
        }

        return listaVagas;
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

    // imprimi, para todas as contas-correntes armazenadas na lista encadeada, o nome de seu titular, o número de sua agência, seu número e saldo. A ordem de impressão deve ser do primeiro nodo da lista para o último.
    public void imprimir()
    {
        CelulaEmpresa aux;

        // o ponteiro aux será utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de empresas está vazia.");
        }
        else
        {
            // enquanto o ponteiro aux não tiver percorrido toda a lista encadeada...
            while (aux != null)
            {
                // imprimi os dados da conta-corrente apontada pelo ponteiro aux.
                System.out.println(aux.item.getNome() + ";" + aux.item.getAreaAtuacao() + ";" + aux.item.getQuantVagas() + ";" + aux.item.getEscolaridadeMin() + ";" + aux.item.getSalarioMax());

                // avançamos na lista encadeada.
                aux = aux.proximo;
            }
        }
    }

    public int numVagas(){
        CelulaEmpresa aux;
        aux = primeiro.proximo;

        int contNumVagas = 0;

        while (aux != null)
        {
            contNumVagas += aux.item.getQuantVagas();
            aux = aux.proximo;
        }
        return contNumVagas;
    }

}
