package estagio.trilhas.intermediario.intermediario01.dominio;

public class ContaBancaria {
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
    }

    public ContaBancaria(String titular, int numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            return;
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0){
            return;
        }

        this.saldo -= valor;
    }

    public double verificarSaldo(){
        return this.getSaldo();
    }

    public void transferir(ContaBancaria contaDestino, double valor){
        if (valor <= 0 || contaDestino == null){
            return;
        }

        this.saldo -= valor;

        contaDestino.depositar(valor);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
