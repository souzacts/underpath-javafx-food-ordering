import java.util.Vector;

public class Sub extends Item
{
    private boolean footlong;
    private breadType bread;
    private meatType meat;

    // CONSTRUCTOR

    public Sub(boolean footlong, int bread, int meat, int topping)
    {
        this.footlong = footlong;
        setBread(bread);
        setMeat(meat);
        super.toppings = new Vector<>();
        toppings.add(toppingStr[topping]);
        setPrice();

    }

    // GETTERS
    public float getPrice()
    {
        return super.price;
    }

    public boolean isFootlong()
    {
        return footlong;
    }

    public String getMeat()
    {
        return meat.name;
    }

    public String getBread()
    {
        return bread.name;
    }

    // SETTERS

    public void setPrice()
    {
        float sizePrice = !isFootlong() ? 0 : 3.0F;
        super.price = sizePrice + bread.price + meat.price;
    }

    public void setMeat(int input)
    {
        for (meatType temp : meatType.values())
            if (temp.index == input)
                this.meat = temp;
    }

    public void setBread(int input)
    {
        for (breadType temp : breadType.values())
            if (temp.index == input)
                this.bread = temp;
    }

    public String getToppings()
    {
        return super.toppings.get(0);
    }

    public void addToppings(int input)
    {
        super.toppings.set(0, toppingStr[input]);
    }

    @Override
    public String toString()
    {
        String sizeStr = isFootlong() ? "Footlong " : "6inch ";
        return sizeStr + meat.name + " on " + bread.name + " bread w/ " + getToppings() + " on top -- $"
                + String.format("%.2f", super.price);
    }

    // used for toppings
    public static final String[] toppingStr = { "Nothing", "Grilled Onions", "Parmesian", "Bacon Bits" };

    // enums handle price as well as names
    public enum breadType
    {
        WHITE(0, 1F, "White"), CIAB(1, 1.5F, "Ciabatta"), ITALIAN(2, 1F, "Italian");

        final int index;
        final float price;
        final String name;

        breadType(int i, float p, String n)
        {
            this.index = i;
            this.price = p;
            this.name = n;
        }
    }

    public enum meatType
    {
        BEEF(0, 4.5F, "Beef"), CHICKEN(1, 3.5F, "Chicken"), MBALL(2, 4.0F, "Meatball");

        final int index;
        final float price;
        final String name;

        meatType(int i, float p, String n)
        {
            this.index = i;
            this.price = p;
            this.name = n;
        }
    }
}
