package com.example.classmannger.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classmannger.R;
import com.example.classmannger.User;
import com.example.classmannger.UserManager;

import java.io.File;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login=(Button) findViewById(R.id.signIn);
        Button register=(Button) findViewById(R.id.register);
        Button skip=(Button) findViewById(R.id.skip);

        EditText username=(EditText) findViewById(R.id.username);
        EditText password=(EditText) findViewById(R.id.password);


        //尝试修复但是只解决了输入文本框为空的问题

//        String users=username.getText().toString();
//        String pass=password.getText().toString();

//        while(true){
//            if(username.length()==0){
//                Toast.makeText(LoginActivity.this, "请输入用户名",
//                        Toast.LENGTH_SHORT).show();
//            }
//            else if(password.length()==0){
//                    Toast.makeText(LoginActivity.this, "密码不能为空",
//                            Toast.LENGTH_SHORT).show();
//                }
//            else{
//                break;
//            }
//
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //检查输入文本框是否为空
                if(username.length()==0){
                Toast.makeText(LoginActivity.this, "请输入用户名",
                        Toast.LENGTH_SHORT).show();
                return;
                }
                else if(password.length()==0){
                    Toast.makeText(LoginActivity.this, "密码不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                 
                String users=username.getText().toString();
                String pass=password.getText().toString();
                File file = new File(getExternalFilesDir("r"), "users.txt");
                UserManager userManager = new UserManager(file);
                try {
                    userManager.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }



                //登录功能每运行到此处就会闪退
                //debug显示是userMannger读取文件的问题
                //修不好了
                //暂不修复，有空有脑子有那个水平了再修
                Log.d("USERLOGIN",userManager.find("2243").password.toString());




                //从用户列表里查找用户
                User user = userManager.find(users);
                if (user == null) {
                    Toast.makeText(LoginActivity.this, "无此用户!",
                            Toast.LENGTH_SHORT).show();
                }

                //比较密码是否匹配
                if (!user.password.equals(pass)) {
                    Toast.makeText(LoginActivity.this, "密码错误!",
                            Toast.LENGTH_SHORT).show();
                }

                //登录成功 把用户信息放在全局对象里

                //进入主界面
                if(user.password.equals(pass)){
                    Toast.makeText(LoginActivity.this, "登录成功！",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}