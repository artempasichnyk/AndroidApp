package pl.rzeszow.wsiz.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Collections;

public class Add extends AppCompatActivity implements View.OnClickListener {

    EditText et_name, et_youtube, et_facebook, et_twitter, et_vkontakte, et_instagram;
    ImageButton ib_adduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        et_name = (EditText) findViewById(R.id.et_name);
        et_youtube = (EditText) findViewById(R.id.et_youtube);
        et_facebook = (EditText) findViewById(R.id.et_facebook);
        et_twitter = (EditText) findViewById(R.id.et_twitter);
        et_vkontakte = (EditText) findViewById(R.id.et_vkontakte);
        et_instagram = (EditText) findViewById(R.id.et_instagram);
        ib_adduser = (ImageButton) findViewById(R.id.ib_adduser);

        ib_adduser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_adduser:
                Intent intent = new Intent();

                String name = et_name.getText().toString(),
                        youtube = et_youtube.getText().toString(),
                        facebook = et_facebook.getText().toString(),
                        twitter = et_twitter.getText().toString(),
                        vkontakte = et_vkontakte.getText().toString(),
                        instagram = et_instagram.getText().toString();

                ArrayList<String> datalist = new ArrayList<>();

                Collections.addAll(datalist, name, youtube, facebook, twitter, vkontakte, instagram);

                intent.putStringArrayListExtra("pl.rzeszow.wsiz.projekt.data", datalist);

                if (!name.equals("") &&
                        (!youtube.equals("") || !facebook.equals("") || !twitter.equals("") || !vkontakte.equals("") || !instagram.equals("")))
                {
                    setResult(RESULT_OK, intent);
                    finish();
                }
        }
    }
}
