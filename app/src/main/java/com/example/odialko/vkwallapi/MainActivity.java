package com.example.odialko.vkwallapi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.odialko.vkwallapi.data.model.Attachment;
import com.example.odialko.vkwallapi.data.model.MyCard;
import com.example.odialko.vkwallapi.data.model.VKwall;
import com.example.odialko.vkwallapi.data.remote.VK_api;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        getData();
    }

    private ArrayList<MyCard> getData() {
        ArrayList<MyCard> aList = new ArrayList<MyCard>();
        VK_api.Factory.getIstance().getVkwall().enqueue(new Callback<VKwall>() {
            @Override
            public void onResponse(Call<VKwall> call, Response<VKwall> response) {
                ArrayList<MyCard> aList = new ArrayList<MyCard>();
                ArrayList<String> url = new ArrayList<String>();
                for (int i = 0; i < response.body().getResponse().getItems().size(); i++) {

                    MyCard myCard = new MyCard();

                    List<Attachment> listAttachment = response.body().getResponse().getItems().get(i).getAttachments();
                    for (Attachment go : listAttachment) {
                        try {
                            if (go.getType().equals("photo")) {
                                myCard.setMainText(response.body().getResponse().getItems().get(i).getText());
                                    url.add(go.getPhoto().getPhoto604());
                                myCard.setUrl2(go.getPhoto().getPhoto604());
                            } else if (go.getType().equals("video")) {
                                myCard.setMainText(go.getVideo().getTitle());
                                    url.add(go.getVideo().getPhoto640());
                                myCard.setUrl2(go.getVideo().getPhoto640());
                            } else if (go.getType().equals("link")) {
                                myCard.setMainText(go.getLink().getTitle());
                                    url.add(go.getLink().getPhoto().getPhoto604());
                                myCard.setUrl2(go.getLink().getPhoto().getPhoto604());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    myCard.setUrl(url);
                    aList.add(myCard);
                    mAdapter.setAList(aList);
                }
            }

            @Override
            public void onFailure(Call<VKwall> call, Throwable t) {
                Log.e("Пиздець якийсь", t.getMessage());
            }
        });
        return aList;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Поїхали", LENGTH_SHORT).show();
    }
}
