package com.example.jsyoo8.ms_hw05_201302436;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    Button date;
    Button time;
    EditText name;
    EditText phoneNumber;

    Calendar calendar;

    int year, month, day, hours, minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        date = (Button) findViewById(R.id.date);
        time = (Button) findViewById(R.id.time);

        calendar = new GregorianCalendar();
        //calendar.add(Calendar.HOUR_OF_DAY, 9); //시차 9시간

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);

        String _date = String.format("%d년 %d월 %d일", year, (month+1), day);
        date.setText(_date);

        String _time = String.format("%d시 %d분", hours, minutes);
        time.setText(_time);
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("_name"))) {
            String _name = pref.getString("_name", "");
            name.setText(_name);
        }
        if ((pref != null) && (pref.contains("_phoneNumber"))) {
            String _phoneNumber = pref.getString("_phoneNumber", "");
            phoneNumber.setText(_phoneNumber);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("_name", name.getText().toString());
        editor.commit();
        editor.putString("_phoneNumber", phoneNumber.getText().toString());
        editor.commit();
    }

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int _year, int _month, int _day) {
            String _date = String.format("%d년 %d월 %d일", _year, _month+1, _day);
            year = _year;
            month = _month;
            day = _day;
            date.setText(_date);
        }
    };

    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int _hours, int _minutes) {
            String _time = String.format("%d시 %d분", _hours, _minutes);
            hours = _hours;
            minutes = _minutes;
            time.setText(_time);
        }
    };

    public void onButtonClickedDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateListener, year, month, day);
        datePickerDialog.show();
    }

    public void onButtonClickedTime(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeListener, hours, minutes, false);
        timePickerDialog.show();
    }

    protected void onPause() {
        super.onPause();

        saveState();
    }

    protected void onResume() {
        super.onResume();

        restoreState();
    }

    public void onButtonClickedSave(View view) {
        saveState();

        Toast.makeText(getApplicationContext(), "이름: " + name.getText() + ", 번호: " + phoneNumber.getText() + ", 날짜: " + year + "년 " + (month+1) + "월 " + day + "일, 시간: " + hours + "시 " + minutes + "분", Toast.LENGTH_LONG).show();
    }
}

