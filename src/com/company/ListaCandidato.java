package com.company;

public class ListaCandidato {
    private CelulaCandidato primeiro;
    private CelulaCandidato ultimo;

    public ListaCandidato() {
        primeiro = new CelulaCandidato();
        ultimo = primeiro;
    }

    public void inserirFinal(Candidato c) {
        CelulaCandidato aux = new CelulaCandidato();
        ultimo.proximo = aux;
        aux.item = c;
        ultimo = ultimo.proximo;
    }

    public Candidato retirar(int identidade) {
        CelulaCandidato aux, anterior;
        anterior = primeiro;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getIdentidade() == identidade) {
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

    public Candidato localizar(int identidade) {
        CelulaCandidato aux;
        aux = primeiro.proximo;

        while (aux != null) {
            if (aux.item.getIdentidade() == identidade) {
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

        CelulaCandidato aux;
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

    public int numCandidatos() {
        int contCandidatos = 0;

        CelulaCandidato aux;
        aux = primeiro.proximo;

        while (aux != null) {
            contCandidatos++;
            aux = aux.proximo;
        }

        return contCandidatos;
    }
    
    public String getQualificados(String areaAtuacao, int escolaridadeMin, int numVagas) {
    	CelulaCandidato aux;

    	String qualificados = "";
    	
        // o ponteiro aux será utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de candidatos está vazia.");
        }
        else
        {
        	
            // enquanto o ponteiro aux não tiver percorrido toda a lista encadeada...
            while (aux != null)
            {
            	if(numVagas > 0 && aux.item.getAreaDeAtuacao().equals(areaAtuacao) && aux.item.getEscolaridade() >= escolaridadeMin) {
            		qualificados += aux.item.getIdentidade() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos" + " - " + 
            				"Escolaridade: " + aux.item.getEscolaridade();
            		qualificados += "\n";
            		numVagas--;
            	}
            	aux = aux.proximo;
            }
        }
        
        return qualificados;
    }
}
