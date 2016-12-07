package com.hades.mylibrary.cloud.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.cloud.bean.JieBean;
import com.hades.mylibrary.cloud.bean.ZhangBean;

import java.util.List;

/**
 * Created by jiuzheyange on 2016/8/14.
 */
public class CourseIntroduceListAdapter extends BaseExpandableListAdapter {

    Context activity;
    List<ZhangBean> parentLists;
    List<List<JieBean>> childLists;


    public CourseIntroduceListAdapter(Context a, List<ZhangBean> parentLists, List<List<JieBean>> childLists)
    {
        activity = a;
        this.childLists=childLists;
        this.parentLists=parentLists;
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
    public View getChildView(final int  groupPosition, final int  childPosition,
                             boolean  isLastChild, View convertView, ViewGroup parent)
    {
        String string = childLists.get(groupPosition).get(childPosition).getNode_caption();
        View view= View.inflate(activity, R.layout.item_expandlistview_content,null);
        
        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText(string);
        
        
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
                             View convertView, ViewGroup parent)
    {
        String string = parentLists.get(groupPosition).getNode_caption();
        View view= View.inflate(activity, R.layout.item_expandlistview_parent,null);

        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText(string);
        return  view;
    }
    // View stub to create Group/Children 's View   
    public TextView getGenericView(String string)
    {
        // Layout parameters for the ExpandableListView   
        AbsListView.LayoutParams layoutParams = new  AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 64 );
        TextView text = new TextView(activity);
        text.setLayoutParams(layoutParams);
        // Center the ic_placeholder_video vertically
        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        // Set the ic_placeholder_video starting position
        text.setPadding(36 , 0 , 0 , 0 );
        text.setText(string);
        return  text;
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

