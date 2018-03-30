package com.example.jsyoo8.ms_hw08_201302436;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    GridView gridView;
    SimpleAdapter adapter;

    class SimpleAdapter extends BaseAdapter {
        ArrayList<SimpleItem> items = new ArrayList<SimpleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SimpleItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public void removeItem(int i) {
            items.remove(i);
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            SimpleItemView view = new SimpleItemView(getApplicationContext());

            SimpleItem item = items.get(i);
            view.setName("[" + item.getManufact() + "] " + item.getName());
            view.setPrice(item.getPrice());
            view.setProduct(item.getProduct());
            view.setImage(item.getResId());

            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new SimpleAdapter();

        adapter.addItem(new SimpleItem("빈폴", "롱 코트", "30,000", "기획상품", R.drawable.clothes1));
        adapter.addItem(new SimpleItem("나이키", "운동화", "70,000", "특가상품", R.drawable.clothes2));
        adapter.addItem(new SimpleItem("폴로", "남방", "150,000", "계절상품", R.drawable.clothes3));
        adapter.addItem(new SimpleItem("리바이스", "모자", "40,000", "반짝상품", R.drawable.clothes4));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SimpleItem item = (SimpleItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택된 제품 : " + item.getName() + "\n가격 : " + item.getPrice(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_add) {
            Intent intent = new Intent(getApplicationContext(), AddActivity.class);

            SimpleData data = new SimpleData();
            intent.putExtra(KEY_SIMPLE_DATA, data);
            startActivityForResult(intent, REQUEST_CODE_MENU);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_MENU && data != null) {
            Bundle bundle = data.getExtras();
            SimpleData simpleData = bundle.getParcelable(KEY_SIMPLE_DATA);
            adapter.addItem(new SimpleItem(simpleData.getManufact(), simpleData.getName(), simpleData.getPrice(), simpleData.getProduct(), simpleData.getResId()));
            gridView.setAdapter(adapter);
            Toast.makeText(getApplicationContext(), "상품이 등록되었습니다.", Toast.LENGTH_LONG).show();
        }
    }

}
