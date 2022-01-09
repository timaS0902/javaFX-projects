package com.example.currencyconverter;

import com.example.currencyconverter.animation.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CurrencyController {
ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> choiceCurrency;

    @FXML
    private TextField valueCur;

    @FXML
    private Button convert;

    @FXML
    private TextField firstCur;

    @FXML
    private TextField secondCur;

    @FXML
    private TextField thirdCur;

    @FXML
    void displayValue(ActionEvent event) {
        String currency = choiceCurrency.getValue();
        if(currency == null)
        {
            Shake choice = new Shake(choiceCurrency);            //animation
            choice.playAnim();
        }
        else
        {
            convertCurrency();
        }
    }

    public void initialize()
    {
        loadData();
    }

    private void convertCurrency()
    {
        String currency = choiceCurrency.getValue();
        switch (currency) {
            case "RUB Ruble" -> {
                double ruble = Integer.parseInt(valueCur.getText());
                double rubleToDollar = Math.ceil(ruble * 0.013 * 100) / 100.0;
                firstCur.setText(rubleToDollar + " USD Dollar");
                double rubleToSum = Math.ceil(ruble * 146 * 100) / 100.0;
                secondCur.setText(rubleToSum + " UZS Sum");
                double rubleToEuro = (Math.ceil(ruble * 0.012 * 100) / 100.0);
                thirdCur.setText(rubleToEuro + " EUR Euro");
            }
            case "USD Dollar" -> {
                double dollar = Integer.parseInt(valueCur.getText());
                double dollarToRuble = Math.ceil(dollar * 74.62 * 100) / 100.0;
                firstCur.setText(dollarToRuble + " RUB Ruble");
                double dollarToSum = Math.ceil(dollar * 10867.27 * 100) / 100.0;
                secondCur.setText(dollarToSum + " UZS Sum");
                double dollarToEuro = Math.ceil(dollar * 0.88 * 100) / 100.0;
                thirdCur.setText(dollarToEuro + " EUR Euro");
            }
            case "UZS Sum" -> {
                double sum = Integer.parseInt(valueCur.getText());
                double sumToDollar = Math.ceil(sum * 0.000092 * 100) / 100.0;
                firstCur.setText(sumToDollar + " USD Dollar");
                double sumToRuble = Math.ceil(sum * 0.0069 * 100) / 100.0;
                secondCur.setText(sumToRuble + " RUB Ruble");
                double sumToEuro = Math.ceil(sum * 0.000081 * 100) / 100.0;
                thirdCur.setText(sumToEuro + " EUR Euro");
            }
            case "EUR Euro" -> {
                double euro = Integer.parseInt(valueCur.getText());
                double euroToDollar = Math.ceil(euro * 1.13 * 100) / 100.0;
                firstCur.setText(euroToDollar + " USD Dollar");
                double euroToRuble = Math.ceil(euro * 84.34 * 100) / 100.0;
                secondCur.setText(euroToRuble + " RUB Ruble");
                double euroToSum = Math.ceil(euro * 12280.88 * 100) / 100.0;
                thirdCur.setText(euroToSum + " UZS Sum");
            }
        }
    }

    private void loadData()
    {
        list.removeAll(list);
        String dollar = "USD Dollar";
        String ruble = "RUB Ruble";
        String sum = "UZS Sum";
        String euro = "EUR Euro";
        list.addAll(dollar,ruble,sum,euro);
        choiceCurrency.getItems().addAll(list);
    }
}