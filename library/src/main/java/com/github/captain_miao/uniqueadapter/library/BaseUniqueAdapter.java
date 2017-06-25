package com.github.captain_miao.uniqueadapter.library;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author YanLu
 * @since 16/09/02
 */

public abstract class BaseUniqueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int  NO_ITEM_TYPE = -1;

    protected OnClickPresenter<? extends ItemModel> mOnClickPresenter;
    protected OnLongClickPresenter<? extends ItemModel> mOnLongClickPresenter;

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
            if (mOnClickPresenter != null) {
                vh.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.onClickPresenter, mOnClickPresenter);
            }
            if (mOnLongClickPresenter != null) {
                vh.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.onLongClickPresenter, mOnClickPresenter);
            }
            vh.dataBinding.executePendingBindings();
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        if(payloads != null && payloads.size() > 0 && holder instanceof UniqueViewHolder){
            for(Object item : payloads){
                if(item instanceof ItemModel) {
                    UniqueViewHolder vh = ((UniqueViewHolder) holder);
                    vh.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.viewModel, item);
                }
            }
        } else {
            onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ItemModel item = getItem(position);
        return item != null ? item.getItemViewLayoutId() : NO_ITEM_TYPE;
    }

    public OnClickPresenter<? extends ItemModel> getOnClickPresenter() {
        return mOnClickPresenter;
    }

    public void setOnClickPresenter(OnClickPresenter<? extends ItemModel> onClickPresenter) {
        mOnClickPresenter = onClickPresenter;
    }

    public OnLongClickPresenter<? extends ItemModel> getOnLongClickPresenter() {
        return mOnLongClickPresenter;
    }

    public void setOnLongClickPresenter(OnLongClickPresenter<? extends ItemModel> onLongClickPresenter) {
        mOnLongClickPresenter = onLongClickPresenter;
    }
}