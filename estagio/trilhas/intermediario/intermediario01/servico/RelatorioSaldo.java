package estagio.trilhas.intermediario.intermediario01.servico;

import estagio.trilhas.intermediario.intermediario01.dominio.ContaBancaria;

public class RelatorioSaldo {
    public static void buscarSaldo(ContaBancaria contaBancaria){
        System.out.println("Olá, " + contaBancaria.getTitular() + ", seu saldo é: " + contaBancaria.verificarSaldo());
    }
}
