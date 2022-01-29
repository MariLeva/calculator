package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private TextView tv_A;
    private Button btnOne; private Button btnTwo; private Button btnThree;
    private Button btnFour; private Button btnFive; private Button btnSix;
    private Button btnSeven; private Button btnEight; private Button btnNine;
    private Button btnZero; private Button btnCE; private Button btnC;
    private Button btnAdd; private Button btnSub; private Button btnMul;
    private Button btnDiv; private Button btnEquals; private Button btnPoint;
    private Button btnPercent;
    private String operation = "";

    private float result = 0;
    private float var_a = 0;
    private float var_b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListenet();
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

    private void setListenet(){
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

            switch (view.getId()) {
                case (R.id.button1): {
                    tv_result.setText(tv_result.getText() + "1");
                    break;
                }
                case (R.id.button2): {
                    tv_result.setText(tv_result.getText() + "2");
                    break;
                }
                case (R.id.button3): {
                    tv_result.setText(tv_result.getText() + "3");
                    break;
                }
                case (R.id.button4): {
                    tv_result.setText(tv_result.getText() + "4");
                    break;
                }
                case (R.id.button5): {
                    tv_result.setText(tv_result.getText() + "5");
                    break;
                }
                case (R.id.button6): {
                    tv_result.setText(tv_result.getText() + "6");
                    break;
                }
                case (R.id.button7): {
                    tv_result.setText(tv_result.getText() + "7");
                    break;
                }
                case (R.id.button8): {
                    tv_result.setText(tv_result.getText() + "8");
                    break;
                }
                case (R.id.button9): {
                    tv_result.setText(tv_result.getText() + "9");
                    break;
                }
                case (R.id.button0): {
                    tv_result.setText(tv_result.getText() + "0");
                    break;
                }
                case (R.id.button_point): {
                    tv_result.setText(tv_result.getText() + ".");
                    break;
                }
                case (R.id.button_C): {
                    tv_result.setText("");
                    break;
                }
                case (R.id.button_CE): {
                    tv_result.setText("");
                    tv_A.setText("");
                    operation = "";
                    break;
                }
                case (R.id.button_add): {
                    tv_A.setText(tv_result.getText());
                    tv_result.setText("");
                    operation = "add";
                    break;
                }
                case (R.id.button_sub): {
                    tv_A.setText(tv_result.getText());
                    tv_result.setText("");
                    operation = "sub";
                    break;
                }
                case (R.id.button_mul): {
                    tv_A.setText(tv_result.getText());
                    tv_result.setText("");
                    operation = "mul";
                    break;
                }
                case (R.id.button_div): {
                    tv_A.setText(tv_result.getText());
                    tv_result.setText("");
                    operation = "div";
                    break;
                }
                case (R.id.button_percent): {
                    tv_A.setText(tv_result.getText());
                    tv_result.setText("");
                    operation = "percent";
                    break;
                }
                 case (R.id.button_equals): {
                    if (operation.equalsIgnoreCase("add")){
                        result = Float.valueOf(String.valueOf(tv_A.getText())) + Float.valueOf(String.valueOf(tv_result.getText()));
                        tv_result.setText(Float.toString(result));
                    } else if (operation.equalsIgnoreCase("sub")){
                        result = Float.valueOf(String.valueOf(tv_A.getText())) - Float.valueOf(String.valueOf(tv_result.getText()));
                        tv_result.setText(Float.toString(result));
                    } else if (operation.equalsIgnoreCase("mul")){
                        result = Float.valueOf(String.valueOf(tv_A.getText())) * Float.valueOf(String.valueOf(tv_result.getText()));
                        tv_result.setText(Float.toString(result));
                    } else if (operation.equalsIgnoreCase("div")){
                        result = Float.valueOf(String.valueOf(tv_A.getText())) / Float.valueOf(String.valueOf(tv_result.getText()));
                        tv_result.setText(Float.toString(result));
                    } else if (operation.equalsIgnoreCase("percent")){
                        result = Float.valueOf(String.valueOf(tv_A.getText())) * Float.valueOf(String.valueOf(tv_result.getText())) / 100;
                        tv_result.setText(Float.toString(result));}

                    break;
                }
            }
        }
    };
}