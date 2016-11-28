package com.hades.mylibrary.cloud.adapter.diliver;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
* 创建时间 2016/11/11
* auther Hades
* 描述  根据布局方向，针对item添加分割线
**/

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int mOratation;
    private int mColumn;
    private int mRow;
    private int mViewPos;
    private int viewCount;

    public SpaceItemDecoration(int space, int column, int row) {
        this.space = space;
        this.mColumn = column;
        this.mRow = row;
        mOratation = LinearLayoutManager.VERTICAL;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设置左右的间隔如果想设置的话自行设置，我这用不到就注释掉了
        //       System.out.println("position"+parent.getChildPosition(view));
        //       System.out.println("count"+parent.getChildCount());

        //         if(parent.getChildPosition(view) != parent.getChildCount() - 1)
        //         outRect.bottom = space;

//            outRect.set(0, space, space, 0);

//            outRect.set(0, 0, 0, mSize);


        Log.d("Tag-Position", "position="+parent.getChildAdapterPosition(view)+"   "
                +"layoutpos="+parent.getChildLayoutPosition(view));

        if (mColumn < 1){
            return;
        }
        if (mRow <1){
            return;
        }

        viewCount = mRow*mColumn;

//        if (mOratation == LinearLayoutManager.VERTICAL) { //垂直
            mViewPos = parent.getChildAdapterPosition(view);
            if (mViewPos < mColumn-1) {
                outRect.right = space;
            }

            if (mViewPos > mColumn-1 ) {
                outRect.top = space;
                outRect.right = space;
            }

            //改成使用上面的间隔来设置
//            if (parent.getChildAdapterPosition(view) != 0)
//                outRect.top = space;
//            outRect.left = space;
//            outRect.right = space;
//        }
    }

}