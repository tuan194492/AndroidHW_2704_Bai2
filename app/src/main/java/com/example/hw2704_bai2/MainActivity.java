package com.example.hw2704_bai2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/*
    @Họ và tên sinh viên:
        Nguyễn Quốc Tuấn - 20194402
    @Mô tả ứng dụng:
        Ứng dụng cho phép người dùng nhập các thông tin sau:
        + MSSV (bắt buộc)
        + Họ tên (bắt buộc)
        + Số CCCD (bắt buộc)
        + Số điện thoại (bắt buộc)
        + Địa chỉ email (bắt buộc)
        + Ngày tháng năm sinh (sử dụng widget CalendarView để chọn ngày tháng năm)
        + Quê quán
        + Nơi ở hiện tại
        + Ngành học hiện tại (sử dụng radio button để chọn Khoa học máy tính hoặc Kỹ thuật máy tính)
        + Ngôn ngữ lập trình (sử dụng check box để chọn, bao gồm C, Java, Python, ...)
        Bên dưới form có 1 check box để đồng ý điều khoản (bắt buộc đồng ý)

 */
public class MainActivity extends AppCompatActivity {
    Button btnBirthDate, btnSubmit;
    CalendarView calendar;
    CheckBox confirmCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setVisibility(View.GONE);
        btnBirthDate = (Button) findViewById(R.id.btnBirthDate);
        btnBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (calendar.getVisibility() == View.VISIBLE) {
                    calendar.setVisibility(View.GONE);
                } else {
                    calendar.setVisibility(View.VISIBLE);
                }
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                btnBirthDate.setText("Date: " + dayOfMonth + " " + month + " " + year);
            }
        });
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        confirmCheckBox = (CheckBox) findViewById(R.id.confirmCheckBox);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Toast message = new Toast(getApplicationContext());
                    if (!confirmCheckBox.isChecked()) {
                        confirmCheckBox.setBackgroundColor(Color.RED);
                        message.setText("Hãy xác nhận gửi!");
                    } else {
                        confirmCheckBox.setBackgroundColor(0);
                        message.setText("Nhập thông tin thành công");
                    }
                    message.show();
                } else {
                    Toast message = new Toast(getApplicationContext());
                    message.setText("Nhập thông tin không thành công. \n Hãy nhập đủ");
                    message.show();
                }
            }
        });

    }
    public boolean isValid() {
        boolean flag = true;
        if (((EditText) findViewById(R.id.mssvTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.mssvTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.mssvTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.cccdTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.cccdTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.cccdTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.nameTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.nameTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.nameTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.phoneTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.phoneTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.phoneTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.emailTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.emailTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.emailTextField)).setBackgroundColor(0);

        return flag;
    }
}