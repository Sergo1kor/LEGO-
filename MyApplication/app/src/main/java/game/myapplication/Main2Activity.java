package game.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements OnTouchListener {

    int width=0;
    int height=0;
    Random random;
    Intent intent;
    public static int k=0, SumR = 0,SumB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = new Intent(this, Main3Activity.class);
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        random = new Random();
        if (Car.New || Home.New) {SumR = 0;SumB = 0;}

        //if (Main3Activity.b)
        k =0;
        Main2Activity.GraphicsView myview = new Main2Activity.GraphicsView(this);
       setContentView(myview);
    }
    public class GraphicsView extends View {


        public GraphicsView(Context context) {
            super(context);
        }
        float touchX0 = 50, touchY0 = height-350;
        float touchX = random.nextInt(height);
        float touchX1 = random.nextInt(height);
        float touchX2 = random.nextInt(height);
        float touchX3 = random.nextInt(height);
        float touchX4 = random.nextInt(height);
        float touchX5 = random.nextInt(height);
        float touchX6 = random.nextInt(height);
        float touchX7 = random.nextInt(height);
        float touchX8 = random.nextInt(height);
        float touchX9 = random.nextInt(height);
        float touchY = 0,touchY1 = -random.nextInt(500),touchY2 = -random.nextInt(500),touchY3 = -random.nextInt(500);
        float touchY4 = -random.nextInt(500),touchY5 = -random.nextInt(500),touchY6 = -random.nextInt(500);
        float touchY7 = -random.nextInt(500),touchY8 = -random.nextInt(500),touchY9 = -random.nextInt(500);


        @Override
        protected void onDraw(Canvas canvas) {

            setTitle("Ты собрал: "+SumR+" красных деталей и " + SumB+ " синих");

            Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kk);
            Bitmap myBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.kk2);

            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.car), touchX0,touchY0 , null);

            boolean XY=true,XY1=true,XY2=true,XY3=true,XY4=true,XY5=true,XY6=true,XY7=true,XY8=true,XY9=true;

            canvas.drawBitmap(myBitmap, touchX, touchY, null);
           canvas.drawBitmap(myBitmap1, touchX1, touchY1, null);
           canvas.drawBitmap(myBitmap, touchX2, touchY2, null);
           canvas.drawBitmap(myBitmap1, touchX3, touchY3, null);
           canvas.drawBitmap(myBitmap, touchX4, touchY4, null);
           canvas.drawBitmap(myBitmap1, touchX5, touchY5, null);
           canvas.drawBitmap(myBitmap, touchX6, touchY6, null);
           canvas.drawBitmap(myBitmap1, touchX7, touchY7, null);
           canvas.drawBitmap(myBitmap1, touchX8, touchY8, null);
           canvas.drawBitmap(myBitmap1, touchX9, touchY9, null);

            if (touchY > height && k<=100) {touchY =0;touchX = random.nextInt(height+700);k++;} else if (touchY > height) XY=false;
            if (touchY1 > height && k<=100) {touchY1 =0;touchX1 = random.nextInt(height+700);k++;}else if (touchY1 > height) XY1=false;
            if (touchY2 > height && k<=100) {touchY2 =0;touchX2 = random.nextInt(height+700);k++;}else if (touchY2 > height) XY2=false;
            if (touchY3 > height && k<=100) {touchY3 =0;touchX3 = random.nextInt(height+700);k++;}else if (touchY3 > height) XY3=false;
            if (touchY4 > height && k<=100){ touchY4 =0;touchX4 = random.nextInt(height+700);k++;}else if (touchY4 > height) XY4=false;
            if (touchY5 > height && k<=100){ touchY5 =0;touchX5 = random.nextInt(height+700);k++;}else if (touchY5 > height) XY5=false;
            if (touchY6 > height && k<=100) {touchY6 =0;touchX6 = random.nextInt(height+700);k++;}else if (touchY6 > height) XY6=false;
            if (touchY7 > height && k<=100){ touchY7 =0;touchX7 = random.nextInt(height+700);k++;}else if (touchY7 > height) XY7=false;
            if (touchY8 > height && k<=100) {touchY8 =0;touchX8 = random.nextInt(height+700);k++;}else if (touchY8 > height) XY8=false;
            if (touchY9 > height && k<=100) {touchY9 =0;touchX9 = random.nextInt(height+700);k++;}else if (touchY9 > height) XY9=false;

            if ((touchY+30 > touchY0) && (touchY<touchY0+57)&& ((touchX+30 > touchX0) && (touchX<touchX0+250))){ SumB++; if (k<=100){touchY =0;touchX = random.nextInt(height);k++;}else {touchY +=300; XY = false;}}
            if ((touchY1+30 > touchY0) && (touchY1<touchY0+57)&& ((touchX1+30 > touchX0) && (touchX1<touchX0+250))) { SumR++; if (k<=100){touchY1 =0;touchX1 = random.nextInt(height);k++;}else {touchY1 +=300; XY1 = false;}}
            if ((touchY2+30 > touchY0) && (touchY2<touchY0+57)&& ((touchX2+30 > touchX0) && (touchX2<touchX0+250))) { SumB++; if (k<=100){touchY2 =0;touchX2 = random.nextInt(height);k++;}else {touchY2 +=300; XY2 = false;}}
            if ((touchY3+30 > touchY0) && (touchY3<touchY0+57)&& ((touchX3+30 > touchX0) && (touchX3<touchX0+250))) { SumR++; if (k<=100){touchY3 =0;touchX3 = random.nextInt(height);k++;}else {touchY3 +=300; XY3 = false;}}
            if ((touchY4+30 > touchY0) && (touchY4<touchY0+57)&& ((touchX4+30 > touchX0) && (touchX4<touchX0+250))) { SumB++; if (k<=100){touchY4 =0;touchX4 = random.nextInt(height);k++;}else {touchY4 +=300; XY4 = false;}}
            if ((touchY5+30 > touchY0) && (touchY5<touchY0+57)&& ((touchX5+30 > touchX0) && (touchX5<touchX0+250))) { SumR++; if (k<=100){touchY5 =0;touchX5 = random.nextInt(height);k++;}else {touchY5 +=300; XY5 = false;}}
            if ((touchY6+30 > touchY0) && (touchY6<touchY0+57)&& ((touchX6+30 > touchX0) && (touchX6<touchX0+250))) { SumB++; if (k<=100){touchY6 =0;touchX6 = random.nextInt(height);k++;}else {touchY6 +=300; XY6 = false;}}
            if ((touchY7+30 > touchY0) && (touchY7<touchY0+57)&& ((touchX7+30 > touchX0) && (touchX7<touchX0+250))) { SumR++; if (k<=100){touchY7 =0;touchX7 = random.nextInt(height);k++;}else {touchY7 +=300; XY7 = false;}}
            if ((touchY8+30 > touchY0) && (touchY8<touchY0+57)&& ((touchX8+30 > touchX0) && (touchX8<touchX0+250))) { SumR++; if (k<=100){touchY8 =0;touchX8 = random.nextInt(height);k++;}else {touchY8 +=300; XY8 = false;}}
            if ((touchY9+30 > touchY0) && (touchY9<touchY0+57)&& ((touchX9+30 > touchX0) && (touchX9<touchX0+250))) { SumR++; if (k<=100){touchY9 =0;touchX9 = random.nextInt(height);k++;}else {touchY9 +=300; XY9 = false;}}

            touchY+=7;
            touchY1+=7;
            touchY2+=7;
            touchY3+=7;
            touchY4+=7;
            touchY5+=7;
            touchY6+=7;
            touchY7+=7;
            touchY8+=7;
            touchY9+=7;
            if( !XY && !XY1 && !XY2 && !XY3 && !XY4 && !XY5 && !XY6 && !XY7 && !XY8 && !XY9)
             startActivity(intent);
            else invalidate();
        }
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                 touchX0 = event.getX()-30;
                 if(touchX0<0)touchX0=0;
                 if (touchX0>width-70)touchX0=width-70;
            }
            return true;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        return false;
    }
}

