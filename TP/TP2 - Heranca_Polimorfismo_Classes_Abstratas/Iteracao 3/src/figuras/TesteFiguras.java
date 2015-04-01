package figuras;

public class TesteFiguras {

    public static void main(String[] args) {

        System.out.println("\n### Figuras Construídas ###");
        Circulo c1 = new Circulo();
        System.out.println(c1);

        Circulo c2 = new Circulo(5, "amarelo");
        System.out.println(c2);

        Retangulo r1 = new Retangulo();
        System.out.println(r1);

        Retangulo r2 = new Retangulo(5, 2, "azul");
        System.out.println(r2);

        // Armazenamento de Objetos num Contentor do Tipo Array
        Figura[] figuras = new Figura[10];

        figuras[0] = c1;
        figuras[1] = c2;
        figuras[2] = r1;
        figuras[3] = r2;

        System.out.println("\n### Listagem de Figuras Armazenadas no Contentor ###");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] != null) {
                System.out.println(figuras[i]);
            }
        }

        System.out.println("\n### Listagem das Áreas das Figuras ###");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] != null) {
                System.out.printf("%s área=%.1f%n", figuras[i], figuras[i].area());
            }
        }

        System.out.println("\n### Listagem de Instâncias de Retangulo ###");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] instanceof Retangulo) {
                System.out.println(figuras[i]);
            }
        }

        System.out.println("\n### Listagem de Instâncias de Circulo ###");
        for (int i = 0; i < figuras.length; i++) {
            if (figuras[i] instanceof Circulo) {
                System.out.println(figuras[i]);
            }
        }

        System.out.println("\n### Clonagem de Objetos ###");
        Circulo c3 = new Circulo(c2);
        System.out.println("Objeto Original: " + c2);
        System.out.println("Objeto Clone: " + c3);
        System.out.println("Referências: " + (c2 == c3 ? "Iguais" : "Diferentes"));        
    }

}

