package com.example.b1013029.gazouparse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int count[]=new int [8];
    int level = 168;//0赤1緑2青3黄4紫5水6白7黒
    ImageView iv;
    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tori2);
    BitmapDrawable bitmapDrawable =new BitmapDrawable(getResources(),bitmap);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        iv = new ImageView(this);
        iv.setImageResource(R.drawable.tori);
        setContentView(iv);

        if(bitmap!=null){
            System.out.println(bitmap);
        }else{
            System.out.println("えらーあああああああああああああ");
        }

        for (int x = 0; x < iv.getMaxWidth(); x++) {  //x軸のピクセル数だけ繰り返す
            for (int y = 0; y < iv.getMaxHeight(); y++) { //y軸のピクセル数だけ繰り返す
                System.out.println(count[colorCount(bitmap.getPixel(x,y))]++);
            }
        }

    }

    public int colorCount(int c) {
        for (int x = 0; x < iv.getMaxHeight(); x++) {  //x軸のピクセル数だけ繰り返す
            for (int y = 0; y < iv.getMaxHeight(); y++) { //y軸のピクセル数だけ繰り返す
                if (Color.red(c) > level && Color.green(c) < level && Color.blue(c) < level)
                    return 0;
                if (Color.red(c) < level && Color.green(c) > level && Color.blue(c) < level)
                    return 1;
                if (Color.red(c) < level && Color.green(c) < level && Color.blue(c) > level)
                    return 2;
                if (Color.red(c) > level && Color.green(c) > level && Color.blue(c) < level)
                    return 3;
                if (Color.red(c) > level && Color.green(c) < level && Color.blue(c) > level)
                    return 4;
                if (Color.red(c) < level && Color.green(c) > level && Color.blue(c) > level)
                    return 5;
                if (Color.red(c) > level && Color.green(c) > level && Color.blue(c) > level)
                    return 6;
                return 7;
            }
        }
        return 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
