# Exercício Vencimentos com Interface Gráfica

Construa uma aplicação com interface gráfica para o exercício Vencimentos, conforme as figuras abaixo apresentadas. A aplicação desenvolvida deve ter uma arquitetura de duas camadas, separando o código da interface gráfica (camada ui) do código relacionado com os dados da aplicação (camada model). A interface gráfica deve ser baseada em componentes Swing. 

Para desenvolver esta aplicação siga os seguintes passos:

1. Construa o sistema de menus ilustrado nas seguintes figuras: 
 
![Img1](http://i.imgur.com/yGD1aO8.png) ![Img2](http://i.imgur.com/vUPzCaQ.png) ![Img3](http://i.imgur.com/MF1H6d4.png)

2. Programe a apresentação de caixas de diálogo, do tipo JDialog, para permitir ao utilizador a introdução dos dados correspondentes ao tipo de trabalhador a criar. Por exemplo:

![Img4](http://i.imgur.com/kkh2Hdz.png) ![Img5](http://i.imgur.com/2Z3Es7q.png)   ![Img6](http://i.imgur.com/oQKPwXU.png)   

3. Programe o item Sair, do menu Criação, para fechar a aplicação. O pedido do utilizador deve ser confirmado através de uma caixa de diálogo semelhante à seguinte:

![Img7](http://i.imgur.com/nc11H5U.png)

4. Da mesma forma, programe o pedido de fecho da aplicação através do botão fechar (X). 

5. Modifique a aplicação de modo a mostrar uma mensagem de aviso, semelhante à da figura seguinte, quando o utilizador selecionar os itens dos menus Manutenção e Gestão com o contentor de trabalhadores vazio. Por exemplo, o item Listar deve apresentar a seguinte caixa de diálogo JOptionPane: 
![Img8](http://i.imgur.com/my0eoCT.png)

6. Programe o item Alterar, do menu Manutenção, para modificar os dados de um trabalhador. Este trabalhador deve ser escolhido numa combobox incluída numa caixa de diálogo JOptionPane. Por exemplo:

![Img9](http://i.imgur.com/EE9EmOU.png) --> ![Img10](http://i.imgur.com/fd49ad2.png)

7. Programe o item Eliminar, do menu Manutenção, para remover um trabalhador do contentor de trabalhadores. O pedido de eliminação tem de ser confirmado pelo utilizador. Por exemplo:

![Img11](http://i.imgur.com/DKk7u8C.png) --> ![Img12](http://i.imgur.com/7UBWibO.png)

8. Programe o item Listar, do menu Gestão, para mostrar todos os trabalhadores guardados no contentor. Esta listagem deve usar um componente JList incluído numa caixa de diálogo JOptionPane. Por exemplo:

![Img12](http://i.imgur.com/F1FAtDv.png)

9. Complete a implementação do Item Calcular Vencimento para calcular e mostrar o vencimento de um trabalhador. O trabalhador deve ser escolhido usando um componente JComboBox incluído numa caixa de diálogo JOptionPane. Por exemplo:

![Img13](http://i.imgur.com/YDfh1nZ.png)
