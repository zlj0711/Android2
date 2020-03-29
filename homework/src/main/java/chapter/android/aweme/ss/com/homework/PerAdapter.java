package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class PerAdapter extends RecyclerView.Adapter<PerAdapter.perViewHolder> {
    private int ItemsNum;
    private OnItemClickListener onItemClickListener;
    private static int ViewHolderCount;
    private static final String TAG = "PerAdapter";
    private List<Message> myMsgList;
    public PerAdapter(List<Message>msgList, OnItemClickListener listener) {
        myMsgList = msgList;
        onItemClickListener = listener;
        ViewHolderCount = 0;
    }
    @NonNull
    @Override
    public perViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        perViewHolder viewHolder = new perViewHolder(view);
        ViewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull perViewHolder perViewHolder, int position) {
        Message msg = myMsgList.get(position);
        perViewHolder.description.setText(msg.getDescription());
        perViewHolder.title.setText(msg.getTitle());
        perViewHolder.time.setText(msg.getTime());
        String pth = msg.getIcon();
        switch (pth){
            case "TYPE_USER":
                perViewHolder.image.setImageResource(R.drawable.icon_girl);
                break;
            case "TYPE_STRANGER":
                perViewHolder.image.setImageResource(R.drawable.session_stranger);
                break;
            case "TYPE_ROBOT":
                perViewHolder.image.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_SYSTEM":
                perViewHolder.image.setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_GAME":
                perViewHolder.image.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            default:break;
        }
    }

    @Override
    public int getItemCount() {
        return myMsgList.size();
    }
    public class perViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView title;
        private final TextView description;
        private final TextView time;
        private final CircleImageView image;

        public perViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tv_title);
            description = (TextView)itemView.findViewById(R.id.tv_description);
            time = (TextView)itemView.findViewById(R.id.tv_time);
            image = (CircleImageView)itemView.findViewById(R.id.iv_avatar);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick in PerAdapt");
            int clickedPosition = getAdapterPosition();
            Log.d(TAG, "clicked position:" +Integer.toString(clickedPosition));
            if (onItemClickListener!=null){
                Log.d(TAG, "in");
                onItemClickListener.onItemClick(clickedPosition);
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int clickedItemIndex);
    }
}
