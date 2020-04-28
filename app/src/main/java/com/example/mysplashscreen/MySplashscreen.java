package com.example.mysplashscreen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MySplashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_splashscreen);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                    Intent intent = new Intent(MySplashscreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        timer.start();

    }
}



