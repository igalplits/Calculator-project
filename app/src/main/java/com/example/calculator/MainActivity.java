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
    private calculator  calculator;

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
        calculator = new calculator();
    }

    public void numFunction(View view) {
        Button button = (Button) view;
        String currentText = result.getText().toString();
        if(calculator.getOperator() != '\u0000' && String.valueOf(calculator.getFirstNumber()).equals(currentText))
        {result.setText(button.getText().toString());}
        else if (currentText.equals("0")) {
            result.setText(button.getText().toString());
        } else {
            result.append(button.getText().toString());
        }
    }



    public void chFunction(View view) {
        String currentText = result.getText().toString();
        if(calculator.getOperator() != '\u0000' && !currentText.contains("-") && !currentText.isEmpty())
        {
            double secondNumber = Double.parseDouble(currentText);
            double resultValue = calculator.calculate(secondNumber);
            result.setText(String.valueOf(resultValue));
            calculator.setFirstNumber(Double.parseDouble(result.getText().toString()));

        }
        else if (!currentText.isEmpty()) {
        calculator.setFirstNumber(Double.parseDouble(result.getText().toString()));
        Button button = (Button) view;
        calculator.setOperator(button.getText().toString().charAt(0));
        result.setText("");
        }

    }



    public void eqFunction(View view) {
        try {
            double secondNumber = Double.parseDouble(result.getText().toString());
            double resultValue = calculator.calculate(secondNumber);
            result.setText(String.valueOf(resultValue));
        } catch (ArithmeticException | IllegalStateException e) {
            result.setText("Error");
        }
    }

    public void clearFunction(View view) {
        calculator.clear();
        result.setText("0");
    }

    public void dotFunction(View view) {
        String currentText = result.getText().toString();
        if (!currentText.contains(".")) {
            result.append(".");
        }
    }
}
