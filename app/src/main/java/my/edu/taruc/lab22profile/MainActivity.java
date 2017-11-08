package my.edu.taruc.lab22profile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "my.edu.taruc.lab22profile.name";
    public static final String PROFILE_EMAIL = "my.edu.taruc.lab22profile.email";
    private TextView textViewName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode = the unique code which identify an intent "number 1"
        //resultCode = the result returned by an intent; either ok or cancel.
        //data = the actual data returned by an intent
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK) {
            String name, email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name) + name);
            textViewEmail.setText(getString(R.string.email) + email);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity", "onPause");
    }

    public void visitBAIT(View v) {
        String uri = "http://bait2073.000webhostapp.com/welcome.html";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showMain(View v) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View v)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0123456789"));
        startActivity(intent);
    }

    public void showSendTo(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+"lincolntee@outlook.com"));
        startActivity(intent);
    }



    public void updateProfile(View view)
    {
        //Activity, Broadcast, Content, Service, =="ABCS"
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE_UPDATE);
    }
}
