package Decorator;

import FactoryMethod.Pizza;
import java.text.NumberFormat;
import java.util.Locale;

public class MassaFina extends PizzaDecorator {
    private static final double CUSTO = 2.00;

    private static final NumberFormat FORMATADOR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public MassaFina(Pizza pizzaDecorada) {
        super(pizzaDecorada);
    }

    @Override
    public double getCustoAdicional() {
        return CUSTO;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao() + ", Massa FINA (" + FORMATADOR.format(CUSTO) + " de acréscimo)";
    }
}