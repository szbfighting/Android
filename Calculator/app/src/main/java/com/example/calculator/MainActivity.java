package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView textView;
    private StringBuilder s = new StringBuilder();
    private int flag = 0;
    private int flak = 0;
    private int flag2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textView = (TextView) findViewById(R.id.text_view);
        //textView.append("sss");
        Button button_0 = (Button) findViewById(R.id.button_0);
        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);
        Button button_4 = (Button) findViewById(R.id.button_4);
        Button button_5 = (Button) findViewById(R.id.button_5);
        Button button_6 = (Button) findViewById(R.id.button_6);
        Button button_7 = (Button) findViewById(R.id.button_7);
        Button button_8 = (Button) findViewById(R.id.button_8);
        Button button_9 = (Button) findViewById(R.id.button_9);
        Button button_jian = (Button) findViewById(R.id.button_jian);
        Button button_add = (Button) findViewById(R.id.button_add);
        Button button_c = (Button) findViewById(R.id.button_c);
        Button button_cheng = (Button) findViewById(R.id.button_cheng);
        Button button_chu = (Button) findViewById(R.id.button_chu);
        Button button_del = (Button) findViewById(R.id.button_del);
        Button button_point = (Button) findViewById(R.id.button_point);
        Button button_res = (Button) findViewById(R.id.button_res);
        Button button_back = (Button) findViewById(R.id.button_back);
        Button button_left = (Button)findViewById(R.id.button_left);
        Button button_right = (Button)findViewById(R.id.button_right);

        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_jian.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_chu.setOnClickListener(this);
        button_cheng.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_res.setOnClickListener(this);
        button_back.setOnClickListener(this);

        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (s.length() > 100) {
            s.delete(0, s.length());
            textView.setText("");
            Toast.makeText(this, "Out of range", Toast.LENGTH_SHORT).show();
        }
        switch (view.getId()) {
            case R.id.button_0:
                if(flag==0) {
                        flag = 1;
                        textView.append("0");
                        s.append("0");
                        Log.d(TAG, "onClick: 000" + flag);
                        break;
                }
                    if (flag == 1)
                        break;

                    break;

            case R.id.button_1:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '1');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("1");
                        s.append("1");
                    }
                }

                break;
            case R.id.button_2:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '2');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("2");
                        s.append("2");
                    }
                }
                break;
            case R.id.button_3:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '3');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("3");
                        s.append("3");
                    }
                }
                break;
            case R.id.button_4:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '4');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("4");
                        s.append("4");
                    }
                }
                break;
            case R.id.button_5:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '5');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("5");
                        s.append("5");
                    }
                }
                break;
            case R.id.button_6:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '6');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("6");
                        s.append("6");
                    }
                }
                break;
            case R.id.button_7:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '7');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("7");
                        s.append("7");
                    }
                }
                break;
            case R.id.button_8:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '8');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("8");
                        s.append("8");
                    }
                }
                break;
            case R.id.button_9:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1) {
                        s.setCharAt(s.length() - 1, '9');
                        textView.setText(s);
                        flag = 0;
                    } else {
                        textView.append("9");
                        s.append("9");
                    }
                }
                break;
            case R.id.button_add:
                if (flag == 1) {
                    textView.append("+");
                    s.append("+");
                    flag = 0;
                    flak = 0;
                    break;
                }
                if (s.length() != 0 && (s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '×' || s.charAt(s.length() - 1) == '÷')) {
                    s.setCharAt(s.length() - 1, '+');
                    textView.setText(s);
                } else if (s.length() == 0 || s.charAt(s.length() - 1) == '(') {
                    textView.append("0+");
                    s.append("0+");
                } else {
                    textView.append("+");
                    s.append("+");
                }
                flak = 0;
                break;
            case R.id.button_c:
                textView.setText("");
                s.delete(0, s.length());
                flag = 0;
                flak = 0;
                flag2 = 0;
                Log.d(TAG, "onClick: " + s);
                break;
            case R.id.button_cheng:
                if (flag == 1) {
                    textView.append("×");
                    s.append("×");
                    flag = 0;
                    flak = 0;
                    break;
                }
                if (s.length() == 0)
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                else if (s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '×' || s.charAt(s.length() - 1) == '÷') {
                    s.setCharAt(s.length() - 1, '×');
                    textView.setText(s);
                } else {
                    textView.append("×");
                    s.append("×");
                }
                flak = 0;
                break;
            case R.id.button_chu:
                if (flag == 1) {
                    textView.append("÷");
                    s.append("÷");
                    flag = 0;
                    flak = 0;
                    break;
                }
                if (s.length() == 0)
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                else if (s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '×' || s.charAt(s.length() - 1) == '÷') {
                    s.setCharAt(s.length() - 1, '÷');
                    textView.setText(s);
                } else {
                    textView.append("÷");
                    s.append("÷");
                }
                flak = 0;
                break;
            case R.id.button_del:
                char c;
                if (s.length() != 0) {
                    c = s.charAt(s.length() - 1);
                    s.delete(s.length() - 1, s.length());
                    if (c == '(')
                        flag2--;
                    if (c == ')')
                        flag2++;
                    if (c == '.')
                        flak = 0;
                }
                textView.setText(s);
                Log.d(TAG, "onClick: " + s);
                break;
            case R.id.button_jian:
                if (flag == 1) {
                    textView.append("-");
                    s.append("-");
                    flag = 0;
                    flak = 0;
                    break;
                }
                if (s.length() > 0 && s.charAt(s.length() - 1) == '+') {
                    s.setCharAt(s.length() - 1, '-');
                    textView.setText(s);
                } else if (s.length() > 0 && s.charAt(s.length() - 1) == '-') {
                    s.setCharAt(s.length() - 1, '+');
                    textView.setText(s);
                } else if (s.length() == 0||s.charAt(s.length()-1)=='(') {
                    s.append("0-");
                    textView.setText(s);
                } else {
                    s.append("-");
                    textView.append("-");
                }
                flak = 0;
                Log.d(TAG, "onClick: "+s);
                break;
            case R.id.button_point:
                if (s.length()==0||s.charAt(s.length()-1)!=')') {
                    if (flag == 1 && flak == 0) {
                        textView.append(".");
                        s.append(".");
                        flag = 0;
                        flak = 1;
                        break;
                    }
                    if (flak == 1)
                        break;
                    if (flak == 0) {
                        if (s.length() == 0 || !(s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9')) {
                            textView.append("0.");
                            s.append("0.");
                        } else {
                            textView.append(".");
                            s.append(".");
                        }
                    }
                    flak = 1;
                }
                break;
            case R.id.button_res:
                if (s.length() == 0)
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                else
                if(s.charAt(s.length()-1)==')'||(s.charAt(s.length()-1)>='0'&&s.charAt(s.length()-1)<='9')) {
                    Log.d(TAG, "onClick: " + s);
                    flag = 0;
                    flak = 0;

                    if (s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-')
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    else {
                        for (int i = 0; i < flag2; i++) {
                            s.append(")");
                            textView.setText(s);
                        }
                        flag2 = 0;
                        zhongResults();
                    }
                    s.delete(0, s.length());
                }else
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_back:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog.");
                dialog.setMessage("Are you sure exit ?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
                break;
            case R.id.button_left:
                if(s.length()==0||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='×'||s.charAt(s.length()-1)=='÷'||s.charAt(s.length()-1)=='('){
                    s.append("(");
                    textView.append("(");
                    flag2++;
                    break;
                }
            case R.id.button_right:
                if(flag2>0) {
                    if (s.length() == 0 || s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '×' || s.charAt(s.length() - 1) == '÷') {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    } else {
                        s.append(")");
                        textView.append(")");
                        flag2--;
                    }
                    break;
                }
        }

    }
    public void zhongResults(){
        int[] arr = new int[s.length()];
        int flag=0;
        for (int i = 0; i < s.length();i++ ) {
            if(s.charAt(i)=='('){
                arr[flag++]=i;

            }else if(s.charAt(i)==')'){

                String l = finalResults(s.substring(arr[--flag]+1, i));
                if(l.equals("Cannot divide by 0")){
                    s=new StringBuilder(l);
                    break;
                }
                if(arr[flag]-1>0&&s.charAt(arr[flag]-1)=='+'&&Double.parseDouble(l)<0){
                    s.replace(arr[flag]-1, i+1, l);
                }else if(arr[flag]-1>0&&s.charAt(arr[flag]-1)=='-'&&Double.parseDouble(l)<0){
                    s.replace(arr[flag]-1, i+1, l);
                    s.setCharAt(arr[flag]-1, '+');;
                }
                else if(arr[flag]==0&&Double.parseDouble(l)<0){
                    s.replace(arr[flag], i+1, l);
                    s.insert(arr[flag], '0');
                }
                else if(arr[flag]-1>0&&s.charAt(arr[flag]-1)=='('&&Double.parseDouble(l)<0){
                    s.replace(arr[flag], i+1, "0-"+l);
                }else
                    s.replace(arr[flag], i+1, l);
                i=arr[flag];
            }
        }
        if(s.toString().equals("Cannot divide by 0"))
            textView.setText(s.toString());
        else
            textView.setText(finalResults(s.toString()));
    }
    public String finalResults(String g) {
        int i=0,j=0;
        char[] l =g.toCharArray();
        char[] flag = new char[l.length];
        int t=0;
        for(i =0;i<l.length;){
            for( j = i+1;j<l.length;j++){
                if(l[j]=='+'||l[j]=='×'||l[j]=='÷'||l[j]=='-'){
                    if(i==0){
                        if(l[j+1]=='-'){
                            l[j+1]='0';
                            flag[t++]='-';
                        }else
                            t++;
                        i=j;
                        break;
                    }else if(l[j]=='×'||l[j]=='÷'){
                        if(l[j+1]=='-'){
                            l[j+1]='0';
                            flag[t++]='-';
                        }
                    }else
                        t++;
                }
            }
            i=j;
        }
        String ss = new String(l);
        String index = "[×÷+-]";
        String[] shuzi = ss.split(index);
        String regex = "[0-9.]";
        String[] fuhao = ss.split(regex);
        String[] fuhao2 = new String[shuzi.length-1];
        int q=0;

        for (String string : fuhao) {
            if(string.equals("+")||string.equals("-")||string.equals("×")||string.equals("÷")){
                fuhao2[q++]=string;
            }
        }
        BigDecimal[] bd = new BigDecimal[shuzi.length];
        for (int k = 0; k < shuzi.length; k++) {
            bd[k]=new BigDecimal(shuzi[k]);
        }
        int o=fuhao2.length;
        int p=bd.length;
        int pg=0;
        for (int k = 0; k < o; ) {
            if(fuhao2[k].equals("×")){
                bd[k]=bd[k].multiply(bd[k+1]);
                if(flag[pg]=='-'){
                    bd[k]=bd[k].negate();
                }
                for (int k2 = k+1; k2 < p-1; k2++) {
                    bd[k2]=bd[k2+1];
                }
                for (int k2 = k; k2 < o-1; k2++) {
                    fuhao2[k2]=fuhao2[k2+1];
                }
                o--;
                p--;
                pg++;
            }else if(fuhao2[k].equals("÷")){
                if(String.valueOf(bd[k].doubleValue()/bd[k+1].doubleValue()).equals("Infinity")){
                    return "Cannot divide by 0";
                }
                bd[k]=new BigDecimal(String.valueOf(bd[k].divide(bd[k+1],9,BigDecimal.ROUND_HALF_UP).doubleValue()));
                if(flag[pg]=='-'){
                    bd[k]=bd[k].negate();
                }
                for (int k2 = k+1; k2 < p-1; k2++) {
                    bd[k2]=bd[k2+1];

                }
                for (int k2 = k; k2 < o-1; k2++) {
                    fuhao2[k2]=fuhao2[k2+1];
                }
                o--;
                p--;
                pg++;
            }else{
                k++;
                pg++;
            }
        }
        BigDecimal sum = bd[0];
        for (int k =1; k < p; k++) {
            if(fuhao2[k-1].equals("+")){
                sum=sum.add(bd[k]);
            }
            if(fuhao2[k-1].equals("-")){
                sum=sum.subtract(bd[k]);
            }
        }
        return String.valueOf(sum.doubleValue());
        /*s.delete(0,s.length());
        textView.setText(String.valueOf(sum.doubleValue()));*/
    }
}
