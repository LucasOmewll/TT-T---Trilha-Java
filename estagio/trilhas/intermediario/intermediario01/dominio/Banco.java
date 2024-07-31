package estagio.trilhas.intermediario.intermediario01.dominio;

import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();

    public void adicionarContas(ContaBancaria conta){
        if (conta == null){
            return;
        }

        this.contas.add(conta);
    }

    public ContaBancaria buscarConta(int numeroConta){
        for(ContaBancaria conta : this.contas){
            if (conta.getNumeroConta() == numeroConta){
                return conta;
            }
        }

        return null;
    }

    public void listarContas(){
        for(ContaBancaria conta : this.contas){
            System.out.println("Titular........: " + conta.getTitular());
            System.out.println("Número da conta: " + conta.getNumeroConta());
            System.out.println("Saldo Atual....: " + conta.getSaldo());
            System.out.println("----------------");
        }
   }

}
