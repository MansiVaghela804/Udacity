package com.example.udacity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextOrNoActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_or_no);
        boolean hasWhippedCream = true;
    }
    public void increment(View view) {
        if (quantity == 100){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
//        This return Editable object (nameFiels=d.getText())
        String name = nameField.getText().toString();
//        Log.v("MainActivity","Name:" + name);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
//        Log.v("MainActivity","has whipped cream:" + hasWhippedCream);
        int price = calculatePrice(hasWhippedCream,hasChocolate);

        String priceMessage = createorderSummary(name,price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//        displayMessage(priceMessage);
//        displayPrice(quantity * 5);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream){
            basePrice = basePrice + 1;
        }

        if (addChocolate){
            basePrice = basePrice + 2;
        }
        int price = quantity * basePrice;
        return price;
    }

    private String createorderSummary(String nameFiled,int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: " + nameFiled;

//        means language change and using string file data get same all fileds 1) name 2) whippedcream 3)chocolate 4)quantity 5)price
//        String priceMessage = getString(R.string.order_summary_name, nameFiled);

//        += MEANS :  priceMessage + "\nQuantity: " + quantity;
//        String priceMessage = getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
//        String priceMessage = getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\nAdd chocolate? " + addChocolate;
//        String priceMessage = getString(R.string.order_summary_quantity, quantity);
        priceMessage +="\nQuantity: " + quantity;
//        += MEANS :  priceMessage + "\nTotal: $" + price;
//        String priceMessage = getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\nTotal: $" + price;
//        += MEANS :  priceMessage = priceMessage +" \nThank You !!";
//        priceMessage += " \n " + getString(R.string.thank_you);
        priceMessage += "\n Thank You !!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }
}
