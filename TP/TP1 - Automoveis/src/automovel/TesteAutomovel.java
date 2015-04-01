package automovel;

public class TesteAutomovel {

    public static void main(String[] args) {

        // a) Criar uma instância Automovel a1, com a marca Toyota, matrícula 11-11-AA e cilindrada 1400 cc
        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400);
        
        // b) Mostrar o automóvel a1 no ecrã
        System.out.println("Automóvel a1: " + a1.toString());
        
        // c) Mostrar apenas a matrícula do automóvel a1
        System.out.println("Matricula de a1: " + a1.getMatricula());
        
        // d) Mostrar a quantidade de instâncias Automovel criadas
        System.out.println("Quantidade de instâncias Automovel: " +  Automovel.getTotalAutomoveis());
        
        // e) Criar uma nova instância Automovel a2, da marca Audi e matrícula 22-22-BB
        Automovel a2 = new Automovel("22-22-BB", "Audi");
        
        // f) Mostrar o automóvel a2
        System.out.println("Automóvel a2: " + a2.toString());
        
        // g) Modificar a cilindrada do automóvel a2 para 1800 cc
        a2.setCilindrada(1800);
        
        // h) Mostrar novamente o automóvel a2 no ecrã
        System.out.println("Automóvel a2: " + a2.toString());

        // i) Mostrar novamente a quantidade de instâncias Automovel criadas
        System.out.println("Quantidade de instâncias Automovel: " +  Automovel.getTotalAutomoveis());
        
        // j) Mostrar a diferença de cilindrada (valor absoluto) entre os automóveis a1 e a2
        System.out.println("Diferença das cilindradas: " + Math.abs(a1.diferencaCilindrada(a2)));
        
        // k) Mostrar a matrícula do automóvel que tem a maior cilindrada entre os automóveis a1 e a2
        if(a1.isCilindradaMaior(a2))
            System.out.println("Automóvel com a maior cilindrada tem a matrícula " +  a1.getMatricula());
        else if (a2.isCilindradaMaior(a1))
            System.out.println("Automóvel com a maior cilindrada tem a matrícula " +  a2.getMatricula());
        else
            System.out.println("os dois automóveis têm a mesma cilindrada");
        
        // l) Verificar se a cilindrada do automóvel a1 é superior a 2000 cc
        if(a1.isCilindradaMaior(2000))
            System.out.println("Automóvel com a matrícula " +  a1.getMatricula() + " tem cilindrada superior a 2000 cc");
        else
            System.out.println("Automóvel com a matrícula " +  a1.getMatricula() + " tem cilindrada inferior ou igual a 2000 cc");
    }

}
