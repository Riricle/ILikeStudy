package com.example.classmannger;

import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

//笔记类
public class Note {
    private String classname; //课程名称
    private Date data;         //创建日期
    File file;

    public Note(){}

    public Note(String name){
        classname=name;
    }

    //采用本地保存的方式将笔记保存到文件中
    public void WriteNote(EditText content) throws IOException {
        FileOutputStream fos = new FileOutputStream(classname+".txt");
        String text=content.getText().toString();
        fos.write(text.getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    public String getClassname(){return this.classname;}
    public Date getData(){return this.data;}
}
