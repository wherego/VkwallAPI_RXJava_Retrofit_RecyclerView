package com.example.odialko.vkwallapi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.odialko.vkwallapi.data.model.Attachment;
import com.example.odialko.vkwallapi.data.model.VKwall;
import com.example.odialko.vkwallapi.data.remote.VK_api;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        wall();
    }

    public void wall() {
        VK_api.Factory.getIstance().getVkwall().enqueue(new Callback<VKwall>() {
            @Override
            public void onResponse(Call<VKwall> call, Response<VKwall> response) {
//                int count = 1;
                for (int i = 0; i < response.body().getResponse().getItems().size(); i++) {

                    TextView myTextView = new TextView(getApplicationContext()); //створюєм місце для основного тексту
                    myTextView.setTextSize(16);
                    myTextView.setTextColor(Color.BLACK);

                    LinearLayout.LayoutParams lpFotText = new LinearLayout.LayoutParams( //а тут задаємо параметри, які не задаються
                            LinearLayout.LayoutParams.MATCH_PARENT,                      //вище
                            LinearLayout.LayoutParams.MATCH_PARENT);
                    lpFotText.setMargins(20, 10, 0, -40);
                    llMain.addView(myTextView, lpFotText);

                    //**********************дыстаэмо дату, точно аналогічно до основного тексту**************************

                    TextView myTextViewDate = new TextView(getApplicationContext()); //створюєм місце для основного тексту
                    myTextViewDate.setTextSize(16);
                    myTextViewDate.setTextColor(Color.BLACK);
                    llMain.addView(myTextViewDate, lpFotText);//текст засовуємо в лейатМейн

                    //***************переводимо мілісікунди в дату********************************
                    long unixSeconds = response.body().getResponse().getItems().get(i).getDate(); // секунды
                    Date date = new Date(unixSeconds * 1000L); // *1000 получаем миллисекунды
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss, dd-MM-yyyy"); // какой формат нужен, выбераем

                    myTextViewDate.setText(sdf.format(date) + "\n");//виводимо час і дату

                    List<Attachment> listAttachment = response.body().getResponse().getItems().get(i).getAttachments();
                    for (Attachment go : listAttachment) {
                        try {
                            if (go.getType().equals("photo")) {
                                myTextView.setText(response.body().getResponse().getItems().get(i).getText() + "\n");
                                if (go.getPhoto() != null) {
                                    ImageView myImageView = new ImageView(getApplication());
                                    LinearLayout.LayoutParams lpForIMG = new LinearLayout.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT);
                                    lpForIMG.gravity = Gravity.CENTER_HORIZONTAL;
                                    lpForIMG.setMargins(0, 15, 0, 20);

                                    myImageView.setLayoutParams(lpForIMG);

                                    llMain.addView(myImageView, lpForIMG); //Вставляем его в нужный Layout
                                    Picasso.with(getApplication())
                                            .load(go.getPhoto().getPhoto604()) //ссылка
                                            .resize(1024, 780)
                                            .onlyScaleDown()
                                            .centerInside()
                                            .into(myImageView); //сюда мы грузим картинку
                                }
                            } else if (go.getType().equals("video")) {
                                myTextView.append(go.getVideo().getDescription() + "\n");
                                if (go.getVideo() != null) {
                                    ImageView myImageView = new ImageView(getApplication());
                                    LinearLayout.LayoutParams lpForIMG = new LinearLayout.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT);
                                    lpForIMG.gravity = Gravity.CENTER_HORIZONTAL;
                                    lpForIMG.setMargins(0, 15, 0, 20);

                                    myImageView.setLayoutParams(lpForIMG);

                                    llMain.addView(myImageView, lpForIMG); //Вставляем его в нужный Layout
                                    Picasso.with(getApplication())
                                            .load(go.getVideo().getPhoto640()) //ссылка
                                            .resize(1024, 780)
                                            .onlyScaleDown()
                                            .centerInside()
                                            .into(myImageView); //сюда мы грузим картинку
                                }
                            } else if (go.getType().equals("link")) {
                                myTextView.append(go.getLink().getDescription() + "\n");
                                if (go.getLink() != null) {
                                    ImageView myImageView = new ImageView(getApplication());
                                    LinearLayout.LayoutParams lpForIMG = new LinearLayout.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT);
                                    lpForIMG.gravity = Gravity.CENTER_HORIZONTAL;
                                    lpForIMG.setMargins(0, 15, 0, 20);

                                    myImageView.setLayoutParams(lpForIMG);

                                    llMain.addView(myImageView, lpForIMG); //Вставляем его в нужный Layout
                                    Picasso.with(getApplication())
                                            .load(go.getLink().getPhoto().getPhoto604() + "\n") //ссылка
                                            .resize(1024, 780)
                                            .onlyScaleDown()
                                            .centerInside()
                                            .into(myImageView); //сюда мы грузим картинку
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<VKwall> call, Throwable t) {
                Log.e("Пиздець якийсь", t.getMessage());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Поїхали", LENGTH_SHORT).show();
    }
}
