package com.example.calculator;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Calculator Display
    private TextView resultTextView;
    private TextView controlTextView;

    // Digits
    private Button zeroBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;

    // Miscellaneous
    private Button clearButton;
    private Button dotButton;
    private Button negativeNumberButton;

    // Division
    private Button divisionButton;
    private final char DIVISION = '/';
    // Multiplication
    private Button multiplicationButton;
    private final char MULTIPLICATION = '*';
    // Subtraction
    private Button subtractionButton;
    private final char SUBTRACTION = '-';
    // Addition
    private Button additionButton;
    private final char ADDITION = '+';
    // Equal
    private Button equalButton;
    private final char EQU = '=';
    // Can be any of the five above, or /0.
    private char ACTION;


    // For freezing the app.
    CountDownTimer countDownTimer;
    // Uh!
    MediaPlayer mediaPlayer;

    // Sets the maximum number of decimals to be displayed.
    private DecimalFormat df = new DecimalFormat("0.##");
    private double valueOne = Double.NaN;
    private double valueTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s0", controlTextView.getText().toString()));
                }
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s1", controlTextView.getText().toString()));
                }
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s2", controlTextView.getText().toString()));
                }
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s3", controlTextView.getText().toString()));
                }
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s4", controlTextView.getText().toString()));
                }
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s5", controlTextView.getText().toString()));
                }
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s6", controlTextView.getText().toString()));
                }
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s7", controlTextView.getText().toString()));
                }
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s8", controlTextView.getText().toString()));
                }
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();
                if((ACTION != EQU || Double.isNaN(valueOne)) && textLength < 10) {
                    negativeNumberButton.setEnabled(false);
                    controlTextView.setText(String.format("%s9", controlTextView.getText().toString()));
                }
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textLength = controlTextView.getText().toString().length();

                if((ACTION != EQU) || Double.isNaN(valueOne)) {
                    if(textLength == 0 || controlTextView.getText().toString().equals("-")) {
                        controlTextView.setText(String.format("%s0.", controlTextView.getText().toString()));
                    }
                    else if(textLength < 10) {
                        controlTextView.setText(String.format("%s.", controlTextView.getText().toString()));
                    }

                    dotButton.setEnabled(false);
                    negativeNumberButton.setEnabled(false);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uh);
                    mediaPlayer.start();
                }
            }
        });

        negativeNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controlTextView.getText().toString().isEmpty() && (Double.isNaN(valueOne) || ACTION != EQU)) {
                    controlTextView.setText(String.format("%s-", controlTextView.getText().toString()));
                    negativeNumberButton.setEnabled(false);
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.badumtss);
                mediaPlayer.start();
            }
        });

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Whether valueOne was initialized or there is text in controlTextView that is different from only "-".
                if(!Double.isNaN(valueOne) || (!controlTextView.getText().toString().isEmpty() && !controlTextView.getText().toString().equals("-")))
                    operationClickMethod(ADDITION);
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(valueOne) || (!controlTextView.getText().toString().isEmpty() && !controlTextView.getText().toString().equals("-")))
                    operationClickMethod(SUBTRACTION);
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(valueOne) || (!controlTextView.getText().toString().isEmpty() && !controlTextView.getText().toString().equals("-")))
                    operationClickMethod(MULTIPLICATION);
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(valueOne) || (!controlTextView.getText().toString().isEmpty() && !controlTextView.getText().toString().equals("-")))
                    operationClickMethod(DIVISION);
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!controlTextView.getText().toString().isEmpty() && !controlTextView.getText().toString().equals("-")) {
                    compute();

                    // Division by zero.
                    if(valueTwo == 0 && ACTION == DIVISION) {
                        freezeApp();
                    }
                    else {
                        controlTextView.setText(null);
                        ACTION = EQU;

                        if(String.valueOf(df.format(valueOne)).length() <= 11) {
                            resultTextView.setText(String.format("%s%s", ACTION, String.valueOf(df.format(valueOne))));

                        }
                        else {
                            freezeApp();
                        }
                    }
                }
                else if(!Double.isNaN(valueOne)){
                    ACTION = EQU;
                    resultTextView.setText(String.format("%s%s", ACTION, String.valueOf(df.format(valueOne))));
                    if(controlTextView.getText().toString().equals("-")) {
                        controlTextView.setText(null);
                    }
                }

                ACTION = EQU;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!controlTextView.getText().toString().isEmpty()) {
                    CharSequence currentText = controlTextView.getText();
                    controlTextView.setText(currentText.subSequence(0, currentText.length() - 1));

                    // Checking for already existing dots in the current text.
                    currentText = controlTextView.getText();
                    if(controlTextView.getText().toString().isEmpty() ||
                            !currentText.toString().contains(".")) {
                        dotButton.setEnabled(true);
                    }
                    if(controlTextView.getText().toString().isEmpty()) {
                        negativeNumberButton.setEnabled(true);
                    }
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    controlTextView.setText(null);
                    resultTextView.setText(null);
                    dotButton.setEnabled(true);
                    negativeNumberButton.setEnabled(true);
                }
            }
        });
    }

    private void setupUIViews() {
        zeroBtn = (Button) findViewById(R.id.button0);
        oneBtn = (Button) findViewById(R.id.oneButton);
        twoBtn = (Button) findViewById(R.id.twoButton);
        threeBtn = (Button) findViewById(R.id.threeButton);
        fourBtn = (Button) findViewById(R.id.fourButton);
        fiveBtn = (Button) findViewById(R.id.fiveButton);
        sixBtn = (Button) findViewById(R.id.sixButton);
        sevenBtn = (Button) findViewById(R.id.sevenButton);
        eightBtn = (Button) findViewById(R.id.eightButton);
        nineBtn = (Button) findViewById(R.id.nineButton);

        divisionButton = (Button) findViewById(R.id.divisionButton);
        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        subtractionButton = (Button) findViewById(R.id.subtractionButton);
        additionButton = (Button) findViewById(R.id.additionButton);
        equalButton = (Button) findViewById(R.id.equalButton);

        clearButton = (Button) findViewById(R.id.clearButton);
        dotButton = (Button) findViewById(R.id.dotButton);
        negativeNumberButton = (Button) findViewById(R.id.negativeNumberButton);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        controlTextView = (TextView) findViewById(R.id.controlTextView);

        StoreKeyboardButtons();
    }

    private void compute() {
        if(controlTextView.getText().toString().equals("-")) {
            freezeApp();
        }

        // If valueOne is a number.
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(controlTextView.getText().toString());

            switch(ACTION){
                case ADDITION:
                    valueOne += valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne -= valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne *= valueTwo;
                    break;
                case DIVISION:
                    valueOne /= valueTwo;
                    break;
                case EQU:
                    break;
            }
        }
        // If valueOne is not initialized, I set it to what's written in the controlTextView.
        else {
            valueOne = Double.parseDouble(controlTextView.getText().toString());
        }

        dotButton.setEnabled(true);
        negativeNumberButton.setEnabled(true);
    }

    // Whenever I click on an operation (which sets the action).
    public void operationClickMethod(char action) {
        if(controlTextView.getText().toString().equals("-")) {
            freezeApp();
        }
        else if(ACTION != EQU && controlTextView.getText().toString().isEmpty())
        {
            if(!Double.isNaN(valueOne))
            {
                switch(ACTION){
                    case ADDITION:
                        controlTextView.setText("0");
                        break;
                    case SUBTRACTION:
                        controlTextView.setText("0");
                        break;
                    case MULTIPLICATION:
                        controlTextView.setText("1");
                        break;
                    case DIVISION:
                        controlTextView.setText("1");
                        break;
                }
                compute();
                ACTION = action;
            }
        }
        else if(ACTION == EQU) {
            if(Double.isNaN(valueOne)) {
                if(!controlTextView.getText().toString().isEmpty()) {
                    compute();
                    ACTION = action;
                }
                else {

                }
            }
            else {
                switch(action){
                    case ADDITION:
                        controlTextView.setText("0");
                        break;
                    case SUBTRACTION:
                        controlTextView.setText("0");
                        break;
                    case MULTIPLICATION:
                        controlTextView.setText("1");
                        break;
                    case DIVISION:
                        controlTextView.setText("1");
                        break;
                }
                ACTION = action;
                compute();
                controlTextView.setText(null);
            }
        }
        else if(ACTION != action) {
            compute();
            ACTION = action;
        }
        else {
            ACTION = action;
            compute();
        }

        Display(ACTION);
    }


    public void Display(char action) {
        // If valueOne was initialized, I do display.
        if(!Double.isNaN(valueOne) && String.valueOf(df.format(valueOne)).length() <= 11) {
            if(resultTextView.getText().toString().isEmpty())
            {
                resultTextView.setText(String.format("%s%s", controlTextView.getText().toString(), action));
                controlTextView.setText(null);
            }
            else
            {
                resultTextView.setText(String.format("%s%s%s", EQU, df.format(valueOne), action));
                controlTextView.setText(null);
            }
        }
        else {
            freezeApp();
        }
    }

    private ArrayList<View> keyboardButtons;
    public void StoreKeyboardButtons() {
        TableLayout keyboard = (TableLayout) findViewById(R.id.tableLayout);
        keyboardButtons = keyboard.getTouchables();
    }

    // true ENABLES all buttons
    // false DISABLES all buttons
    public void ToggleKeyboard(boolean goToState) {

        for(View v : keyboardButtons) {
            v.setEnabled(goToState);
        }
    }


    public void freezeApp() {
        countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                controlTextView.setText(null);
                dotButton.setEnabled(true);
                ToggleKeyboard(true);
            }
        };

        ToggleKeyboard(false);
        resultTextView.setText(null);
        controlTextView.setText(getString(R.string.contain_yourself));

        countDownTimer.start();
    }
}
