package com.anye.permission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class PermissinThreeActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {
    /***
     * 获取TAG的activity名称
     **/
    protected final String TAG = this.getClass().getSimpleName();

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
                    Manifest.permission.CAMERA);

            if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED) {
                //这里就会弹出对话框

                String[] perms = {Manifest.permission.CAMERA};
                if (EasyPermissions.hasPermissions(this, perms)) {
                    //...
                } else {
                    //...
                    EasyPermissions.requestPermissions(this, "获取摄像头", 101, perms);
                }
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
                        Manifest.permission.CAMERA);

                if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED) {
                    //设置需要添加的权限可以多个，多个的情况下判断需要重新根据需求设置
                    String[] perms = {Manifest.permission.CAMERA,
//                            Manifest.permission.RECORD_AUDIO
                    };
                    if (EasyPermissions.hasPermissions(this, perms)) {
                        //...
                    } else {
                        //...
                        EasyPermissions.requestPermissions(this, "获取摄像头", 101, perms);
                    }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e(TAG, "onRequestPermissionsResult");
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //成功
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
         /*
            用户授予权限，做业务逻辑
        */
        Toast.makeText(this, "TODO: CAMERA Granted", Toast.LENGTH_SHORT).show();
    }

    //失败
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
 /*
            用于拒绝授予权限，提示信息
        */
        Toast.makeText(this, "TODO: CAMERA Denied", Toast.LENGTH_SHORT).show();
        //用户点击了不再询问，弹出对话框去Settings界面开启,这段代码根据业务需求可以添加，也可删去
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this, "授权啊,不授权没法用啊," + "去设置里授权大哥", R.string.setting, R.string.cancel, perms);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
            从Settings界面跳转回来，标准代码，就这么写ss
        */
        if (requestCode == EasyPermissions.SETTINGS_REQ_CODE) {
            if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
                //已授权，处理业务逻辑
                //...
            } else {
                Toast.makeText(this, "没有权限，无法工作", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
