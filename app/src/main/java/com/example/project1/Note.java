package com.example.project1;

import java.util.Date;

public class Note {
    public String title;
    public String description;
    public Date timeCreate;
    public boolean isChecked;

    public Note(String title, String description, Date timeCreate, boolean isChecked) {
        this.title = title;
        this.description = description;
        this.timeCreate = timeCreate;
        this.isChecked = isChecked;
    }

    public Note(String title, Date timeCreate, boolean isChecked) {
        this.title = title;
        this.description = null;
        this.timeCreate = timeCreate;
        this.isChecked = isChecked;
    }

    public String getDescription() {
        if (description == null) {
            return "";
        } else {
            return description;
        }
    }
    public String getCreateTime() {
        int h = timeCreate.getHours();
        int m = timeCreate.getMinutes();
        return h + ":" + m;
    }
}
