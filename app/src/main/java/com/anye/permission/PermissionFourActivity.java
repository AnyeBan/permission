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
import com.tbruyelle.rxpermissions2.RxPermissions;

public class PermissionFourActivity extends AppCompatActivity implements View.OnClickListener {
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
            RxPermissions rxPermission = new RxPermissions(PermissionFourActivity.this);
            rxPermission
                    .requestEach(Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_CALENDAR,
                            Manifest.permission.READ_CALL_LOG,
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.READ_SMS,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.CAMERA,
                            Manifest.permission.CALL_PHONE,
                            Manifest.permission.SEND_SMS)
                    .subscribe(new io.reactivex.functions.Consumer<com.tbruyelle.rxpermissions2.Permission>() {
                        @Override
                        public void accept(com.tbruyelle.rxpermissions2.Permission permission) throws Exception {
                            if (permission.granted) {
                                // 用户已经同意该权限
//                                Log.d(TAG, permission.name + " is granted.");
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
//                                Log.d(TAG, permission.name + " is denied. More info should be provided.");
                            } else {
                                // 用户拒绝了该权限，并且选中『不再询问』
//                                Log.d(TAG, permission.name + " is denied.");
                            }
                        }
                    });
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
            initPermission();
        }
    }
}
