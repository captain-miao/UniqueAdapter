package com.github.captain_miao.uniqueadapter.library;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author YanLu
 * @since 16/09/02
 */

public abstract class BaseUniqueAdapter extends RecyclerView.Adapter<UniqueViewHolder> {

    protected OnClickViewPresenter<? extends ItemModel> mPresenter;

    public abstract ItemModel getItem(int position) ;

    @Override
    public UniqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType > 0) {// it's RvResourceId
            return new UniqueViewHolder(
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(viewType, parent, false));
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(UniqueViewHolder holder, int position) {
        ItemModel item = getItem(position);
        holder.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.viewModel, item);
        if (mPresenter != null) {
            holder.dataBinding.setVariable(com.github.captain_miao.uniqueadapter.library.BR.presenter, mPresenter);
        }
        holder.dataBinding.executePendingBindings();
    }


    @Override
    public int getItemViewType(int position) {
        ItemModel item = getItem(position);
        return item.getItemViewLayoutId();
    }

    public OnClickViewPresenter<? extends ItemModel> getPresenter() {
        return mPresenter;
    }

    public void setPresenter(OnClickViewPresenter<? extends ItemModel> presenter) {
        mPresenter = presenter;
    }


}