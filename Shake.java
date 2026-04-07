import java.util.*;

public class Shake extends Item
{
    // FIELDS
    private sizeType size;
    private flavorType flavor;

    // CONSTRUCTORS
    public Shake(int size, int flavor, int topping)
    {
        setSize(size);
        setFlavor(flavor);
        super.toppings = new Vector<>();
        toppings.add(toppingStr[topping]);
        setPrice();
    }

    // GETTERS
    public float getPrice()
    {
        return super.price;
    }

    public String getSize()
    {
        return size.name;
    }

    public String getToppings()
    {
        return super.toppings.get(0);
    }

    public String getFlavor()
    {
        return flavor.name;
    }

    // SETTERS
    public void addToppings(int input)
    {
        super.toppings.set(0, toppingStr[input]);

    }

    // sets price for the super class
    public void setPrice()
    {
        super.price = size.price + flavor.price;
    }

    public void setSize(int input)
    {
        for (sizeType temp : sizeType.values())
            if (temp.value == input)
                size = temp;

    }

    public void setFlavor(int input)
    {
        for (flavorType temp : flavorType.values())
            if (temp.value == input)
                this.flavor = temp;

    }

    // prints a shake in appropriate format
    @Override
    public String toString()
    {
        return getSize() + " " + getFlavor() + " " + "Milkshake w/ " + getToppings() + " on top -- $"
                + String.format("%.2f", getPrice());
    }

    public static final String[] toppingStr = { "Nothing", "Sprinkles", "Peanuts", "Choco Chips" };

    // all enums are used to aid with printing the name and retrieving the string
    // for item choices
    public static enum sizeType
    {
        SMALL(0, 3, "Small"), MEDIUM(1, 4, "Medium"), LARGE(2, 5, "Large");

        final int value;
        final int price;
        final String name;

        sizeType(int value, int price, String name)
        {
            this.value = value;
            this.price = price;
            this.name = name;
        }

        int getValue(String s)
        {

            return this.value;
        }
    }

    public static enum flavorType
    {
        STRAW(0, 1.5F, "Strawberry"), CHOC(1, 2.5F, "Chocolate"), VANL(2, 0.5F, "Vanilla");

        final int value;
        final float price;
        final String name;

        flavorType(int value, float price, String name)
        {
            this.value = value;
            this.price = price;
            this.name = name;
        }
    }

};
