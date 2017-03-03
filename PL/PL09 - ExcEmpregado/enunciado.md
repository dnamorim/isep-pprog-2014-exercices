#Exercício Empregado

Pretende-se uma classe de nome Empregado que satisfaça os seguintes requisitos:
* Possua os seguintes atributos: primeiroNome, ultimoNome, dataContrato, horaEntrada e horaSaida. O atributo dataContrato deve ser um objeto da classe Data fornecida. Os atributos horaEntrada e horaSaida devem ser objetos da classe Tempo também disponibilizada;
* As classes Data e Tempo devem ser reutilizadas por composição;

Disponibilize funcionalidades para:
* Calcular o número de horas de trabalho semanal de um empregado, considerando que todos os empregados trabalham 5 dias por semana;
* Determinar há quanto tempo o empregado foi contratado.

O desenvolvimento desta classe deve ser realizado da seguinte forma:

1. Elabore um diagrama de classes para visualizar as relações entre as classes Empregado, Data e Tempo.

2. Crie uma biblioteca de classes contendo as classes Data e Tempo, seguindo as instruções referidas no PDF disponibilizado.

3. Implemente a classe Empregado.

4. Construa outra classe com o nome TesteEmpregado que permita testar as funcionalidades da classe Empregado. Para isso:

  * Crie e visualize uma instância de Data para representar a data atual;

  * Crie e visualize duas instâncias de Tempo;

  * Crie duas instâncias de Empregado usando para o efeito as instâncias de Data e de Tempo criadas anteriormente;

  * Teste se os atributos do tipo Data dos empregados criados possuem referências partilhadas;

  * Teste se os atributos do tipo Tempo dos empregados criados possuem referências partilhadas;

  * Altere o conteúdo do objeto Data e o conteúdo dos objetos Tempo inicialmente criados;

  * Visualize as instâncias de Data e de Tempo, bem como as instâncias de Empregado criadas;

  * Altere a data de contrato e as horas de entrada e de saída do segundo empregado;

  * Armazene as instâncias de Empregado criadas num contentor de objetos do tipo array;

  * Liste todos os empregados;

  * Liste o nome, o número de horas de trabalho por semana e a antiguidade de cada um dos empregados.
