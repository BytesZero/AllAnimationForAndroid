package com.zhengsonglan.allanimationforandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    /**
     * 渐变动画
     */
    Button alphaxml,alphajava;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    //初始化控件
    void initView(){
        alphaxml= (Button) findViewById(R.id.alphaxml);
        alphaxml.setOnClickListener(this);
        alphajava= (Button) findViewById(R.id.alphajava);
        alphajava.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this, AnimationActivity.class);
        switch (v.getId()){
            case R.id.alphaxml:{
                intent.putExtra("type","xml");
                intent.putExtra("animation","alpha");
                break;
            }

            case R.id.alphajava:{
                intent.putExtra("type","java");
                intent.putExtra("animation","alpha");
                break;
            }
        }

        startActivity(intent);
    }
}
