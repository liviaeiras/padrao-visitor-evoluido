package visitorevoluido;

public interface Produto {
    <R> R aceitar(Visitor<R> visitor);
}
