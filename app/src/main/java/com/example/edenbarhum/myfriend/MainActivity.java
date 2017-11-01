package com.example.edenbarhum.myfriend;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHandler;

    private Button insert;
    private Button select;

    private EditText nameET;
    private EditText lastNameET;
    private EditText ageET;

    private TextView tx;

    private ArrayList<String> list;
    private ArrayAdapter <String>arrayAdapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(MainActivity.this);

        nameET =(EditText)findViewById(R.id.editTextName);
        lastNameET =(EditText)findViewById(R.id.editTextLastName);
        ageET = (EditText)findViewById(R.id.editTextAge);

        listView = (ListView)findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row, R.id.listView, list) {

            @Override
            public View getView(int position, final View view, ViewGroup parent) {
                View v = super.getView(position, view, parent);
                tx = (TextView)view;

                    if(list.equals("eden barhum 20")) {
                        tx.setBackgroundColor(Color.RED);
                        Toast.makeText(MainActivity.this, "blue", Toast.LENGTH_SHORT).show();

                    }else if(list.equals("red")){
                        Toast.makeText(MainActivity.this, "red", Toast.LENGTH_SHORT).show();

                    }else if(list.equals("green")){

                        Toast.makeText(MainActivity.this, "green", Toast.LENGTH_SHORT).show();

                    }else if(list.equals("grey")){

                        Toast.makeText(MainActivity.this, "grey", Toast.LENGTH_SHORT).show();

                    }else  if (list.equals("yellow")){

                        Toast.makeText(MainActivity.this, "yellow", Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(MainActivity.this, "with out color", Toast.LENGTH_SHORT).show();
                        tx.setBackgroundColor(Color.YELLOW);
                    }
                return v;
            }
        };

        insert = (Button)findViewById(R.id.buttonInsert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String lastName = lastNameET.getText().toString();
                int age = Integer.parseInt(ageET.getText().toString());
                dbHandler.addFriend(name, lastName, age);
                Toast.makeText(MainActivity.this, "enter " + name, Toast.LENGTH_SHORT).show();
            }
        });

        select = (Button)findViewById(R.id.buttonSelect);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = dbHandler.getAllFriends();
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, list) {

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View v = super.getView(position, convertView, parent);

                        if (convertView == null) { // for the first time, inflate the view
                            LayoutInflater inflater =
                                    LayoutInflater.from(parent.getContext());
                            convertView = inflater.inflate(
                                    R.layout.row, parent, false);
                        }

                            if(position == 1 || position == 2 || position == 5 ) {
                                tx.setBackgroundColor(Color.BLUE);
                                Toast.makeText(MainActivity.this, "blue", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "with out color", Toast.LENGTH_SHORT).show();

                            }




                        return v;
                    }
                };
                listView.setAdapter(arrayAdapter);
            }
        });
    }
}
