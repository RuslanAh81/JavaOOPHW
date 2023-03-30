package com.example.demo;

import com.example.demo.datamodel.ProductData;
import com.example.demo.datamodel.ProductItem;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller{
    private List<ProductItem>productItems;
    @FXML
    private ListView<ProductItem> productListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private BorderPane mainBorderPane;
    public void initialize(){
//        ProductItem item1 = new ProductItem("хлеб", "белый","50","1");
//        ProductItem item2 = new ProductItem("молоко", "бел","80","1");
//        ProductItem item3 = new ProductItem("сыр", "маасдам","500","1");
//
//        productItems = new ArrayList<ProductItem>();
//        productItems.add(item1);
//        productItems.add(item2);
//        productItems.add(item3);
//
//        ProductData.getInstance().setProductItems(productItems);

        //listContextMenu.getItems().addAll(deleteMenuItem);
        productListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductItem>() {
            @Override
            public void changed(ObservableValue<? extends ProductItem> observable, ProductItem oldValue, ProductItem newValue) {
                if(newValue != null) {
                    ProductItem item = productListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                }
            }
        });

        productListView.getItems().setAll(ProductData.getInstance().getProductItems());
        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        productListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Product Item");
        dialog.setHeaderText("Use this dialog to create a new product item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("productItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            controller.processResults();
            productListView.getItems().setAll(ProductData.getInstance().getProductItems());

            System.out.println(" Ok pressed");

        }else {
            System.out.println(" Cancel pressed");
        }
    }


    @FXML
    public void handleClickListView(){
        ProductItem item = productListView.getSelectionModel().getSelectedItem();
        //System.out.println(" Выбран продукт " + item);
        itemDetailsTextArea.setText(item.getDetails());
    }


}
