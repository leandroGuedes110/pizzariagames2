package Strategy;

public interface PagamentoStrategy {
    double calcularPrecoFinal(double precoBruto);
    String getNomeEstrategia();
}