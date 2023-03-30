package com.example.demo;

import com.example.demo.datamodel.ProductItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Controller{
    private List<ProductItem>productItems;
    @FXML
    private ListView<ProductItem> productListView;
    @FXML
    private TextArea itemDetailsTextArea;
    public void initialize(){
        ProductItem item1 = new ProductItem("хлеб", "белый","50",1);
        ProductItem item2 = new ProductItem("молоко", "бел","80",1);
        ProductItem item3 = new ProductItem("сыр", "маасдам","500",1);

        productItems = new ArrayList<ProductItem>();
        productItems.add(item1);
        productItems.add(item2);
        productItems.add(item3);

        productListView.getItems().setAll(productItems);
        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handClickListView(){
        ProductItem item = productListView.getSelectionModel().getSelectedItem();
        //System.out.println(" Выбран продукт " + item);
        itemDetailsTextArea.setText(item.getDetails());
    }

}
