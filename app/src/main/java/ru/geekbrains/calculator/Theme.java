package ru.geekbrains.calculator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Theme extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
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
        switch (view.getId()) {
            case (R.id.rb_themeDefault):
                setAppTheme(R.style.MyStyle);
                break;
            case (R.id.rb_themeBlue):
                setAppTheme(R.style.myThemeBlue);
                break;
            case (R.id.rb_themePurple):
                setAppTheme(R.style.myThemePurple);
                break;
            case (R.id.rb_themeGreen):
                setAppTheme(R.style.myThemeGreen);
                break;
        }
        setResult(RESULT_OK);
        finish();
    }

    public void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(MainActivity.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(MainActivity.PREF_KEY_THEME, codeStyle);
        editor.apply();
    }

    public int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(MainActivity.PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(MainActivity.PREF_KEY_THEME,R.style.MyStyle);
    }

}
