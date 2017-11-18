package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cc.somkiat.basicunittesting.validation.IsEmailPatternCheck;
import cc.somkiat.basicunittesting.validation.IsEmptyCheck;
import cc.somkiat.basicunittesting.validation.IsInRangeCheck;
import cc.somkiat.basicunittesting.validation.IsNullCheck;
import cc.somkiat.basicunittesting.validation.IsSpecialCharCheck;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    EditText emailInput;
    Boolean completeFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);
        Button saveButton = findViewById(R.id.saveButton);
        Button revertButton = findViewById(R.id.revertButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveClick();
            }
        });
        revertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRevertClick();
            }
        });
    }


    public void onSaveClick() {
        List<MyValidation> validations = new ArrayList<>();
        validations.add(new IsEmptyCheck());
        validations.add(new IsNullCheck());
        validations.add(new IsInRangeCheck());
        validations.add(new IsSpecialCharCheck());
        IsEmailPatternCheck isEmailPatternCheck = new IsEmailPatternCheck();
        completeFlag = true;
        for(MyValidation validation : validations){
            if(!validation.isValid(nameInput.getText().toString())) {
                Toast.makeText(getApplicationContext(), validation.getErrorMessage(), Toast.LENGTH_SHORT).show();
                completeFlag = false;
            }
        }
        if(!isEmailPatternCheck.isValid(emailInput.getText().toString())){
        Toast.makeText(getApplicationContext(), isEmailPatternCheck.getErrorMessage(), Toast.LENGTH_SHORT).show();
        completeFlag = false;
        }
        if(completeFlag){
            Toast.makeText(getApplicationContext(), "COMPLETE", Toast.LENGTH_SHORT).show();
        }




    }

    public void onRevertClick() {
        nameInput.setText("");
        emailInput.setText("");
    }


}
