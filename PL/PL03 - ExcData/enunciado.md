#Exercício Data

1. Analise a classe Data fornecida e que foi construída com base nos seguintes requisitos: 
	1. Permitir obter o estado de um objeto Data no formato "ano/mês/dia".
	2. Determinar o dia da semana de uma data, tendo em conta que:
		* O dia 1/1/1 é uma segunda-feira;
		* Um ano não bissexto avança um dia da semana (365 % 7 = 1);
		* Um ano bissexto avança 2 dias da semana (366 % 7 = 2).
		* Anos bissextos são os anos divisíveis por 4 mas não por 100, ou os divisíveis por 400.
	3. Permitir obter o estado de um objeto Data por extenso. Exemplo: "terça-feira, 5 de outubro de 2011".
	4. Verificar se uma data é maior (mais recente) do que outra.
	5. Determinar a diferença, em dias, entre duas datas.

2. Crie uma nova classe com o nome TesteData que permita testar todas as funcionalidades da classe Data. Para isso: 
	1. Crie uma instância da classe Data com o nome data1 e que represente a data de hoje.
	2. Mostre data1 usando o formato por extenso.
	3. Crie uma outra instância da classe Data chamada data2 que guarde a data 25 de abril de 1974.
	4. Mostre data2 no formato "ano/mês/dia".
	5. Utilize o método de instância isMaior para confirmar que, de facto, data1 é mais recente do que data2.
	6. Determine o número de dias entre data1 e data2.
	7. Determine o número de dias que faltam para o Natal, usando o método que recebe, por parâmetro, o dia, o mês e o ano de uma data.
	8. Determine o dia da semana em que ocorreu o dia 25 de abril de 1974.
	9. Verifique se o ano 1974 foi bissexto, invocando o método de classe isAnoBissexto:
		* Através do objeto data2;
		* Através da classe Data.
