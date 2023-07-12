package sg.edu.rp.c346.id22017139.myprofile;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;

    @Override
    protected void onPause() {
        super.onPause();
        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName=etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());
        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        //Step 1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit= prefs.edit();
        //Step 1d: Set a key-value pair in the editor
        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA",gpa );
        //Step 1e:Call commit() to save the changes made to the SharedPreference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Step 2a:Obtain the SHaredPreferences instance
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        //Step 2b: Retrieve the saved data from the SharedPreferences object
        String strName = prefs.getString("name", "John");
        float gpa=prefs.getFloat("gpa", 4);
        //with a default value if no matching data
        etGPA.setText(String.valueOf(gpa));
        etName.setText(strName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
    }
}