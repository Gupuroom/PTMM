package com.project.ptmm;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.project.ptmm.databinding.ActivityWriteBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteActivity extends AppCompatActivity {

    ActivityWriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write);
        binding.setActivity(this);

        setPage();
    }

    private void setPage() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String today = format.format(calendar.getTime());

        String text = "오늘 " + today;
        binding.textPage.setText(text);

        binding.icon1.setColorFilter(Color.GRAY);
        binding.icon2.setColorFilter(Color.GRAY);
        binding.icon3.setColorFilter(Color.GRAY);
        binding.icon4.setColorFilter(Color.parseColor("#ee9ca7"));
    }
}
