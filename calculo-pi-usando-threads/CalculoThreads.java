
import java.lang.Thread;

public class CalculoThreads {

    private final double MILHAO = 1000000;

    /*
    
        ### double calculaComThreads(int numeroThreads) ###

    */

    public long calculaComThreads(int numeroThreads) {

        // Determina o numero de partes que serao dividas para cada thread
        double partes = (1.0/(double)numeroThreads) * MILHAO;
        int partesDivididas = (int) partes;

        // Cria um array que auxilia o salvamento das partes que cada thread calcula
        double[] arrayAuxiliar = new double[numeroThreads];

        iniciaTempo();

        // Inicio e fim das partes separadas para cada array
        int inicio = 0, fim = partesDivididas;

        // Guarda cada thread criada
        Thread[] threads = new Thread[numeroThreads];

        // Cria threads a cada interacao
        for (int i = 0; i < numeroThreads; i++) {

            threads[i] = criaThread(inicio, fim, arrayAuxiliar, i);

            inicio = fim+1;
            fim += partesDivididas;

        }
 
        // Espera todas as threads terminarem
        while (true) {

            try {
                
                for (int i = 0; i < numeroThreads; i++)
                    threads[i].join(); // Espera uma thread morrer

            } catch (Exception e) {
                e.printStackTrace();
            }

            break;

        }

        double somatorio = 0;

        // Faz somatorio dos resultados
        for (int i = 0; i < numeroThreads; i++)
            somatorio += arrayAuxiliar[i];

        // Termina calculo multiplicando por 4
        somatorio *= 4;

        System.out.println("Somatorio com " + numeroThreads + ": " + somatorio);

        return terminaTempo();

    }

    /* 
        ### double criaThread(int inicio, int fim) ###

        Esse metodo cria uma unica thread que faz o processamento de uma unica parte
            e retorna a parte processada 
    */
    private Thread criaThread(int inicio, int fim, double[] arrayAuxiliar, int posicao) {

        Thread thread = new Thread() {

            @Override
            public void run() {

                double calculo = new Calculo().calculaNPartes(inicio, fim);

                arrayAuxiliar[posicao] = calculo;

                System.out.println("Calculo = " + calculo);

                setSaida( calculo );
            }

        };
        
        thread.setDaemon(true);
        thread.start();

        return thread;

    }

    private double saida = 0;
    private void setSaida(double saida) {
        this.saida = saida;
    }

    private long tempoInicial = 0;

    private void iniciaTempo() {
        tempoInicial = System.currentTimeMillis();
    }

    private long terminaTempo() {
        return System.currentTimeMillis() - tempoInicial;
    }

}
