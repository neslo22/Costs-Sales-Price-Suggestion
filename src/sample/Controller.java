package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.text.DecimalFormat;
import java.text.ParseException;

public class Controller {

    @FXML TextField incrementCost_Text, incrementPrice_Text, incrementIncome_Text, cost_Text, price_Text, income_Text;
    @FXML Button decreaseCost_Button, increaseCost_Button, decreasePrice_Button, increasePrice_Button, decreaseIncome_Button, increaseIncome_Button;
    @FXML RadioButton cost_Radio, price_Radio, income_Radio;
    Predictions predict = new Predictions();
    private DecimalFormat df2 = new DecimalFormat("###.##");

    @FXML private void decreaseCost(){
        cost_Text.setText(increaseDecrease(cost_Text,incrementCost_Text,false));
        executePrediction();
    }
    @FXML private void increaseCost(){
        cost_Text.setText(increaseDecrease(cost_Text,incrementCost_Text,true));
        executePrediction();
    }
    @FXML private void decreasePrice(){
        price_Text.setText(increaseDecrease(price_Text,incrementPrice_Text,false));
        executePrediction();
    }
    @FXML private void increasePrice(){
        price_Text.setText(increaseDecrease(price_Text,incrementPrice_Text,true));
        executePrediction();
    }
    @FXML private void decreaseIncome(){
        income_Text.setText(increaseDecrease(income_Text,incrementIncome_Text,false));
        executePrediction();
    }
    @FXML private void increaseIncome(){
        income_Text.setText(increaseDecrease(income_Text,incrementIncome_Text,true));
        executePrediction();
    }
    @FXML private void executePrediction(){
        if(cost_Radio.isSelected() && !price_Text.getText().isEmpty() && !income_Text.getText().isEmpty())
            cost_Text.setText(String.valueOf(Double.valueOf(df2.format(predict.predictCost(Double.parseDouble(price_Text.getText()), Double.parseDouble(income_Text.getText()))))));

        else if(price_Radio.isSelected() && !cost_Text.getText().isEmpty() && !income_Text.getText().isEmpty())
            price_Text.setText(String.valueOf(Double.valueOf(df2.format(predict.predictPrice(Double.parseDouble(cost_Text.getText()), Double.parseDouble(income_Text.getText()))))));

        else if(income_Radio.isSelected() && !cost_Text.getText().isEmpty() && !price_Text.getText().isEmpty())
            income_Text.setText(String.valueOf(Double.valueOf(df2.format(predict.predictIncome(Double.parseDouble(cost_Text.getText()), Double.parseDouble(price_Text.getText()))))));
    }
    @FXML private void predictCost(){
        enableInputs();
        decreaseCost_Button.setDisable(true);
        increaseCost_Button.setDisable(true);
        cost_Text.setDisable(true);
    }
    @FXML private void predictPrice(){
        enableInputs();
        decreasePrice_Button.setDisable(true);
        increasePrice_Button.setDisable(true);
        price_Text.setDisable(true);
    }
    @FXML private void predictIncome(){
        enableInputs();
        decreaseIncome_Button.setDisable(true);
        increaseIncome_Button.setDisable(true);
        income_Text.setDisable(true);
    }
    private void enableInputs(){
        decreaseCost_Button.setDisable(false);
        increaseCost_Button.setDisable(false);
        cost_Text.setDisable(false);
        decreasePrice_Button.setDisable(false);
        increasePrice_Button.setDisable(false);
        price_Text.setDisable(false);
        decreaseIncome_Button.setDisable(false);
        increaseIncome_Button.setDisable(false);
        income_Text.setDisable(false);
    }
    private String increaseDecrease(TextField x, TextField y, boolean increase){
        if(increase)
            return String.valueOf(Double.valueOf(df2.format(Double.parseDouble(x.getText()) + Double.parseDouble(y.getText()))));
        else{
            return String.valueOf(Double.valueOf(df2.format(Double.parseDouble(x.getText()) - Double.parseDouble(y.getText()))));
        }
    }



}
