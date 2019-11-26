package com.company;

public class EmpresaDAO {
    private EscreverArquivo arquivoEscrita;
    private LerArquivo arquivoLeitura;
    private String nomeArquivo;

    ListaEmpresa empresas;

    EmpresaDAO() {
        arquivoEscrita = new EscreverArquivo();
        arquivoLeitura = new LerArquivo();
        empresas = new ListaEmpresa();
    }

    public void lerDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        arquivoLeitura.abrirArquivo(nomeArquivo);
        String linhaAtual = arquivoLeitura.ler();

        while (linhaAtual != null) {
            String[] dados = linhaAtual.split(";");
            Empresa e = new Empresa(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4]
            );

            empresas.inserirFinal(e);
            linhaAtual = arquivoLeitura.ler();
        }

        arquivoLeitura.fecharArquivo();
    }

    public Empresa buscar(String nomeEmpresa) {
        return empresas.localizar(nomeEmpresa);
    }

    public ListaEmpresa buscarVagas(String areaAtuacao, int escolaridadeMin) {
        return empresas.localizarVagas(areaAtuacao, escolaridadeMin);
    }

    public void atualizar(Empresa e) {
        empresas.retirar(e.getNome());
        empresas.inserirFinal(e);
    }

    public void excluir(String nomeEmpresa) {
        empresas.retirar(nomeEmpresa);
    }

    public void cadastrar(Empresa e) {
        boolean empresaExistente = empresas.localizar(e.getNome()) != null;

        if (!empresaExistente) {
            empresas.inserirFinal(e);
            System.out.println();
        }
    }

    public void salvarDados() {
        arquivoEscrita.abrirArquivo(nomeArquivo);
        arquivoEscrita.escrever(empresas.serializarLista());
        arquivoEscrita.fecharArquivo();
    }

    public void numVagas(){
        System.out.print("Total de vagas: " + empresas.numVagas() + "\n");
    }

}
