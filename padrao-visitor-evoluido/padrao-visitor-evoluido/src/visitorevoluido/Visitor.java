package visitorevoluido;

public interface Visitor<R> {
    R visitar(Livro livro);

    R visitar(Eletronico eletronico);

    R visitar(Alimento alimento);

    R visitar(Vestuario vestuario);

    R visitar(Carrinho carrinho);
}
