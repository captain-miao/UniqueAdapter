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

package com.github.captain_miao.uniqueadapter.model;

import com.github.captain_miao.uniqueadapter.R;
import com.github.captain_miao.uniqueadapter.library.ItemData;

/**
 * @author YanLu
 * @since 16/09/03
 */

public class TextModel extends BaseModel implements ItemData {

    public String text;

    public TextModel(String text) {
        this.text = text;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_text;
    }

    @Override
    public int getViewModelVariableId() {
        return com.github.captain_miao.uniqueadapter.BR.viewModel;
    }

    @Override
    public int getPresenterVariableId() {
        return com.github.captain_miao.uniqueadapter.BR.presenter;
    }
}
