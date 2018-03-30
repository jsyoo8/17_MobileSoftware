package com.example.jsyoo8.ms_hw02_201302436;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by jsyoo8 on 2017-09-21.
 */

public class Calculator {

    Vector<Integer> symbols;
    Vector<Integer> numbers;
    Vector<String> number;
    Context c;

    TextView tv;

    public Calculator(TextView _tv, Context _c) {
        symbols = new Vector<Integer>();
        numbers = new Vector<Integer>();
        number = new Vector<String>();
        tv = _tv;
        c = _c;
    }

    public void btnOnClick(View v) {
        int bid = v.getId();
        if (bid == R.id.bc) {
            clear();
        } else if (bid == R.id.br) {
            getResult();
        } else {
            if (bid == R.id.bp || bid == R.id.bs || bid == R.id.bm || bid == R.id.bd) {
                if (number.size() == 0 && numbers.size() == 0 && numbers.size() > symbols.size() && numbers.size() > symbols.size() + 1) {
                    eToast();
                } else {
                    this.symbolSave(v);
                    this.tPrint(v);
                }
            } else {
                this.numberSave(v);
                this.tPrint(v);
            }
        }
    }

    public void numberSave(View v) {
        String str = ((Button) v).getText().toString();
        number.add(str);
    }

    public void symbolSave(View v) {
        int bid = v.getId();
        symbols.add(bid);
        pushNumbers();
    }

    public void pushNumbers() {
        String result = "";
        Iterator<String> it = number.iterator();
        while (it.hasNext()) {
            result += it.next();
        }
        if(!result.equals("")){
            numbers.add(Integer.parseInt(result));
            number.clear();
        }
    }

    public void tPrint(View v) {
        StringBuilder str = new StringBuilder(tv.getText().toString());
        str.append(((Button) v).getText().toString());
        tv.setText(str.toString());
    }

    public void clear() {
        tv.setText("");
        symbols.clear();
        numbers.clear();
        number.clear();
    }

    public void getResult() {
        int result;
        pushNumbers();
        if (numbers.size() - symbols.size() == 1) {
            result = calculate();
            tToast(result);
        } else {
            eToast();
        }
    }

    public int calculate() {
        int i;
        int lValue;
        int rValue;
        int symbol;
        int result;
        result = 0;
        lValue = numbers.get(0);
        for (i = 0; i < symbols.size(); i++) {
            rValue = numbers.get(i + 1);
            symbol = symbols.get(i);
            switch (symbol) {
                case R.id.bp:
                    result = lValue + rValue;
                    break;
                case R.id.bs:
                    result = lValue - rValue;
                    break;
                case R.id.bm:
                    result = lValue * rValue;
                    break;
                case R.id.bd:
                    result = lValue / rValue;
                    break;
                default:
                    break;
            }
            lValue = result;
        }
        return result;
    }

    public void tToast(int result) {
        String message = String.valueOf(result);
        Toast.makeText(c, "result : " + message, Toast.LENGTH_LONG).show();
    }

    public void eToast() {
        Toast.makeText(c, "ERROR!", Toast.LENGTH_SHORT).show();
    }
}
