package visitorevoluido;

public class TesteVisitorEvoluido {
    public static void main(String[] args) {
        testeProdutoIsolado();
        testeVestuarioNovoElemento();
        testeCarrinhoSomaPreco();
        testeCarrinhoSomaImposto();
        testeCarrinhoSomaDesconto();
        testeCarrinhoVazio();
        testeRelatorioComCarrinhoAninhado();
        System.out.println("Todos os testes passaram");
    }

    private static Carrinho montarCarrinho() {
        Carrinho interno = new Carrinho();
        interno.adicionar(new Alimento("Cafe", 50.0, 120));
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Livro("Java", 100.0));
        carrinho.adicionar(new Eletronico("Notebook", 1000.0, 12));
        carrinho.adicionar(new Vestuario("Camisa", 200.0, "M"));
        carrinho.adicionar(interno);
        return carrinho;
    }

    private static void testeProdutoIsolado() {
        double preco = new Livro("Java", 100.0).aceitar(new PrecoVisitor());
        verificar(iguais(preco, 100.0), "visitor retorna o preco de um livro");
    }

    private static void testeVestuarioNovoElemento() {
        Vestuario camisa = new Vestuario("Camisa", 200.0, "M");
        verificar(iguais(camisa.aceitar(new ImpostoVisitor()), 24.0), "vestuario paga 12% de imposto");
        verificar(iguais(camisa.aceitar(new DescontoVisitor()), 30.0), "vestuario recebe 15% de desconto");
    }

    private static void testeCarrinhoSomaPreco() {
        double preco = montarCarrinho().aceitar(new PrecoVisitor());
        verificar(iguais(preco, 1350.0), "carrinho soma o preco dos itens e do carrinho aninhado");
    }

    private static void testeCarrinhoSomaImposto() {
        double imposto = montarCarrinho().aceitar(new ImpostoVisitor());
        verificar(iguais(imposto, 227.5), "carrinho soma impostos de todos os itens");
    }

    private static void testeCarrinhoSomaDesconto() {
        double desconto = montarCarrinho().aceitar(new DescontoVisitor());
        verificar(iguais(desconto, 90.0), "carrinho soma descontos de todos os itens");
    }

    private static void testeCarrinhoVazio() {
        Carrinho vazio = new Carrinho();
        verificar(iguais(vazio.aceitar(new PrecoVisitor()), 0.0), "carrinho vazio tem preco zero");
        verificar("Carrinho\n".equals(vazio.aceitar(new RelatorioVisitor())), "carrinho vazio gera relatorio so com o titulo");
    }

    private static void testeRelatorioComCarrinhoAninhado() {
        String esperado = "Carrinho\n"
                + "  Livro: Java - R$ 100.00\n"
                + "  Eletronico: Notebook - R$ 1000.00\n"
                + "  Vestuario: Camisa - R$ 200.00\n"
                + "  Carrinho\n"
                + "    Alimento: Cafe - R$ 50.00\n";
        String obtido = montarCarrinho().aceitar(new RelatorioVisitor());
        verificar(esperado.equals(obtido), "relatorio recua os itens do carrinho aninhado");
    }

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError("FALHOU: " + descricao);
        }
        System.out.println("OK - " + descricao);
    }

    private static boolean iguais(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
