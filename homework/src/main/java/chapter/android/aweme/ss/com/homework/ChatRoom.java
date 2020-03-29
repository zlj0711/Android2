package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

public class ChatRoom extends AppCompatActivity {
    private static final String TAG = "ChatRoom";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        Bundle bundle = getIntent().getExtras();
        int ItemIndex = bundle.getInt("ItemIndex");
        TextView tv = (TextView)findViewById(R.id.tv_with_name);
        tv.setText("ItemIndex: " + Integer.toString(ItemIndex));
    }
}

