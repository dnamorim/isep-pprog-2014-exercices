#Exercício Data com Exceções

Pretende-se a atualização da classe Data fornecida, de modo a realizar a validação dos parâmetros mes e dia de uma data. Para isso: 

1. Crie duas classes de exceções, MesInvalidoException e DiaInvalidoException, para serem usadas nas validações referidas.

2. Faça a modificação pretendida da classe Data. Os parâmetros mes e dia inválidos devem originar o lançamento de uma exceção da classe MesInvalidoException e DiaInvalidoException, respetivamente.

3. Construa outra classe com o nome TesteData para testar as novas funcionalidades da classe Data. Nesse sentido implemente o seguinte:
  * A leitura de uma data fornecida pelo utilizador, no formato ano/mês/dia (p. ex., 2014/3/5);
  * A apresentação da data lida no formato por extenso (p. ex., Quarta-feira, 5 de Março de 2014);
  * A repetição da leitura de uma data inválida;
  * A visualização de mensagens de erro que indiquem o tipo de erro: formato ou mes ou dia inválido.
