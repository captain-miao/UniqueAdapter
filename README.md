# UniqueAdapter
The UniqueAdapter With DataBinding...

## Gradle
Get library from  [oss.sonatype.org.io](https://oss.sonatype.org/content/repositories/snapshots)
```java

repositories {

    maven { url 'https://oss.sonatype.org/content/repositories/releases' }
    maven { url "https://oss.sonatype.org/content/repositories/snapshots" }

}

dependencies {
    compile 'com.github.captain-miao:uniqueadapter:1.0.2'
}

```


## Step 1: define data model
```
public class TextModel extends BaseViewModel implements ItemModel {

    public String text;

    public TextModel(String text) {
        this.text = text;
    }

    // the layoutId == RecyclerView.Adapter.ItemViewType
    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_text;
    }
}
```

## Step 2: define item view layout
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <import type="com.github.captain_miao.uniqueadapter.model.TextModel"/>

        <import type="com.github.captain_miao.uniqueadapter.library.UniquePresenter"/>

        <variable
            name="viewModel"
            type="TextModel"/>

        <variable
            name="presenter"
            type="UniquePresenter"/>
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="@{(v) -> presenter.onClick(v, viewModel)}"
        android:orientation="horizontal">

        <TextView
            android:paddingTop="@dimen/activity_horizontal_margin"
            android:paddingBottom="2dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ellipsize="end"
            android:maxLines="1"
            android:gravity="center_horizontal"
            android:text="@{viewModel.text}"/>


    </LinearLayout>


</layout>
```

## Step 3: create UniqueAdapter for RecycleView
```
public class MainActivity extends AppCompatActivity implements UniquePresenter<ItemModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_example);

        List<ItemModel> dataList = getMockData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new UniqueAdapter(dataList, this));
    }

    @Override
    public void onClick(View view, ItemModel item) {
        if(item instanceof TextModel){
            Toast.makeText(this, ((TextModel)item).text, Toast.LENGTH_SHORT).show();
        } else if(item instanceof ImageModel){
            Toast.makeText(this, ((ImageModel)item).url, Toast.LENGTH_SHORT).show();
        }
    }


    private List<ItemModel> getMockData(){
        List<ItemModel> dataList = new ArrayList<>();
        dataList.add(new TextModel("Photo 1"));
        dataList.add(new ImageModel("http://ww2.sinaimg.cn/bmiddle/7a8aed7bjw1f340c8jrk4j20j60srgpf.jpg"));
        dataList.add(new TextModel("Photo 2"));
        dataList.add(new ImageModel("http://ww1.sinaimg.cn/bmiddle/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg"));

        return dataList;
    }
}
```
## Step 4: run
![unique-adapter-recycle-view](https://raw.githubusercontent.com/captain-miao/me.github.com/master/databinding/unique-adapter-recycle-view.jpg "unique-adapter-recycle-view")

# License

This project is licensed under the terms of the MIT license.