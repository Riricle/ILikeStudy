package com.example.classmannger;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoteMannger {
    //创建一个List来缓存User信息
    List<User> noteList = new ArrayList<>();

    //数据保存到这个文件
    File file;

    public NoteMannger(File file){this.file = file;}


    //保存文件
//    public void save() throws Exception
//    {
//        //每行存储一个用户的信息
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        for (User u : noteList)
//        {
//            String line = u.username + "," + u.password + "\n";
//            fileOutputStream.write(line.getBytes("UTF-8"));
//        }
//        fileOutputStream.close();
//    }

    //从文件加载
    public void load() throws Exception
    {
        InputStreamReader in = new InputStreamReader(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(in);

        noteList.clear();//清空链表
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
            noteList.add( user );
        }
        reader.close();
    }

    //注册一个新用户
    public void add(User u)
    {
        noteList.add(u);
    }

    // 按名称查找
    public User find(String username)
    {
        for (User u : noteList)
        {
            if(u.username.equals(username))
            {
                return u;
            }
        }
        return null;
    }
}
