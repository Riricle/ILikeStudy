package com.example.classmannger.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classmannger.R;
import com.example.classmannger.adpater.TodoListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TODOFragment extends Fragment {


    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        recyclerView = view.findViewById(R.id.news_list);
        // 设置LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        List<Map<String, Object>> mDataList = getData();
        recyclerView.setAdapter(new TodoListAdapter(getActivity(), mDataList));
        return view;
    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
////        recyclerView.findViewById(R.id.news_list);
////        // 设置LinearLayoutManager
////        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
////        // 设置ItemAnimator
////        recyclerView.setItemAnimator(new DefaultItemAnimator());
////        // 设置固定大小
////        List<Map<String, Object>> mDataList = getData();
////        recyclerView.setAdapter(new TodoListAdapter(getActivity(), mDataList));
//
//        return inflater.inflate(R.layout.fragment_me, container, false);
//    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Map<String, Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("news_title","软件工程求组队");
        map.put("news_info","   有无大佬带带，资源要合理运用对吧，建议一对一帮扶，救……");
        map.put("news_thumb",R.drawable.p2);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("news_title","求助！移动平台开发");
        map.put("news_info","   救命!做不出来了，马上就要期末答辩了，又滚染上了新冠，简直……");
        map.put("news_thumb",R.drawable.p1);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("news_title","数电的一些知识点笔记");
        map.put("news_info","   下面是我做的一些关于数电的知识点笔记，仅供大……");
        map.put("news_thumb",R.drawable.p3);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("news_title","志愿者招募");
        map.put("news_info","   明日下午4:30将在广乐楼举行关于考研的讲座，现需要招……");
        map.put("news_thumb",R.drawable.p4);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("news_title","大创项目招人");
        map.put("news_info","计电院大创正在招募一位精通Python，C++，Java，JavaW……");
        map.put("news_thumb",R.drawable.p5);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("news_title","失物招领");
        map.put("news_info","   昨天晚上我在一号门右侧的草坪里捡到一串钥匙，请失主……");
        map.put("news_thumb",R.drawable.p6);
        list.add(map);
        return list;
    }
}