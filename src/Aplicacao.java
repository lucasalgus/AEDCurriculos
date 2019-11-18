import java.util.Scanner;

public class Aplicacao {
    private static EscreverArquivo arquivoEscrita = new EscreverArquivo();
    private static LerArquivo arquivoLeitura = new LerArquivo();

    public static void main(String[] args) {

        String nomeArquivo = "";
        String pedaco = "";
        String conteudoArquivo = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo texto: ");

        do {
            nomeArquivo += scanner.next();
            pedaco = scanner.next();

        }while(!pedaco.equals("0"));

        arquivoEscrita.abrirArquivo(nomeArquivo);

        System.out.print("Digite o conteudo do arquivo: ");

        do {
            conteudoArquivo += scanner.next();
            pedaco = scanner.next();
        }while(!pedaco.equals("0"));

        arquivoEscrita.escrever(conteudoArquivo);

        arquivoEscrita.fecharArquivo();

        arquivoLeitura.abrirArquivo(nomeArquivo);
        System.out.print(arquivoLeitura.ler());
        arquivoLeitura.fecharArquivo();


    }
}
