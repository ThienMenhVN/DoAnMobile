package com.example.food.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.SectionAdapter;
import com.example.food.Model.News;
import com.example.food.Model.Section;
import com.example.food.R;

import java.util.ArrayList;

public class Fragment_news extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.listofsections);
        ArrayList<Section> sections = new ArrayList<>();
        Section section = new Section();
        section.setHeaderTitle("Ưu đãi đặc biệt");
        ArrayList<News> news = new ArrayList<>();
        news.add(new News(R.drawable.news1,"Giảm 50%, thèm gì gọi nhé Nhà mang tới liền",
                "Hòa vào không kí sale cuối năm mình nghỉ tay gọi món yêu thích, Nhà giảm 50% khi nhập mã MERRY50 " +
                        "để lên tinh thần săn sale thoăn thoắt. Shipper Nhà rộn ràng chờ bạn đặt là giao liền tận nơi, chỉ " +
                        "30 phút và Freeship luôn nha. Sướng nhất team săn sale rồi Order liền thôi!","Order ngay"));
        news.add(new News(R.drawable.new2,"Nhà mời cà phê đậm đà chỉ 12k",
                "Tuần mới chỉ thật sự tươi khi có một tách cà phê đậm đà kề bên. Biết vậy nên Nhà mời liền bạn " +
                        "có hóa đơn từ 50k mua cà phê Việt Nam giá chỉ 12k. Nhanh tay mở app, nhâp mã YEUCAPHE để nhận ưu đãi " +
                        "Dù bạn ở đâu Shipper Nhà cũng Freeship tới ngay trong 30p","Order ngay"));
        news.add(new News(R.drawable.new3,"Nhà mời 20% PICKUP nha","Trải nghiệm nay tính năng PICKUP của Nhà với ưu đãi" +
                " 20% cho đơn hàng chỉ từ 2 món, khi nhập mã PICKUPDI NÀO. Chỉ càn vài thao tác đơn giản bạn đã có thể ghé Nhà với thần " +
                "thái cự ngầu để láy món nước yêu thích","Order ngay"));
        news.add(new News(R.drawable.new4,"Bánh ngon Nhà mời, chỉ 19.000đ!","Cuối năm bận rộn thi cử, chạy số, chiến deadline" +
                " nhưng không được bỏ bữa đâu nha ấy nhé! Nhà luôn sẵn sàng giao tận nơi bánh mì nóng giòn cùng cà phê đậm đà" +
                " trà mát lạnh cho bạn nạp căng năng lượng","Order ngay"));
        section.setListContent(news);
        sections.add(section);


        Section section1 = new Section();
        section1.setHeaderTitle("Cập nhật từ nhà");
        ArrayList<News> news1 = new ArrayList<>();
        news1.add(new News(R.drawable.new5,"Nhà Riverside Vũ Tông Phan Hà Nội khai trương",
                "Người ta dậy thì thành công, còn chúng mình dậy thì nhớ mang chiếc áo đủ ấm, ghé ngay Nhà " +
                        "Riverside Vũ Tông Phan - Hà Nội mới toanh vui khai trương linh đình(07/12 - 09/12) và tham gia ngay" +
                        " Vòng quay may mắn để nhận quà cực xịn nha","Xem chi tiết"));
        news1.add(new News(R.drawable.new6,"Taste of Xmas - Chạm vị Giáng sinh",
                "Những ngày cuối năm thật khác. Giáng sinh cũng vì thế mà khác hơn sau 1 năm đặc biệt. Thế nhưng tại Nhà" +
                        " năm nay, vị giáng sinh mà bạn yêu thích mong chờ từ trước đến nay vẫn sẽ vẹn nguyên và đong đầy- tất cả " +
                        "đều sống động qua từng khoảnh khắc từng ngóc ngách quanh chiếc bàn cà phê ấm cúng","Xem chi tiết"));
        news1.add(new News(R.drawable.new7,"Bánh ngon Nhà mời, chỉ 19.000đ!","Cuối năm bận rộn thi cử, chạy số, chiến deadline" +
                " nhưng không được bỏ bữa đâu nha ấy nhé! Nhà luôn sẵn sàng giao tận nơi bánh mì nóng giòn cùng cà phê đậm đà" +
                " trà mát lạnh cho bạn nạp căng năng lượng","Order ngay"));
        section1.setListContent(news1);
        sections.add(section1);
        SectionAdapter sectionAdapter = new SectionAdapter(sections,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sectionAdapter);
        return v;
    }
}
