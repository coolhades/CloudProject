package com.hades.mylibrary.cloud.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.cloud.bean.JieBean;
import com.hades.mylibrary.cloud.bean.ZhangBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiuzheyange on 2016/8/14.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

    Context mContext;
    List<ZhangBean> parentLists;
    List<List<JieBean>> childLists;
    public List<TextView> alltextview = new ArrayList<>();
    ExpandableListView expandableListView;

    int mGroupPosition;
    int mChildPosition;

    public ExpandableAdapter(Context context, ExpandableListView listView,List<ZhangBean> parentLists, List<List<JieBean>> childLists)
    {
        this.expandableListView = listView;
        this.mContext = context;
        this.childLists=childLists;
        this.parentLists=parentLists;
        if (!alltextview.isEmpty()){
            alltextview.clear();
        }
    }

    /**
     * 设置子项被选中方法
     *
     * @param groupPosition
     * @param childPosition
     */
    @Deprecated
    public void setItemChecked(int groupPosition, int childPosition) {
        if (expandableListView == null) {
            return;
        }
        this.mGroupPosition = groupPosition;
        this.mChildPosition = childPosition;

        int numberOfGroupThatIsOpened = 0;

        for (int i = 0; i < groupPosition; i++) {
            if (expandableListView.isGroupExpanded(i)) {
                numberOfGroupThatIsOpened += this.getChildrenCount(i);
            }
        }

        int position = numberOfGroupThatIsOpened + groupPosition
                + childPosition + 1;

        if (!expandableListView.isItemChecked(position)) {
            expandableListView.setItemChecked(position, true);
        }
    }


    public Object getChild(int  groupPosition, int  childPosition)
    {
        return  childLists.get(groupPosition).get(childPosition);
    }
    public  long  getChildId(int  groupPosition, int  childPosition)
    {
        return  childPosition;
    }
    public  int  getChildrenCount(int  groupPosition)
    {
        if(childLists.get(groupPosition)==null)
        {
            return 0;
        }else {
            return childLists.get(groupPosition).size();
        }
    }
    public View getChildView(final int groupPosition, final  int  childPosition,
                             boolean  isLastChild, View convertView, ViewGroup parent)
    {
        String string = childLists.get(groupPosition).get(childPosition).getNode_caption();
        View view= View.inflate(mContext, R.layout.child_listview_item,null);

        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText(string);

        
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getChildVideo(groupPosition,childPosition);
//            }
//        });

        return  view;
    }
    // group method stub   
    public Object getGroup(int  groupPosition)
    {
        return  parentLists.get(groupPosition);
    }
    public  int  getGroupCount()
    {
        return  parentLists.size();
    }
    public  long  getGroupId(int  groupPosition)
    {
        return  groupPosition;
    }

    public View getGroupView(final int  groupPosition, boolean  isExpanded,
                             View convertView, ViewGroup parent) {
        String string = parentLists.get(groupPosition).getNode_caption();
        View view = View.inflate(mContext, R.layout.parent_listview_item, null);

        TextView text = (TextView) view.findViewById(R.id.text);
        if (parentLists.size() > alltextview.size()){
            alltextview.add(text);
            Log.i("TAGTAG", "alltextview_size="+alltextview.size());
        }

        //看过的视频项 设置颜色
        if (parentLists.get(groupPosition).getIs_watched().equalsIgnoreCase("1")){
            text.setTextColor(Color.parseColor("#999999"));
        }
        text.setText(string);

        //选中项设置颜色
        if (selectedPosition == groupPosition){
//            expanditem_ly.setBackgroundColor(Color.parseColor("#000000"));
//            text.setTextColor(Color.parseColor("#ffffff"));
//            view1.setBackgroundColor(Color.parseColor("#ffffff"));
        }


        return view;
    }


    private int selectedPosition = -1;// 选中的位置

    /**
     * 自定义方法，设定item点击状态保持
     *
     * @param position
     */
    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    public  boolean  hasStableIds()
    {
        return  false ;
    }
    public  boolean  isChildSelectable(int  groupPosition, int  childPosition)
    {
        return  true ;
    }
}

