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
    private Double firstNumber = null ;

    private char ch;

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
        result.setText("");
    }

    public void numFunction(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void chFunction(View view) {
        Button button = (Button) view;
        ch = ((Button) view).getText().toString().charAt(0);
        if (!result.getText().toString().isEmpty()) {
            firstNumber = Double.parseDouble(result.getText().toString());
            result.setText("");
        }
    }

    public void eqFunction(View view) {
        if (!result.getText().toString().isEmpty() && ch !='\u0000') {
           action();
        }
    }

    public void clearFunction(View view) {
        if (!result.getText().toString().isEmpty())
            result.setText("");
    }

    public void dotFunction(View view) {
        if (result.getText().toString().contains("."))
            return ;
        else {
            if ((!result.getText().toString().isEmpty()) && (!result.getText().toString().equals(".")))
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
            result.setText(String.valueOf(firstNumber - secondNumber));
        }
        if (ch == '*') {
            result.setText(String.valueOf(firstNumber * secondNumber));
        }
        if (ch == '/') {
            result.setText(String.valueOf(firstNumber / secondNumber));
        }
        ch = '\u0000';
    }
}