package com.hades.mylibrary.base.ui.customview.banner.loader;

import android.content.Context;
import android.widget.ImageView;


public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }

}