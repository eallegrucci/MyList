package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

public class ListItem extends AppCompatActivity {
    private int mImageResource;
    private String mName;
    private String mReference;

    public ListItem(int imageResource, String name, String reference) {
        mImageResource = imageResource;
        mName = name;
        mReference = reference;
    }

    int getImageResource() {
        return mImageResource;
    }

    String getName() {
        return mName;
    }

    String getReference() {
        return mReference;
    }

    public void changeView(String ref) {
        mName = ref;
    }
}
