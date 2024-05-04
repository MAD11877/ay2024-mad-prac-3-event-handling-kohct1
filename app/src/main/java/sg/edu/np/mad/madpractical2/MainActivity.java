package sg.edu.np.mad.madpractical2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int random = new Random().nextInt(61) + 20;

        // Initialize a new User object
        User user = new User("MAD " + random, "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvBanner = findViewById(R.id.tvBanner);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button btnMessage = findViewById(R.id.btnMessage);

        // Set the TextViews with the User's name, description and default button message
        tvBanner.setText("MAD Practical");
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");
        btnMessage.setText("Message");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnFollow.getText() == "Follow") {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed",
                            Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MessageGroup.class));
            }
        });





    }
}