package sample.validateFields;

import javafx.scene.control.TextField;

import java.text.ParseException;

public class NumberTextField extends TextField {

    public NumberTextField() {

    }
    @Override
    public void replaceText(int i, int i1, String string) {
        //if(string.matches("[0-9]") || string.isEmpty() || string.matches(".") ){
        if((getText()+string).matches("(\\d*(?:\\.\\d*)?)")){
            super.replaceText(i, i1, string);
        }
    }

    @Override
    public void replaceSelection(String string) {
        super.replaceSelection(string);
    }
}
