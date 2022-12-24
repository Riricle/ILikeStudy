package com.example.classmannger.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.classmannger.R;

import java.util.zip.Inflater;


//    19200241康佳


public class ClassTableFragment extends Fragment {


    private GridLayout gridLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classtable, container, false);
        gridLayout = view.findViewById(R.id.news_list);
        return view;
    }

    public void framework() {

        //创建一个GridLayout对象
//        GridLayout gridLayout;
        //定义每个框的id，之后会动态改变id值
        int id = 1;

        //渲染每一列（周）
        for (int i = 1; i < 8; i++) {

            //注入GridLayout对应的列，根据星期几调用LayoutColumn方法
//            gridLayout = LayoutColumn(i);

            //渲染每一行（节课）
            for (int j = 1; j < 10; j +=2) {
                //声明一个新的TextView
                TextView textView1 = new TextView(getActivity());

                //给TextView设置style样式
                textView1.setId(id++);
                textView1.setText("");
                textView1.setMaxLines(5);
                textView1.setEllipsize(TextUtils.TruncateAt.END);
                textView1.setBackgroundColor(Color.parseColor("#F0FFFF"));
                textView1.setGravity(Gravity.CENTER);

                //GridLayout.LayoutParams设置在此gridLayout列中TextView布局
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.setMargins(5,10,5,10);
                params1.width = GridLayout.LayoutParams.MATCH_PARENT;
                params1.height = 0;
                //设置在gridLayout中的方位，参数1：在第几行。参数2：占几行。参数3：权值
                //这个权值是根据xml中第一个gridLayout节课权值设定的。
                params1.rowSpec = GridLayout.spec( j, 2,1);

                //把TextView和布局样式添加到此gridLayout中
                gridLayout.addView(textView1, params1);
            }

        }

    }

//    public GridLayout LayoutColumn(int i) {
//
//        //防止空指针操作
//        GridLayout gridLayout = findViewById(R.id.d1);
//
//        //参数i：星期几。根据i寻找xml对应的GridLayout并注入。
//        switch (i) {
//            case 1: {
//                gridLayout = findViewById(R.id.d1);
//                break;
//            }
//            case 2: {
//                gridLayout = findViewById(R.id.d2);
//                break;
//            }
//            case 3: {
//                gridLayout = findViewById(R.id.d3);
//                break;
//            }
//            case 4: {
//                gridLayout = findViewById(R.id.d4);
//                break;
//            }
//            case 5: {
//                gridLayout = findViewById(R.id.d5);
//                break;
//            }
//            case 6: {
//                gridLayout = findViewById(R.id.d6);
//                break;
//            }
//            case 7: {
//                gridLayout = findViewById(R.id.d7);
//                break;
//            }
//        }
//        return gridLayout;
//    }
}