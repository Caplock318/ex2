package com.example.huyang.myapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Coach> mDataList;


    public MyAdapter(List<Coach> list) {

        mDataList = list;
    }

    @Override
    public int getItemCount() {
        // 返回数据集合大小
        return mDataList == null ? 0 : mDataList.size();
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //获取这个CardView

        CardView tv= holder.mTvTitle;
        // 在这设置初始化卡片：
        ImageView avatar = (ImageView) tv.findViewById(R.id.imageView5);
        TextView name = (TextView) tv.findViewById(R.id.textView29);
        TextView telNo = (TextView) tv.findViewById(R.id.textView30);
        Picasso.get().load(mDataList.get(position).getUrl()).into(avatar);
        name.setText(mDataList.get(position).getCoachName());
        telNo.setText(mDataList.get(position).getCoachTel());



    }



    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coach_message, parent, false));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (CardView) itemView.findViewById(R.id.item_tv);

        }


    }
}


