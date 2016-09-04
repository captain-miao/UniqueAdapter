package com.github.captain_miao.uniqueadapter.library;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author YanLu
 * @since 16/9/4
 */
public class UniqueViewHolder extends RecyclerView.ViewHolder {
    public ViewDataBinding dataBinding;

    public UniqueViewHolder(View itemView) {
        super(itemView);
        dataBinding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
        return dataBinding;
    }
}