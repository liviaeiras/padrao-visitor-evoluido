package visitorevoluido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho implements Produto {
    private final List<Produto> itens = new ArrayList<>();

    public void adicionar(Produto produto) {
        itens.add(produto);
    }

    public List<Produto> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public <R> R aceitar(Visitor<R> visitor) {
        return visitor.visitar(this);
    }
}
