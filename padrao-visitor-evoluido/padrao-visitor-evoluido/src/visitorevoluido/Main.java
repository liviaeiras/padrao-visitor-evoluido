package visitorevoluido;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Carrinho promocoes = new Carrinho();
        promocoes.adicionar(new Alimento("Cafe", 50.0, 120));

        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Livro("Java", 100.0));
        carrinho.adicionar(new Eletronico("Notebook", 1000.0, 12));
        carrinho.adicionar(new Vestuario("Camisa", 200.0, "M"));
        carrinho.adicionar(promocoes);

        double preco = carrinho.aceitar(new PrecoVisitor());
        double imposto = carrinho.aceitar(new ImpostoVisitor());
        double desconto = carrinho.aceitar(new DescontoVisitor());

        System.out.print(carrinho.aceitar(new RelatorioVisitor()));
        System.out.printf(Locale.US, "Subtotal: R$ %.2f%n", preco);
        System.out.printf(Locale.US, "Impostos: R$ %.2f%n", imposto);
        System.out.printf(Locale.US, "Descontos: R$ %.2f%n", desconto);
        System.out.printf(Locale.US, "Total final: R$ %.2f%n", preco + imposto - desconto);
    }
}
