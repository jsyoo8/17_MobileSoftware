package com.example.jsyoo8.ms_hw10_201302436;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int THREAD_PLAY = 0;
    final int THREAD_STOP = 1;
    int status = THREAD_STOP;
    int i = 0;
    ListView listView;
    ArrayList<ArrayList<Item>> dataBox;
    SendMessageHandler handler;
    ListThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        dataBox = new ArrayList<>();

        for (i = 0; i < 3; i++) {
            dataBox.add(i, new ArrayList<Item>());
            Item temp = new Item(R.drawable.customer, "Name" + i, "Phone" + i, "City" + i, i);
            dataBox.get(i).add(temp);
        }
        changeView(0);

        handler = new SendMessageHandler();
    }

    public void btnStart(View v) {
        if (status == THREAD_STOP) {
            thread = new ListThread(((Adapter) listView.getAdapter()).getData().get(0).getIndex());
            thread.start();
            status = THREAD_PLAY;
        }
    }

    public void btnStop(View v) {
        if (status == THREAD_PLAY) {
            handler.sendEmptyMessage(THREAD_STOP);
            status = THREAD_STOP;
        }
    }

    private void changeView(int i) {
        i = i % 3;
        Adapter adapter = new Adapter(this, R.layout.listview, dataBox.get(i));
        listView.setAdapter(adapter);

    }

    class SendMessageHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case THREAD_PLAY:
                    changeView(msg.arg1);
                    break;

                default:
                    thread.stopThread();
                    break;
            }
        }

    }

    class ListThread extends Thread implements Runnable {

        private boolean isPlay = false;
        int i;

        public ListThread(int i) {
            isPlay = true;
            this.i = i;
        }

        public void isThreadState(boolean isPlay) {
            this.isPlay = isPlay;
        }

        public void stopThread() {
            isPlay = !isPlay;
        }

        @Override
        public void run() {
            super.run();

            while (isPlay) {
                i++;
                Message msg = handler.obtainMessage();
                msg.what = THREAD_PLAY;
                msg.arg1 = i;
                handler.sendMessage(msg);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}