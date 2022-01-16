package com.example.project1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("записка", "Hello, world!", new Date(), false));
        notes.add(new Note("n2", "qwerty, world!", new Date(), false));
        notes.add(new Note("qwerty1", "VasyaPupkin", new Date(), true));
        notes.add(new Note("записка3", "yayayyayayaa", new Date(), false));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        NoteAdapter noteAdapter = new NoteAdapter(notes);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextInfo = findViewById(R.id.editTextInfo);

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(editTextName.getText().toString(),
                        editTextInfo.getText().toString(),
                        new Date(),
                        false
                        );
                notes.add(note);
                editTextName.setText("");
                editTextInfo.setText("");
                noteAdapter.notifyDataSetChanged();

            }
        });


    }


}