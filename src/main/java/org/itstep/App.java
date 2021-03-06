package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) {
//        ImageView logoView = new ImageView();
//
//        Image image = new Image(pathToCard("itstep-logo.png"));
//
//        logoView.setImage(image);
//        logoView.setPreserveRatio(true);
//        logoView.setFitWidth(100);
//
//        playAnimation(logoView);
        // корневой узел
        Pane rootNode = new Pane();

        // метка - текст
        Label label_dealer = new Label("Dealer: 0");
        label_dealer.setFont(Font.font("Arial", 35));
        label_dealer.setTextFill(Paint.valueOf("white"));
        label_dealer.relocate(650, 10); // указываем местоположение метки - отступ по 10px сверху и слева
        Label label_player = new Label("Player: 0");
        label_player.setFont(Font.font("Arial", 35));
        label_player.setTextFill(Paint.valueOf("white"));
        label_player.relocate(650, 970); // указываем местоположение метки - отступ по 10px сверху и слева
        Label label_blackjack = new Label("Black Jack");
        label_blackjack.setFont(Font.font("TimesRoman", 140));
        label_blackjack.setTextFill(Paint.valueOf("white"));
        label_blackjack.relocate(400, 450); // указываем местоположение метки - отступ по 10px сверху и слева
        Label label_cash = new Label("Cash: 1000");
        label_cash.setFont(Font.font("Arial", 50));
        label_cash.setTextFill(Paint.valueOf("white"));
        label_cash.relocate(1500, 10); // указываем местоположение метки - отступ по 10px сверху и слева
        Label label_bet = new Label("BET");
        label_bet.setFont(Font.font("Arial", 50));
        label_bet.setTextFill(Paint.valueOf("white"));
        label_bet.relocate(1550, 530); // указываем местоположение метки - отступ по 10px сверху и слева


        // изображение
       /* Image image = new Image(pathToCard("cards/ace_of_clubs.png")); // загружаем изображение
        ImageView imageView = new ImageView(image);
        imageView.relocate(200, 10);
        imageView.setPreserveRatio(true); // сохраняем пропорции
        imageView.setFitWidth(100); // задаем размер изображения*/

        // поле ввода
        TextField textField = new TextField();
        textField.setFont(Font.font("Arial", 30));
        textField.relocate(1450, 630);

        // кнопки
        Button button_hit = new Button("HIT");
        button_hit.setFont(Font.font("Arial", 45));
        button_hit.relocate(1525, 230);
        Button button_stand = new Button("STAND");
        button_stand.setFont(Font.font("Arial", 45));
        button_stand.relocate(1500, 360);
        Button button_play = new Button("PLAY");
        button_play.setFont(Font.font("Arial", 45));
        button_play.relocate(1500, 900);
        //button.setOnAction((event) -> label_dealer.setText(textField.getText()));

        // прямоугольник
        Rectangle rectangle_black = new Rectangle(1920, 1080);
        rectangle_black.setFill(Paint.valueOf("black"));
        Rectangle rectangle_green = new Rectangle(1380, 1080);
        rectangle_green.setFill(Paint.valueOf("green"));



        // добавить метку в корневой узел
        rootNode.getChildren().add(rectangle_black);
        rootNode.getChildren().add(rectangle_green);
        rootNode.getChildren().add(label_dealer);
        rootNode.getChildren().add(label_player);
        rootNode.getChildren().add(label_blackjack);
        rootNode.getChildren().add(label_cash);
        rootNode.getChildren().add(label_bet);
        //rootNode.getChildren().add(imageView);
        rootNode.getChildren().add(button_hit);
        rootNode.getChildren().add(button_stand);
        rootNode.getChildren().add(button_play);
        rootNode.getChildren().add(textField);

        // создать сцену
        Scene scene = new Scene(rootNode, 1920, 1010);

        // установить сцену в окне
        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}