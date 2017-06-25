package com.github.captain_miao.uniqueadapter.library;

import android.view.View;

import java.io.Serializable;

/**
 * @author YanLu
 * @since 16/09/02
 */
public interface OnClickPresenter<T extends ItemModel> extends Serializable {
    void onClick(View view, T t);
}
