package com.example.demo.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ProductData {
    private static ProductData instance = new ProductData();
    private static String filename = "ProductListItems.txt";

    private ObservableList<ProductItem> productItems;


    public static ProductData getInstance() {
        return instance;
    }


    public ObservableList<ProductItem> getProductItems() {
        return productItems;
    }

    public void addProductItem(ProductItem item) {
        productItems.add(item);
    }

    public void loadProductItems() throws IOException {

        productItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String name = itemPieces[0];
                String details = itemPieces[1];
                String price = itemPieces[2];
                String dateString = itemPieces[3];

                Quantity = quantity.parse(dateString);
                ProductItem productItem = new ProductItem(name, details,price,quantity);
                productItems.add(productItem);
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<ProductItem> iter = productItems.iterator();
            while(iter.hasNext()) {
                ProductItem item = iter.next();
                ((BufferedWriter) bw).write(String.format("%s\t%s\t%s",
                        item.getName(),
                        item.getDetails(),
                        item.getPrice(),
                        item.getQuantity()));
                bw.newLine();
            }

        } finally {
            if(bw != null) {
                bw.close();
            }
        }
    }

    public void deleteProductItem(ProductItem item) {
        productItems.remove(item);
    }

}
