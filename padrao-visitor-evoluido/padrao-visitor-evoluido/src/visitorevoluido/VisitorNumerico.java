package visitorevoluido;

public abstract class VisitorNumerico implements Visitor<Double> {
    @Override
    public Double visitar(Carrinho carrinho) {
        double soma = 0.0;
        for (Produto produto : carrinho.getItens()) {
            soma += produto.aceitar(this);
        }
        return soma;
    }
}
