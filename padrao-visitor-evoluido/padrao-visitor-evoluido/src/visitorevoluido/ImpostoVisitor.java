package visitorevoluido;

public class ImpostoVisitor extends VisitorNumerico {
    private static final double TAXA_LIVRO = 0.0;
    private static final double TAXA_ELETRONICO = 0.20;
    private static final double TAXA_ALIMENTO = 0.07;
    private static final double TAXA_VESTUARIO = 0.12;

    @Override
    public Double visitar(Livro livro) {
        return livro.getPreco() * TAXA_LIVRO;
    }

    @Override
    public Double visitar(Eletronico eletronico) {
        return eletronico.getPreco() * TAXA_ELETRONICO;
    }

    @Override
    public Double visitar(Alimento alimento) {
        return alimento.getPreco() * TAXA_ALIMENTO;
    }

    @Override
    public Double visitar(Vestuario vestuario) {
        return vestuario.getPreco() * TAXA_VESTUARIO;
    }
}
