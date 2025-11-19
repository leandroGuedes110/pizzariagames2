package FactoryMethod;

public class PizzaFrangao implements Pizza {
    @Override
    public String getDescricao() {
        return "Pizza de Frangão";
    }

    @Override
    public double getCusto() {
        return 45.00; // Custo base de R$ 45,00
    }
}