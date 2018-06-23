package game.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends Activity implements View.OnClickListener {
    private TextView t1;
    private TextView t2;
    ImageButton button,button1;
    Button button2;
    Intent intent,intent1,intent2;
    public static boolean b = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("Выбери игрушку");

        button = (ImageButton)findViewById(R.id.car);
        button1 = (ImageButton)findViewById(R.id.home);
        button2 = (Button) findViewById(R.id.button2);

        t1 = (TextView) findViewById(R.id.text1);
        int s = Main2Activity.SumB;
        t1.setText("" + s);

        t2 = (TextView) findViewById(R.id.text2);
        int s1 = Main2Activity.SumR;
        t2.setText("" + s1);

        intent = new Intent(this, Car.class);
        intent1 = new Intent(this, Home.class);
        intent2 = new Intent(this, Main2Activity.class);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
                b = false;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
                b = true;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent1);
                b = false;
            }
        });
    }

    @Override
    public void onClick(View v) {

        }

}
