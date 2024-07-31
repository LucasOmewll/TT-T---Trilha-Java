package estagio.trilhas.basico.exerciciobasico01;

public class Calculadora {
    public double adicionar(double a, double b){
        return a + b;
    }

    public double subtrair(double a, double b){
        return a - b;
    }

    public double multiplicar(double a, double b){
        return a * b;
    }

    public double dividir(double a, double b){
        if (b == 0){
            return 0;
        }
        return a / b;
    }
}
