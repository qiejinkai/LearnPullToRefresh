package com.example.qiejinkai.learnpulltorefresh;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private PullToRefreshListView plv;
    private ArrayAdapter<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plv = (PullToRefreshListView) findViewById(R.id.lv);
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        data = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        plv.setAdapter(data);

        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {

                        try {
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {

                        data.add("wangzhe");
                        data.add("zhanglong");
                        plv.onRefreshComplete();
                    }
                }.execute();
            }
        });

    }

}
