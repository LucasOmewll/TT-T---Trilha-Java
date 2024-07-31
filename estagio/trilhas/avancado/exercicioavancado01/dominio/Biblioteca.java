package estagio.trilhas.avancado.exercicioavancado01.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca implements Gerenciavel {
    ArrayList<ItemBiblioteca> itens;

    public Biblioteca(ArrayList<ItemBiblioteca> itens) {
        this.itens = itens;
    }

    @Override
    public void adicionarItem(ItemBiblioteca item) {
        this.itens.add(item);
    }

    @Override
    public void removerItem(ItemBiblioteca item) {
        this.itens.remove(item);
    }

    @Override
    public ItemBiblioteca buscarItem(String titulo) {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equals(titulo)) {
                return item;
            }
        }

        return null;
    }

    public static void main(String[] args) throws ItemNaoDisponivelException, ItemNaoEncontradoException {
        Livro livro = new Livro("A Volta Dos Que Não Foram", "Machado de Assis", true, GeneroLivro.DRAMA, 4);
        Periodico periodico = new Periodico("Sobre A Inteligência Humana", "Professor Pasquale", true, LocalDate.of(2022, 10, 24), FrequenciaPublicacao.SEMESTRAL);
        ArrayList<ItemBiblioteca> itens = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(itens);

        biblioteca.adicionarItem(livro);
        biblioteca.adicionarItem(periodico);

        boolean isContinuar = true;
        Scanner teclado = new Scanner(System.in);
        String inputUsuario;
        int escolhaTeclado;
        ItemBiblioteca itemBuscado;

        do {
            try {
                System.out.println("----- Biblioteca -----");
                System.out.println("Por favor, escolha uma opção: ");
                System.out.println("1 - Exibir itens disponíveis");
                System.out.println("2 - Pegar item emprestado");
                System.out.println("3 - Devolver item");
                System.out.println("4 - Sair");
                System.out.println("----------------------");
                System.out.println();

                escolhaTeclado = teclado.nextInt();

                switch (escolhaTeclado) {
                    case 1:
                        System.out.println("==========================================");
                        System.out.println("Lista de itens disponíveis na biblioteca: ");
                        for (ItemBiblioteca itemBiblioteca : biblioteca.itens) {
                            System.out.println(itemBiblioteca.toString());
                        }
                        break;
                    case 2:
                        System.out.println("==========================================");
                        System.out.println("Por favor, digite o título do item desejado: ");

                        teclado.nextLine(); // Removendo o \n do .nextInt() anterior

                        inputUsuario = teclado.nextLine();

                        itemBuscado = biblioteca.buscarItem(inputUsuario);

                        if (itemBuscado == null) {
                            throw new ItemNaoEncontradoException();
                        } else {
                            itemBuscado.emprestar();
                            System.out.println(itemBuscado.getTitulo() + " foi alugado com sucesso!");
                        }
                        break;
                    case 3:
                        System.out.println("==========================================");
                        System.out.println("Por favor, digite o título do item a ser devolvido: ");

                        teclado.nextLine(); // Removendo o \n do .nextInt() anterior

                        inputUsuario = teclado.nextLine();

                        itemBuscado = biblioteca.buscarItem(inputUsuario);

                        if (itemBuscado == null) {
                            throw new ItemNaoEncontradoException();
                        } else {
                            itemBuscado.devolver();
                            System.out.println(itemBuscado.getTitulo() + " foi devolvido com sucesso!");
                        }
                        break;
                    case 4:
                        System.out.println("Encerrando a operação, tenha um bom dia!");
                        isContinuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (isContinuar);
    }
}
