package com.github.captain_miao.uniqueadapter.model;

import com.github.captain_miao.uniqueadapter.R;
import com.github.captain_miao.uniqueadapter.library.ItemModel;

/**
 * @author YanLu
 * @since 16/09/03
 */

public class ImageModel extends BaseModel implements ItemModel {

    public String url;

    public ImageModel(String url) {
        this.url = url;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_image;
    }

    @Override
    public int getViewModelVariableId() {
        return com.github.captain_miao.uniqueadapter.BR.viewModel;
    }

    @Override
    public int getPresenterVariableId() {
        return com.github.captain_miao.uniqueadapter.BR.presenter;
    }
}
