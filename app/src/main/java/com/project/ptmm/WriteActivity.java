package com.project.ptmm;

import android.content.Context;
import android.graphics.Color;

import android.os.Bundle;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.project.ptmm.databinding.ActivityWriteBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteActivity extends AppCompatActivity {

    ActivityWriteBinding binding;
    InputMethodManager inputMethodManager;
    Vibrator vibrator;

    final int bTime = 100;
    boolean icon1 = false, icon2 = false, icon3 = false, icon4 = false;
    boolean bold = false;

    int i = 1;
    int ho = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write);
        binding.setActivity(this);

        settings();

        /* icon2번 액션
        binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (icon2) {
                        int start = Math.max(binding.editText.getSelectionStart(), 0);
                        int end = Math.max(binding.editText.getSelectionEnd(), 0);
                        binding.editText.getText().replace(Math.min(start, end), Math.max(start, end), "◎");
                        binding.editText.setSelection(v.getText().length()-1);
                    }
                    binding.editText.setSelection(v.getText().length());
                    return false;
                }
                return true;
            }

        });*/
    }

    private void settings() {
        // 기본 페이지 세팅
        setPage();
        // 애니매이션
        overridePendingTransition(R.anim.vertical_enter, R.anim.none);
        // 메뉴 클릭시 진동
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private void setPage() {

        // 화면 시작하자마자 edittext 포커스 및 키보드 올리기
        binding.editText.requestFocus();
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String today = format.format(calendar.getTime());

        String text = "오늘 " + today;
        binding.textPage.setText(text);

        binding.icon1.setColorFilter(Color.GRAY);
        binding.icon2.setColorFilter(Color.GRAY);
        binding.icon3.setColorFilter(Color.GRAY);
        binding.icon4.setColorFilter(Color.GRAY);
    }

    public void onClickIcon1(View view) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, 15));// 0.5초간 진동

        if (!icon1) { // Icon1 클릭시
            binding.icon1.setColorFilter(Color.parseColor("#ee9ca7"));
            icon1 = true;
            binding.icon2.setColorFilter(Color.GRAY);
            icon2 = false;
            binding.icon3.setColorFilter(Color.GRAY);
            icon3 = false;
            binding.icon4.setColorFilter(Color.GRAY);
            icon4 = false;

            binding.linearStyle.setVisibility(View.VISIBLE);
            binding.linearWord.setVisibility(View.INVISIBLE);

            binding.view1.setVisibility(View.VISIBLE);
            binding.view2.setVisibility(View.VISIBLE);
            icon1 = true;
        } else {
            binding.icon1.setColorFilter(Color.GRAY);
            binding.linearStyle.setVisibility(View.INVISIBLE);
            binding.linearWord.setVisibility(View.INVISIBLE);

            binding.view1.setVisibility(View.INVISIBLE);
            binding.view2.setVisibility(View.INVISIBLE);
            icon1 = false;
        }
    }

    public void onClickIcon2(View view) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, 15));// 0.5초간 진동
        if (!icon2) { // Icon1 클릭시
            binding.icon1.setColorFilter(Color.GRAY);
            icon1 = false;
            binding.icon2.setColorFilter(Color.parseColor("#ee9ca7"));
            icon2 = true;
            binding.icon3.setColorFilter(Color.GRAY);
            icon3 = false;
            binding.icon4.setColorFilter(Color.GRAY);
            icon4 = false;

        } else {
            binding.icon2.setColorFilter(Color.GRAY);
            icon2 = false;
        }
    }

    public void onClickIcon4(View view) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, 15));// 0.5초간 진동
        if (!icon4) { // Icon4 클릭시
            binding.icon1.setColorFilter(Color.GRAY);
            icon1 = false;
            binding.icon2.setColorFilter(Color.GRAY);
            icon2 = false;
            binding.icon3.setColorFilter(Color.GRAY);
            icon3 = false;
            binding.icon4.setColorFilter(Color.parseColor("#ee9ca7"));
            icon4 = true;

            binding.linearWord.setVisibility(View.VISIBLE);
            binding.linearStyle.setVisibility(View.INVISIBLE);

            binding.view1.setVisibility(View.VISIBLE);
            binding.view2.setVisibility(View.VISIBLE);
        } else {
            binding.icon4.setColorFilter(Color.GRAY);

            binding.linearWord.setVisibility(View.INVISIBLE);
            binding.linearStyle.setVisibility(View.INVISIBLE);

            binding.view1.setVisibility(View.INVISIBLE);
            binding.view2.setVisibility(View.INVISIBLE);
            icon4 = false;
        }
    }

    public void onClickBold(View view) {
        if (bold) {
            binding.iconBold.setColorFilter(Color.GRAY);
            bold = false;
            Toast.makeText(WriteActivity.this, "false", Toast.LENGTH_SHORT).show();
        } else {
            binding.iconBold.setColorFilter(Color.parseColor("#ee9ca7"));
            Toast.makeText(WriteActivity.this, "true", Toast.LENGTH_SHORT).show();
            bold = true;
        }
    }

    public void onClickItalic(View view) {
    }

    public void onClickUnderline(View view) {
    }

    public void onClickStrike(View view) {
    }

    public void onClickTextSet(View view) {
        int start = Math.max(binding.editText.getSelectionStart(), 0);
        int end = Math.max(binding.editText.getSelectionEnd(), 0);
        binding.editText.getText().replace(Math.min(start, end), Math.max(start, end), "set");
    }

    public void onClickTextKG(View view) {
        int start = Math.max(binding.editText.getSelectionStart(), 0);
        int end = Math.max(binding.editText.getSelectionEnd(), 0);
        binding.editText.getText().replace(Math.min(start, end), Math.max(start, end), "kg");
    }

    public void onClickTextLB(View view) {
        int start = Math.max(binding.editText.getSelectionStart(), 0);
        int end = Math.max(binding.editText.getSelectionEnd(), 0);
        binding.editText.getText().replace(Math.min(start, end), Math.max(start, end), "LB");
    }

    public void onClickTextCount(View view) {
        int start = Math.max(binding.editText.getSelectionStart(), 0);
        int end = Math.max(binding.editText.getSelectionEnd(), 0);
        binding.editText.getText().replace(Math.min(start, end), Math.max(start, end), "개");
    }

    @Override
    protected void onPause() {
        super.onPause();
        View focusView = getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // back 버튼으로 화면 종료가 야기되면 동작한다.
        overridePendingTransition(R.anim.none, R.anim.vertical_exit);
    }
}
