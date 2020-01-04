package VoterMan.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

 public class MainActivity extends AppCompatActivity {
     Button login, Register;

     EditText Email_Address, Password;
     EditText C_Password,Gender, dob, name;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         login =  findViewById(R.id.login_navigation);
         Register = findViewById(R.id.sign_in_navigation);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                finish();

                background bg = new background(this);
                bg.execute(Email_Address, Password);

            }
        });

         Register.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent i = new Intent(MainActivity.this, Register.class);
                 startActivity(i);
                 finish();

                 background bg = new background();
                 bg.execute(Email_Address, Password, Gender, dob, C_Password, name);
             }

         });

         public static void loginbtn (View view)
         {
             String Email_Address = Email_Address.getText().toString();
             String Password = Password.getText().toString();
         };

         public static void registerbtn (View view)
         {
             String Email_Address = Email_Address.getText().toString();
             String Password = Password.getText().toString();
             String Gender = Gender.getText().toString();
             String dob = dob.getText().toString();
             String name = name.getText().toString();
             String C_Password = C_Password.getText().toString();
         };


     }
 }