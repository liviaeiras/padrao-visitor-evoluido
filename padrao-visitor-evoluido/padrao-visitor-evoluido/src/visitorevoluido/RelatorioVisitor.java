package visitorevoluido;

import java.util.Locale;

public class RelatorioVisitor implements Visitor<String> {
    private int nivel;

    private String recuo() {
        return "  ".repeat(nivel);
    }

    @Override
    public String visitar(Livro livro) {
        return recuo() + String.format(Locale.US, "Livro: %s - R$ %.2f\n", livro.getTitulo(), livro.getPreco());
    }

    @Override
    public String visitar(Eletronico eletronico) {
        return recuo() + String.format(Locale.US, "Eletronico: %s - R$ %.2f\n", eletronico.getNome(), eletronico.getPreco());
    }

    @Override
    public String visitar(Alimento alimento) {
        return recuo() + String.format(Locale.US, "Alimento: %s - R$ %.2f\n", alimento.getNome(), alimento.getPreco());
    }

    @Override
    public String visitar(Vestuario vestuario) {
        return recuo() + String.format(Locale.US, "Vestuario: %s - R$ %.2f\n", vestuario.getNome(), vestuario.getPreco());
    }

    @Override
    public String visitar(Carrinho carrinho) {
        StringBuilder texto = new StringBuilder(recuo() + "Carrinho\n");
        nivel++;
        for (Produto produto : carrinho.getItens()) {
            texto.append(produto.aceitar(this));
        }
        nivel--;
        return texto.toString();
    }
}
