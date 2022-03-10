package com.dthaveesha.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean leftTextView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Get numbers to left text view*/
    public void textView(View v) {
        if (leftTextView) {
            String text = ((Button) v).getText().toString();
            ((TextView) findViewById(R.id.left_number)).append(text);

        } else if (!leftTextView) {
            String text = ((Button) v).getText().toString();
            ((TextView) findViewById(R.id.right_number)).append(text);
        }
    }

    public void allClear(View ac) {
        ((TextView)findViewById(R.id.left_number)).setText("");
        ((TextView)findViewById(R.id.operator)).setText("");
        ((TextView)findViewById(R.id.right_number)).setText("");
        ((TextView)findViewById(R.id.answer)).setText("");
        leftTextView = true;
    }


    public void operator(View op) {
        leftTextView = false;
        String calculation = ((Button) op).getText().toString();
        ((TextView) findViewById(R.id.operator)).setText(calculation);
        Log.d("calc", calculation);

        ((TextView)findViewById(R.id.answer)).setText(String.valueOf(((TextView)findViewById(R.id.left_number)).getText()));

    }

    public void equals(View eq) {
        String operation = String.valueOf(((TextView)findViewById(R.id.operator)).getText());
        Log.d("calc", operation.getClass().getName());

        String leftValue = String.valueOf(((TextView)findViewById(R.id.left_number)).getText());
        Log.d("calc", leftValue);

        String rightValue = String.valueOf(((TextView)findViewById(R.id.right_number)).getText());
        Log.d("calc", rightValue);

        if (operation.equals("+")) {
            Log.d("calc", operation);
            float ans = Float.parseFloat(leftValue) + Float.parseFloat(rightValue);
            Log.d("calc", String.valueOf(ans));

            ((TextView)findViewById(R.id.answer)).setText(String.valueOf(ans));
        }
        else if (operation.equals("-")) {
            Log.d("calc", operation);
            float ans = Float.parseFloat(leftValue) - Float.parseFloat(rightValue);
            Log.d("calc", String.valueOf(ans));

            ((TextView) findViewById(R.id.answer)).setText(String.valueOf(ans));
        }
        else if (operation.equals("×")) {
            Log.d("calc", operation);
            float ans = Float.parseFloat(leftValue) * Float.parseFloat(rightValue);
            Log.d("calc", String.valueOf(ans));

            ((TextView) findViewById(R.id.answer)).setText(String.valueOf(ans));
        }
        else if (operation.equals("÷")) {
            Log.d("calc", operation);
            float ans = Float.parseFloat(leftValue) / Float.parseFloat(rightValue);
            Log.d("calc", String.valueOf(ans));

            ((TextView) findViewById(R.id.answer)).setText(String.valueOf(ans));
        }



        ((TextView)findViewById(R.id.left_number)).setText(String.valueOf(((TextView)findViewById(R.id.answer)).getText()));
        ((TextView)findViewById(R.id.right_number)).setText("");

    }

    public void sqRoot(View sq) {
        String operation = String.valueOf(((TextView)findViewById(R.id.operator)).getText());

        String leftValue = String.valueOf(((TextView)findViewById(R.id.left_number)).getText());

        double root = Double.parseDouble(leftValue);
        double ans = Math.sqrt(root);

        ((TextView)findViewById(R.id.left_number)).setText("");
        ((TextView) findViewById(R.id.answer)).setText(String.valueOf(ans));
    }


}