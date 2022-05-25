
/*
* Essa classe serve para calcular um pedaco de PI mas:
*  ############################### Sem multiplicar por 4 #####################################
* 
*/

import java.lang.Math;

public class Calculo {

    /* 
        ### double calculaNPartes(int inicio, int fim) ###

        O metodo calculaNPartes(INICIO, FIM) faz o calculo de A numeros onde:
            cada numero de A, chamado de I, comeca com INICIO e vai ate FIM, aumentando de um em um;
        A cada I serve como entrada para o metodo calculaParte que por sua vez retorna um pedaco menor, logo,
            a cada resultado de calculaParte(N) eh somado a variavel RESULTADO, fazendo assim uma parte de PI 
     */
    public double calculaNPartes(int inicio, int fim) {

            double resultado = 0.0;

            for (int i = inicio; fim > i; i++)
                resultado += calculaParte(i);

            return resultado;

    }

    /*
    
        ### double calculaParte(int n) ###

        Esse metodo faz o calculo:
            (-1)^n / 2n + 1
    
    */
    public double calculaParte(int n) {

            return Math.pow(-1, n) 
                        / 
                    ( (2*n) + 1);

    }

    /*public static void main(String[] args) {

        Calculo c = new Calculo();

        System.out.println(c.calculaNPartes(0, 100));

    }*/

    

}
