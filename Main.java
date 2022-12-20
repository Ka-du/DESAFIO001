import java.util.Random;

/*
    1. Incluir vendedores dos outros mercados para vender com compradores
    2. Incluir atributo de total compras dos compradores [int compras]
    3. Imprimir top 3 maiores vendedores e dizer de qual mercado foi
    4. Imprimir top 3 maiores compradores e e dizer qual mercado mais comprou

 */
public class Main {

    private static final String[] nomesVendedores = new String[] {
            "Caio", "Marina", "Luca", "Rafa"
    };

    private static final String[] sobrenomes = new String[] {
            "Matias", "Fernandes", "Maia", "Rocha", "Gaspar",
            "Leão", "Alves", "Fagundes", "Sineza", "Bertoldi"
    };

    private static final String[] nomesCompradores = new String [] {
            "Vinicius", "Jociele", "Breno", "Vitor", "Alesandro",
            "Cicero", "Debora", "Eduardo", "Ezio", "Grabriel",
            "Vitor", "Wallys"
    };

    private static final Random random = new Random();

    private static int sequencial = 0;

    public static void main(String[] args) {

        Vendedor[] vendedoresFlores = criarVendedores();
        Vendedor[] vendedoresFrutas = criarVendedores();
        Vendedor[] vendedoresRoupas = criarVendedores();

        Mercado mercadoFlores = new Mercado(vendedoresFlores, "flores");
        Mercado mercadoFrutas = new Mercado(vendedoresFrutas, "frutas");
        Mercado mercadoRoupas = new Mercado(vendedoresRoupas, "roupas");

        Comprador[] compradores = criarCompradores();

        int qtdVendedoresFlores = mercadoFlores.getVendedores().length;
        int indiceCompradorFlor = 0;
        double valorVendasFlores = 0;


        for (int i = 0; i < qtdVendedoresFlores; i++) {
            Vendedor vendedor = mercadoFlores.getVendedores()[i];
            indiceCompradorFlor = random.nextInt(compradores.length);
            Comprador comprador = compradores[indiceCompradorFlor];
            comprador.comprar( vendedor );
            valorVendasFlores =+ vendedor.getVendas();
        }

        int qtdVendedoresFrutas = mercadoFrutas.getVendedores().length;
        int indiceCompradorFrutas = 0;
        double valorVendasFrutas = 0;

        for (int i = 0; i < qtdVendedoresFrutas; i++) {
            Vendedor vendedor = mercadoFrutas.getVendedores()[i];
            indiceCompradorFrutas = random.nextInt(compradores.length);
            Comprador comprador = compradores[indiceCompradorFrutas];
            comprador.comprar( vendedor );
            valorVendasFrutas =+ vendedor.getVendas();
        }

        int qtdVendedoresRoupas = mercadoRoupas.getVendedores().length;
        int indiceCompradorRoupas = 0;
        double valorVendasRoupas = 0;

        for (int i = 0; i < qtdVendedoresRoupas; i++) {
            Vendedor vendedor = mercadoRoupas.getVendedores()[i];
            indiceCompradorRoupas = random.nextInt(compradores.length);
            Comprador comprador = compradores[indiceCompradorRoupas];
            comprador.comprar( vendedor );
            valorVendasRoupas =+ vendedor.getVendas();
        }

        Regulador regulador = new Regulador();
        regulador.aplicar(
                new Mercado[] {
                        mercadoFlores
                }
        );

        Regulador regulador2 = new Regulador();
        regulador.aplicar(
                new Mercado[] {
                        mercadoFrutas
                }
        );

        Regulador regulador3 = new Regulador();
        regulador.aplicar(
                new Mercado[] {
                        mercadoRoupas
                }
        );

        MelhoresVendedorFlores(vendedoresFlores);
        MelhoresVendedorFrutas(vendedoresFrutas);
        MelhoresVendedorRoupas(vendedoresRoupas);

        MercadoMaisLucrativo(valorVendasFlores, valorVendasFrutas, valorVendasRoupas);


    }


    private static void MelhoresVendedorRoupas(Vendedor[] vendedoresRoupas) {
        String vendedorMaisVendas = new String();
        String [] segundoVendedor = new String [3];
        String segundoMelhorVendedor = new String();
        String [] terceiroVendedor = new String [2];
        String terceiroMelhorVendedor = new String();
        double valorVenda = 0;



        for (int j = 0; j < vendedoresRoupas.length; j++) {
            Vendedor vendedor = vendedoresRoupas[j];
            if (vendedor.getVendas()>valorVenda){
                valorVenda = vendedor.getVendas();
                vendedorMaisVendas = String.valueOf(vendedor);
            }

        }
        System.out.println("o vendedor que mais vendeu no mercado de Roupas: ");
        System.out.println(vendedorMaisVendas);


        for(int i = 0; i<segundoVendedor.length; i++){
            if (vendedorMaisVendas != String.valueOf(vendedoresRoupas[i])){
                segundoVendedor[i]= String.valueOf(vendedoresRoupas[i]);
            }
        }
        for (int i =0; i<segundoVendedor.length;i++){
            Vendedor vendedor = vendedoresRoupas[i];
            if(vendedor.getVendas()>valorVenda){
                valorVenda = vendedor.getVendas();
                segundoMelhorVendedor = String.valueOf(vendedor);
            }
        }
        System.out.println("o segundo melhor vendedro foi: ");
        System.out.println(segundoMelhorVendedor);

    }
    private static void MelhoresVendedorFrutas(Vendedor[] vendedoresFrutas) {
        String vendedorMaisVendas = new String();
        double valorVenda = 0;
        for (int j = 0; j < vendedoresFrutas.length; j++) {
            Vendedor vendedor = vendedoresFrutas[j];
            if (vendedor.getVendas()>valorVenda){
                valorVenda = vendedor.getVendas();
                vendedorMaisVendas = String.valueOf(vendedor);
            }
        }
        System.out.println("o vendedor que mais vendeu no mercado de Frutas: ");
        System.out.println(vendedorMaisVendas);
    }

