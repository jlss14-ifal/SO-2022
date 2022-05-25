
# Cálculo de PI usando Threads

Abaixo, a descrição do problema e da solução:

## Descrição do problema

Esta atividade avaliativa tem como principal objetivo compreender melhor o conceito de thread e como elas podem ser usadas para utilizar melhor os recursos de processamento disponíveis nos computadores e sistemas operacionais modernos. Ela é inspirada [nesta atividade](http://wiki.inf.ufpr.br/maziero/doku.php?id=so:calculo_de_pi_com_threads), do curso de sistemas operacionais do prof. Carlos Maziero (UFPR). A atividade pode ser realizada em dupla.

Construa um programa utilizando a linguagens Java ou Go para calcular o valor de π utilizando N threads processando de forma concorrente. O valor de π deve ser aproximado pela [série de Leibniz-Grégory](https://pt.wikipedia.org/wiki/F%C3%B3rmula_de_Leibniz_para_%CF%80):

<p align="center">
  <img src="http://wiki.inf.ufpr.br/maziero/lib/exe/fetch.php?cache=&media=so:calcpi.png" />
</p>

### Observações:

- Devem ser calculados pelo menos 1 milhão (106) de termos da série; use variáveis reais de dupla precisão (double) nos cálculos;
- O programa deve dividir o espaço de cálculo uniformemente entre as N threads; cada thread efetua uma soma parcial de forma autônoma;
- Lembrando que os resultados parciais de cada thread devem ser somados, pois o objetivo é chegar ao valor mais próximo do número π
- Devem ser medidos os tempos de execução do programa para execuções com 1, 2, 4, 8, 16 e 32 threads (cenários experimentais). Para determinar o tempo de cada execução, você pode usar comando time do UNIX ou realizar a medição dentro do próprio programa;
- Para que os resultados tenham valor estatístico, devem ser feitas pelo menos 5 execuções de cada cenário (repetições) e calculados o tempo médio de execução e o desvio padrão entre execuções.
- Vocês devem evitar usar uma variável para acumular os valores das somas parciais calculadas por cada thread. Uma forma de evitar isso é criar um array de tamanho N (número de threads) e usar como memória compartilhada. Cada thread deve alterar uma posição única desse array com sua soma parcial.

Dica: Ao executar seus experimentos, verifique se a máquina não está muito carregada, o que pode falsear os resultados (use o comando top para ver a carga da máquina);

O resultado deve conter o valor obtido de π. Além disso, para cada cenário experimental -- 1,2,4,8,16 e 32 threads, deve apresentar:
- média do tempo de execução
- desvio padrão do tempo de execução

## Descrição da solução

Foram criadas as classes:
- `Calculo.java`: para fazer o cálculo de uma parte de PI;
- `CalculoThreads.java`: para criar Threads baseado no número que ele recebe;
- `Main.java`: para iniciar `CalculoThreads.java` para cada quantidade de Threads e apresentar os resultados de média e desvio padrão para cada.

Também foi criado o arquivo `run.sh` para compilar e executar.

### Funcionamento

...
