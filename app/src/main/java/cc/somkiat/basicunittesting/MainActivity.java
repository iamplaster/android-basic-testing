package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.model.UserProfile;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);
    }


    public void onSaveClick(View view) {
        UserProfile userProfile = new UserProfile();
        NameValidation nameValidation = new NameValidation();
        EmailValidation emailValidation = new EmailValidation();
        userProfile.setChecker(nameValidation, emailValidation);
        userProfile.setName(nameInput.getText().toString());
        userProfile.setEmail(emailInput.getText().toString());
        Toast.makeText(getApplicationContext(), userProfile.getReport(), Toast.LENGTH_SHORT).show();
        userProfile.clearReport();
    }

    public void onRevertClick(View view) {
        nameInput.setText("");
        emailInput.setText("");
    }


}
