package com.example.ticketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button botao_var;
    EditText email_var;
    private static final Pattern EMAIL_PADRAO = Pattern.compile("[a-zA-Z0-9*]+@gmail.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // RegEx: padrão qualquer@gmail
        botao_var = findWievById(R.id.btn_avancar);
        email_var = findViewById(R.id.etx_email);

        botao_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_var_2 = email_var.getText().toString();

                if(email_var_2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Não informou o e-mail!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
