package com.hades.mylibrary.cloud.biz.bizbase;

/**
 * Created by Hades on 2016/12/2.
 */

public class BizConditionItem {
    private String opModel;//规约操作key:Sort
    private String opAction;//规约的接口:getlist
    private String opName;//

    private String opSort;//搜索字段
    private String opFlag;//升序降序

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
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

    public String getOpSort() {
        return opSort;
    }

    public void setOpSort(String opSort) {
        this.opSort = opSort;
    }

    public static class Builder {
        private String opModel;//规约操作key:Sort
        private String opAction;//规约的接口:getlist
        private String opName;//

        private String opSort;//搜索字段
        private String opFlag;//升序降序

        public Builder setOpFlag(String opFlag) {
            this.opFlag = opFlag;
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

        public Builder setOpSort(String opSort) {
            this.opSort = opSort;
            return this;
        }

        public BizConditionItem create() {
            BizConditionItem item = new BizConditionItem();
            if (opModel != null) {
                item.setOpModel(opModel);
            }
            if (opAction != null) {
                item.setOpAction(opAction);
            }
            if (opName != null) {
                item.setOpName(opName);
            }
            if (opFlag != null) {
                item.setOpFlag(opFlag);
            }

            if (opSort != null) {
                item.setOpSort(opSort);
            }

            return item;
        }
    }
}
