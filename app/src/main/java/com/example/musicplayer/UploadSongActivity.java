package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class UploadSongActivity extends AppCompatActivity {
    Uri uriSong, image;
    byte[] bytes;
    String fileName, songUrl, imageUrl;
    String songLength;
    private StorageReference storageReference;
    ProgressDialog progressDialog;
    EditText selectSongNameEditText;
    EditText artistName;
    ImageView selectImage;
    Button uploadButton;
    ImageButton selectSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_song);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Song");
        storageReference = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        selectSongNameEditText = findViewById(R.id.selectSong);
        selectImage = findViewById(R.id.selectImage);
        uploadButton = findViewById(R.id.uploadSongButton);
        artistName = findViewById(R.id.artistNameEditText);
        selectSong = findViewById(R.id.selectSongButton);

        selectSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickSong();
            }
        });

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });
    }

    // SELECT THE SONG TO UPLOAD FROM MOBILE STORAGE
    private void pickSong() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        startActivityForResult(intent,1);
    }

