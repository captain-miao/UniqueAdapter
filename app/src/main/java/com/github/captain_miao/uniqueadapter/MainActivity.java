package com.github.captain_miao.uniqueadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.captain_miao.uniqueadapter.library.ItemData;
import com.github.captain_miao.uniqueadapter.library.OnClickViewPresenter;
import com.github.captain_miao.uniqueadapter.library.UniqueAdapter;
import com.github.captain_miao.uniqueadapter.model.ImageModel;
import com.github.captain_miao.uniqueadapter.model.TextModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickViewPresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_example);

        List<ItemData> dataList = getMockData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new UniqueAdapter(dataList, this));
    }

    @Override
    public void onClick(View view, ItemData itemData) {
        if(itemData instanceof TextModel){
            Toast.makeText(this, ((TextModel)itemData).text, Toast.LENGTH_SHORT).show();
        } else if(itemData instanceof ImageModel){
            Toast.makeText(this, ((ImageModel)itemData).url, Toast.LENGTH_SHORT).show();
        }
    }


    private List<ItemData> getMockData(){
        List<ItemData> dataList = new ArrayList<>();
        dataList.add(new TextModel("Photo 1"));
        dataList.add(new ImageModel("http://ww2.sinaimg.cn/bmiddle/7a8aed7bjw1f340c8jrk4j20j60srgpf.jpg"));
        dataList.add(new TextModel("Photo 2"));
        dataList.add(new ImageModel("http://ww1.sinaimg.cn/bmiddle/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg"));

        return dataList;
    }
}
