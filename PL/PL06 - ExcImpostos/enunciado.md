# Exercício Impostos

Tendo como base os tipos de contribuinte abaixo indicados, pretende-se um programa para calcular o valor total de um imposto extra. Esse imposto recai sobre rendimentos do trabalho (RT) e outros rendimentos (OR). Adicionalmente, cada contribuinte é ainda caracterizado pelo nome e morada.
Tipos de contribuintes e atributos específicos:


|                  | Reformado | Trab. por c/Outrem | Trab. por c/Própria | Desempregado |
|------------------|-----------|--------------------|---------------------|--------------|
| Taxa s/ RT       | 1%        | 1% ou 2% (1)       | 3%                  |              |
| Taxa s/ OR       | 3%        | 2%                 | 2% ou 5% (2)        | 2%           |
| Nome da empresa  |           | X                  |                     |              |
| Profissão        |           |                    | X                   |              |
| Meses de paragem |           |                    |                     | X            |


* (1) Se o rendimento do trabalho for inferior ou igual a 30.000 €, a taxa a aplicar é de 1%, caso contrário é de 2%.
* (2) Se o montante dos outros rendimentos for inferior ou igual a 50.000 €, a taxa a aplicar é de 2%, caso contrário é de 5%.


Para a implementação desta aplicação faça uma modelação de classes que melhor se adequa ao cálculo do imposto pretendido.
Para testar as classes, crie uma classe principal e programe o seguinte:

1. A construção de objetos de cada uma das classes instanciáveis.

2. A declaração de um contentor de objetos do tipo array, de comprimento superior ao número de objetos criados.

3. O armazenamento dos objetos no contentor.

4. Uma listagem dos objetos do contentor para mostrar, para cada objeto, a sua representação textual juntamente com o respetivo valor do imposto a pagar.

5. Uma listagem dos objetos do contentor que são contribuintes desempregados.
