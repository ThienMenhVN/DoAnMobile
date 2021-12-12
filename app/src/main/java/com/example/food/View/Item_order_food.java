package com.example.food.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.ProductAdapter;
import com.example.food.Model.Product;
import com.example.food.Model.Size;
import com.example.food.R;

import java.util.ArrayList;

public class Item_order_food extends Fragment {
    ArrayList<Product> productArrayList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Item_order_food() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Item_order_food.
     */
    // TODO: Rename and change types and number of parameters
    public static Item_order_food newInstance(String param1, String param2) {
        Item_order_food fragment = new Item_order_food();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_item_order_coffee, container, false);
        productArrayList = new ArrayList<Product>();

        Product product1 = new Product();
        product1.setName("Macca Phủ Socola");
        product1.setPrice("45000");
        product1.setImg(R.drawable.macca);
        product1.setDescription("Sô cô la thơm lừng bao bọc hạt mắc ca bùi béo thiệt ngon - món ăn vặt" +
                "đắng nhẹ, ngọt ngào không thể thiếu cho mùa Giáng sinh ấm áp, cắn 1 miếng là mê ngay" +
                "và nhâm nhi với món nước nào cũng hợp đấy");
        productArrayList.add(product1);

        Product product2 = new Product();
        product2.setName("Đậu Phộng Tỏi Ớt");
        product2.setPrice("15000");
        product2.setImg(R.drawable.dauphong);
        ArrayList<Size> sizes2 = new ArrayList<>();
        product2.setSize(sizes2);
        ArrayList<Topping> toppings2 = new ArrayList<>();
        product2.setTopping(toppings2);
        product2.setDescription("Là món ăn chơi nhưng ngọt thiệt mới nhất của The CoffeeHouse, đậu phộng béo " +
                "được áo thêm lớp tỏi ớt mặn mặn, ngọt ngọt và chút cay cay. Vừa nhâm nhi với trà hay món " +
                "nước mát lạnh nữa là đúng bài, ăn hoài không ngán nhé!");
        productArrayList.add(product2);

        Product product3 = new Product();
        product3.setName("Mít Sấy");
        product3.setPrice("20000");
        product3.setImg(R.drawable.mitxay);
        ArrayList<Size> sizes3 = new ArrayList<>();
        product3.setSize(sizes3);
        ArrayList<Topping> toppings3 = new ArrayList<>();
        product3.setTopping(toppings3);
        product3.setDescription("Mít sấy khô vàng ươm giòn rụm, khi ăn vẫn giữ nguyên được vị ngọt lịm của mít tươi");
        productArrayList.add(product3);

        Product product4 = new Product();
        product4.setName("Cam tươi Sấy Dẻo");
        product4.setPrice("35000");
        product4.setSize(sizes2);
        product4.setDescription("Cam tươi được sấy với độ ẩm vừa phải, vị chua thanh thích hợp cho các bạn thích healthy");
        product4.setImg(R.drawable.camvang);
        productArrayList.add(product4);

        Product product5 = new Product();
        product5.setName("Điều vàng mật ong");
        product5.setPrice("39000");
        product5.setSize(sizes2);
        product5.setDescription("Ăn vặt cũng phải healty. Hạt điều nhiều dinh dưỡng phủ lớp mật ong ngọt ngọt " +
                "mặn mặn ăn hoài ngon hoài hứa luôn :))");
        product5.setImg(R.drawable.hatdieu);
        productArrayList.add(product5);

        Product product6 = new Product();
        product6.setName("Heo Sấy Xông khói");
        product6.setPrice("35000");
        product6.setSize(sizes2);
        product6.setDescription("Thịt heo được ướp gia vị đậm đà - mặn, ngọt, chua, cay ngon ngất ngây. Chút mồi sừng " +
                "sựt để cuộc hèn không bao giờ chán.");
        product6.setImg(R.drawable.heosay);
        productArrayList.add(product6);

        Product product7 = new Product();
        product7.setName("Mochi Kem Matcha");
        product7.setPrice("19000");
        product7.setSize(sizes2);
        product7.setDescription("Vừa quen vừa lạ từ vỏ bánh mềm dẻo, đến lớp kem lạnh và nhân trà xanh đậm vị, gọi 1 chiếc Mochi" +
                " cho ngày thiệt tươi nha. Sản phẩm phải bảo quản mát và dùng ngon trong 2h sau khi nhận hàng");
        product7.setImg(R.drawable.mochi);
        productArrayList.add(product7);

        Product product8 = new Product();
        product8.setName("Mousse Gấu Chocolate");
        product8.setPrice("39000");
        product8.setSize(sizes2);
        product8.setDescription("Với vẻ bề ngoài đáng yêu và hương vị ngọt ngào thơm béo nhất định bạn phải thử ít nhất một lần");
        product8.setImg(R.drawable.banhgau);
        productArrayList.add(product8);


        RecyclerView recyclerView = v.findViewById(R.id.linear_coffee);
        ProductAdapter productAdapter = new ProductAdapter(productArrayList,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(productAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }
}
