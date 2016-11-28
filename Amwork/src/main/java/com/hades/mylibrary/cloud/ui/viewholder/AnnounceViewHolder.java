package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.view.View;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.customview.VerticalTextview;

import java.util.List;

/**
 * Created by Hades on 2016/11/3.
 */

public class AnnounceViewHolder extends RootViewHolder {

    VerticalTextview textbanner;
    List<String> textlist;


    public AnnounceViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initview(View view) {
        textbanner = (VerticalTextview) view.findViewById(R.id.textbanner);
    }

    @Override
    public void setData(String object, final Context context) {
//        listBanner = GsonUtils.getInstance().fromJson(s, new TypeToken<List<BannerBean>>(){}.getType() );


    }

    @Override
    public void setConfig(String rootBean, Context context) {
        //此处进行配置设置，主要针对样式

    }

    /**
    * 创建时间 2016/11/17
    * auther Hades
    * 描述   控制循环消息的数量
     * @param  k 消息数量
    **/
//    void initTextBannerData(int k){
//        if (k<= 3){
//            for (int i = 0; i<k;i++){
//                textlist.add(announcelists.get(i).getTitle());
//            }
//            textbanner.setTextList((ArrayList<String>) textlist);
//            textbanner.setText(16, 5, Color.BLACK);//设置属性,具体跟踪源码
//            textbanner.setTextStillTime(5000);//设置停留时长间隔
//            textbanner.setAnimTime(300);//设置进入和退出的时间间隔
//            //对单条文字的点击监听
//            textbanner.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
//                @Override
//                public void onItemClick(int position) {
//                    // TO DO
//                    //跳转查看具体公告
//                    //传Bundle
//                    Bundle bundle = new Bundle();
//                    bundle.putString("title", announcelists.get(position).getTitle());
//                    bundle.putString("content", announcelists.get(position).getContent());
//                    bundle.putString("data", announcelists.get(position).getDate_create());
//                    //使用Transaction 进行跳转
//
//
////                    Intent i = new Intent(,GongGaoDetailActivity.class);
////                    i.putExtras(bundle);
////                    mContext.startActivity(i);
////                    Intent i = new Intent(mContext, GongGaoActivity.class);
////                    mContext.startActivity(i);
//
//                }
//            });
//
//            textbanner.startAutoScroll();
//        }else {
//            for (int i = 0; i<3; i++){
//                textlist.add(announcelists.get(i).getTitle());
//            }
//            textbanner.setTextList((ArrayList<String>) textlist);
//            textbanner.setText(16, 5, Color.BLACK);//设置属性,具体跟踪源码
//            textbanner.setTextStillTime(5000);//设置停留时长间隔
//            textbanner.setAnimTime(300);//设置进入和退出的时间间隔
//            //对单条文字的点击监听
//            textbanner.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
//                @Override
//                public void onItemClick(int position) {
//                    // TO DO
//                    //跳转查看具体公告
//                    //传Bundle
//                    Bundle bundle = new Bundle();
//                    bundle.putString("title", announcelists.get(position).getTitle());
//                    bundle.putString("content", announcelists.get(position).getContent());
//                    bundle.putString("data", announcelists.get(position).getDate_create());
//                    Intent i = new Intent(mContext,GongGaoDetailActivity.class);
//                    i.putExtras(bundle);
//                    mContext.startActivity(i);
////                    Intent i = new Intent(mContext, GongGaoActivity.class);
////                    mContext.startActivity(i);
//                }
//            });
//
//            textbanner.startAutoScroll();
//        }
//    }


}
