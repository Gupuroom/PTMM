package com.project.ptmm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.ptmm.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        setPage();

    }

    private void setPage() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String today = format.format(calendar.getTime());

        String second_text = "메모를 작성하세요.";
        String first_text = "오늘 " + today + "\n" + second_text;
        SpannableStringBuilder ssb = new SpannableStringBuilder(first_text);
        ssb.setSpan(new AbsoluteSizeSpan(80), first_text.length() - second_text.length(), first_text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // Size
        ssb.setSpan(new ForegroundColorSpan(Color.LTGRAY), first_text.length() - second_text.length(), first_text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // Color
        binding.textPage.setText(ssb);

        binding.icon1.setColorFilter(Color.GRAY);
        binding.icon2.setColorFilter(Color.GRAY);
        binding.icon3.setColorFilter(Color.GRAY);
        binding.icon4.setColorFilter(Color.parseColor("#ee9ca7"));
    }

    public void ontextPageClick(View v){
        Intent intent = new Intent(MainActivity.this,WriteActivity.class);
        startActivity(intent);
    }

    public void onIcon4Click(View v){
        Intent intent = new Intent(MainActivity.this,WriteActivity.class);
        startActivity(intent);
    }

}