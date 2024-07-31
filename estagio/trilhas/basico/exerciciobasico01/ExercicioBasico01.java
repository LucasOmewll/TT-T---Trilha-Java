package estagio.trilhas.basico.exerciciobasico01;

import java.util.Scanner;

public class ExercicioBasico01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        double operando01, operando02;
        double resultadoAdicao, resultadoSubtracao, resultadoMultiplicacao, resultadoDivisao;

        System.out.println("Insira o primeiro operando: ");
        operando01 = scanner.nextDouble();

        System.out.println("Insira o segundo operando: ");
        operando02 = scanner.nextDouble();

        resultadoAdicao = calculadora.adicionar(operando01, operando02);
        resultadoSubtracao = calculadora.subtrair(operando01, operando02);
        resultadoMultiplicacao = calculadora.multiplicar(operando01, operando02);
        resultadoDivisao = calculadora.dividir(operando01, operando02);

        System.out.println("Resultado das Operações:");
        System.out.printf("Adição: %.2f\n", resultadoAdicao);
        System.out.printf("Subtração: %.2f\n", resultadoSubtracao);
        System.out.printf("Multiplicação: %.2f\n", resultadoMultiplicacao);
        System.out.printf("Divisão: %.2f\n", resultadoDivisao);

    }
}
