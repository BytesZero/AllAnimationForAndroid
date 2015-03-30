package com.zhengsonglan.allanimationforandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;


public class AnimationActivity extends ActionBarActivity {

    ImageView img_animation;
    Animation animation1;

    String type;
    String animation;
    String contextString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        initData();
    }

    void initView() {
        img_animation = (ImageView) findViewById(R.id.imageView);
    }

    void initData() {
        //接收数据
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("type") != null) {
            //接收动画方式
            type = bundle.getString("type");
        }
        if (bundle.getString("animation") != null) {
            //接收动画类型
            animation = bundle.getString("animation");
        }

        if (type.equals("xml")) {//通过xml方式添加的动画
            if (animation.equals("alpha")) {
                contextString = "通过xml代码方式展示的透明度(alpha)变化";
                //通过AnimationUtils.loadAnimation(int i)方法加载xml中的动画
                animation1 = AnimationUtils.loadAnimation(this, R.anim.alphaxml);
            } else if (animation.equals("scale")) {
                contextString = "通过xml代码方式展示的缩放(scale)变化";
                animation1 = AnimationUtils.loadAnimation(this, R.anim.scalexml);
            } else if (animation.equals("rotate")) {
                contextString = "通过xml代码方式展示的旋转(rotate)变化";
                animation1 = AnimationUtils.loadAnimation(this, R.anim.rotatexml);
            }else if (animation.equals("translate")) {
                contextString = "通过xml代码方式展示的移动(translate)变化";
                animation1 = AnimationUtils.loadAnimation(this, R.anim.translatexml);
            }

        } else {//通过java代码添加的动画
            if (animation.equals("alpha")) {
                contextString = "通过java代码方式展示的透明度(alpha)变化";
                //透明度从1~0
                animation1 = new AlphaAnimation(1, 0);
                //动画时长1000毫秒
                animation1.setDuration(1000);
                //动画结束时停留在动画结束的时刻
                animation1.setFillAfter(true);
                //动画延迟400毫秒开始
                animation1.setStartOffset(400);
                //重复3次动画
                animation1.setRepeatCount(3);
            } else if (animation.equals("scale")) {
                contextString = "通过java代码方式展示的缩放(scale)变化";
                /**
                 * ( float fromX, float toX, float fromY, float toY, float pivotX, float pivotY)
                 *
                 * float fromX 动画起始时 X坐标上的伸缩尺寸
                 * float toX 动画结束时 X坐标上的伸缩尺寸
                 * float fromY 动画起始时Y坐标上的伸缩尺寸
                 * float toY 动画结束时Y坐标上的伸缩尺寸
                 * float pivotXValue 动画相对于物件的X坐标的开始位置
                 * float pivotYValue 动画相对于物件的Y坐标的开始位置
                 */
                animation1 = new ScaleAnimation(1f, 0f, 1f, 1f, 0.5f, 0.5f);
                //动画时长1000毫秒
                animation1.setDuration(1000);
                //动画结束时停留在动画结束的时刻
                animation1.setFillAfter(true);
                //重复3次动画
                animation1.setRepeatCount(3);
            } else if (animation.equals("rotate")) {
                contextString = "通过java代码方式展示的旋转(rotate)变化";
                /**
                 * (float fromDegrees, float toDegrees, float pivotX, float pivotY)
                 *
                 * float fromDegrees动画开始的度数
                 * float toDegrees 动画结束的度数
                 * float pivotX 动画围绕的旋转的中心x
                 * float pivotY 动画围绕的旋转的中心y
                 */
                animation1 = new RotateAnimation(0f, 360f, 0f, 0f);
                animation1.setDuration(1000);
                animation1.setFillAfter(false);
                animation1.setRepeatCount(3);
            } else if(animation.equals("translate")){
                contextString="通过java代码方式展示的移动(translate)变化";
                /**
                 * TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
                 *
                 * float fromXDelta 动画开始X轴上的位置
                 * float toXDelta 动画结束在X轴上的位置
                 * float fromYDelta 动画开始Y轴上的位置
                 * float toYDelta 动画结束在Y轴上的位置
                 */
                animation1=new TranslateAnimation(-500f,500f,-200,200);
                animation1.setDuration(1500);
                animation1.setFillAfter(false);

            }
        }
        //输出Toast
        showToast(contextString);

        if (animation1 != null) {
            //执行动画
            img_animation.startAnimation(animation1);
        }

    }

    //显示土司
    void showToast(String context) {
        Toast.makeText(this, context, Toast.LENGTH_LONG).show();
    }

}
