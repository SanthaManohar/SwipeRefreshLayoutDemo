package basicandroid.com.swiperefreshlayoutdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    TextView textView;
    ArrayAdapter adapter;
    List list;
    int items_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        listView = (ListView)findViewById(R.id.items_listview);
        textView = (TextView)findViewById(R.id.items_title);
        textView.setText("Swipe to Refresh...");


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshLayout();

            }
        });


    }

    private void refreshLayout(){

        switch(items_count){
            case 0:
                list = Arrays.asList(getResources().getStringArray(R.array.vehicle));
                textView.setText("Vehicle");
                break;
            case 1:
                list = Arrays.asList(getResources().getStringArray(R.array.books));
                textView.setText("Books");
                break;
            case 2:
                list = Arrays.asList(getResources().getStringArray(R.array.sweet));
                textView.setText("Sweet");
                break;
            case 3:
                list = Arrays.asList(getResources().getStringArray(R.array.vegtable));
                textView.setText("Vegtables");
                break;
            case 4:
                list = Arrays.asList(getResources().getStringArray(R.array.village));
                textView.setText("Village");
                break;
        }

        items_count++;
        adapter = new ArrayAdapter(this,R.layout.items_layout,list);
        listView.setAdapter(adapter);

        if(items_count>3){
            items_count = 0;
        }

        swipeRefreshLayout.setRefreshing(false);



    }



}
