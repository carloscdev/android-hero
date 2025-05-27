package com.carloscdev.heros_android;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.carloscdev.heros_android.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String SUPERHERO_KEY = "superhero";
    public static final String BITMAP_KEY = "bitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        Superhero superhero = extras != null ? extras.getParcelable(SUPERHERO_KEY) : null;
        Bitmap bitmap = extras != null ? extras.getParcelable(BITMAP_KEY) : null;
        if (bitmap != null) {
            binding.imageView.setImageBitmap(bitmap);
        }
        binding.setSuperhero(superhero);
    }
}