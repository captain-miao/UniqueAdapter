/*
 * Copyright 2016 drakeet. https://github.com/drakeet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.captain_miao.uniqueadapter.library;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author YanLu
 * @since 16/09/02
 */

public class UniqueAdapter extends RecyclerView.Adapter<UniqueAdapter.UniqueViewHolder> {

    private OnClickViewPresenter<? extends ItemData> mPresenter;
    private final List<? extends ItemData> mDataList;


    public UniqueAdapter(@NonNull List<? extends ItemData> dataList) {
        this.mDataList = dataList;
    }

    public UniqueAdapter(@NonNull List<? extends ItemData> dataList, OnClickViewPresenter<? extends ItemData> presenter) {
        this.mDataList = dataList;
        this.mPresenter = presenter;
    }

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
        ItemData item = mDataList.get(position);
        holder.dataBinding.setVariable(item.getViewModelVariableId(), item);
        if (mPresenter != null) {
            holder.dataBinding.setVariable(item.getPresenterVariableId(), mPresenter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ItemData item = mDataList.get(position);
        return item.getItemViewLayoutId();
    }


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


    public ItemData getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}