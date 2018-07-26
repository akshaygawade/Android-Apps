package com.example.akshay.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_stbd;

    static final int Dialog_id=0;
    int hour_x;
    int min_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTimePickerDialog();

    }

public void showTimePickerDialog(){

    button_stbd=(Button)findViewById(R.id.button);

    button_stbd.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View v){

                showDialog(Dialog_id);
            }

        }
    );

}
@Override
protected Dialog onCreateDialog(int id){

if (id==Dialog_id)
    return new TimePickerDialog(MainActivity.this,  kTimepickerListener,hour_x, min_x, false);

return  null;

}

    protected TimePickerDialog.OnTimeSetListener kTimepickerListener = new
        TimePickerDialog.OnTimeSetListener()
        {
@Override
public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    hour_x = hourOfDay;
    min_x = minute;

    Toast.makeText(MainActivity.this, hour_x+" : "+min_x, Toast.LENGTH_LONG).show();
        }
        };



public boolean onCreateOptionMenu(Menu menu){


//getMenuInflater().inflate(R.menu.menu_main,menu);


return  true;

}

}

