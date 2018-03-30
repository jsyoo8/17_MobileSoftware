package com.example.jsyoo8.ms_hw07_201302436;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    InfoAdapter adapter;
    private int num;

    class InfoAdapter extends BaseAdapter {
        ArrayList<InfoItem> items = new ArrayList<InfoItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(InfoItem item) {
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
            InfoItemView view = new InfoItemView(getApplicationContext());

            InfoItem item = items.get(i);
            view.setName(item.getName());
            view.setPhone(item.getPhone());
            view.setDate(item.getDate());
            view.setImage(item.getImg());

            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        final EditText name = (EditText) findViewById(R.id.EName);
        final EditText date = (EditText) findViewById(R.id.EDate);
        final EditText phone = (EditText) findViewById(R.id.EPhone);
        final TextView number = (TextView) findViewById(R.id.number);


        final ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new InfoAdapter();
        adapter.addItem(new InfoItem("유정식", "010-2613-4141", "1994-10-21", R.drawable.customer));
        num = 1;
        number.setText(num + "명");
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("안내")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                num--;
                                number.setText(num + "명");
                                adapter.removeItem(position);
                                listView.setAdapter(adapter);
                            }
                        })
                        .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create().show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name, _phone, _date;
                _name = name.getText().toString();
                _date = date.getText().toString();
                _phone = phone.getText().toString();

                if (!_name.equals("") && !_phone.equals("") && !_date.equals("")) {
                    adapter.addItem(new InfoItem(_name, _phone, _date, R.drawable.customer));
                    listView.setAdapter(adapter);
                    num++;
                    number.setText(num + "명");

                    name.setText("");
                    date.setText("");
                    phone.setText("");
                }

            }
        });

    }
}
