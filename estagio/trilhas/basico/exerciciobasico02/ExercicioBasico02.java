package estagio.trilhas.basico.exerciciobasico02;

public class ExercicioBasico02 {
    public static double listMean(double[] lista){
        if(lista == null || lista.length == 0){
            return 0;
        }

        double media = 0;
        double tamanhoLista = lista.length;

        for(double num : lista){
            media += num;
        }

        return media / tamanhoLista;
    }

    public static void main(String[] args) {
        double[] lista01 = new double[]{1.0, 5.0, 16.0, 41.0, 23.0};
        double[] lista02 = new double[]{};

        double media = listMean(lista01);
        System.out.println("A média dos itens é: " + media);

        System.out.println("Lista vazia: " + listMean(lista02));
    }
}
