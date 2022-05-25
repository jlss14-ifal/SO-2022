
public class Main {

    public static void main(String args[]) {

        // INICIALIZACAO

        int[] numeroThreads = new int[]{1, 2, 4, 8, 16, 32};

        double[] medias = new double [numeroThreads.length];
        double[] deviosPadrao = new double [numeroThreads.length];

        //long[] tempos = new long [numeroThreads.length];

        // PROCESSAMENTO

        for (int i = 0; i < numeroThreads.length; i++) {

            System.out.println("\nCom " + numeroThreads[i] + " thread:" + "\n");

            long[] execucoes = new long[5];
            
            for(i=0;  i<5; i++){
                execucoes[i] = new CalculoThreads().calculaComThreads(numeroThreads[i]);
            }
            for(j=0; j<5; j++){
                soma += execucoes[i]
            }
            //medias[i]= ((i-3)**2)/5
        }
        // SAIDA

        System.out.println("\nRESULTADOS:\n");

        for (int i = 0; i < numeroThreads.length; i++) {

            System.out.println("Tempo para " + numeroThreads[i] + " Threads: " + 
                "Media = " + medias[i] + " | " + "Desvio Padrao = " + desviosPadrao[i]);
            
        }
    }

}
