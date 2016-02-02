package com.example.cs1120224.testcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.app.ActionBarActivity;
import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //////
    TextView disp;
    public boolean isEmpty;
    double accumulator=0.0;
    short prevOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp=(TextView)findViewById(R.id.textView);
        disp.setText("0");
        isEmpty=true;
        accumulator=0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void num_clicked(View sender)
    {
        Button bt = (Button)sender;
        if(disp.getText().length()>10)return;
        if( isEmpty || Double.parseDouble(disp.getText().toString())==0) {
            disp.setText(bt.getText());
            isEmpty=false;
        }
        else {
            disp.append(bt.getText());
        }
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

    public void op_Clicked(View sender)
    {
        Button bt = (Button)sender;
        String nextOp = bt.getText().toString();
        switch(prevOperation) {
            case 1:
                accumulator += Double.parseDouble(disp.getText().toString());
                disp.setText(Double.toString(accumulator));
                break;
            case 2:
                accumulator -= Double.parseDouble(disp.getText().toString());
                disp.setText(Double.toString(accumulator));
                break;
//            case 3:
//                accumulator = Double.parseDouble(disp.getText().toString());
//                break;
            default: ////// 0
                accumulator = Double.parseDouble(disp.getText().toString());
                break;
        }
        if(nextOp.equals("+")) prevOperation=1;
        else if(nextOp.equals("-")) prevOperation=2;
        else if(nextOp.equals("=")) prevOperation=0;
        isEmpty=true;


    }




}
