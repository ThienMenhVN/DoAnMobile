package com.example.food.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.ProductAdapter;
import com.example.food.Model.Product;
import com.example.food.Model.Size;
import com.example.food.Model.Topping;
import com.example.food.R;

import java.util.ArrayList;

public class Item_order_coffee extends Fragment {
    ArrayList<Product> productArrayList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Item_order_coffee() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Item_order_coffee newInstance(String param1, String param2) {
        Item_order_coffee fragment = new Item_order_coffee();
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
        View v = inflater.inflate(R.layout.fragment_item_order_coffee, container, false);
        productArrayList = new ArrayList<Product>();

        Product product1 = new Product();
        product1.setName("Cafe Đá Xay-Lạnh");
        product1.setPrice("59000");
        product1.setImg(R.drawable.coffeedaxay);
        ArrayList<Size> sizes1 = new ArrayList<>();
        sizes1.add(new Size("Nhỏ","0"));
        sizes1.add(new Size("Vừa","6000"));
        product1.setSize(sizes1);
        product1.setDescription("Một phiên bản upgrade từ ly cà phê sữa quen thuộc, nhưng lại tỉnh táo và tưới mát" +
                "hơn bở lớp đã xay đi kèm. Nhấp 1 ngụm là thấy đã, ngụm thứ hai thêm tỉnh táo và cứ thế lôi" +
                "cuối bạn đến giọt cuối cùng");
        productArrayList.add(product1);

        Product product2 = new Product();
        product2.setName("Americano Đá");
        product2.setPrice("40000");
        product2.setImg(R.drawable.americanoda);
        ArrayList<Size> sizes2 = new ArrayList<>();
        sizes2.add(new Size("Nhỏ","0"));
        sizes2.add(new Size("Vừa","5000"));
        product2.setSize(sizes2);
        ArrayList<Topping> toppings2 = new ArrayList<>();
        toppings2.add(new Topping("Expresso(1shot)","10000"));
        product2.setTopping(toppings2);
        product2.setDescription("Americano được pha chế bằng cách thêm nước vào một hoặc hai shot Expressp" +
                " để pha loãng độ đặc của cà phê, từ đó mang lại hương vị nhẹ nhàng, không gắt mạnh và vẫn thơm" +
                " nồng nàn.");
        productArrayList.add(product2);

        Product product3 = new Product();
        product3.setName("Cappuchino Nóng");
        product3.setPrice("50000");
        product3.setImg(R.drawable.cappuchino);
        ArrayList<Size> sizes3 = new ArrayList<>();
        sizes3.add(new Size("Nhỏ","0"));
        sizes3.add(new Size("Vừa","5000"));
        product3.setSize(sizes3);
        ArrayList<Topping> toppings3 = new ArrayList<>();
        toppings3.add(new Topping("Expresso(1shot)","10000"));
        product3.setTopping(toppings3);
        product3.setDescription("Cappuchino được gọi vui là thức uống một phần ba - 1/3 Expresso, 1/3 Sữa nóng, 1/3 Foam");
        productArrayList.add(product3);

        Product product4 = new Product();
        product4.setName("Cafe Sữa Nóng");
        product4.setPrice("35000");
        product4.setSize(sizes1);
        product4.setDescription("Cà phê phin kết hợp cùng sữa đặc là một sáng tạo đầy tự hào của người Việt, được xem món uống thương hiệu của Việt Nam");
        product4.setImg(R.drawable.coffeesua);

        Product product5 = new Product();
        product5.setName("Cafe Đen Đá");
        product5.setPrice("32000");
        ArrayList<Size> sizes5 = new ArrayList<>();
        sizes5.add(new Size("Nhỏ","0"));
        sizes5.add(new Size("Vừa","3000"));
        sizes5.add(new Size("Lớn","6000"));
        product5.setSize(sizes5);
        product5.setDescription("Một tách cà phê đen thơm ngào ngạt, phảng phất mù cacao là món quá tự thưởng tuyệt vời" +
                "nhất cho những ai mê đắm tinh chất nguyên bản của cà phê. Một tách cà phê trầm lắm, thi vị giữa dòng đời" +
                "vồn vã.");
        product5.setImg(R.drawable.coffeedaxay);

        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);
        productArrayList.add(product5);

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