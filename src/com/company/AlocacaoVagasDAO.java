package com.company;

public class AlocacaoVagasDAO {
    private EscreverArquivo arquivoEscrita;
    private LerArquivo arquivoLeitura;
    private String nomeArquivo;

    ListaAlocacaoVagas alocacaoVagas;

    AlocacaoVagasDAO() {
        arquivoEscrita = new EscreverArquivo();
        arquivoLeitura = new LerArquivo();
        alocacaoVagas = new ListaAlocacaoVagas();
    }

    public void lerDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;

        arquivoLeitura.abrirArquivo(nomeArquivo);
        String linhaAtual = arquivoLeitura.ler();

        while (linhaAtual != null) {
        	alocacaoVagas.inserirFinal(linhaAtual);
            linhaAtual = arquivoLeitura.ler();
        }

        arquivoLeitura.fecharArquivo();
    }

    public void cadastrar(String c) {
    	alocacaoVagas.inserirFinal(c);
    }

    public void salvarDados() {
        arquivoEscrita.abrirArquivo(nomeArquivo);
        arquivoEscrita.escrever(alocacaoVagas.serializarLista());
        arquivoEscrita.fecharArquivo();
    }

}
