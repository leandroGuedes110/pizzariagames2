package Strategy;


public class DescontoDoProfessor10_10QueVaiMeDar10 implements PagamentoStrategy {
    private static final double DESCONTO = 1.0;

    @Override
    public double calcularPrecoFinal(double precoBruto) {

        return precoBruto * (1 - DESCONTO);
    }

    @Override
    public String getNomeEstrategia() {
        return "Desconto do Professor 10/10 Que Vai Me Dar 10 (100%)";
    }
}