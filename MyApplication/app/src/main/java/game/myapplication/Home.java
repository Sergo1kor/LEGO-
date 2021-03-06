package game.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class Home extends AppCompatActivity implements View.OnTouchListener {

    int width=0;
    int height=0;
    Random random;
    Intent intent,intent1;
    int k;
    public int SumR;
    public int SumB;
    public static boolean New=false;
    boolean Sborka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Дом");
        k=5;
        intent = new Intent(this, Main2Activity.class);
        intent1 = new Intent(this, Main3Activity.class);
        SumR = Main2Activity.SumR;
        SumB = Main2Activity.SumB;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        Sborka = false;
        Home.GraphicsView myview = new Home.GraphicsView(this);
        setContentView(myview);
    }

    public class GraphicsView extends View {

        Bitmap myBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.dom11);
        Bitmap myBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.dom12);
        Bitmap myBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.dom13);
        Bitmap myBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.dom14);
        Bitmap myBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.dom15);
        RelativeLayout view = (RelativeLayout) findViewById(R.id.li_home);
        float touchX0 = 50, touchY0 = height-350;

        public GraphicsView(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {

            if (k==5 && SumR>=20) {
                canvas.drawBitmap(myBitmap1, width/2-myBitmap1.getWidth()/2,height/2-myBitmap1.getHeight()/2, null);
                SumR-=20;
            }else
            if (k==4&&SumR>=20) {
                canvas.drawBitmap(myBitmap2, width/2-myBitmap1.getWidth()/2,height/2-myBitmap1.getHeight()/2, null);
                SumR-=20;
            }else
            if (k==3&&SumR>=20) {
                canvas.drawBitmap(myBitmap3, width/2-myBitmap1.getWidth()/2,height/2-myBitmap1.getHeight()/2, null);
                SumR-=20;
            }else
            if (k==2&&SumR>=20) {
                canvas.drawBitmap(myBitmap4, width/2-myBitmap1.getWidth()/2,height/2-myBitmap1.getHeight()/2, null);
                SumR-=20;
            }else
            if (k==1&&SumR>=20&&SumB>=20){
                canvas.drawBitmap(myBitmap5, width/2-myBitmap1.getWidth()/2,height/2-myBitmap1.getHeight()/2, null);
                SumB-=20;
                SumR-=20;
                Sborka = true;
            }else k=0;

        }
        public void onClick(View v) {

        }

        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                k--;
                invalidate();
                if (Sborka){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                    builder.setTitle("Отлично!")
                            .setMessage("Тебе хватило деталей построить дом! Собери ещё деталей и постой ещё один!")
                            .setIcon(R.drawable.kk)
                            .setCancelable(false)
                            .setPositiveButton("Вперёд", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    startActivity(intent);
                                    New = true;
                                }
                            })

                            .setNegativeButton("Назад", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(intent1);
                                    New = false;
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }else
                if (k<=0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                    builder.setTitle("Не хватает деталей!")
                            .setMessage("Прости, но тебе не хватает деталей. Чтобы закончить дом, тебе нужно собрать больше!")
                            .setIcon(R.drawable.kk)
                            .setCancelable(false)
                    .setPositiveButton("Вперёд", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            startActivity(intent);
                            New = true;
                        }
                    })

                            .setNegativeButton("Назад", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            startActivity(intent1);
                                            New = false;
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
            return true;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
