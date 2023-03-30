package com.example.demo;

import com.example.demo.datamodel.ProductData;
import com.example.demo.datamodel.ProductItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DialogController {
    @FXML
    private TextField nameField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private TextArea priceArea;
    @FXML
    private TextArea quantityArea;

    public ProductItem processResults() {
        String name = nameField.getText().trim();
        String details = detailsArea.getText().trim();
        String price = priceArea.getText().trim();
        String quantity = quantityArea.getText().trim();

        ProductItem newItem = new ProductItem(name, details, price, quantity);
        ProductData.getInstance().addProductItem(newItem);
        return newItem;
    }

}
