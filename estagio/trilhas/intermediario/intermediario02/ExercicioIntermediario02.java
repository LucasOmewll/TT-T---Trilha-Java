package estagio.trilhas.intermediario.intermediario02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExercicioIntermediario02 {
    public static boolean isNomeValido(String nome) {
        Pattern pattern = Pattern.compile("^[A-Za-z]+$");
        Matcher matcher = pattern.matcher(nome);

        return matcher.matches();
    }

    public static boolean isSobrenomeValido(String sobrenome) {
        Pattern pattern = Pattern.compile("^[A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(sobrenome);

        return matcher.matches();
    }

    public static boolean isCpfValido(String cpf) {
        Pattern pattern = Pattern.compile("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9][0-9]");
        Matcher matcher = pattern.matcher(cpf);

        return matcher.matches();
    }

    public static boolean isEmailValido(String email) {
        Pattern pattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaDadosCadastrais = new ArrayList<>();
        String nome;
        String sobrenome;
        String cpf;
        String email;

        do {
            System.out.println("Por favor, digite o nome (sem números ou caracteres especiais):");
            nome = scanner.nextLine();
        } while (!isNomeValido(nome));

        do {
            System.out.println("Por favor, digite o sobrenome (sem números ou caracteres especiais):");
            sobrenome = scanner.nextLine();
        } while (!isSobrenomeValido(sobrenome));

        do {
            System.out.println("Por favor, digite o CPF (Formato 000.000.000-00):");
            cpf = scanner.nextLine();
        } while (!isCpfValido(cpf));

        do {
            System.out.println("Por favor, digte o e-mail:");
            email = scanner.nextLine();
        } while (!isEmailValido(email));

        listaDadosCadastrais.add(nome);
        listaDadosCadastrais.add(sobrenome);
        listaDadosCadastrais.add(cpf);
        listaDadosCadastrais.add(email);

        System.out.println("Dados Cadastrais: ");
        for (int i = 0; i < listaDadosCadastrais.size(); i++) {
            switch (i) {
                case 0:
                    System.out.println("Nome: " + listaDadosCadastrais.getFirst());
                    break;
                case 1:
                    System.out.println("Sobrenome: " + listaDadosCadastrais.get(1));
                    break;
                case 2:
                    System.out.println("CPF: " + listaDadosCadastrais.get(2));
                    break;
                case 3:
                    System.out.println("E-mail: " + listaDadosCadastrais.get(3));
                    break;
            }
        }
    }
}
