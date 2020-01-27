package pl.rzeszow.wsiz.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Instagram extends AppCompatActivity {

    WebView wv_webpage;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram);

        wv_webpage = (WebView) findViewById(R.id.wv_webpage);

        wv_webpage.setWebViewClient(new WebViewClient());
        wv_webpage.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();

        username = intent.getStringExtra("Instagram");

        wv_webpage.loadUrl("https://www.instagram.com/" + username);
    }
}
