package com.hades.mylibrary.cloud.demo;


import com.hades.mylibrary.cloud.biz.bizroot.ActionRoot;
import com.hades.mylibrary.cloud.biz.bizbase.BizActionItem;
import com.hades.mylibrary.cloud.biz.bizbase.BizConditionItem;
import com.hades.mylibrary.cloud.biz.bizbase.BizSimpleOper;
import com.hades.mylibrary.cloud.biz.bizbase.SimpleModel;

import java.util.List;

/**
 * Created by Hades on 2016/12/1.
 */

public class ClassOper extends BizSimpleOper {

    public ClassOper() {
        this.model = new SimpleModel();
        model.keyField = "uid";
        model.dataField = "list";

        this.action = new ActionRoot();
        action.setBaseUrl("adm/demo/test/");

        //查询操作  Builder模式
        BizActionItem query = new BizActionItem.Builder()
                .setOpAction("getlist")
                .setOpModel("OP_QUERY")
                .setOpName("查询")
                .create();
        action.addAction("Query", query);

        BizActionItem getOne = new BizActionItem();
        getOne.setOpModel("OP_GET");
        getOne.setOpAction("getone");
        getOne.setOpName("提取");
        action.addAction("Get", getOne);

        BizActionItem reset = new BizActionItem();
        reset.setOpModel("OP_RESET");
        reset.setOpAfter("Query");
        reset.setOpName("重置");
        action.addAction("Reset", reset);

        BizActionItem itemNew = new BizActionItem();
        itemNew.setOpModel("OP_NEW");
        itemNew.setOpAction("savedata");
        itemNew.setOpName("新增");
        itemNew.setOpAfter("Query");
        itemNew.setOpCtrl("couponCategoryEditorCtr");
        itemNew.setOpView("couponCategoryEditorView");
        action.addAction("New", itemNew);

        BizActionItem itemUpdate = new BizActionItem();
        itemUpdate.setOpAction("savedata");
        itemUpdate.setOpModel("OP_UPDATE");
        itemUpdate.setOpName("修改");
        itemUpdate.setOpBefore("GetOne");
        itemUpdate.setOpAfter("Query");
        action.addAction("Updata", itemUpdate);

        BizActionItem delete = new BizActionItem();
        delete.setOpAction("deldata");
        delete.setOpModel("OP_SINGLE");
        delete.setOpName("删除");
        delete.setOpAfter("Query");
        action.addAction("Delete", delete);

        //下拉刷新
        BizActionItem refresh = new BizActionItem.Builder()
                .setOpModel("OP_RELOAD")
                .setOpAction("getlist")
                .setOpName("刷新")
                .create();
        action.addAction("ReFresh", refresh);

        BizActionItem loadMore  = new BizActionItem.Builder()
                .setOpModel("OP_LOADMORE")
                .setOpAction("getlist")
                .setOpName("加载更多")
                .create();
        action.addAction("LoadMore", loadMore);

        //初始化排序规则 将 按钮 和 字段key绑定 如按vala降序
        BizActionItem sort = new BizActionItem.Builder()
                .setOpModel("OP_SORT")
                .setOpAction("getlist")
                .setOpName("精华")
                .setOpFlag("-")
                .setOpSort("vala")
                .create();
        action.addAction("精华", sort);

        BizActionItem sort2 = new BizActionItem.Builder()
                .setOpModel("OP_SORT")
                .setOpAction("getlist")
                .setOpName("精华")
                .setOpFlag("-")
                .setOpSort("valb")
                .create();
        action.addAction("精华", sort2);



    }

    //初始化排序规则 将 按钮 和 字段key绑定
    public void initSortCondition(List<String> title, List<String> value){
        int size = title.size();
        BizConditionItem item;
        for (int i =0; i<size; i++){
            //

        }
    }


}
