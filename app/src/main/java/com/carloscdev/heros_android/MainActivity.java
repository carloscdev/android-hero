package com.carloscdev.heros_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.carloscdev.heros_android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bitmap imageBitmap;
    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data == null || data.getExtras() == null) {
                        Toast.makeText(this, "Error taking photo", Toast.LENGTH_SHORT).show();
                    } else {
                        imageBitmap = data.getExtras().getParcelable("data");
                        if (imageBitmap != null) {
                            binding.heroImage.setImageBitmap(imageBitmap);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v -> {
            String superHeroName = binding.heroNameEdit.getText().toString();
            String alterEgoName = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();
            openDetailActivity(superHeroName, alterEgoName, bio, rating);
        });

        binding.heroImage.setOnClickListener(v -> {
            openCamera();
        });
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(cameraIntent);
    }

    private void openDetailActivity(String superHeroName, String alterEgoName, String bio, float rating) {
        Superhero superhero = new Superhero(superHeroName, alterEgoName, bio, rating);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero);
        if (imageBitmap != null) {
            intent.putExtra(DetailActivity.BITMAP_KEY, imageBitmap);
        }
        startActivity(intent);
    }
}