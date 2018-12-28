package com.example.gspl.firebasebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    TextView textView1;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.text1);
        editText=findViewById(R.id.edit1);
        button=findViewById(R.id.button1);

        ref= FirebaseDatabase.getInstance().getReference().child("Student").child("name");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String str;
                str=dataSnapshot.getValue(String.class);
                //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                textView1.setText(str);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void but(View view) {
        String str2=editText.getText().toString();
        ref.setValue(str2);
        Toast.makeText(this, "value saved", Toast.LENGTH_SHORT).show();

    }
}
