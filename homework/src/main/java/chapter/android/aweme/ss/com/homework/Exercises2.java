package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    private TextView Count_Show;
    private static final String TAG = "Exercise2";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countview);
        Count_Show = findViewById(R.id.txt);
        ViewGroup group = (ConstraintLayout)findViewById(R.id.view);
        int count = getAllChildViewCount(group);
        String content = Integer.toString(count);
        Count_Show.setText(content);
    }
    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if(view == null){
            return 0;
        }
        else {
            int count = 0;
            Log.d(TAG, "count now:" + Integer.toString(count));
            if(view instanceof  ViewGroup){
                ViewGroup group = (ViewGroup)view;
                count++;
                int i;
                for(i = 0;i < group.getChildCount();i++){
                    Log.d(TAG, "in view group:" + Integer.toString(i));
                    View child = group.getChildAt(i);
                    if(child instanceof ViewGroup){
                        Log.d(TAG, "child instanceof ViewGroup");
                        count += getAllChildViewCount(child);
                    }
                    else{
                        Log.d(TAG, "child is not instanceof ViewGroup");
                        count ++;
                    }
                }
            }
            return count;
        }
    }
}
