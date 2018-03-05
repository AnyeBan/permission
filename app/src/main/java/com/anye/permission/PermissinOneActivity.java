package com.anye.permission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermissinOneActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissin_one);
        initView();
//        initPermission();
    }

    /**
     * 正常获取权限的方式，方便演示，改为按钮请求权限
     */
    private void initPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            //如果不想判断SDK，可以使用ActivityCompat的接口来检查和申请权限
            int hasReadContactsPermission = checkSelfPermission(
                    android.Manifest.permission.CAMERA);

            if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED) {
                //这里就会弹出对话框
                requestPermissions(
                        new String[]{Manifest.permission.CAMERA},
                        1);

                return;
            }
            //高版本中检查是否有运行时权限，具有权限时才调用
            //要进行的操作
        } else {
            //在AndroidManifest.xml中仍然声明使用"android.permission.READ_CONTACTS"
            //在低版本中直接调用该函
            //要进行的操作
        }
    }

    /**
     * 声明布局
     */
    private void initView() {
        permission = (TextView) findViewById(R.id.permission_one);
        permission.setOnClickListener(this);
    }

    /**
     * 按钮响应
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.permission_one == id) {
            if (Build.VERSION.SDK_INT >= 23) {
                //如果不想判断SDK，可以使用ActivityCompat的接口来检查和申请权限
                int hasReadContactsPermission = checkSelfPermission(
                        android.Manifest.permission.CAMERA);

                if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED) {
                    //这里就会弹出对话框
                    requestPermissions(
                            new String[]{Manifest.permission.CAMERA},
                            1);

                    return;
                }
                //高版本中检查是否有运行时权限，具有权限时才调用
                //要进行的操作
            } else {
                //在AndroidManifest.xml中仍然声明使用"android.permission.READ_CONTACTS"
                //在低版本中直接调用该函
                //要进行的操作
            }
        }
    }
}
