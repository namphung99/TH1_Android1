package com.example.sum2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText so1, so2;
    Button submit;
    TextView tvRes;
    RadioButton cong, tru, nhan, chia;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        submit.setOnClickListener(this);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void initView(){
        so1 = (EditText) findViewById(R.id.so1);
        so2 = (EditText) findViewById(R.id.so2);
        submit = (Button) findViewById(R.id.btn);
        tvRes = (TextView) findViewById(R.id.tvRes);
        sp = (Spinner) findViewById(R.id.sp);

        String[] st = sp.getResources().getStringArray(R.array.op);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item,st);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(adapter);
    }

    private String cal (String op, double s1, double s2){
        String res ="";
        switch (op){
            case "+":
                res = "Sum = " + (s1 + s2);
                break;
            case "-":
                res = "Sub = " + (s1 - s2);
                break;

            case "x":
                res = " Mul = " + (s1 * s2);
                break;
            case "/":
                if(s2 == 0){
                    res = "khong the chia cho 0";
                }
                else {
                    res = "Div = " + (s1 / s2);
                }
                break;
        }
        return res;
    }

    @Override
    public void onClick(View v) {
        double s1,s2;
        s1 = Double.parseDouble(so1.getText().toString());
        s2 = Double.parseDouble(so2.getText().toString());
        if(v == submit){
            String op = sp.getSelectedItem().toString();
            String text = cal(op,s1,s2);
            tvRes.setText(text);
        }
    }
}