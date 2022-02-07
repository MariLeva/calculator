package ru.geekbrains.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Theme extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        findViewById();
    }

    private void findViewById(){
        ((RadioButton) findViewById(R.id.rb_themeDefault)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.rb_themePurple)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.rb_themeBlue)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.rb_themeGreen)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.rb_themeDefault):
                break;
            case (R.id.rb_themeBlue):
                break;
            case (R.id.rb_themePurple):
                break;
            case (R.id.rb_themeGreen):
                break;
        }
        finish();
    }
}
