package estagio.trilhas.intermediario.intermediario01.teste;

import estagio.trilhas.intermediario.intermediario01.dominio.Banco;
import estagio.trilhas.intermediario.intermediario01.dominio.ContaBancaria;
import estagio.trilhas.intermediario.intermediario01.servico.RelatorioSaldo;

import java.util.ArrayList;

public class ExercicioIntermediario01Teste {
    public static void main(String[] args) {
        ContaBancaria conta01 = new ContaBancaria("Gideon", 1);
        ContaBancaria conta02 = new ContaBancaria("Melina", 2);
        ContaBancaria conta03 = new ContaBancaria("Hewg", 3);

        Banco banco = new Banco();

        banco.adicionarContas(conta01);
        banco.adicionarContas(conta02);
        banco.adicionarContas(conta03);

        RelatorioSaldo.buscarSaldo(conta01);
        RelatorioSaldo.buscarSaldo(conta02);
        RelatorioSaldo.buscarSaldo(conta03);

        conta01.depositar(5000);
        conta02.depositar(3000);
        conta03.depositar(7500);

        conta01.sacar(75.50);
        conta02.transferir(conta03, 115.90);

        System.out.println("--- Relatório das Contas ---");
        banco.listarContas();
    }
}
