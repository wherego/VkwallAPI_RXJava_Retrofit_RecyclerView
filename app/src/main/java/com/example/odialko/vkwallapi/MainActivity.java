package com.example.odialko.vkwallapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.odialko.vkwallapi.data.model.Attachment;
import com.example.odialko.vkwallapi.data.model.MyCard;
import com.example.odialko.vkwallapi.data.remote.VK_api;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);

        VK_api service = VK_api.Factory.getIstance();

        service.getVkwall()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myCards -> {
                    ArrayList<MyCard> aList = new ArrayList<>();
                    for (int i = 0; i < myCards.getResponse().getItems().size(); i++) {

                        MyCard myCard = new MyCard();

                        List<Attachment> listAttachment = myCards.getResponse().getItems().get(i).getAttachments();
                        for (Attachment go : listAttachment) {
                            try {
                                if (go.getType().equals("photo")) {
                                    myCard.setMainText(myCards.getResponse().getItems().get(i).getText());
                                    myCard.setUrl2(go.getPhoto().getPhoto604());
                                } else if (go.getType().equals("video")) {
                                    myCard.setMainText(go.getVideo().getTitle());
                                    myCard.setUrl2(go.getVideo().getPhoto640());
                                } else if (go.getType().equals("link")) {
                                    myCard.setMainText(go.getLink().getTitle());
                                    myCard.setUrl2(go.getLink().getPhoto().getPhoto604());
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        aList.add(myCard);
                        mAdapter.setAList(aList);
                    }
                });
    }
}
