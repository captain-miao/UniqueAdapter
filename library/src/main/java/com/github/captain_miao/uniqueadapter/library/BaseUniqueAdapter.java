package com.github.captain_miao.uniqueadapter.library;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author YanLu
 * @since 16/09/02
 */

public abstract class BaseUniqueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected UniquePresenter<? extends ItemModel> mPresenter;

    public abstract ItemModel getItem(int position) ;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType > 0) {// it's itemView of RecycleView layout ResourceId
            return new UniqueViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(viewType, parent, false));
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof UniqueViewHolder) {
            ItemModel item = getItem(position);
            UniqueViewHolder vh = ((UniqueViewHolder) holder);
            vh.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.viewModel, item);
            if (mPresenter != null) {
                vh.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.presenter, mPresenter);
            }
            vh.dataBinding.executePendingBindings();
        }
    }


    @Override
    public int getItemViewType(int position) {
        ItemModel item = getItem(position);
        return item.getItemViewLayoutId();
    }

    public UniquePresenter<? extends ItemModel> getPresenter() {
        return mPresenter;
    }

    public void setPresenter(UniquePresenter<? extends ItemModel> presenter) {
        mPresenter = presenter;
    }


}