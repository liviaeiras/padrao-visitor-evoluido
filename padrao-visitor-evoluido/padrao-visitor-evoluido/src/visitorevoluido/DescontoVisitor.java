package visitorevoluido;

public class DescontoVisitor extends VisitorNumerico {
    private static final double DESCONTO_LIVRO = 0.10;
    private static final double DESCONTO_ELETRONICO = 0.05;
    private static final double DESCONTO_ALIMENTO = 0.0;
    private static final double DESCONTO_VESTUARIO = 0.15;

    @Override
    public Double visitar(Livro livro) {
        return livro.getPreco() * DESCONTO_LIVRO;
    }

    @Override
    public Double visitar(Eletronico eletronico) {
        return eletronico.getPreco() * DESCONTO_ELETRONICO;
    }

    @Override
    public Double visitar(Alimento alimento) {
        return alimento.getPreco() * DESCONTO_ALIMENTO;
    }

    @Override
    public Double visitar(Vestuario vestuario) {
        return vestuario.getPreco() * DESCONTO_VESTUARIO;
    }
}
