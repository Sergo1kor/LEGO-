package game.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
setTitle("Lego Cтроитель");
        Button startBtn = (Button) findViewById(R.id.button);
        startBtn.setOnClickListener((View.OnClickListener) this);


    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;

                default:break;
        }


    }
}
