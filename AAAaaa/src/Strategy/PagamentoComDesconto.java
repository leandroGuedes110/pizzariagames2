package Strategy;

public class PagamentoComDesconto implements PagamentoStrategy {

    private static final double DESCONTO = 0.20;

    @Override
    public double calcularPrecoFinal(double precoBruto) {

        return precoBruto * (1 - DESCONTO);
    }

    @Override
    public String getNomeEstrategia() {

        return "Desconto do Sabadão (20%)";
    }
}