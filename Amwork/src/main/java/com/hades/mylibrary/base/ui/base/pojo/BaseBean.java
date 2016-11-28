package com.hades.mylibrary.base.ui.base.pojo;

/**
 * Created by Hades on 16/10/17.
 * 抽象数据层
 */

public class BaseBean<T,D> {
    private D blockData;
    private T blockConfig;//对象解析为Map 方便后续扩展
    private String blockType;

    public D getBlockData() {
        return blockData;
    }

    public void setBlockData(D blockData) {
        this.blockData = blockData;
    }

    public T getBlockConfig() {
        return blockConfig;
    }

    public void setBlockConfig(T blockConfig) {
        this.blockConfig = blockConfig;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }
}
