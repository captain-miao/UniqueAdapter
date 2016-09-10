package com.github.captain_miao.uniqueadapter.model;

import com.github.captain_miao.uniqueadapter.R;
import com.github.captain_miao.uniqueadapter.library.ItemModel;

/**
 * @author YanLu
 * @since 16/09/03
 */

public class TextModel extends BaseViewModel implements ItemModel {

    public String text;

    public TextModel(String text) {
        this.text = text;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_text;
    }
}
