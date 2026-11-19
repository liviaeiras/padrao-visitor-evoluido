package visitorevoluido;

public class Livro implements Produto {
    private final String titulo;
    private final double preco;

    public Livro(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public <R> R aceitar(Visitor<R> visitor) {
        return visitor.visitar(this);
    }
}
