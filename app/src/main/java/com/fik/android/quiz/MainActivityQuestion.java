package com.fik.android.quiz;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fik.android.quiz.adapter.AdapterRecyclerQuestion;
import com.fik.android.quiz.data.DataQuestion;

import java.util.ArrayList;
import java.util.List;

public class MainActivityQuestion extends AppCompatActivity {

    RecyclerView list;
    Button btnSubmit;
    SwipeRefreshLayout swipe;
    List<DataQuestion> itemList = new ArrayList<DataQuestion>();
    AdapterRecyclerQuestion adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list         = (RecyclerView) findViewById(R.id.list);
        btnSubmit    = (Button) findViewById(R.id.btSelesai);

        //inisialisasi recycler view
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setItemAnimator(new DefaultItemAnimator());

        //set dummy data
        setDummyData();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fungsi untuk dapat semua jawaban di adapter
                List<DataQuestion>listAnswer = adapter.getAllAnswer();

                int nilai = 0;
                //looping untuk nilai
                for (int i = 0; i <listAnswer.size() ; i++) {
                    //cek jawaban sama atau tidak dengan kunci jawaban
                    if(listAnswer.get(i).getJawaban().equals(listAnswer.get(i).getDipilih())){
                        //jika jawaban betul maka nilai + 1
                        nilai = nilai + 1;
                    }
                }
                //tampilkan nilai di toast
                Toast.makeText(getApplicationContext(),"Nilai anda: "+nilai,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setDummyData() {

        //data dummy
        itemList.add(new DataQuestion("1","Hello ini soal no 1","Jawaban A",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("2","Hello ini soal no 2","Jawaban B",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("3","Hello ini soal no 3","Jawaban A",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("4","Hello ini soal no 4","Jawaban C",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("5","Hello ini soal no 5","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("6","Hello ini soal no 6","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("7","Hello ini soal no 7","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("8","Hello ini soal no 8","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("9","Hello ini soal no 9","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));

        itemList.add(new DataQuestion("10","Hello ini soal no 10","Jawaban D",
                "Jawaban A","Jawaban B","Jawaban C","Jawaban D"));


        //set adapter untuk recycler view
        adapter = new AdapterRecyclerQuestion(itemList);
        list.setAdapter(adapter);

    }
}
