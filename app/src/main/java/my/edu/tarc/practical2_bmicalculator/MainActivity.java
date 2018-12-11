package my.edu.tarc.practical2_bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMessage1;
    private EditText editTextMessage2;
    public static final String TAG_MESSAGE = "my.edu.tarc.practical2_bmicalculator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage1 = findViewById(R.id.editTextWeight);
        editTextMessage2 = findViewById(R.id.editTextHeight);
    }

    public void calculateBMI(View view){
        if(TextUtils.isEmpty(editTextMessage1.getText())){
            editTextMessage1.setError(getString(R.string.error_message));
            return;
        }

        if(TextUtils.isEmpty(editTextMessage2.getText())){
            editTextMessage2.setError(getString(R.string.error_message));
            return;
        }

        String stringMsg;

        stringMsg = editTextMessage1.getText().toString();
        Double weight1 = Double.parseDouble(stringMsg);

        stringMsg = editTextMessage2.getText().toString();
        Double height1 = Double.parseDouble(stringMsg);

        height1 /= 100;
        height1 *= height1;

        Double BMI = weight1 / height1;

        stringMsg = BMI.toString();


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, stringMsg);
        startActivity(intent);
    }
}
