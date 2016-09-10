package com.github.captain_miao.uniqueadapter.library;

/**
 * @author YanLu
 * @since 16/09/02
 */

public interface ItemModel {

    // recycleView's itemView layout
    int getItemViewLayoutId();
    // itemView dataBinding variable: ? extends ItemModel
    //int getViewModelVariableId();
    // itemView dataBinding variable:OnClickViewPresenter.onClick(View view, T t);
    //int getPresenterVariableId();
}
