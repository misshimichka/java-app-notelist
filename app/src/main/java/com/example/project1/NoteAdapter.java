package com.example.project1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    public ArrayList<Note> notes;

    public NoteAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewInfo;
        TextView textViewName;
        TextView textViewDate;
        CheckBox checkBox;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewInfo = itemView.findViewById(R.id.textViewInfo);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            checkBox = itemView.findViewById(R.id.checkBox);

        }
        public void bind(Note note) {
            textViewName.setText(note.title);
            textViewInfo.setText(note.getDescription());
            textViewDate.setText(note.getCreateTime());
            checkBox.setChecked(note.isChecked);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    note.isChecked = isChecked;
                }
            });
        }




    }
}
