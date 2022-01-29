package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidhome.ani.RetrofitInterfaces.SliderInterface;
import com.example.androidhome.ani.builder.BuilderProduct;
import com.example.androidhome.ani.builder.BuilderSignup;
import com.example.androidhome.ani.product_adapter.ProductAdapter;
import com.example.androidhome.ani.productRetro.ProductEntity;
import com.example.androidhome.ani.recommended_adapter.RecommendedAdapter;
import com.example.androidhome.ani.signupRetro.Respentity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Product extends AppCompatActivity implements ProductAdapter.ProductDataInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2);

        List<ProductEntity> productEntitiesList =new ArrayList<>();
        //generateUserData(productEntitiesList);




        String p = getIntent().getStringExtra("categoryName");
        Log.d("ABBBBBBBBBBBBBBBBBBBBBB", "Hello ....... " + p);

//
//
        if (p.equals("0")) {
            SliderApi("Game", productEntitiesList);
            return;
        }
        else if (p.equals("1")) {
            SliderApi("Healthcare", productEntitiesList);
            return;
        }
        else if (p.equals("2")) {
            SliderApi("Drinks", productEntitiesList);
            return;
        }
        else if (p.equals("3")) {
            SliderApi("Cigarette", productEntitiesList);
            return;
        }
        else if (p.equals("4")) {
            SliderApi("Food", productEntitiesList);
            return;
        }


//        RecyclerView recyclerView=findViewById(R.id.productrecycler);
//        ProductAdapter productAdapter =new ProductAdapter(productEntitiesList,  Product.this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        recyclerView.setAdapter(productAdapter);

    }


//    private void generateUserData(List<ProductEntity> productEntitiesList) {
//
//        productEntitiesList.add(new ProductEntity("1", 100, "Call of Duty Ghosts", "Game", 0L, "Infinity Ward", "Xbox One", "Single, Multi, Online Multi", "Action", "Activician", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kkbh8cw0/physical-game/r/e/m/infinity-ward-call-of-duty-ghosts-graphic-game-xbox-one-original-imafzzqmw5afvjej.jpeg?q=70" ));//        productModelList.add(new ProductModel("Employee 2", 101));
//        productEntitiesList.add(new ProductEntity("2", 100, "James Bond 007 (Blood Stone)", "Game", 0L, "Blood stone", "Xbox 360", "Single, Multi, Online Multi", "Action", "Activician", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kkbh8cw0/physical-game/r/5/9/blood-stone-james-bond-007-graphic-game-xbox-360-original-imafzzqer5rhzheh.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("3", 100, "Black Rose Valkyrie Sp. Japanese Version (PS4)", "Game", 0L, "Ultimate Evil", "Xbox 360", "Single, Multi, Online Multi", "RPG", "Blizzard", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kirr24w0-0/physical-game/r/m/z/ultimate-evil-edition-black-rose-valkyrie-special-edition-original-imafyhd7zncnqyg8.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("4", 100, "Ashes Cricket (for PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Sports", "Koach", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/j8uiljk0/physical-game/t/f/z/standard-edition-ashes-cricket-full-game-ps4-original-imaeysfjybhwxda9.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("5", 100, "Gran Turismo 7 (Standard) (for PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Racing", "Blizzard", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/kwb07m80/physical-game/h/r/j/yes-standard-edition-ps4-gran-turismo-7-standard-ed-full-game-original-imag9yd5gkfzkpus.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("6", 100, "Diablo III : Reaper of Souls (Ultimate Evil Edition)", "Game", 0L, " Game & Exp Pack", "PS4", "Single, Multi, Online Multi", "RPG", "Sony", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/physical-game/3/v/z/ps4-ultimate-evil-edition-game-and-expansion-pack-diablo-iii-original-imae37ekvqv77gbz.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("7", 100, "Pillars Eternity", "Game", 0L, "Complete", "PS4", "Single, Multi, Online Multi", "RPG", "505 Games", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/j5mrxjk0/physical-game/h/v/e/complete-edition-pillars-of-eternity-game-and-map-pack-ps4-original-imaewa3evygh8zvj.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("8", 100, "The Witcher 3 : Wild Hunt(PS4)", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Action", "505 Games", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/physical-game/b/g/c/ps4-the-witcher-3-wild-hunt-original-imaejtzhsbnjg2jh.jpeg?q=70" ));
//        productEntitiesList.add(new ProductEntity("9", 100, "Marvel's Avengers", "Game", 0L, "Standard", "PS4", "Single, Multi, Online Multi", "Action Adv", "Sony", null, "Create-A-Soldier system for avatar customization", "CoD: Ghosts tells the story of Logan and Hesh, two jarheads who find themselves part of the last stand of the USA against invaders from the South American Federation after the SAF nukes the US from orbit. ... Once Logan and Hesh – and their dog Riley – join the Ghosts, things begin to move into high gear.", "https://rukminim1.flixcart.com/image/832/832/k6zda4w0/physical-game/x/z/z/standard-marvel-s-avengers-full-game-ps4-original-imafpbedz4dqty47.jpeg?q=70" ));
//
//    }

    @Override
    public void onUserClick(ProductEntity productEntity) {


//        Toast.makeText(this, "Image Clicked for" + productEntity.getProductName(), Toast.LENGTH_SHORT).show();
////        SharedPreferences sharedPreferences=getSharedPreferences("com.example.inkedpages", Context.MODE_PRIVATE);
//
//
//        Intent intent = new Intent(this, ProductFullView.class);
//        intent.putExtra("productId",productEntity.getProductId());
//        intent.putExtra("merchantId", productEntity.getMerchantList().get(0).getMerchantId());
//
//        startActivity(intent);
//

//        SharedPreferences sharedPreferences=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("productID",productEntity.getProductId());

        Toast.makeText(this, "Image Clicked for" + productEntity.getProductId(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ProductFullView.class);
//        String p = productEntity.getProductId();
//        intent.putExtra("productId",productEntity.getProductId());
     //   Bundle bundle = new Bundle();
        //String productId =productEntity.getProductId();
        intent.putExtra("productId",productEntity.getProductId());
   //     bundle.putSerializable("product", productEntity);
     //   intent.putExtras(bundle);
        //intent.putExtra("merchantId", productEntity.getMerchantList().get(0).getMerchantId());
        startActivity(intent);
    }



    public void SliderApi(String catName, List<ProductEntity> productEntities) {

        Retrofit retrofit = BuilderProduct.getInstance();
//        SliderInterface sliderInterface = retrofit.create(SliderInterface.class);
        Call<List<ProductEntity>> productListCall = retrofit.create(SliderInterface.class).postLog(catName);

        Log.d("Hellllllllllllooooo", "1SliderAPI");
        productListCall.enqueue(new Callback<List<ProductEntity>>() {
            @Override
            public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {

//                for(int i=0;i <= response.body().size();i++) {
//
//
//                }
                //productEntities.add(response.body().get(0));

                RecyclerView recyclerView = findViewById(R.id.productrecycler);
                ProductAdapter productAdapter = new ProductAdapter(response.body(), Product.this);
                Toast.makeText(Product.this,response.body().get(0).getProductName(), Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setAdapter(productAdapter);

                Toast.makeText(Product.this,response.body().get(0).getProductName(), Toast.LENGTH_SHORT).show();

                //Toast.makeText(Product.this, "Everything is correct", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ProductEntity>> call, Throwable t) {
                Toast.makeText(Product.this, "Everything is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}