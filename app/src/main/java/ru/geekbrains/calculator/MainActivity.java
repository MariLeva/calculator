package ru.geekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private TextView tv_A;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;
    private Button btnCE;
    private Button btnC;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnEquals;
    private Button btnPoint;
    private Button btnPercent;

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListenet();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        calculator.setVar_a((String) tv_A.getText());
        calculator.setVar_b((String) tv_result.getText());
        instanceState.putSerializable("calculator", calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculator = (Calculator) instanceState.getSerializable("calculator");
        tv_A.setText((String.valueOf(calculator.getVar_a())));
        tv_result.setText((String.valueOf(calculator.getVar_b())));
    }


    private void initView() {
        tv_result = findViewById(R.id.tv_result);
        tv_A = findViewById(R.id.tv_A);
        btnOne = findViewById(R.id.button1);
        btnTwo = findViewById(R.id.button2);
        btnThree = findViewById(R.id.button3);
        btnFour = findViewById(R.id.button4);
        btnFive = findViewById(R.id.button5);
        btnSix = findViewById(R.id.button6);
        btnSeven = findViewById(R.id.button7);
        btnEight = findViewById(R.id.button8);
        btnNine = findViewById(R.id.button9);
        btnZero = findViewById(R.id.button0);
        btnC = findViewById(R.id.button_C);
        btnCE = findViewById(R.id.button_CE);
        btnAdd = findViewById(R.id.button_add);
        btnSub = findViewById(R.id.button_sub);
        btnMul = findViewById(R.id.button_mul);
        btnDiv = findViewById(R.id.button_div);
        btnPoint = findViewById(R.id.button_point);
        btnEquals = findViewById(R.id.button_equals);
        btnPercent = findViewById(R.id.button_percent);
    }

    private void setListenet() {
        btnOne.setOnClickListener(listener);
        btnTwo.setOnClickListener(listener);
        btnThree.setOnClickListener(listener);
        btnFour.setOnClickListener(listener);
        btnFive.setOnClickListener(listener);
        btnSix.setOnClickListener(listener);
        btnSeven.setOnClickListener(listener);
        btnEight.setOnClickListener(listener);
        btnNine.setOnClickListener(listener);
        btnZero.setOnClickListener(listener);
        btnC.setOnClickListener(listener);
        btnCE.setOnClickListener(listener);
        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
        btnPoint.setOnClickListener(listener);
        btnPercent.setOnClickListener(listener);
        btnEquals.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            switch (view.getId()) {
                case (R.id.button1):
                case (R.id.button2):
                case (R.id.button3):
                case (R.id.button4):
                case (R.id.button5):
                case (R.id.button6):
                case (R.id.button7):
                case (R.id.button8):
                case (R.id.button9):
                case (R.id.button0):
                case (R.id.button_point): {
                    tv_result.setText(String.format("%s%s", tv_result.getText(), btn.getText()));
                    break;
                }
                case (R.id.button_C): {
                    tv_result.setText("");
                    tv_A.setText("");
                    break;
                }
                case (R.id.button_CE): {
                    tv_result.setText("");
                    break;
                }
                case (R.id.button_add):
                case (R.id.button_sub):
                case (R.id.button_mul):
                case (R.id.button_div): {
                    setA_cleanResult();
                    calculator.setOperation((String) btn.getText());
                    break;
                }
                case (R.id.button_percent): {
                    tv_result.setText(calculator.percent(Float.parseFloat((String) tv_A.getText()), Float.parseFloat((String) tv_result.getText())));
                    tv_A.setText("");
                    break;
                }
                case (R.id.button_equals): {
                    tv_result.setText(calculator.equals(Float.parseFloat((String) tv_A.getText()), Float.parseFloat((String) tv_result.getText())));
                    tv_A.setText("");
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }
    };

    public void setA_cleanResult() {
        tv_A.setText(tv_result.getText());
        tv_result.setText("");
    }
}