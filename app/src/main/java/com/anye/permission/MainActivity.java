package com.anye.permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button permission_first, permission_second, permission_third, permission_fourth;

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
        permission_fourth = (Button) findViewById(R.id.permission_fourth);
        permission_fourth.setOnClickListener(this);
    }

    /**
     * 按钮响应
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.permission_first == id) {
            Intent intent = new Intent(MainActivity.this, PermissionOneActivity.class);
            startActivity(intent);

        } else if (R.id.permission_second == id) {
            Intent intent = new Intent(MainActivity.this, PermissionTwoActivity.class);
            startActivity(intent);

        } else if (R.id.permission_third == id) {
            Intent intent = new Intent(MainActivity.this, PermissionThreeActivity.class);
            startActivity(intent);
        } else if (R.id.permission_fourth == id) {
            Intent intent = new Intent(MainActivity.this, PermissionFourActivity.class);
            startActivity(intent);
        }
    }
}
