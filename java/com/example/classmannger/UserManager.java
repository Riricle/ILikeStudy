package com.example.classmannger;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserManager
{
    //创建一个List来缓存User信息
    List<User> userList = new ArrayList<>();

    //数据保存到这个文件
    File file;

    public UserManager(File file){this.file = file;}


    //保存文件
    public void save() throws Exception
    {
        //每行存储一个用户的信息
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (User u : userList)
        {
            String line = u.username + "," + u.password + "\n";
            fileOutputStream.write(line.getBytes("UTF-8"));
        }
        fileOutputStream.close();
    }

    //从文件加载
    public void load() throws Exception
    {
        Log.d("USERLOAD","laoding");
        InputStreamReader in = new InputStreamReader(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(in);

        userList.clear();//清空链表
        while (true)
        {
            String line = reader.readLine();
            if (line == null)
                break;
            String[] cols = line.split(",");
            if (cols.length<2) continue;

            User user = new User();
            user.username = cols[0].trim();
            user.password = cols[1].trim();
            Log.d("USER",user.username);
            userList.add( user );
        }
        reader.close();
    }

    //注册一个新用户
    public void add(User u)
    {
        userList.add(u);
    }

    // 按名称查找
    public User find(String username)
    {
        for (User u : userList)
        {
            if(u.username.equals(username))
            {
                return u;
            }
        }
        return null;
    }

}
