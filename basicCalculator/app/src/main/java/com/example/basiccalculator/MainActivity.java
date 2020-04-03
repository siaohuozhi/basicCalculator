package com.example.basiccalculator;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import android.view.View;
import com.fathzer.soft.javaluator.*;




public class MainActivity extends AppCompatActivity {

    private EditText e1, e2;
    private int count=0;
    private String expression="";
    private String text="";
    private Double result=0.0;
    private int toggleMode=1;
    private int angleMode=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);



    }

    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);
            e2.setText("");
            count=0;
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }

    public void onClick(View v)
    {
        switch(v.getId()) {
            case R.id.num0:
                e2.setText(e2.getText() + "0");
                break;

            case R.id.num1:
                e2.setText(e2.getText() + "1");
                break;

            case R.id.num2:
                e2.setText(e2.getText() + "2");
                break;

            case R.id.num3:
                e2.setText(e2.getText() + "3");
                break;


            case R.id.num4:
                e2.setText(e2.getText() + "4");
                break;

            case R.id.num5:
                e2.setText(e2.getText() + "5");
                break;

            case R.id.num6:
                e2.setText(e2.getText() + "6");
                break;

            case R.id.num7:
                e2.setText(e2.getText() + "7");
                break;

            case R.id.num8:
                e2.setText(e2.getText() + "8");
                break;

            case R.id.num9:
                e2.setText(e2.getText() + "9");
                break;

            case R.id.dot:
                if (count == 0 && e2.length() != 0) {
                    e2.setText(e2.getText() + ".");
                    count++;
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count = 0;
                expression = "";
                break;
            case R.id.plus:
                operationClicked("+");
                break;

            case R.id.minus:
                operationClicked("-");
                break;

            case R.id.divide:
                operationClicked("/");
                break;

            case R.id.multiply:
                operationClicked("*");
                break;

            case R.id.sin:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    if(angleMode==1)
                    {
                        double angle=Math.toRadians(new ExtendedDoubleEvaluator().evaluate(text));
                        if(toggleMode==1)
                            e2.setText("sin(" + angle + ")");
                        else if(toggleMode==2)
                            e2.setText("asind(" + text + ")");
                        else
                            e2.setText("sinh(" + text + ")");
                    }
                    else
                    {
                        if(toggleMode==1)
                            e2.setText("sin(" + text + ")");
                        else if(toggleMode==2)
                            e2.setText("asin(" + text + ")");
                        else
                            e2.setText("sinh(" + text + ")");
                    }
                }
                break;

            case R.id.cos:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    if(angleMode==1)
                    {
                        double angle=Math.toRadians(new ExtendedDoubleEvaluator().evaluate(text));
                        if(toggleMode==1)
                            e2.setText("cos(" + angle + ")");
                        else if(toggleMode==2)
                            e2.setText("acosd(" + text + ")");
                        else
                            e2.setText("cosh(" + text + ")");
                    }
                    else
                    {
                        if(toggleMode==1)
                            e2.setText("cos(" + text + ")");
                        else if(toggleMode==2)
                            e2.setText("acos(" + text + ")");
                        else
                            e2.setText("cosh(" + text + ")");
                    }
                }
                break;

            case R.id.tan:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    if(angleMode==1)
                    {
                        double angle=Math.toRadians(new ExtendedDoubleEvaluator().evaluate(text));
                        if(toggleMode==1)
                            e2.setText("tan(" + angle + ")");
                        else if(toggleMode==2)
                            e2.setText("atand(" + text + ")");
                        else
                            e2.setText("tanh(" + text + ")");
                    }
                    else
                    {
                        if(toggleMode==1)
                            e2.setText("tan(" + text + ")");
                        else if(toggleMode==2)
                            e2.setText("atan(" + text + ")");
                        else
                            e2.setText("tanh(" + text + ")");
                    }
                }
                break;


            case R.id.equal:
                /*for more knowledge on DoubleEvaluator and its tutorial go to the below link
                http://javaluator.sourceforge.net/en/home/*/
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    expression=e1.getText().toString()+text;
                }
                e1.setText("");
                if(expression.length()==0)
                    expression="0.0";
                try
                {
                    //evaluate the expression
                    result=new ExtendedDoubleEvaluator().evaluate(expression);
                    e2.setText(result+"");
                }
                catch (Exception e)
                {
                    e2.setText("Invalid Expression");
                    e1.setText("");
                    expression="";
                    e.printStackTrace();
                }
                break;
        }
    }
}
