package Decorator;

import FactoryMethod.Pizza;
import java.text.NumberFormat;
import java.util.Locale;

public class MolhoExtra extends PizzaDecorator {
    private static final double CUSTO = 1.00;
    private static final NumberFormat FORMATADOR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public MolhoExtra(Pizza pizzaDecorada) {
        super(pizzaDecorada);
    }

    @Override
    public double getCustoAdicional() {
        return CUSTO;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao() + ", Molho EXTRA (" + FORMATADOR.format(CUSTO) + " de acréscimo)";
    }
}
