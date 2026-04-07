
//import Shake.sizeType;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    public Order myOrder = new Order();

    @FXML
    private Label ShakeSizeLbl;

    @FXML
    private Label ShakeTitle;

    @FXML
    private ChoiceBox<String> ShakeSizeChoiceBox;

    @FXML
    private ChoiceBox<String> ShakeFlavorCB;

    @FXML
    private Label ShakeFlavorLBL;

    @FXML
    private Label ToppingsShakeLBL;

    @FXML
    private ChoiceBox<String> ToppingShakeCB;

    @FXML
    private Button AddShakeBTTN;

    @FXML
    private TextField shakePrice;

    @FXML
    private Label subSizeLabel;

    @FXML
    private ChoiceBox<String> subSizeCB;

    @FXML
    private ChoiceBox<String> subMeatCB;

    @FXML
    private ChoiceBox<String> subBreadCB;

    @FXML
    private Button addSubBttn;

    @FXML
    private ListView<String> orderView = new ListView<>();
    private ObservableList<String> orderViewList = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> subToppCB;

    // used these to try to implement a delete function but it proved to be
    // harder than I thought, I couldn't do it
    static int numShakes = 0;
    static int numSubs = 0;

    // event for complete order button, prompts user after order completion
    public void completeOrder()
    {
        // as long as order isnt empty, prompts user properlly
        if (!myOrder.isEmpty())
            AlertBox.popUp("Thank You For Your Order!", "Expect your order within 30mins.\nOtherwise it's on us!");
    }

    // initialize all fields with data while formatting it
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {

        DecimalFormat price = new DecimalFormat("#0.00");
        String priceStr;
        for (Shake.sizeType s : Shake.sizeType.values())
        {
            priceStr = price.format(s.price);
            ShakeSizeChoiceBox.getItems().add(s.name + " - $" + priceStr);
        }
        for (Shake.flavorType s : Shake.flavorType.values())
        {
            priceStr = price.format(s.price);
            ShakeFlavorCB.getItems().add(s.name + " - $" + priceStr);
        }
        // shakePrice

        ToppingShakeCB.getItems().addAll(Shake.toppingStr);

        // SUBS

        subSizeCB.getItems().addAll("6 Inches - No Charge", "Footlong - $3.00");

        for (Sub.breadType b : Sub.breadType.values())
        {
            priceStr = price.format(b.price);
            subBreadCB.getItems().add(b.name + " -$" + priceStr);
        }

        for (Sub.meatType m : Sub.meatType.values())
        {
            priceStr = price.format(m.price);
            subMeatCB.getItems().add(m.name + " - $" + priceStr);
        }

        subToppCB.getItems().addAll(Sub.toppingStr);
    }

    // event handler for addShakeButton, prompts user confirming order
    // builds a shake with user input and adds it to the order to be displayed
    public void addShake()
    {
        if (ShakeSizeChoiceBox.getValue() != null && ShakeFlavorCB.getValue() != null
                && ToppingShakeCB.getValue() != null)
        {
            int size = 0;
            for (String s : ShakeSizeChoiceBox.getItems())
            {
                if (s.equals(ShakeSizeChoiceBox.getValue()))
                    break;

                size++;
            }

            int flavor = 0;
            for (String s : ShakeFlavorCB.getItems())
            {
                if (s.equals(ShakeFlavorCB.getValue()))
                    break;

                flavor++;
            }

            int topping = 0;
            for (String s : Shake.toppingStr)
            {
                if (s == ToppingShakeCB.getValue())
                    break;

                topping++;
            }
            Shake shk = new Shake(size, flavor, topping);

            AlertBox.popUp("Item Ordered", shk.toString());
            myOrder.addShake(shk);

            orderViewList.clear();

            orderViewList.add(myOrder.toString());

            orderView.setItems(orderViewList);

            // this triggers when user doesnt enter all data for an item
            // an alert box pops up with appropriate msg
        } else
            AlertBox.popUp("ERROR: Incomplete Shake", "You still have choices to make");

    }

    // event handler for adding sub, works same way as addShake
    // adds a sub to the order, built with user input
    public void addSub()
    {
        if (subSizeCB.getValue() != null && subBreadCB.getValue() != null && subMeatCB.getValue() != null)
        {
            boolean ftlong = false;
            String footStr = "Footlong - $3.00";
            if (footStr.equals(subSizeCB.getValue()))
                ftlong = true;

            int bread = 0;
            for (String b : subBreadCB.getItems())
            {
                if (b.equals(subBreadCB.getValue()))
                    break;
                bread++;
            }

            int meat = 0;
            for (String b : subMeatCB.getItems())
            {
                if (b.equals(subMeatCB.getValue()))
                    break;
                meat++;
            }
            int subTop = 0;
            for (String s : subToppCB.getItems())
            {
                if (s.equals(subToppCB.getValue()))
                    break;

                subTop++;
            }

            Sub sb = new Sub(ftlong, bread, meat, subTop);
            AlertBox.popUp("Item Ordered", sb.toString());

            myOrder.addSub(sb);

            orderViewList.clear();
            orderViewList.add(myOrder.toString());
            // orderViewList.add("#" + (numSubs+1) + " - " + sb.toString());
            // numSubs++;
            orderView.setItems(orderViewList);

        } else
            AlertBox.popUp("ERROR: Incomplete Sub", "You still have choices to make");
    }

}
