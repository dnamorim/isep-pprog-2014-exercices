# Exercício Disciplina

Uma escola pretende uma aplicação informática para facilitar a gestão de regentes das disciplinas de um curso com três anos letivos. Nesse sentido é preciso implementar duas classes que satisfaçam os seguintes requisitos:
  * Classe Professor: deve representar um professor através do nome e habilitação académica (Licenciatura, Mestrado ou Doutoramento);
  * Classe Disciplina: deve representar uma disciplina através da designação, ano do curso e regente. O regente deve ser uma instância de Professor e esta classe tem de ser reutilizada por agregação. 

O desenvolvimento destas duas classes deve se realizado da seguinte forma:
1. Elabore um diagrama de classes para visualizar as classes Professor e Disciplina e a relação entre elas.
2. Implemente a classe Professor.
3. Crie uma classe principal, chamada Teste, para testar as duas classes pretendidas.
4. Nesta classe Teste implemente um método auxiliar para visualizar os objetos de um contentor do tipo array, passado por parâmetro. Este método deve ser designado listar.
5. Teste a classe Professor da seguinte forma:
  * Crie um contentor de objetos para guardar instâncias de Professor;
  * Armazene neste contentor objetos que representem os seguintes professores: João Cardoso com doutoramento, Ana Amorim com mestrado, Rui Almeida com mestrado e Rui Almeida com licenciatura;
  * Visualize os objetos do contentor utilizando o método listar.
6. Implemente a classe Disciplina.
7. Teste a classe Disciplina usando o seguinte procedimento:
  * Crie um contentor de objetos para guardar instâncias de Disciplina;
  * Armazene neste contentor objetos que representem as seguintes disciplinas:
  
  | Designação    | Ano Lectivo | Regente                  |
  |---------------|-------------|--------------------------|
  | Inglês        | 1           | João Cardoso             |
  | Programação   | 2           | Ana Amorim               |
  | Projecto      | 3           | Rui Almeida com mestrado |
  | Matemática I  | 1           | //por definir            |
  | Matemática II | 2           | //por definir            |
  
  * Visualize os objetos deste contentor reutilizando o método listar.
  
8. Atribua a responsabilidade das duas disciplinas de matemática ao professor Rui com licenciatura. Para confirmar estas modificações, visualize novamente os objetos do contentor de disciplinas.
9. O professor com licenciatura concluiu um doutoramento, por isso, atualize as suas habilitações académicas. Para confirmar esta atualização, visualize apenas a informação sobre este professor antes e depois da alteração.
10. Visualize as disciplinas da responsabilidade deste novo doutorado, usando um varrimento do contentor de disciplinas.
11. Visualize as disciplinas da responsabilidade de professores doutorados, usando um varrimento do contentor de disciplinas. Cada disciplina deve ser descrita apenas pela sua designação.
12. Visualize as disciplinas organizadas pelo nome do respetivo responsável. Tanto as disciplinas como os nomes dos professores responsáveis devem estar organizados por ordem alfabética. Use varrimentos dos contentores de disciplinas e professores.
