package dell.example.com.myspanabledome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String content="你好，我好，大家好。";
    private String[] arrary={"a","b","c","d","e","f","g","h","i","j","k","l","n","o"};
    private int [] arr={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,
    R.mipmap.g,R.mipmap.h,R.mipmap.i,R.mipmap.j,R.mipmap.k,R.mipmap.l,R.mipmap.n,R.mipmap.o};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.texts);

//        SpannableString spannableString=new SpannableString(content);
        //设置背景颜色 BackgroundColorSpan
//        spannableString.setSpan(new BackgroundColorSpan(Color.BLUE),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //设置前景色 ForegroundColorSpan
//        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE),0,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //下划线 UnderlineSpan
//        spannableString.setSpan(new UnderlineSpan(),0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //显示图片
        //获得Drawable对象
//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        //设置图片setBounds()参数设置图片的左上右下的位置及大小
//        drawable.setBounds(0,0,120,120);
        //设置图片显示位置
//        spannableString.setSpan(new ImageSpan(drawable),0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //文字的加粗、倾斜
//        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),0,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //添加下标
//        spannableString.setSpan(new SubscriptSpan(),0,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //添加上标
//        spannableString.setSpan(new SuperscriptSpan(),4,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //设置绑定打开网页
//        textView.setMovementMethod(new LinkMovementMethod());
//        spannableString.setSpan(new URLSpan("http://www.baidu.com"),3,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);

        //对选中文字进行监听
//        ClickableSpan clickableSpan=new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "大家好！！！！！！！！！！", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override//在其方法内部可以对文字进行操作
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                ds.setColor(Color.RED);
//            }
//        };
//        spannableString.setSpan(clickableSpan,0,6,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);
//        textView.setMovementMethod(new LinkMovementMethod());

        //实现图文并存
        String contents="nihao,wohao,dajiahao";
        textView.setText(toImageSpan(this,contents,arr,arrary));

    }
    public static SpannableString toImageSpan(Context context, String content, int[] emoImg, String[] emoText) {
        SpannableString ss = new SpannableString(content);
        for (int i = 0; i < emoText.length; i++) {
            int startPos = 0;
            String rep = emoText[i];
            int fromPos = 0;
            while ((startPos = content.indexOf(rep, fromPos)) != -1) {
                fromPos = startPos + rep.length();
                Bitmap bit = BitmapFactory.decodeResource(context.getResources(),emoImg[i]);

                BitmapDrawable bitmapDrawable = new BitmapDrawable(bit);
                bitmapDrawable.setBounds(0, 0, 50,50);
                ImageSpan span = new ImageSpan(bitmapDrawable);
                ss.setSpan(span, startPos, fromPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return ss;
    }

}
