package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareListData();

        expandableListView = findViewById(R.id.expandableListViewId);
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), "Groupname " + groupName, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), groupName + " is collapsed", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String childString = listDataChild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(), childString, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && lastExpandedPosition != i)
                {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
    }

    public void prepareListData() {
        String[] headerString = getResources().getStringArray(R.array.abbreviations_list_header);
        String[] childString = getResources().getStringArray(R.array.abbreviations_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i = 0; i < headerString.length; i++) {
            //adding header data
            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i), child);


        }
    }
}