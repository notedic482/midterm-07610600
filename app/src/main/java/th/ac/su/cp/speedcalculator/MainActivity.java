package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

        private EditText Edis;
        private EditText Etime;
        private Button Cal;
        private TextView AV;
        private Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edis = (EditText)findViewById(R.id.Edis);
        Etime = (EditText)findViewById(R.id.Etime);
        Cal = (Button)findViewById(R.id.cal);
        AV = (TextView)findViewById(R.id.AV);
        clear = (Button)findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edis.setText("");
                Etime.setText("");
                AV.setText("");
            }
        });

       Cal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               EditText dis = findViewById(R.id.Edis);
               EditText time= findViewById(R.id.Etime);
               double d = Double.parseDouble(Edis.getText().toString());
               double ti = Double.parseDouble(Etime.getText().toString());
               double sum = d/ti;
               double Sum = sum/0.277778;
               String str = String.format( Locale.getDefault(), "%.2f", Sum);
               double S = Double.parseDouble(str);
               AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
               if(Edis.length()==0||Etime.length()==0){
                   Toast t= Toast.makeText(MainActivity.this, R.string.distimre,Toast.LENGTH_LONG);
                   t.show();
               }else if(ti <= 0){
                   Toast t= Toast.makeText(MainActivity.this, R.string.zero,Toast.LENGTH_LONG);
                   t.show();
               }else {
                   AV.setText(String.valueOf(S));
                   if(Sum>80.00){
                       dialog.setTitle("SPEED CALCULATOR");
                       dialog.setMessage(R.string.over);
                       dialog.setPositiveButton("Ok",null);
                       dialog.show();
                   }
               }




           }
       });
    }
}