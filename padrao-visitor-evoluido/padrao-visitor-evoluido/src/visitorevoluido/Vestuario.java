package visitorevoluido;

public class Vestuario implements Produto {
    private final String nome;
    private final double preco;
    private final String tamanho;

    public Vestuario(String nome, double preco, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public <R> R aceitar(Visitor<R> visitor) {
        return visitor.visitar(this);
    }
}
