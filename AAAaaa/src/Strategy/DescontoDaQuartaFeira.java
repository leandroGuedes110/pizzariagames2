package Strategy;


public class DescontoDaQuartaFeira implements PagamentoStrategy {
    private static final double DESCONTO = 0.10;

    @Override
    public double calcularPrecoFinal(double precoBruto) {

        return precoBruto * (1 - DESCONTO);
    }

    @Override
    public String getNomeEstrategia() {
        return "Desconto da Quarta-feira (10%)";
    }
}
