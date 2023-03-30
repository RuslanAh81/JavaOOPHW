package com.example.demo;

import com.example.demo.datamodel.ProductData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Список продуктов");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        Main.launch();
    }
    @Override
    public void stop() throws Exception {
        try {
            ProductData.getInstance().storeProductItems();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            ProductData.getInstance().loadProductItems();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}