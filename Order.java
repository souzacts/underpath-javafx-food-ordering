import java.util.*;

public class Order
{
    private Vector<Shake> myShakes;
    private Vector<Sub> mySubs;

    // default constructor, initializes the vectors
    Order()
    {
        myShakes = new Vector<>();
        mySubs = new Vector<>();
    }

    // getters, return the full vector of shakes or subs
    public Vector<Shake> getShakes()
    {
        return myShakes;
    }

    public Vector<Sub> getSubs()
    {
        return mySubs;
    }

    // checks size to return bool equivalent to its state
    public boolean isEmpty()
    {
        return myShakes.size() == 0 && mySubs.size() == 0;
    }

    // adds items to respective vectors members
    public void addShake(Shake newShake)
    {
        myShakes.add(newShake);
    }

    public void addSub(Sub newSub)
    {
        mySubs.add(newSub);
    }

    // calculate price of whole order
    public float getSubTotal()
    {
        float subTotal = 0;
        for (Shake s : myShakes)
            subTotal += s.getPrice();

        for (Sub sub : mySubs)
            subTotal += sub.getPrice();

        return subTotal;
    }

    // used to add tax + delivery fee
    public float getTotal()
    {
        return getSubTotal() * 1.07F + 3.5F;
    }

    // prints a comprehensive list of ordered items
    @Override
    public String toString()
    {
        int numShakes = 0;
        StringBuilder buffer = new StringBuilder();

        buffer.append("Your shakes:\n\n");

        for (Shake shk : myShakes)
        {
            numShakes++;
            buffer.append("#" + numShakes + " -- " + shk.toString() + '\n');
        }

        int numSubs = 0;
        buffer.append("\nYour Subs: \n\n");

        for (Sub s : mySubs)
        {
            numSubs++;
            buffer.append("#" + numSubs + " -- " + s.toString() + '\n');
        }

        buffer.append("\nNumber of Items: " + (numShakes + numSubs) + '\n');
        buffer.append("Subtotal: $" + String.format("%.2f", getSubTotal()) + '\n');
        buffer.append("Tax: $" + String.format("%.2f", getSubTotal() * .07F) + '\n');
        buffer.append("Delivery fee: $" + String.format("%.2f", 3.50F) + '\n');
        buffer.append("Total: $" + String.format("%.2f", getTotal()));

        return buffer.toString();
    }
}
