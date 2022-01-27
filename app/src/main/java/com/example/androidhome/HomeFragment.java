package com.example.androidhome;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidhome.ani.RetrofitInterfaces.SliderInterface;
import com.example.androidhome.ani.builder.BuilderSignup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidhome.ani.productRetro.ProductEntity;
import com.example.androidhome.ani.signupRetro.SignUpActivity;
import com.example.androidhome.ani.slider_model.*;
import com.example.androidhome.ani.slider_adapter.*;

import com.example.androidhome.ani.recommended_model.*;
import com.example.androidhome.ani.recommended_adapter.*;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements RecommendedAdapter.RecommendedDataInterface {


    String url3 = "https://images.theconversation.com/files/2982/original/3600947113_fe7208d8a8_b.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip"; // Daru
    String url1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQV4PnR4TldWDpedxe0GOT7bz1bU0VI0CbtA&usqp=CAU";   // Game
    String url4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWaqxg8sKlxVsGdJ3UVvhoHThp43G8kJlpkg&usqp=CAU";  // Cigarattes
    String url5 = "https://i.ytimg.com/vi/rNzg-_lZZuw/maxresdefault.jpg";    // Food Packet
    String url2 = "https://image.shutterstock.com/image-vector/various-meds-pills-capsules-blisters-260nw-1409823341.jpg";   // Dava
    public String p;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SliderModel> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = view.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderModel(url1));
        sliderDataArrayList.add(new SliderModel(url2));
        sliderDataArrayList.add(new SliderModel(url3));
        sliderDataArrayList.add(new SliderModel(url4));
        sliderDataArrayList.add(new SliderModel(url5));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(view.getContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();



        adapter.setOnItemClickListener(new SliderAdapter.OnItemClickListener() {

            @Override public void onItemClick(int position)
            {

//                String[] cname = {"drinks", "game", "cigarette", "food", "healthcare"};
                    p = String.valueOf(position);

//
//                //List<ProductModel> productModelList = new ArrayList<>();
//
//                String s = cname[position];
//                List<ProductModel> productModelList = generateProductData(s);

                p = String.valueOf(position);




//                if(p.equals("1"))
//                {
////                    String categoryName="";
//                    //ProductDto productDto=getProductDetailsByCategory(categoryName);
//
//
//                    // Builder logic for game product retrieval
//                    //ProductDto fun(int pos)
//
//                }
//                  ......
//                else if(p.equals("0"))
//                {
////                    Intent intent = new Intent(getContext(), DrinksShow.class);
////                    startActivity(intent);
//                }
//
////                Intent intent = new Intent(getContext(), GamesShow.class);
////                startActivity(intent);


                Toast.makeText(getContext(), p+"...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), Product.class);
                intent.putExtra("categoryName", p);
                startActivity(intent);

            }
        });


        List<Recommended_Model> recommended_models = new ArrayList<>();
        generateUserData(recommended_models);

        RecyclerView recyclerView = view.findViewById(R.id.recycler1);
        RecommendedAdapter recommendedAdapter = new RecommendedAdapter(recommended_models, HomeFragment.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(recommendedAdapter);
    }

//    private ProductDto getProductDetailsByCategory(String categoryName)
//    {
//        //get data from productapi by calling findByCategory(category);
//        // Bulder logic According to Category name
//        // if 1 the call game api
//        // if 2 then call cegerates Api
//
//    }

    private void generateUserData(List<Recommended_Model> recommendDataList) {

        recommendDataList.add(new Recommended_Model("1", 100, "Call of Duty Ghosts", "Game", 0L, "Infinity Ward", "Xbox One", "Single, Multi, Online Multi", "Action", "Activician", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kkbh8cw0/physical-game/r/e/m/infinity-ward-call-of-duty-ghosts-graphic-game-xbox-one-original-imafzzqmw5afvjej.jpeg?q=70" ));//        productModelList.add(new ProductModel("Employee 2", 101));
        recommendDataList.add(new Recommended_Model("2", 100, "James Bond 007 (Blood Stone)", "Game", 0L, "Blood stone", "Xbox 360", "Single, Multi, Online Multi", "Action", "Activician", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kkbh8cw0/physical-game/r/5/9/blood-stone-james-bond-007-graphic-game-xbox-360-original-imafzzqer5rhzheh.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("3", 100, "Black Rose Valkyrie Sp. Japanese Version (PS4)", "Game", 0L, "Ultimate Evil", "Xbox 360", "Single, Multi, Online Multi", "RPG", "Blizzard", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kirr24w0-0/physical-game/r/m/z/ultimate-evil-edition-black-rose-valkyrie-special-edition-original-imafyhd7zncnqyg8.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("4", 100, "Ashes Cricket (for PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Sports", "Koach", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/j8uiljk0/physical-game/t/f/z/standard-edition-ashes-cricket-full-game-ps4-original-imaeysfjybhwxda9.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("5", 100, "Gran Turismo 7 (Standard) (for PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Racing", "Blizzard", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kwb07m80/physical-game/h/r/j/yes-standard-edition-ps4-gran-turismo-7-standard-ed-full-game-original-imag9yd5gkfzkpus.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("6", 100, "Diablo III : Reaper of Souls (Ultimate Evil Edition)", "Game", 0L, " Game & Exp Pack", "PS4", "Single, Multi, Online Multi", "RPG", "Sony", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/physical-game/3/v/z/ps4-ultimate-evil-edition-game-and-expansion-pack-diablo-iii-original-imae37ekvqv77gbz.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("7", 100, "Pillars Eternity", "Game", 0L, "Complete", "PS4", "Single, Multi, Online Multi", "RPG", "505 Games", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/j5mrxjk0/physical-game/h/v/e/complete-edition-pillars-of-eternity-game-and-map-pack-ps4-original-imaewa3evygh8zvj.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("8", 100, "The Witcher 3 : Wild Hunt(PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Action", "505 Games", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/physical-game/b/g/c/ps4-the-witcher-3-wild-hunt-original-imaejtzhsbnjg2jh.jpeg?q=70" ));
        recommendDataList.add(new Recommended_Model("9", 100, "Marvel's Avengers", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Action Adv", "Sony", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/k6zda4w0/physical-game/x/z/z/standard-marvel-s-avengers-full-game-ps4-original-imafpbedz4dqty47.jpeg?q=70" ));
    }

    @Override
    public void onUserClick(Recommended_Model recommended_model, View view, int position) {
        startActivity(new Intent(getContext(),Product.class));
    }

//    public void SliderApi(String catName) {
//
//        Retrofit retrofit = BuilderSignup.getInstance();
////        SignupEntity signupEntity = new SignupEntity(name, email, password, address);
//        SliderInterface sliderInterface = retrofit.create(SliderInterface.class);
//        Call<List<ProductEntity>> productListCall = sliderInterface.postLog(catName);
//        productListCall.enqueue(new Callback<List<ProductEntity>>() {
//            @Override
//            public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {
////                if(response.body()==null){
////                    Toast.makeText(Dummy.this, "User mail is already registered", Toast.LENGTH_SHORT).show();
////                }
////                Toast.makeText(SignUp.this, "Signin Successful", Toast.LENGTH_SHORT).show();
////                Toast.makeText(SignUp.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
////                startActivity(new Intent(getApplicationContext(), Dummy.class));
//                Toast.makeText(getContext(), "Everything is correct", Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(getContext(), Product.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<List<ProductEntity>> call, Throwable t) {
//                Toast.makeText(getContext(), "Everything is wrong", Toast.LENGTH_SHORT).show();
////                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public String  fun()
    {
        return p;
    }

}