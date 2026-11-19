package visitorevoluido;

public class Eletronico implements Produto {
    private final String nome;
    private final double preco;
    private final int garantiaMeses;

    public Eletronico(String nome, double preco, int garantiaMeses) {
        this.nome = nome;
        this.preco = preco;
        this.garantiaMeses = garantiaMeses;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public <R> R aceitar(Visitor<R> visitor) {
        return visitor.visitar(this);
    }
}
