package com.github.captain_miao.uniqueadapter.library;

import android.view.View;

import java.io.Serializable;

/**
 * @author YanLu
 * @since 17/06/25
 */
public interface OnLongClickPresenter<T extends ItemModel> extends Serializable {
    boolean onLongClick(View view, T t);
}
