package com.example.listview;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextName,  editTextSurname, editTextUserName, editTextPassword,editTextDOB,editTextReTypePassword;
    private Button buttonRegister;
    private DataBaseHelper dataBaseHelper;
    SharePreference sharedpreferences;
    String name, surname,dob, userName, password, ReTypePassword;
    String gender = "";
    RadioButton male, female;
    RadioGroup radioGroup;
    private Calendar calendar;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sharedpreferences = new SharePreference(getApplicationContext());

        dataBaseHelper = new DataBaseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextReTypePassword = findViewById(R.id.editTextReTypePassword);


        male = findViewById(R.id.rdbMale);
        female = findViewById(R.id.rdbFemale);
        radioGroup = findViewById(R.id.RDGroup);

        calendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        editTextDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

//        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        RadioButton radioButton = findViewById(checkedId);
                        gender = radioButton.getText().toString();
                    }
                });
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString();
                surname = editTextSurname.getText().toString();
                userName = editTextUserName.getText().toString();
                dob = editTextDOB.getText().toString();
                ReTypePassword = editTextReTypePassword.getText().toString();
                password = editTextPassword.getText().toString();

                if (name.isEmpty()) {
                    editTextName.setError("Name Cannot be Empty");
                    return;
                } else {
                    editTextName.setError(null);
                }

                if (surname.isEmpty()) {
                    editTextSurname.setError("Surname Cannot be Empty");
                    return;
                } else {
                    editTextSurname.setError(null);
                }

                if (dob.isEmpty()) {
                    editTextDOB.setError("DOB Cannot be Empty");
                    showDatePickerDialog();
                    return;
                }

                if (radioGroup.getCheckedRadioButtonId() == -1 && gender.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please select your gender And Gender cannot be Empty ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (userName.isEmpty()) {
                    editTextUserName.setError("Username cannot be empty");
                    Toast.makeText(RegistrationActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    editTextUserName.setError(null);
                }

                if (password.isEmpty()) {
                    editTextPassword.setError("Password cannot be Empty");
                    Toast.makeText(RegistrationActivity.this, "Password cannot be Empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    editTextPassword.setError(null);
                }

                if (password.length() < 6 || password.length() > 10) {
                    editTextPassword.setError("You must have 6 character in your password");
                } else {
                    editTextPassword.setError(null);
                }

                if (ReTypePassword.isEmpty()){
                    editTextReTypePassword.setError("ReTypePassword cannot be Empty");
                    Toast.makeText(RegistrationActivity.this, "ReTypePassword cannot be Empty", Toast.LENGTH_SHORT).show();
                }else {
                    editTextReTypePassword.setError(null);
                }

                if (!password.equals(ReTypePassword)) {
                    editTextReTypePassword.setError("Password do not match");
                    return;
                } else {
                    editTextPassword.setError(null);
                    editTextReTypePassword.setError(null);
                }

                if ((!name.isEmpty()) && (!surname.isEmpty()) && (!dob.isEmpty()) && (!userName.isEmpty())
                        && (!password.isEmpty()) && (!ReTypePassword.isEmpty()) && (password.equals(ReTypePassword)))
                {
                    long result = dataBaseHelper.insertData(name, surname, gender, dob, userName, password, ReTypePassword);
                    if (result > 0) {
                        Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_LONG).show();
                        openDashBoard();
                        sharedpreferences.saveUsername(userName);
                        sharedpreferences.savePassword(password);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error has occurred", Toast.LENGTH_LONG).show();
                    }
                    editTextName.setText("");
                    editTextSurname.setText("");
                    editTextUserName.setText("");
                    editTextPassword.setText("");
                    editTextDOB.setText("");
                    editTextReTypePassword.setText("");
                }
            }
        });
    }
    private void openDashBoard() {
        Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year,month, dayOfMonth);
                        editTextDOB.setText(dateFormatter.format(calendar.getTime()));
                    }
                },
                calendar.get(calendar.YEAR),
                calendar.get(calendar.MONTH),
                calendar.get(calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}
//        sharedPreferences = getSharedPreferences(PREFERENCE_FILE_KEY,MODE_PRIVATE);

//                saveData();
//                openDashBoard();

//    private void saveData() {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("Name",name);
//        editor.putString("middleName",middleName);
//        editor.putString("dob",dob);
//        editor.putString("gender",gender);
//        editor.putString("userName",userName);
//        editor.putString("password",password);
//        editor.apply();

//                                if (gender.equals("Male"))
//                                {
//                                    gender = "Male";
//                                } else if (gender.equals("Female"))
//                                {
//                                    gender = "Female";
//                                }

