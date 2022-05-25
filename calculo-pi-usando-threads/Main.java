
import java.lang.Math;

public class Main {

    public static void main(String args[]) {

        // INICIALIZACAO

        int[] numeroThreads = new int[]{1, 2, 4, 8, 16, 32};

        double[] medias = new double [numeroThreads.length];
        double[] desviosPadrao = new double [numeroThreads.length];

        //long[] tempos = new long [numeroThreads.length];

        // PROCESSAMENTO

        for (int i = 0; i < numeroThreads.length; i++) {

            System.out.println("\nCom " + numeroThreads[i] + " thread:" + "\n");

            double[] execucoes = new double[5];
            
            for(int j = 0;  j<5; j++){
                execucoes[j] =  (double) new CalculoThreads().calculaComThreads(numeroThreads[j]);
            }

            // Calcula MEDIA

            double soma = 0;
            for(int j=0; j<5; j++){
                soma += execucoes[j];
            }
            medias[i]= (soma/5);

            // Calcula DESVIO PADRAO

            double diferenca = 0;
            for(int j=0; j<5; j++){
                diferenca += Math.pow((execucoes[j]-medias[i]), 2);
            }

            desviosPadrao[i] = Math.sqrt(diferenca/5);
        }
        // SAIDA

        System.out.println("\nRESULTADOS:\n");

        for (int i = 0; i < numeroThreads.length; i++) {

            System.out.println("\nTempo para " + numeroThreads[i] + " Threads: " + 
                "\n Media = " + medias[i] + " | " + "Desvio Padrao = " + desviosPadrao[i]);
            
        }
    }

}
