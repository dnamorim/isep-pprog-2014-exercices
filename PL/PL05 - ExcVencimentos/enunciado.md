#Exercício Vencimentos

As classes Trabalhador, TrabPeca, TrabCom e TrabHora foram construídas com base na necessidade de desenvolver um programa que calculasse os vencimentos mensais dos seguintes tipos de trabalhadores:
* *Trabalhador à peça (TrabPeca):* vencimento dependente do número de peças produzidas. Foram considerados dois tipos de peças e com pagamentos diferentes, sendo atualmente estes pagamentos iguais a 15,50 € e 20,00 €;
* *Trabalhador à comissão (TrabCom):* vencimento igual a um salário base mais uma percentagem das vendas. Foi considerado, por omissão, o salário base de 485 €;
* Trabalhador à hora (TrabHora), vencimento proporcional às horas de trabalho. Foi considerado, por omissão, o pagamento à hora de 10 €.

Para tal, definiu-se uma classe para cada tipo de trabalhador com uma implementação apropriada do método vencimento() e uma superclasse com o nome Trabalhador.
Analise o código destas classes e crie uma nova classe com o nome TesteVencimentos que permita testar todas as suas funcionalidades. Para isso:

1. Crie 3 objetos, um para cada tipo de trabalhador:
  * Objeto tp, do tipo TrabPeca, de nome Jorge Silva que produziu 20 peças do tipo 1 e 30 do tipo 2;
  * Objeto tc, do tipo TrabCom, de nome Susana Ferreira, com o salário base de 500,00 € e uma comissão de 6% sobre as vendas efetuadas que totalizaram o valor de 1500,00 €;
  * Objeto th, do tipo TrabHora, de nome Carlos Miguel, que ganha por hora 3,50 € e com um total de horas de trabalho igual a 160.
  
2. Crie um contentor de objetos para guardar os objetos existentes. Este contentor deve ser um array do tipo Object com comprimento 10.

3. Guarde os objetos existentes no contentor. 

4. Programe as seguintes listagens independentes, obtidas através do varrimento do contentor com uma instrução for tradicional:
  * Listagem das representações textuais dos trabalhadores;
  * Listagem das representações textuais apenas dos trabalhadores à hora;
  * Listagem dos nomes dos trabalhadores existentes, acompanhadas dos respetivos vencimentos.
  
5. Substitua o tipo Object do array pelo tipo Trabalhador (é o tipo mais genérico da hierarquia de classes).

6. Simplifique o código das listagens.

7. Crie uma instância clone da instância tp.

8. Compare esta nova instância com a instância original tp, usando o método equals. 
