package com.ProjectUAS.ReportApp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ProjectUAS.ReportApp.R;
import com.ProjectUAS.ReportApp.ui.history.HistoryActivity;
import com.ProjectUAS.ReportApp.ui.report.ReportActivity;
import com.ProjectUAS.ReportApp.utils.Constant;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;

public class MainActivity extends AppCompatActivity {

    int REQ_PERMISSION = 100;
    double strCurrentLatitude;
    double strCurrentLongitude;
    String strTitle;
    CardView cvPS, cvBeritaHoax, cvKriminalitas, cvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusBar();
        setInitLayout();
    }

    private void setInitLayout() {
        cvPS = findViewById(R.id.cvKS);
        cvBeritaHoax = findViewById(R.id.cvBullying);
        cvKriminalitas = findViewById(R.id.cvFasilitas);
        cvHistory = findViewById(R.id.cvHistory);

        cvPS.setOnClickListener(v -> {
            strTitle = "Laporan Pelecehan Seksual";
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            intent.putExtra(ReportActivity.DATA_TITLE, strTitle);
            startActivity(intent);
        });

        cvBeritaHoax.setOnClickListener(v -> {
            strTitle = "Laporan Berita Hoax";
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            intent.putExtra(ReportActivity.DATA_TITLE, strTitle);
            startActivity(intent);
        });

        cvKriminalitas.setOnClickListener(v -> {
            strTitle = "Laporan Kriminalitas";
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            intent.putExtra(ReportActivity.DATA_TITLE, strTitle);
            startActivity(intent);
        });

        cvHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_GRANTED) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_PERMISSION && resultCode == RESULT_OK) {

        }
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }
}