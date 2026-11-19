package visitorevoluido;

public class Alimento implements Produto {
    private final String nome;
    private final double preco;
    private final int diasValidade;

    public Alimento(String nome, double preco, int diasValidade) {
        this.nome = nome;
        this.preco = preco;
        this.diasValidade = diasValidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getDiasValidade() {
        return diasValidade;
    }

    @Override
    public <R> R aceitar(Visitor<R> visitor) {
        return visitor.visitar(this);
    }
}
