package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */

public class Exercises1 extends AppCompatActivity {
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static String Rem_Str = "";
    private static String Tmp_Str;
    private TextView mLifecycleDisplay;

    private void logAndAppend(){
        Rem_Str = Rem_Str + Tmp_Str + "\n";
        mLifecycleDisplay.setText(Rem_Str);
    }
    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);
        Tmp_Str = ON_CREATE;
        logAndAppend();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Tmp_Str = ON_RESTART;
        logAndAppend();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Tmp_Str = ON_START;
        logAndAppend();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Tmp_Str = ON_RESUME;
        logAndAppend();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Tmp_Str = ON_PAUSE;
        logAndAppend();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Tmp_Str = ON_STOP;
        logAndAppend();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Tmp_Str = ON_DESTROY;
        logAndAppend();
    }
}
