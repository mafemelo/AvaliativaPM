/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avaliativapm;

/**
 *
 * @author 1635579
 */
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Empresa empresa = new Empresa();

    public static void main(String[] args) {
        gerarDados();

        int opcao;
        do {
            exibirMenu();
            opcao = lerTudo("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarReserva();
                    break;
                case 2:
                    associarOrganizador();
                    break;
                case 3:
                    atribuirResereva();
                    break;
                case 4:
                    exibirReservasSalao();
                    break;
                case 5:
                    exibirTotalFinalizadasSalao();
                    break;
                case 6:
                    buscarReservaStatus();
                    break;
                case 7:
                    exibirReservaDetalhes();
                    break;
                case 0:
                    System.out.println("Fim.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void gerarDados() {
        Organizador or1 = new Organizador("Emanuel", "123.456.789-10", "Festa Infantil", "3144445555");
        Organizador or2 = new Organizador("Helena", "987.654.321-00", "Casamento", "3122224444");
        Organizador or3 = new Organizador("Gabriela", "222.333.444-66", "Aniversários", "3177778888");

        Salao s1 = new Salao(1, "Festa Infantil", 5, "Tipo P");
        Salao s2 = new Salao(2, "Casamentos", 5, "Tipo M");
        Salao s3 = new Salao(3, "Aniversários", 5, "Tipo G");

        empresa.adicionarOrganizador(or1);
        empresa.adicionarOrganizador(or2);
        empresa.adicionarOrganizador(or3);

        empresa.adicionarSalao(s1);
        empresa.adicionarSalao(s2);
        empresa.adicionarSalao(s3);
    }

    private static void exibirMenu() {
        System.out.println("\n Empresa de Eventos");
        System.out.println("1.Cadastrar uma reserva");
        System.out.println("2.Associar um organizador a um salão");
        System.out.println("3.Atribuir reserva a um salão");
        System.out.println("4.Exibir todas as reservas confirmadas em um salão específico");
        System.out.println("5.Quantidade de reservas finalizadas para cada salão");
        System.out.println("6.Buscar reservas por status");
        System.out.println("7.Exibir detalhes de uma reserva");
        System.out.println("0.Sair");
    }
}

private static void cadastrarReserva() {
        System.out.println("\nCadastro Reserva");
        int codigo = lerTudo("Código: ");
        if (empresa.buscarReserva(codigo) != null) {
            System.out.println("Já existe uma reserva com esse código.");
            return;
        }

        String cliente = lerTexto("Nome do cliente: ");
        String data = lerTexto("Data: ");
        String status = lerStatus();
        double valor = lerDouble("Valor total: ");

        System.out.println("\nDados do serviço:");
        String nomeServico = lerTexto("Nome: ");
        double valorServico = lerDouble("Valor: ");
        String categoria = lerTexto("TipoSalao: ");

    
        System.out.println("Reserva cadastrada");
        if (status.equalsIgnoreCase("aberta")) {
            System.out.println("");
        }
    }





private static String lerStatus() {
        while (true) {
            String status = lerTexto("Status (solicitada, confirmada, finalizada): ");
            if (status.equalsIgnoreCase("solicitada") ||
                    status.equalsIgnoreCase("confirmada") ||
                    status.equalsIgnoreCase("finalizada")) {
                return status;
            }
            System.out.println("Status inválido.");
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerTudo(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                String valor = lerTexto(mensagem).replace(',', '.');
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }
}