package com.company;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        String nomeArquivo = "bdCandidato.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo texto: ");

//        nomeArquivo = scanner.nextLine();

        CandidatoDAO c = new CandidatoDAO();
        c.lerDados("bdCandidato.txt");

        c.atualizar(new Candidato("123456", "Joãozinho da Silva", "33", "M", "Pós-graduação", "Computação", "3000"));

        EmpresaDAO e = new EmpresaDAO();
        e.lerDados("bdEmpresa.txt");

        c.salvarDados();
    }
}
