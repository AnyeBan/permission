package com.anye.permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button permission_first, permission_second, permission_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 声明布局
     */
    private void initView() {
        permission_first = (Button) findViewById(R.id.permission_first);
        permission_first.setOnClickListener(this);
        permission_second = (Button) findViewById(R.id.permission_second);
        permission_second.setOnClickListener(this);
        permission_third = (Button) findViewById(R.id.permission_third);
        permission_third.setOnClickListener(this);
    }

    /**
     * 按钮响应
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.permission_first == id) {
            Intent intent = new Intent(MainActivity.this, PermissinOneActivity.class);
            startActivity(intent);

        } else if (R.id.permission_second == id) {
            Intent intent = new Intent(MainActivity.this, PermissinTwoActivity.class);
            startActivity(intent);

        } else if (R.id.permission_third == id) {
            Intent intent = new Intent(MainActivity.this, PermissinThreeActivity.class);
            startActivity(intent);
        }
    }
}
