package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;


/**
 * 大作业:实现一个抖音消息页面,
 * 1、所需的data数据放在assets下面的data.xml这里，使用PullParser这个工具类进行xml解析即可
 * <p>如何读取assets目录下的资源，可以参考如下代码</p>
 * <pre class="prettyprint">
 *
 *         @Override
 *     protected void onCreate(@Nullable Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_xml);
 *         //load data from assets/data.xml
 *         try {
 *             InputStream assetInput = getAssets().open("data.xml");
 *             List<Message> messages = PullParser.pull2xml(assetInput);
 *             for (Message message : messages) {
 *
 *             }
 *         } catch (Exception exception) {
 *             exception.printStackTrace();
 *         }
 *     }
 * </pre>
 * 2、所需UI资源已放在res/drawable-xxhdpi下面
 *
 * 3、作业中的会用到圆形的ImageView,可以参考 widget/CircleImageView.java
 */
public class Exercises3 extends AppCompatActivity implements PerAdapter.OnItemClickListener {
    private static final int ItemNum = 20;
    private RecyclerView perListView;
    private PerAdapter myAdapter;
    private List<Message> messages;
    private static final String TAG = "Exercise3";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "activityCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RelativeLayout header = findViewById(R.id.header);
        header.setBackgroundColor(Color.BLACK);
        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
            for (Message message : messages) {
                Log.d(TAG,message.toString()+"\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        perListView = findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        perListView.setLayoutManager(layoutManager);
        perListView.setHasFixedSize(true);
        myAdapter = new PerAdapter(messages, this);
        perListView.setAdapter(myAdapter);
    }
    @Override
    public void onItemClick(int clickedItemIndex) {
        Log.d(TAG, "onItemClick in Exercises");
        Bundle bundle = new Bundle();
        bundle.putInt("ItemIndex", clickedItemIndex);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(Exercises3.this, ChatRoom.class);
        startActivity(intent);
    }
}
