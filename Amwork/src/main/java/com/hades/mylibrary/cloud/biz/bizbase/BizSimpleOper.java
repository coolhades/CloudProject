package com.hades.mylibrary.cloud.biz.bizbase;


import com.hades.mylibrary.cloud.biz.bizroot.BizRootOper;

/**
 * Created by Hades on 2016/12/1.
 * 一些Presenter的通用操作
 */
public  class BizSimpleOper extends BizRootOper {

    @Override
    protected void loadData(String alldata) {
        iLoadData.loadData(alldata);
    }

    @Override
    protected void dealReSort(String s) {
        iLoadData.dealReSort(s);
    }

    @Override
    protected void dealReload(String s) {
        iLoadData.dealReload(s);
    }

    @Override
    protected void dealNext(String s) {
        iLoadData.dealNext(s);
    }


}
