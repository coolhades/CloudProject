package com.hades.mylibrary.cloud.biz.bizbase;

/**
 * Created by Hades on 2016/12/1.
 * 规约了操作 如 查询 重置 修改等
 */
public class BizActionItem {
    private String opModel;//规约操作key:Query
    private String opAction;//规约的接口
    private String opName;
    private String opAfter;
    private String opBefore;
    private String opCtrl;//
    private String opView;

    private String opFlag;
    private String opSort;

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }

    public String getOpSort() {
        return opSort;
    }

    public void setOpSort(String opSort) {
        this.opSort = opSort;
    }

    public String getOpModel() {
        return opModel;
    }

    public void setOpModel(String opModel) {
        this.opModel = opModel;
    }

    public String getOpAction() {
        return opAction;
    }

    public void setOpAction(String opAction) {
        this.opAction = opAction;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpAfter() {
        return opAfter;
    }

    public void setOpAfter(String opAfter) {
        this.opAfter = opAfter;
    }

    public String getOpBefore() {
        return opBefore;
    }

    public void setOpBefore(String opBefore) {
        this.opBefore = opBefore;
    }

    public String getOpCtrl() {
        return opCtrl;
    }

    public void setOpCtrl(String opCtrl) {
        this.opCtrl = opCtrl;
    }

    public String getOpView() {
        return opView;
    }

    public void setOpView(String opView) {
        this.opView = opView;
    }

    //后续使用建造者优化初始化
    public static class Builder {
        private String opModel;//规约操作key:Query
        private String opAction;//规约的接口
        private String opName;
        private String opAfter;
        private String opBefore;
        private String opCtrl;
        private String opView;

        private String opFlag;
        private String opSort;

        public Builder setOpFlag(String opFlag) {
            this.opFlag = opFlag;
            return this;
        }

        public Builder setOpSort(String opSort) {
            this.opSort = opSort;
            return this;
        }

        public Builder setOpModel(String opModel) {
            this.opModel = opModel;
            return this;
        }

        public Builder setOpAction(String opAction) {
            this.opAction = opAction;
            return this;
        }

        public Builder setOpName(String opName) {
            this.opName = opName;
            return this;
        }

        public Builder setOpAfter(String opAfter) {
            this.opAfter = opAfter;
            return this;
        }

        public Builder setOpBefore(String opBefore) {
            this.opBefore = opBefore;
            return this;
        }

        public Builder setOpCtrl(String opCtrl) {
            this.opCtrl = opCtrl;
            return this;
        }

        public Builder setOpView(String opView) {
            this.opView = opView;
            return this;
        }

        public BizActionItem create(){
            BizActionItem bizActionItem = new BizActionItem();

            if (opModel !=null){
                bizActionItem.setOpModel(opModel);
            }

            if (opAction != null){
                bizActionItem.setOpAction(opAction);
            }

            if (opName != null){
                bizActionItem.setOpName(opName);
            }
            if (opBefore != null){
                bizActionItem.setOpName(opBefore);
            }
            if (opAfter != null){
                bizActionItem.setOpName(opAfter);
            }
            if (opCtrl != null){
                bizActionItem.setOpName(opCtrl);
            }
            if (opView != null){
                bizActionItem.setOpName(opView);
            }

            if (opFlag != null){
                bizActionItem.setOpFlag(opFlag);
            }

            if (opSort != null){
                bizActionItem.setOpSort(opSort);
            }

            return bizActionItem;
        }
    }
}
