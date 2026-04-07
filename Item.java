import java.util.*;

public abstract class Item
{
    protected float price;
    protected Vector<String> toppings;

    public abstract float getPrice();

    public abstract void setPrice();

    public abstract String getToppings();

    public abstract void addToppings(int input);

    @Override
    public abstract String toString();
}
