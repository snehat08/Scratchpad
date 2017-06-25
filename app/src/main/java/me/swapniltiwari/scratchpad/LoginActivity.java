package me.swapniltiwari.scratchpad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final PinEntryEditText txtPinEntry =
                (PinEntryEditText) findViewById(R.id.passwordEdit);
        txtPinEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start,
                                          int count,
                                          int after) {}

            @Override
            public void onTextChanged(CharSequence s,
                                      int start,
                                      int before,
                                      int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("1234")) {
                    startHome();
                } else if (s.length() == "1234".length()) {
                    Toast.makeText(LoginActivity.this,
                            "Incorrect", Toast.LENGTH_SHORT).show();
                    txtPinEntry.setText(null);
                }
            }
        });
    }

    private void startHome() {
        Intent startHomeActivity = new Intent(this,HomeActivity.class);
        startActivity(startHomeActivity);
    }

}
