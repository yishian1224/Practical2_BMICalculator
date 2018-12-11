package my.edu.tarc.practical2_bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private double BMI;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewMsg;
        textViewMsg = findViewById(R.id.textViewMessage);

        imageView = findViewById(R.id.imageView1);
        //Read the extra value
        Intent intent = getIntent(); //Who called me
        if(intent.hasExtra(MainActivity.TAG_MESSAGE)){
            String stringMsg;
            stringMsg =  intent.getStringExtra(MainActivity.TAG_MESSAGE);
            BMI = Double.parseDouble(stringMsg);
            textViewMsg.setText(stringMsg);
        }

        if(BMI <= 18.5){
            //Under
            textViewMsg.setText("Your BMI is " + BMI + ". You are under weight.");
            imageView.setImageResource(R.drawable.under);

        }
        else if(BMI > 18.5 && BMI < 25){
            //Normal
            textViewMsg.setText("Your BMI is " + BMI + ". You are normal weight.");
            imageView.setImageResource(R.drawable.normal);

        }
        else{
            //Over
            textViewMsg.setText("Your BMI is " + BMI + ". You are over weight.");
            imageView.setImageResource(R.drawable.over);

        }
    }
}
