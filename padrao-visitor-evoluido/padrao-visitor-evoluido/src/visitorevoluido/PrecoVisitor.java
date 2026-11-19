package visitorevoluido;

public class PrecoVisitor extends VisitorNumerico {
    @Override
    public Double visitar(Livro livro) {
        return livro.getPreco();
    }

    @Override
    public Double visitar(Eletronico eletronico) {
        return eletronico.getPreco();
    }

    @Override
    public Double visitar(Alimento alimento) {
        return alimento.getPreco();
    }

    @Override
    public Double visitar(Vestuario vestuario) {
        return vestuario.getPreco();
    }
}
