package com.anye.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.permission.manager.PermissionManager;

public class PermissinTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView permission, permission_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissin_two);
        initView();
//        initPermission();
    }

    /**
     * 正常获取权限的方式，方便演示，改为按钮请求权限
     */
    private void initPermission() {
        //同时申请多个权限
//        PermissionManager.getInstance(getApplicationContext()).execute(this, Manifest.permission.RECORD_AUDIO,
//                Manifest.permission.READ_EXTERNAL_STORAGE,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        //请求单个，显示对话框的方式
        PermissionManager.getInstance(getApplicationContext()).executeDialog(this, Manifest.permission.RECORD_AUDIO,
                PermissionManager.getInstance(getApplicationContext()).new Builder(this)
                        .setMessage("应用需要获取您的录音权限，是否授权？")
                        .setTitle(getString(R.string.app_name))
                        .setIcon(R.mipmap.ic_launcher)
                        .setOk("OK")
                        .setCancel("CANCEL"));
    }

    /**
     * 声明布局
     */
    private void initView() {
        permission = (TextView) findViewById(R.id.permission_one);
        permission.setOnClickListener(this);
        permission_get = (TextView) findViewById(R.id.permission_get);
        permission_get.setOnClickListener(this);
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
                //请求单个，显示对话框的方式
                PermissionManager.getInstance(getApplicationContext()).executeDialog(this, Manifest.permission.RECORD_AUDIO,
                        PermissionManager.getInstance(getApplicationContext()).new Builder(this)
                                .setMessage("应用需要获取您的录音权限，是否授权？")
                                .setTitle(getString(R.string.app_name))
                                .setIcon(R.mipmap.ic_launcher)
                                .setOk("OK")
                                .setCancel("CANCEL"));
                //要进行的操作
            } else {
                //要进行的操作
            }
        } else if (R.id.permission_get == id) {
            //正常在将要使用次功能前进行判断，根据结果进行处理
            //判断是否获取了录音权限
            if (PermissionManager.getInstance(getApplicationContext()).getGrantedInfo(Manifest.permission.RECORD_AUDIO)) {
                Toast.makeText(PermissinTwoActivity.this, "录音权限已经获取", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PermissinTwoActivity.this, "你还没有获取录音权限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
