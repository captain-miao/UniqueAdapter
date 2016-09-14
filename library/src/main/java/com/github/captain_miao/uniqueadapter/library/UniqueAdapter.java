package com.github.captain_miao.uniqueadapter.library;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author YanLu
 * @since 16/09/02
 */

public class UniqueAdapter extends BaseUniqueAdapter {

    protected final List<? extends ItemModel> mDataList;


    public UniqueAdapter(@NonNull List<? extends ItemModel> dataList) {
        this.mDataList = dataList;
    }

    public UniqueAdapter(@NonNull List<? extends ItemModel> dataList, UniquePresenter<? extends ItemModel> presenter) {
        this.mDataList = dataList;
        this.mPresenter = presenter;
    }

    public ItemModel getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}