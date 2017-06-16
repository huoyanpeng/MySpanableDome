package dell.example.com.toast;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button Toast_custom_location = (Button) findViewById(R.id.Toast_custom_location);
        Button Toast_default = (Button) findViewById(R.id.Toast_default);
        Button Toast_entirely_custom = (Button) findViewById(R.id.Toast_entirely_custom);
        Button Toast_image = (Button) findViewById(R.id.Toast_image);
        Button Toast_thread = (Button) findViewById(R.id.Toast_thread);

        Toast_custom_location.setOnClickListener(this);
        Toast_default.setOnClickListener(this);
        Toast_entirely_custom.setOnClickListener(this);
        Toast_image.setOnClickListener(this);
        Toast_thread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast toast=null;
        switch (view.getId()){
            case R.id.Toast_default:
                Toast.makeText(this, "默认Toast样式", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Toast_custom_location:
                toast = Toast.makeText(this, "自定义位置Toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            case R.id.Toast_image:
                toast = Toast.makeText(this, "带图片的Toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView imageCodeProject = new ImageView(getApplicationContext());
                imageCodeProject.setImageResource(R.mipmap.ic_launcher);
                toastView.addView(imageCodeProject, 0);
                toast.show();
                break;
            case R.id.Toast_entirely_custom:
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom,
                        (ViewGroup) findViewById(R.id.llToast));
                ImageView image = (ImageView) layout
                        .findViewById(R.id.tvImageToast);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                title.setText("Attention");
                TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
                text.setText("完全自定义Toast");
                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
            case R.id.Toast_thread:
                new Thread(new Runnable() {
                    public void run() {
                        showToast();
                    }
                }).start();
                break;
        }
    }

    private void showToast() {
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "我来自其他线程！",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
