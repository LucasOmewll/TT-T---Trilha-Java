package estagio.trilhas.avancado.exercicioavancado02.teste;

import estagio.trilhas.avancado.exercicioavancado02.dominio.DadoInvalidoException;
import estagio.trilhas.avancado.exercicioavancado02.dominio.Usuario;
import estagio.trilhas.avancado.exercicioavancado02.dominio.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioAvancado02Teste {
    public static void main(String[] args) {
        // Entradas do usuário do programa
        int escolha;
        boolean shouldContinue = true;

        // Variáveis utilizadas na criação de um novo usuário durante a execução
        Long idUsuario;
        String nomeUsuario;
        String emailUsuario;
        int idadeUsuario;

        try (Scanner teclado = new Scanner(System.in)) {
            do {
                try {
                    mostrarMenu();

                    escolha = escolher(teclado);

                    switch (escolha) {
                        case 1:
                            idUsuario = solicitarIdUsuario(teclado);

                            nomeUsuario = solicitarNomeUsuario(teclado);

                            emailUsuario = solicitarEmailUsuario(teclado);

                            idadeUsuario = solicitarIdadeUsuario(teclado);

                            if (nomeUsuario.isEmpty() || emailUsuario.isEmpty() || idadeUsuario <= 0) {
                                throw new DadoInvalidoException("Erro: informações inseridas não válidas. Tente novamente");
                            } else {
                                Usuario novoUsuario = new Usuario(idUsuario, nomeUsuario, emailUsuario, idadeUsuario);
                                UsuarioService.adicionarUsuario(novoUsuario);

                                System.out.println("Usuário adicionado com sucesso!");
                            }
                            break;
                        case 2:
                                buscarPorNome(teclado);
                            break;
                        case 3:
                            buscaPorEmail(teclado);
                            break;
                        case 4:
                            if (UsuarioService.getUsuarios().isEmpty()){
                                System.out.println("Não há usuários cadastrados.");
                            } else {
                                for (Usuario usuario : UsuarioService.getUsuarios()){
                                    System.out.println(usuario);
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Encerrando programa, tenha um bom dia!");
                            shouldContinue = false;
                            break;
                        default:
                            System.out.println("Opção Inválida");
                    }
                } catch (DadoInvalidoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (InputMismatchException e){
                    System.out.println("Erro: Entrada inválida. Por favor, tente novamente.");
                    teclado.nextLine(); // Limpa o buffer;
                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                }
            } while (shouldContinue);
        }
    }

    private static void mostrarMenu() {
        System.out.println("----Gerenciamento de Usuários----");
        System.out.println();
        System.out.println("Por favor, selecione uma opção:");
        System.out.println("1 - Adicionar Usuário");
        System.out.println("2 - Buscar Usuário por nome");
        System.out.println("3 - Buscar Usuário por e-mail");
        System.out.println("4 - Exibir todos os usuários");
        System.out.println("5 - Sair");
        System.out.println("---------------------------------");
    }

    private static int escolher(Scanner teclado) {
        int escolha = 0;
        try {
            escolha = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
            teclado.nextLine(); // Limpa o buffer
        }
        teclado.nextLine(); // Avança o scanner
        return escolha;
    }

    private static Long solicitarIdUsuario(Scanner teclado) {
        System.out.println("Por favor, digite o ID do usuário: ");
        while (!teclado.hasNextLong()) {
            System.out.println("ID inválido. Por favor, digite um número válido.");
            teclado.next();
        }
        Long idUsuario = teclado.nextLong();
        teclado.nextLine(); // Consome o newline
        return idUsuario;
    }

    private static String solicitarNomeUsuario(Scanner teclado) {
        System.out.println("Por favor, digite o nome do usuário:");
        return teclado.nextLine();
    }

    private static String solicitarEmailUsuario(Scanner teclado) {
        System.out.println("Por favor, digite o email do usuário:");
        return teclado.nextLine();
    }

    private static int solicitarIdadeUsuario(Scanner teclado) {
        System.out.println("Por favor, digite a idade do usuário:");
        while (!teclado.hasNextInt()) {
            System.out.println("Idade inválida. Por favor, digite um número válido.");
            teclado.next();
        }
        int idadeUsuario = teclado.nextInt();
        teclado.nextLine(); // Consome o newline
        return idadeUsuario;
    }

    private static void buscarPorNome(Scanner teclado){
        System.out.println("Por favor, digite o padrão do nome que deseja buscar:");

        UsuarioService.findByNome(teclado.nextLine()).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Não foram encontrados usuários com este padrão"));
    }

    private static void buscaPorEmail(Scanner teclado){
        System.out.println("Por favor, digite o padrão do e-mail que deseja buscar:");

        UsuarioService.findByEmail(teclado.nextLine()).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Não foram encontrados usuários com este padrão"));
    }
}