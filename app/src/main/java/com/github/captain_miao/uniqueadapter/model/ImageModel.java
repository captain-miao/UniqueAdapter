package com.github.captain_miao.uniqueadapter.model;

import com.github.captain_miao.uniqueadapter.R;

/**
 * @author YanLu
 * @since 16/09/03
 */

public class ImageModel extends BaseViewModel {

    public String url;

    public ImageModel(String url) {
        this.url = url;
    }
    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_image;
    }
}
