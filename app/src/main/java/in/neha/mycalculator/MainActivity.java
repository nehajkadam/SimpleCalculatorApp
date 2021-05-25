package in.neha.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    private Button mSeven,mEight,mNine,mFive,mFour,mThree,mOne,mTwo,mZero,mSix;
    private Button mDiv,mMul,mAdd,mEqual,mMinus,mClr,mDot;
    private TextView  mUesrInput,mFinalResult;

    private final char ADD='+';
    private final char SUB='-';
    private final char MUL='*';
    private final char DIV='/';
    private final char EQU='0';
    private final char  DOT='.';

    private Double val1=Double.NaN;
    private Double val2;
    private char choice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "0");
            }
        });

        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "1");


            }
        });

        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "2");
            }
        });

        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "3");
            }
        });

        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "4");
            }
        });

        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "5");
            }
        });

        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "6");
            }
        });

        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "7");
            }
        });

        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "8");
            }
        });

        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + "9");
            }
        });

        mDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUesrInput.setText(mUesrInput.getText().toString() + ".");

            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                choice=ADD;
                mFinalResult.setText(String.valueOf(val1) + "+");
                mUesrInput.setText(null);

            }
        });

        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                choice=SUB;
                mFinalResult.setText(String.valueOf(val1) + "-");
                mUesrInput.setText(null);
            }
        });

        mMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                choice=MUL;
                mFinalResult.setText(String.valueOf(val1) + "*");
                mUesrInput.setText(null);
            }
        });

        mDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                choice=DIV;
                mFinalResult.setText(String.valueOf(val1) + "/");
                mUesrInput.setText(null);
            }
        });

        mEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                choice=EQU;
                mFinalResult.setText( mFinalResult.getText().toString() + String.valueOf(val2)  + "=" + String.valueOf(val1));


            }
        });

        mClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUesrInput.getText().length() > 0){
                    CharSequence name=mUesrInput.getText().toString();
                    mUesrInput.setText(name.subSequence(0, name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    mUesrInput.setText(null);
                    mFinalResult.setText(null);
                }

            }
        });

    }

    private void init() {

        mNine = (Button) findViewById(R.id.btn_nine);
        mEight = (Button) findViewById(R.id.btn_eight);
        mSeven = (Button) findViewById(R.id.btn_seven);
        mSix = (Button) findViewById(R.id.btn_six);
        mFive = (Button) findViewById(R.id.btn_five);
        mFour = (Button) findViewById(R.id.btn_four);
        mThree = (Button) findViewById(R.id.btn_three);
        mTwo = (Button) findViewById(R.id.btn_two);
        mOne = (Button) findViewById(R.id.btn_one);
        mZero = (Button) findViewById(R.id.btn_zero);

        mDiv = (Button) findViewById(R.id.btn_div);
        mMul = (Button) findViewById(R.id.btn_mul);
        mAdd= (Button) findViewById(R.id.btn_add);
        mMinus = (Button) findViewById(R.id.btn_minus);
        mEqual = (Button) findViewById(R.id.btn_equal);
        mClr = (Button) findViewById(R.id.btn_clear);
        mDot=(Button)findViewById(R.id.btn_dot);

        mUesrInput = (TextView) findViewById(R.id.txtv_uesrInput);
        mFinalResult = (TextView) findViewById(R.id.txtv_finalResult);
    }


    private void compute(){

        if(!Double.isNaN(val1)) {

            val2 = Double.parseDouble(mUesrInput.getText().toString());

            switch (choice) {

                case ADD:
                    val1 = val1 + val2;
                    break;

                case SUB:
                    val1 = val1 - val2;
                    break;

                case MUL:
                    val1 = val1 * val2;
                    break;

                case DIV:
                    val1 = val1 / val2;
                    break;

                case EQU:
                    break;

            }

        }

        else {

            val1 = Double.parseDouble(mUesrInput.getText().toString());
        }

    }






























}