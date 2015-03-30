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
    Button alphaxml,alphajava,scalexml,scalejava,rotatexml,rotatejava,translatexml,translatejava;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    //初始化控件
    void initView(){
        //透明度
        alphaxml= (Button) findViewById(R.id.alphaxml);
        alphaxml.setOnClickListener(this);
        alphajava= (Button) findViewById(R.id.alphajava);
        alphajava.setOnClickListener(this);
        //缩放
        scalexml= (Button) findViewById(R.id.scalexml);
        scalexml.setOnClickListener(this);
        scalejava= (Button) findViewById(R.id.scalejava);
        scalejava.setOnClickListener(this);
        //旋转
        rotatexml= (Button) findViewById(R.id.rotatexml);
        rotatexml.setOnClickListener(this);
        rotatejava= (Button) findViewById(R.id.rotatejava);
        rotatejava.setOnClickListener(this);
        //移动
        translatexml= (Button) findViewById(R.id.translatexml);
        translatexml.setOnClickListener(this);
        translatejava= (Button) findViewById(R.id.translatejava);
        translatejava.setOnClickListener(this);

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

            case R.id.scalexml :{
                intent.putExtra("type","xml");
                intent.putExtra("animation", "scale");
                break;
            }

            case R.id.scalejava :{
                intent.putExtra("type","java");
                intent.putExtra("animation","scale");
                break;
            }

            case R.id.rotatexml :{
                intent.putExtra("type","xml");
                intent.putExtra("animation","rotate");
                break;
            }

            case R.id.rotatejava :{
                intent.putExtra("type","java");
                intent.putExtra("animation","rotate");
                break;
            }

            case R.id.translatexml :{
                intent.putExtra("type","xml");
                intent.putExtra("animation","translate");
                break;
            }

            case R.id.translatejava :{
                intent.putExtra("type","java");
                intent.putExtra("animation","translate");
                break;
            }
        }

        startActivity(intent);
    }
}
