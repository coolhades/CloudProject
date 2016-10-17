package com.hades.libamtest;

import com.hades.libam.ui.interf.IRootModel;

/**
 * Created by Hades on 16/10/17.
 */

public interface BaseModel extends IRootModel {
    void fetchData(IDataCallBack callBack);
    void cacheData(IDataCacheCallBack cacheCallBack);

}
