package com.example.careconnect1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String [] [] packages =
            {
                    {"Packages 1 : Full Body Checkup", "", "", "", "999"},
                    {"Packages 2 : Blood Glucose Fasting", "", "", "", "299"},
                    {"Packages 3 : COVID-19 Antibody -Ig6", "", "", "", "899"},
                    {"Packages 4 : Thyroid Check", "", "", "", "499"},
                    {"Packages 5 : Immunity Check", "", "", "", "699"},
            };
    private String [] packages_details = {
            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test\n",
            "Blood Glucose Fasting",
            "COVID-19 Antibody -Ig6",
            "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
            "Complete Hemogram\n" +
                    "CPR (C Reactive Protein) Quantitative Serum\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid Profile"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLDAddToCart);
        btnBack = findViewById(R.id.buttonLDGoBack);
        listView = findViewById(R.id.ListViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put( "Line1", packages[i][0]);
            item.put( "Line2", packages[i][1]);
            item.put( "Line3", packages[i][2]);
            item.put( "Line4", packages[i][3]);
            item.put( "Line5", "Total Cost:"+packages[i][4]+"/-");
            list.add( item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] { "Line1","Line2","Line3","Line4","Line5" },
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e, });
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("Text1", packages[i][0]);
                it.putExtra("Text2", packages_details[i]);
                it.putExtra("Text1", packages[i][4]);
                startActivity(it);
            }
        });
    }
}