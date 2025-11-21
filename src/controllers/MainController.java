package controllers;
import javafx.application.Application;
import views.POSApplication;
public class MainController {
    public static void main(String[] args)
    {
        System.out.println("Starting ... ");



        Application.launch(POSApplication.class, args);
        System.out.println("Started ");

    }
}
