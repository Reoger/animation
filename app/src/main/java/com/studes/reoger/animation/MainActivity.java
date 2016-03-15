package com.studes.reoger.animation;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int res[] = {R.id.a_png, R.id.b_png, R.id.c_png, R.id.d_png, R.id.e_png, R.id.f_png,
            R.id.g_png, R.id.h_png};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }


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



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a_png:
                if(!flag){
                move();
                    flag=true;
                }else{
                    revser();
                    flag=false;
                }
                break;
            case R.id.b_png:
                Toast.makeText(MainActivity.this,"ÕÕÏà"+v.getId(),Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(MainActivity.this,"test"+v.getId(),Toast.LENGTH_LONG).show();
                break;
                }
        }

    private void revser() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",
                    i*150F,0F);
            animator.setDuration(300);
            animator.setStartDelay(i * 300);
            animator.start();
        }
    }


    private void move() {

        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",
                    0F,i*150);
            animator.setDuration(300);
            animator.setStartDelay(i * 300);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
        }


    }


}
