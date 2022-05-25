
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

### Resultados

Para cada Thread:
```
Tempo para 1 Threads: 
 Media = 23.0 | Desvio Padrao = 19.879637823662684

Tempo para 2 Threads: 
 Media = 15.0 | Desvio Padrao = 9.338094023943002

Tempo para 4 Threads: 
 Media = 16.4 | Desvio Padrao = 9.850888284819801

Tempo para 8 Threads: 
 Media = 15.0 | Desvio Padrao = 9.57078889120432

Tempo para 16 Threads: 
 Media = 15.6 | Desvio Padrao = 10.3072789813801

Tempo para 32 Threads: 
 Media = 15.2 | Desvio Padrao = 9.927738916792686
```

A saida completa:

```
Com 1 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = 0.785397663397423
Calculo = -7.499990000014253E-7
Somatorio com 2: 3.141587653593692
Calculo = -1.4999960000114516E-6
Calculo = 0.7853971633974453
Calculo = -5.833328888892614E-7
Calculo = -8.333323333346824E-7
Somatorio com 4: 3.141576986944892
Calculo = -1.6666626666774501E-6
Calculo = -1.1666648888919275E-6
Calculo = -2.999984000092093E-6
Calculo = 0.785396163397432
Calculo = -8.999990000012253E-7
Calculo = -7.333326933339691E-7
Calculo = -6.190471746035219E-7
Calculo = -5.357139591838853E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -5.999936000736018E-6
Calculo = -2.3333262222467083E-6
Calculo = -3.333317333419903E-6
Calculo = -1.0714272653078892E-6
Calculo = -7.636357236369444E-7
Calculo = -8.444436543217823E-7
Calculo = -1.466664106671619E-6
Calculo = -6.410251965815234E-7
Calculo = -9.444434444455774E-7
Calculo = -1.799996000009927E-6
Calculo = -1.2380934603202249E-6
Calculo = -6.969691680445169E-7
Calculo = -5.934062147086221E-7
Calculo = -5.523806258505462E-7
Calculo = -5.166663822223796E-7
Somatorio com 16: 3.1414854706665714

Com 2 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = -7.499990000014253E-7
Calculo = 0.785397663397423
Somatorio com 2: 3.141587653593692
Calculo = 0.7853971633974453
Calculo = -1.4999960000114516E-6
Calculo = -5.833328888892614E-7
Calculo = -8.333323333346824E-7
Somatorio com 4: 3.141576986944892
Calculo = 0.785396163397432
Calculo = -7.333326933339691E-7
Calculo = -8.999990000012253E-7
Calculo = -2.999984000092093E-6
Calculo = -1.6666626666774501E-6
Calculo = -1.1666648888919275E-6
Calculo = -5.357139591838853E-7
Calculo = -6.190471746035219E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -5.999936000736018E-6
Calculo = -3.333317333419903E-6
Calculo = -2.3333262222467083E-6
Calculo = -1.799996000009927E-6
Calculo = -1.466664106671619E-6
Calculo = -1.0714272653078892E-6
Calculo = -9.444434444455774E-7
Calculo = -1.2380934603202249E-6
Calculo = -7.636357236369444E-7
Calculo = -8.444436543217823E-7
Calculo = -5.934062147086221E-7
Calculo = -6.969691680445169E-7
Calculo = -5.166663822223796E-7
Calculo = -6.410251965815234E-7
Calculo = -5.523806258505462E-7
Somatorio com 16: 3.1414854706665714

Com 4 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = 0.785397663397423
Calculo = -7.499990000014253E-7
Somatorio com 2: 3.141587653593692
Calculo = 0.7853971633974453
Calculo = -8.333323333346824E-7
Calculo = -5.833328888892614E-7
Calculo = -1.4999960000114516E-6
Somatorio com 4: 3.141576986944892
Calculo = -1.1666648888919275E-6
Calculo = 0.785396163397432
Calculo = -7.333326933339691E-7
Calculo = -8.999990000012253E-7
Calculo = -6.190471746035219E-7
Calculo = -1.6666626666774501E-6
Calculo = -2.999984000092093E-6
Calculo = -5.357139591838853E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -3.333317333419903E-6
Calculo = -1.799996000009927E-6
Calculo = -1.2380934603202249E-6
Calculo = -5.999936000736018E-6
Calculo = -1.0714272653078892E-6
Calculo = -2.3333262222467083E-6
Calculo = -1.466664106671619E-6
Calculo = -8.444436543217823E-7
Calculo = -6.969691680445169E-7
Calculo = -9.444434444455774E-7
Calculo = -6.410251965815234E-7
Calculo = -7.636357236369444E-7
Calculo = -5.934062147086221E-7
Calculo = -5.523806258505462E-7
Calculo = -5.166663822223796E-7
Somatorio com 16: 3.1414854706665714

Com 8 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = -7.499990000014253E-7
Calculo = 0.785397663397423
Somatorio com 2: 3.141587653593692
Calculo = 0.7853971633974453
Calculo = -8.333323333346824E-7
Calculo = -1.4999960000114516E-6
Calculo = -5.833328888892614E-7
Somatorio com 4: 3.141576986944892
Calculo = -1.1666648888919275E-6
Calculo = 0.785396163397432
Calculo = -2.999984000092093E-6
Calculo = -8.999990000012253E-7
Calculo = -7.333326933339691E-7
Calculo = -1.6666626666774501E-6
Calculo = -6.190471746035219E-7
Calculo = -5.357139591838853E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -5.999936000736018E-6
Calculo = -3.333317333419903E-6
Calculo = -1.466664106671619E-6
Calculo = -1.2380934603202249E-6
Calculo = -1.0714272653078892E-6
Calculo = -2.3333262222467083E-6
Calculo = -9.444434444455774E-7
Calculo = -1.799996000009927E-6
Calculo = -6.969691680445169E-7
Calculo = -7.636357236369444E-7
Calculo = -6.410251965815234E-7
Calculo = -8.444436543217823E-7
Calculo = -5.934062147086221E-7
Calculo = -5.523806258505462E-7
Calculo = -5.166663822223796E-7
Somatorio com 16: 3.1414854706665714

Com 16 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = 0.785397663397423
Calculo = -7.499990000014253E-7
Somatorio com 2: 3.141587653593692
Calculo = -1.4999960000114516E-6
Calculo = -5.833328888892614E-7
Calculo = 0.7853971633974453
Calculo = -8.333323333346824E-7
Somatorio com 4: 3.141576986944892
Calculo = -2.999984000092093E-6
Calculo = -1.1666648888919275E-6
Calculo = 0.785396163397432
Calculo = -7.333326933339691E-7
Calculo = -8.999990000012253E-7
Calculo = -1.6666626666774501E-6
Calculo = -5.357139591838853E-7
Calculo = -6.190471746035219E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -5.999936000736018E-6
Calculo = -2.3333262222467083E-6
Calculo = -1.466664106671619E-6
Calculo = -1.799996000009927E-6
Calculo = -1.2380934603202249E-6
Calculo = -1.0714272653078892E-6
Calculo = -8.444436543217823E-7
Calculo = -9.444434444455774E-7
Calculo = -3.333317333419903E-6
Calculo = -7.636357236369444E-7
Calculo = -5.934062147086221E-7
Calculo = -6.410251965815234E-7
Calculo = -5.166663822223796E-7
Calculo = -5.523806258505462E-7
Calculo = -6.969691680445169E-7
Somatorio com 16: 3.1414854706665714

Com 32 thread:

Calculo = 0.7853979133974436
Somatorio com 1: 3.1415916535897743
Calculo = 0.785397663397423
Calculo = -7.499990000014253E-7
Somatorio com 2: 3.141587653593692
Calculo = -8.333323333346824E-7
Calculo = -1.4999960000114516E-6
Calculo = 0.7853971633974453
Calculo = -5.833328888892614E-7
Somatorio com 4: 3.141576986944892
Calculo = -2.999984000092093E-6
Calculo = -1.1666648888919275E-6
Calculo = -1.6666626666774501E-6
Calculo = -7.333326933339691E-7
Calculo = 0.785396163397432
Calculo = -8.999990000012253E-7
Calculo = -5.357139591838853E-7
Calculo = -6.190471746035219E-7
Somatorio com 8: 3.1415501679721967
Calculo = 0.7853941633974414
Calculo = -5.999936000736018E-6
Calculo = -1.799996000009927E-6
Calculo = -3.333317333419903E-6
Calculo = -2.3333262222467083E-6
Calculo = -1.466664106671619E-6
Calculo = -9.444434444455774E-7
Calculo = -1.2380934603202249E-6
Calculo = -7.636357236369444E-7
Calculo = -1.0714272653078892E-6
Calculo = -8.444436543217823E-7
Calculo = -6.969691680445169E-7
Calculo = -6.410251965815234E-7
Calculo = -5.523806258505462E-7
Calculo = -5.934062147086221E-7
Calculo = -5.166663822223796E-7
Somatorio com 16: 3.1414854706665714

RESULTADOS:


Tempo para 1 Threads: 
 Media = 23.0 | Desvio Padrao = 19.879637823662684

Tempo para 2 Threads: 
 Media = 15.0 | Desvio Padrao = 9.338094023943002

Tempo para 4 Threads: 
 Media = 16.4 | Desvio Padrao = 9.850888284819801

Tempo para 8 Threads: 
 Media = 15.0 | Desvio Padrao = 9.57078889120432

Tempo para 16 Threads: 
 Media = 15.6 | Desvio Padrao = 10.3072789813801

Tempo para 32 Threads: 
 Media = 15.2 | Desvio Padrao = 9.927738916792686
```

Nota: alguns número aparecem negativos por excederem o número de casas decimais para valores `double`, entretanto isso não afeta o cálculo, isso pode ser solucionado utilizando um limitador decimal: `String.format(format, args)`.
