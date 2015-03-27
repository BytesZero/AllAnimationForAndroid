package com.zhengsonglan.allanimationforandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


public class AnimationActivity extends ActionBarActivity {

    ImageView img_animation;
    Animation animation1;

    String type;
    String animation;
    String contextString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        initData();
    }

    void initView(){
        img_animation= (ImageView) findViewById(R.id.imageView);
    }
    void initData(){
        //接收数据
        Bundle bundle=getIntent().getExtras();
        if (bundle.getString("type")!=null){
            //接收动画方式
            type=bundle.getString("type");
        }
        if (bundle.getString("animation")!=null){
            //接收动画类型
            animation=bundle.getString("animation");
        }

        if (type.equals("xml")){//通过xml方式添加的动画
            if (animation.equals("alpha")){
                contextString="通过xml代码方式展示的透明度(alpha)变化";
                //通过AnimationUtils.loadAnimation(int i)方法加载xml中的动画
                animation1= AnimationUtils.loadAnimation(this,R.anim.alphaxml);
            }

        }else{//通过java代码添加的动画
            if (animation.equals("alpha")){
                contextString="通过java代码方式展示的透明度(alpha)变化";
                animation1=new AlphaAnimation(1,0);
                animation1.setDuration(1000);
                animation1.setFillAfter(true);
                animation1.setStartOffset(400);
                animation1.setRepeatCount(3);
            }
            if (animation1!=null){
                img_animation.startAnimation(animation1);
            }
        }
        //输出Toast
        showToast(contextString);

        if (animation1!=null){
            //执行动画
            img_animation.startAnimation(animation1);
        }

    }

    void showToast(String context){
        Toast.makeText(this,context,Toast.LENGTH_LONG).show();
    }

}
