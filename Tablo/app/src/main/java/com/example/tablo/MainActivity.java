package com.example.tablo;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int juventusCount = 0;
    int barcelonaCount = 0;

    Button CSharp, Java, Reset;
    TextView cSharp, java, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CSharp = (Button)findViewById(R.id.ButtCSharp);
        cSharp = (TextView)findViewById(R.id.CSharp);
        Java = (Button)findViewById(R.id.ButtJava);
        java = (TextView)findViewById(R.id.Java);
        Reset = (Button)findViewById(R.id.Reset);
        reset = (TextView)findViewById(R.id.reset);
        CSharpClick();
        JavaClick();
        ResetClick();

    }

    void CSharpClick(){
        CSharp.setOnClickListener(view -> {
            juventusCount++;
            cSharp.setText(String.valueOf(juventusCount));
            cSharp.setText(juventusCount+"");
            });
    }
    void JavaClick(){
        Java.setOnClickListener(view -> {
            barcelonaCount++;
            java.setText(String.valueOf(barcelonaCount));
            java.setText(barcelonaCount+"");
        });
    }
    void ResetClick(){
        Reset.setOnClickListener(view -> {
            juventusCount=0;
            barcelonaCount=0;

            resetUI();
        });
    }
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", (int) juventusCount);
        outState.putInt("count1", (int) barcelonaCount);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        juventusCount = savedInstanceState.getInt("count");
        barcelonaCount = savedInstanceState.getInt("count1");
        resetUI();
    }
    private void resetUI() {
        cSharp.setText(String.valueOf(juventusCount));
        cSharp.setText(juventusCount+"");
        java.setText(String.valueOf(barcelonaCount));
        java.setText(barcelonaCount+"");
        Log.d(TAG, "resetUI");
    }
}