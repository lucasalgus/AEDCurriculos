package com.company;

public class CandidatoDAO {
    private EscreverArquivo arquivoEscrita;
    private LerArquivo arquivoLeitura;
    private String nomeArquivo;

    ListaCandidato candidatos;

    CandidatoDAO() {
        arquivoEscrita = new EscreverArquivo();
        arquivoLeitura = new LerArquivo();
        candidatos = new ListaCandidato();
    }

    public void lerDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;

        arquivoLeitura.abrirArquivo(nomeArquivo);
        String linhaAtual = arquivoLeitura.ler();

        while (linhaAtual != null) {
            String[] dados = linhaAtual.split(";");
            Candidato c = new Candidato(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4],
                    dados[5],
                    dados[6]
            );

            candidatos.inserirFinal(c);
            linhaAtual = arquivoLeitura.ler();
        }

        arquivoLeitura.fecharArquivo();
    }

    public Candidato buscar(int identidade) {
        return candidatos.localizar(identidade);
    }

    public void atualizar(Candidato c) {
        candidatos.retirar(c.getIdentidade());
        candidatos.inserirFinal(c);
    }

    public void excluir(int identidade) {
        candidatos.retirar(identidade);
    }

    public void cadastrar(Candidato c) {
        boolean candidatoExistente = candidatos.localizar(c.getIdentidade()) != null;

        if (!candidatoExistente) {
            candidatos.inserirFinal(c);
        }
    }

    public void salvarDados() {
        arquivoEscrita.abrirArquivo(nomeArquivo);
        arquivoEscrita.escrever(candidatos.serializarLista());
        arquivoEscrita.fecharArquivo();
    }

    public void numCandidatos(){
        System.out.print("Total de candidatos: " + candidatos.numCandidatos() + "\n");
    }

}
