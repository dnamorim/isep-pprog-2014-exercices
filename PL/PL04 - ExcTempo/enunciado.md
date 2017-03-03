#Exercício Tempo

1. Crie uma classe de nome Tempo com os atributos hora, minuto e segundo, sendo zero o valor por omissão. Esta classe deve disponibilizar funcionalidades que permitam:
	1. Obter o estado de uma instância Tempo no formato:
		* "hh:mm:ss";
		* "hh:mm:ss AM (ou PM)".
	2. Acrescentar 1 segundo a um dado tempo.
	3. Verificar se um dado tempo é maior do que outro. Este tempo deve poder ser representado por uma instância de Tempo ou pelos valores simples das horas, minutos e segundos.
	4. Determinar a diferença entre dois tempos fornecidos:
		* em segundos;
		* em Tempo.
2. Crie uma nova classe com o nome TesteTempo que permita testar todas as funcionalidades da classe Tempo. Para isso: 
	1. Crie uma instância da classe Tempo com o nome t1 e que represente o tempo: 5 horas, 30 minutos e 12 segundos.
	2. Mostre o tempo t1 usando o formato "hh:mm:ss AM (ou PM)". 
	3. Acrescente 1 segundo ao tempo t1.
	4. Mostre novamente t1 usando o formato "hh:mm:ss AM (ou PM)".
	5. Crie uma outra instância da classe Tempo chamada t2 que guarde o tempo: 18 horas, 5 minutos e 20 segundos.
	6. Mostre o tempo t2 usando o formato "hh:mm:ss AM (ou PM)".
	7. Verifique se o tempo t1 é maior do que o tempo t2.
	8. Verifique se o tempo t1 é maior do que o tempo 23 horas, 7 minutos e 4 segundos usando o método que recebe por parâmetro as horas, os minutos e os segundos de um tempo.
	9. Determinar a diferença entre o tempo t1 e o tempo t2:
		* em segundos;
		* em Tempo.