    private static void MelhoresVendedorFlores(Vendedor[] vendedoresFlores) {
        String vendedorMaisVendas = new String();
        double valorVenda = 0;
        for (int j = 0; j < vendedoresFlores.length; j++) {
            Vendedor vendedor = vendedoresFlores[j];
            if (vendedor.getVendas()>valorVenda){
                valorVenda = vendedor.getVendas();
                vendedorMaisVendas = String.valueOf(vendedor);
            }
        }
        System.out.println("o vendedor que mais vendeu no mercado de Flores: ");
        System.out.println(vendedorMaisVendas);
    }

    private static void MercadoMaisLucrativo(double valorVendasFlores, double valorVendasFrutas, double valorVendasRoupas) {
        if ((valorVendasFlores > valorVendasFrutas)&&(valorVendasFlores > valorVendasRoupas)){
            System.out.println("o mercado mais lucrativo foi o mercado de flores");
        }
        if ((valorVendasFlores < valorVendasFrutas)&&(valorVendasFrutas > valorVendasRoupas)){
            System.out.println("o mercado mais lucrativo foi o mercado de frutas");
        }
        if((valorVendasFlores < valorVendasRoupas)&&(valorVendasFrutas < valorVendasRoupas)){
            System.out.println("o mercado mais lucrativo foi o mercado de roupas");
        }
    }

    private static Vendedor[] criarVendedores() {
        Vendedor[] vendedores = new Vendedor[nomesVendedores.length];
        for (int i = 0; i < nomesVendedores.length; i++) {
            int indiceNome = random.nextInt(nomesVendedores.length);
            String nome = nomesVendedores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome] + " " + proximoSequencial();
            vendedores[i] = new Vendedor(nome, sobrenome);
        }
        return vendedores;
    }

    private static Comprador[] criarCompradores() {
        Comprador[] compradores = new Comprador[nomesCompradores.length];
        for (int i = 0; i < nomesCompradores.length; i++) {
            int indiceNome = random.nextInt(nomesCompradores.length);
            String nome = nomesCompradores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome] + " " + proximoSequencial();

            compradores[i] = new Comprador(nome, sobrenome);
        }

        return compradores;
    }

    private static int proximoSequencial() {
        return ++sequencial;
    }

}

class Comprador extends Object {

    private String nome;
    private String sobrenome;

    public Comprador(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    private static final Random random = new Random();
    public void comprar(Vendedor vendedor) {
        vendedor.vender(random.nextInt(1000));
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }
}

class Mercado {
    private Vendedor[] vendedores;

    private String tipo;

    private double VendasMercados;

    public Mercado(Vendedor[] vendedores, String tipo) {
        this.vendedores = vendedores;
        this.tipo = tipo;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }


}

class Regulador {
    public void aplicar(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) { // para cada mercado ->
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            for (int j = 0; j < vendedores.length; j++) { // para cada vendedor
                Vendedor vendedor = vendedores[j];
                if (isSuperiorMeta(vendedor)) {
                    this.bonificar(vendedor);
                }
                System.out.println( vendedor.anunciar() );
            }
        }
    }

    private boolean isSuperiorMeta(Vendedor vendedor) {
        return vendedor.getVendas() > 500;
    }

    // private, protected, package, public
    // segurança -> oportunidade e necessidade
    private void bonificar(Vendedor vendedor) {
        double total = vendedor.getVendas();
        double bonificacao = (total * 0.10);
        vendedor.receberBonificacao(bonificacao);
    }

}

class Vendedor {
    private String nome;
    private String sobrenome;

    private double bonificacao;

    private double vendas;
    public Vendedor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String anunciar() {
        String textoBonificacao = "";
        if (bonificacao > 0)
            textoBonificacao = " e fui bonificado " + bonificacao;
        return nome + " " + sobrenome
                + " e vendi " + vendas
                + textoBonificacao
                + " : total " + (vendas + bonificacao);
    }

    public void vender(double valor) {
        this.vendas += valor;
    }

    public void receberBonificacao(double bonificacao) {
        this.bonificacao += bonificacao;
    }

    public double getVendas() {
        return this.vendas;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }
}