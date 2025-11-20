package FactoryMethod;

public class PizzaCalabresa implements Pizza {
    @Override
    public String getDescricao() {
        return "Pizza de Calabresa";
    }

    @Override
    public double getCusto() {
        return 45.00; 
    }
}
