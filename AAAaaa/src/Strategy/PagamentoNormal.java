package Strategy;

public class PagamentoNormal implements PagamentoStrategy {
    @Override
    public double calcularPrecoFinal(double precoBruto) {
        return precoBruto;
    }

    @Override
    public String getNomeEstrategia() {
        return "Pagamento Normal (Sem Desconto)";
    }
}