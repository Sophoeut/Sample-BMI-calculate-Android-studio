package com.example.bmicalculator;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        onclickbuttonListener();
        onclickbuttonlisteners();

    }
    public void onclickbuttonListener(){
        Button button=(Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final EditText heightText=(EditText) findViewById(R.id.Editheight);
                String heightstr= heightText.getText().toString();
                double height=Double.parseDouble(heightstr);
                final EditText weighttext=(EditText) findViewById(R.id.EditWeight);
                String weightstr=weighttext.getText().toString();
                double weight=Double.parseDouble(weightstr);
                double BMItext=(weight)/(height)*(height);
                final EditText BMIresult=(EditText)findViewById(R.id.bmiresultext);
                BMIresult.setText(Double.toString(BMItext));
                String CAT_BMI;
                if(BMItext<15){
                    CAT_BMI="very underweight severe";
                }else if(BMItext<16){
                    CAT_BMI="severe underweight";
                }else if(BMItext<18.5){
                CAT_BMI="underweight";

                }else if(BMItext<25){
                CAT_BMI="Normal";

                }else if(BMItext<30){
                    CAT_BMI="Over weight";

                }else if(BMItext<35){
                    CAT_BMI="Obese1-Moderately Obese!";

                }else if(BMItext<40){
                    CAT_BMI="Obese2-Severely Obese!";

                }else{

                    CAT_BMI="Obese 3-Very Severe Obese!!";
                }
                  final TextView ViewResult=(TextView)findViewById(R.id.textViewBMI);
                    ViewResult.setText(CAT_BMI);
            }
        });

    }

    public void onclickbuttonlisteners(){
        final Button buttonNew=(Button)findViewById(R.id.AddbtnNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText heightText=(EditText) findViewById(R.id.Editheight);
                heightText.setText("");
                final EditText weighttext=(EditText) findViewById(R.id.EditWeight);
                weighttext.setText("");
                final EditText BMIresult=(EditText)findViewById(R.id.bmiresultext);
                BMIresult.setText("");
                final TextView ViewResult=(TextView)findViewById(R.id.textViewBMI);
                ViewResult.setText("");
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}