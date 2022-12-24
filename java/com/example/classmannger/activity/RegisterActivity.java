package com.example.classmannger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classmannger.R;
import com.example.classmannger.User;
import com.example.classmannger.UserManager;

import java.io.File;

public class RegisterActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register=(Button) findViewById(R.id.sign);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户输入
                String username = ((EditText)findViewById(R.id.setusername)).getText().toString();
                String password = ((EditText)findViewById(R.id.setpassword)).getText().toString();
                String password2 = ((EditText)findViewById(R.id.setpassword2)).getText().toString();

                if(!password.equals(password2))
                {
                    Toast.makeText(RegisterActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }

                //保存用户信息
                File file = new File(getExternalFilesDir(""),"users.txt");
                Log.d("Path",file.getPath());
                UserManager userManager = new UserManager(file);
                //检查用户是否存在
                if(userManager.find(username) != null)
                {
                    Toast.makeText(RegisterActivity.this, "用户名已经存在!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //添加用户 保存文件
                    userManager.add(new User(username,password));
                    try {
                        userManager.save();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(RegisterActivity.this, "注册成功!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}