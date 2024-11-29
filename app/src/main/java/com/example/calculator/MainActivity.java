package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Double firstNumber = 0.0;
    private char ch;
    private final char charNull = '\u0000' ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.textViewResult);
        result.setText("0");
    }

    public void numFunction(View view) {
        Button button = (Button) view;
        if (ch!=charNull && firstNumber.toString().equals(result.getText().toString())) {
            result.setText(button.getText().toString());
        }
       else if (result.getText().toString().equals("0"))
           result.setText(button.getText().toString());

       else
           result.append(button.getText().toString());
    }

    public void chFunction(View view) {
//
            if (ch != charNull && !result.getText().toString().contains("-") && !result.getText().toString().isEmpty()) {
                action();
                chgetNumber(view);
                firstNumber = Double.parseDouble(result.getText().toString());
            }
            else if (!result.getText().toString().isEmpty()) {
                    chgetNumber(view);
                    firstNumber = Double.parseDouble(result.getText().toString());
                    result.setText("");
            }

    }


    public void eqFunction(View view) {
        if ( ch != charNull) {
           action();
        }
    }

    public void clearFunction(View view) {
        cleanScreen();
        ch = charNull;
    }

    public void dotFunction(View view) {
        if (result.getText().toString().contains("."))
            return ;
        else {
            if ( (!result.getText().toString().equals(".")))
                result.append(".");
        }
    }

    public void action(){
        double secondNumber;
        secondNumber = Double.parseDouble(result.getText().toString());
        if (ch == '+') {
            result.setText(String.valueOf(firstNumber + secondNumber));
        }
        if (ch == '-') {
            secondNumber = -secondNumber;
            result.setText(String.valueOf(firstNumber + secondNumber));
        }
        if (ch == '*') {
            result.setText(String.valueOf(firstNumber * secondNumber));
        }
        if (ch == '/') {
            result.setText(String.valueOf(firstNumber / secondNumber));
        }
        ch = charNull;

    }

    public void chgetNumber(View view){
        Button button = (Button) view;
        ch = ((Button) view).getText().toString().charAt(0);
    }

    public void cleanScreen() {
            result.setText("0");
    }


}