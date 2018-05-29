package com.example.akshay.gstcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

//import android.widget.SeekBar.setOnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextObj;
    private SeekBar seekBar;
    private Button calculateButton;
    protected TextView seekpercent;
    protected TextView result;
    protected int gstPercent;
    private float enteredAmount;
    protected TextView finalbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextObj = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        calculateButton = (Button) findViewById(R.id.button);
        seekpercent = (TextView) findViewById(R.id.textView5);
        result = (TextView) findViewById(R.id.textView2);
        finalbill = (TextView) findViewById(R.id.textView3);



        calculateButton.setOnClickListener(this);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekpercent.setText(String.valueOf(seekBar.getProgress())+"%  ");
                result.setText("");
                finalbill.setText("");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                gstPercent = seekBar.getProgress();
            }
        });
        }

    @Override
    public void onClick(View view) {calculate();
    }


    public void calculate(){
        float result1 = 0.0f;
        if (!editTextObj.getText().toString().equals("")){
            enteredAmount = Float.parseFloat(editTextObj.getText().toString());
            result1 = (enteredAmount * gstPercent)/100;
            result.setText("Your G.S.T will be : " + String.valueOf(result1));
            finalbill.setText("Total Bill : " + String.valueOf(result1+enteredAmount));

        }else {
            Toast.makeText(MainActivity.this,"Please enter bill amount !",Toast.LENGTH_LONG).show();
        }
    }

}
