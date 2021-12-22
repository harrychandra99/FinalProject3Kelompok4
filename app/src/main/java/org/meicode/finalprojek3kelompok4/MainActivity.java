package org.meicode.finalprojek3kelompok4;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.meicode.finalprojek3kelompok4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        display = binding.tvInputAngka;
        display.setShowSoftInputOnFocus(false);


        binding.tvInputAngka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.InputAngka).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

}

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.InputAngka).equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr,strToAdd, rightStr));
        }
        display.setSelection(cursorPos + 1);

    }

    public void zeroBtn(View view){
        updateText("0");
    }

    public void oneBtn(View view){
        updateText("1");
    }

    public void twoBtn(View view){
        updateText("2");
    }

    public void threeBtn(View view){
        updateText("3");
    }

    public void fourBtn(View view){
        updateText("4");
    }

    public void fiveBtn(View view){
        updateText("5");
    }

    public void sixBtn(View view){
        updateText("6");
    }

    public void sevenBtn(View view){
        updateText("7");
    }

    public void eightBtn(View view){
        updateText("8");
    }

    public void nineBtn(View view){
        updateText("9");
    }

    public void clearBtn(View view){
        display.setText("");
    }

    public void penjumlahanBtn(View view){
        updateText("+");
    }

    public void penguranganBtn(View view){
        updateText("-");
    }

    public void perkalianBtn(View view){
        updateText("X");
    }

    public void pembagianBtn(View view){
        updateText("/");
    }

    public void decimalBtn(View view){
        updateText(".");
    }

    public void answerBtn(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("X", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void deleteBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textlen = display.getText().length();

        if (cursorPos !=0 && textlen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

}