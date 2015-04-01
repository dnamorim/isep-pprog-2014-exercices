/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ginasio;

/**
 * Representa um Utente através do nome, o género, a idade, a altura e o peso.
 * Possui valores alteráveis para o IMC (Índice Massa Corporal).
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class Utente {
    /**
     * Nome do Utente
     */
    private String nome;
    /**
     * Sexo/Género do Utente - Exemplo: M, F
     */
    private char sexo;
    /**
     * Idade do Utente
     */
    private int idade;
    /**
     * Altura do Utente (em metros)
     */
    private float altura;
    /**
     * Peso do Utente (em quilogramas - kg)
     */
    private float peso;
    /**
     * Índice de Massa Corporal Mínimo (valor por defeito - 18)
     */
    private static int minIMC=18;
    /**
     * Índice de Massa Corporal Máximo (valor por defeito - 25)
     */
    private static int maxIMC=25;
    
    /**
     * Constrói uma instância de um Utente, recebendo os seguintes parâmetros:
     * @param nome Nome do Utente
     * @param sexo Sexo do Utente (M ou F)
     * @param idade Idade do Utente
     * @param altura Altura do Utente (em metros - m)
     * @param peso Peso do Utente (em quilogramas - kg)
     */
    public Utente(String nome, String sexo, int idade, float altura, float peso) {
        this.nome=nome;
        this.sexo=sexo.toUpperCase().charAt(0);
        this.idade=idade;
        this.altura=altura;
        this.peso=peso;                
    }
    
    /**
    * Constrói uma instância de um Utente, recebendo apenas o nome, o sexo e a idade e inicializado a altura e a idade a 0.
    * @param nome Nome do Utente
    * @param sexo Sexo do Utente (M ou F)
    * @param idade Idade do Utente
    */
    public Utente(String nome, String sexo, int idade) {
        this(nome, sexo, idade, 0, 0);
    }
    
    /**
     * Constrói uma instância de um Utente, inicializado os parâmetros com o seu valor padrão: nome = "n.d." 
     * (não definido); sexo = 'N'; idade = 0; altura = 0; peso = 0.
     */
    public Utente() {
        this("n.d.", "N", 0, 0, 0);
    }
    
    /**
     * Constrói uma instância de um Utente, tendo por base um utente previamente existente. 
     * @param novoUtente o Utente com as características a copiar
     */
    public Utente(Utente novoUtente) {
        this(novoUtente.nome, novoUtente.sexo+"", novoUtente.idade, novoUtente.altura, novoUtente.peso);
    }
 
    //GET'S
    
    /**
     * Devolve o Nome do Utente
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Devolve o Sexo do Utente (M ou F).
     * @return sexo
     */
    public char getSex() {
        return this.sexo;
    }
    
    /**
     * Devolve a Idade do Utente.
     * @return idade
     */
    public int getIdade() {
        return this.idade;
    }
    
    /**
     * Devolve a Altura do Utente em metros (m).
     * @return altura
     */
    public float getAltura() {
        return this.altura;
    }
    
    /**
     * Devolve o Peso do Utente em quilogramas (kg).
     * @return peso
     */
    public float getPeso() {
        return this.peso;
    }
    
    //SET's
    
    /**
     * Altera o Nome do Utente para o nome recebido por parâmetro.
     * @param nome Novo Nome do Utente
     */
    public void setNome(String nome) {
        this.nome=nome;
    }
    
    /**
     * Altera o Sexo do Utente para o sexo recebido por parâmetro.
     * @param sexo Novo Sexo do Utente
     */
    public void setSexo(char sexo) {
        this.sexo=sexo;
    }
    
    /**
     * Altera o Nome do Utente para o nome recebido por parâmetro.
     * @param idade Nova Idade do Utente
     */
    public void setIdade(int idade) {
        this.idade=idade;
    }
    
    /**
     * Altera a Altura do Utente para uma altura recebida por parâmetro.
     * @param altura Nova Altura do Utente, em metros (m)
     */
    public void setAltura(float altura) {
        this.altura=altura;
    }
    
    /**
     * Altera o Peso do Utente para um peso recebido por parâmetro.
     * @param peso Novo peso do Utente, em quilogramas (kg).
     */
    public void setPeso(float peso) {
        this.peso=peso;
    }
    
    /**
     * Obter a descrição Textual do Utente.
     * @return descricao (Exemplo: O Duarte, do sexo M e com 19 anos, tem 1.80 m de altura e 60 kg de peso.
     */
    @Override
    public String toString() {
        return String.format("O Utente %s, do sexo %c e com %d anos, tem %.2f m de altura e %.2f kg de peso.", this.nome, this.sexo, this.idade, this.altura, this.peso);
    }
    
    /**
     * Devolve o valor do Índice de Massa Corporal (IMC) do Utente.
     * @return imc
     */
    public float calcularIMC() {
        return (float) (this.peso / Math.pow((double) this.altura, 2));
    }
    
    /**
     * Devolve uma Descrição do grau de obesidade de um Utente, tendo por base o IMC e os valores de referência.
     * @return descricaoObesidadeUtente
     */
    public String descricaoObesidade() {
        float imc = this.calcularIMC();
        if(imc < minIMC) {
            return "Magro";
        } else if(imc > maxIMC) {
            return "Obeso";
        }
        return "Saudável";
    }
    
    //VARIÁVEIS DE CLASSE
    
    /**
     * Devolve o Valor Mínimo do Índice de Massa Corporal (IMC).
     * @return minIMC
     */
    public static int getMinIMC() {
        return minIMC;
    }
    
    /**
     * Devolve o Valor Máximo do Índice de Massa Corporal (IMC).
     * @return maxIMC
     */
    public static int getMaxIMC() {
        return maxIMC;
    }
    
    /**
     * Permite alterar o Valor Mínimo do Índice de Massa Corporal (IMC) para o cálculo da Obesidade
     * @param min Novo Valor Mínimo de IMC
     */
    public static void setMinIMC(int min) {
        minIMC=min;
    }
    
    /**
     * 
     * Permite alterar o Valor Mánimo do Índice de Massa Corporal (IMC) para o cálculo da Obesidade
     * @param max Novo Valor Máximo de IMC
     */
    public static void setMaxIMC(int max) {
        maxIMC=max;
    }
}
