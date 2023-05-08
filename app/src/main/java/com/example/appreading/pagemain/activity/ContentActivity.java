package com.example.appreading.pagemain.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.appreading.R;
import com.example.appreading.model.ChapModel;
import com.example.appreading.model.HomeItemModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ContentActivity extends AppCompatActivity {
    TextView chap_main, chap_content, id, idtr;
    ChapModel position;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        chap_main       = findViewById(R.id.chap2);
        chap_content    = findViewById(R.id.content2);
        id              = findViewById(R.id.id2);
        idtr              = findViewById(R.id.idtruyen1);
        position = getIntent().getParcelableExtra("chap_pos");

//        assert position != null;
//        chap_main.setText(position.getChap1());
//        chap_content.setText(position.getContent1());
//        id.setText(position.getId1());
//        idtr.setText(position.getId_tr1());
        chap_content.setText("Chương 1 Thất nghiệp.\n" +
                "\n"+
                "Phồn hoa ma đô, nào đó ruồi bọ tiệm ăn, một cái thân hình đơn bạc thiếu niên, vây quanh một cái tràn đầy vấy mỡ tạp dề, chính ngồi xổm ướt dầm dề sau bếp trên mặt đất tẩy chén đũa.\n" +
                "\n" +
                "Thỉnh thoảng lại có mâm bị đưa lại đây, đôi ở hắn bên cạnh, hắn đem kia mâm thừa đồ ăn đảo tiến thùng đồ ăn cặn, đánh chút chất tẩy rửa ở mâm thượng, bỏ vào đã ô uế chậu nước, dùng mướp hương nhương rửa sạch.\n" +
                "\n" +
                "“Ai! Ngươi, nói bao nhiêu lần, không cần phóng như vậy nhiều chất tẩy rửa, ngươi không nghe được đúng không!” Một cái tai to mặt lớn mập mạp đi vào tới, đổ ập xuống liền mắng.\n" +
                "\n" +
                "Dương Phong sửng sốt: “Du quá nhiều, không cần chất tẩy rửa tẩy không sạch sẽ.”\n" +
                "\n" +
                "Mập mạp một ngụm cục đàm phun trên mặt đất: “A ~ phi! Chất tẩy rửa không cần tiền a! Một ngày dùng nhiều như vậy, tháng này tiền thưởng không có, chạy nhanh lại đây chạy đồ ăn, đồ ăn lại lui nói, tiền lương đều không có.”\n" +
                "\n" +
                "Không đợi Dương Phong nói chuyện, mập mạp lại phân phó lên: “Chạy xong đồ ăn, lại đi đem cái kia đào lý phố tây cơm hộp tặng, nhanh lên a, đều tm mau siêu khi, bị khiếu nại ta liền khấu ngươi tiền lương.”\n" +
                "\n" +
                "Dương Phong hít sâu một ngụm, nắm chặt nắm tay lại buông ra, yên lặng mà lấy rớt tạp dề, xách theo cơm hộp đi ra ngoài.\n" +
                "\n" +
                "Tám tháng phân phục thiên, bên ngoài liền cùng một đoàn hỏa giống nhau, lúc này trên đường cái trừ bỏ qua lại xuyên qua cơm hộp viên, cơ hồ nhìn không tới người.\n" +
                "\n" +
                "Dương Phong cưỡi kia mập mạp phá xe đạp, dựa theo địa chỉ cấp tặng qua đi, phá xe kỵ một đoạn đường liền rớt dây xích, này dọc theo đường đi hắn xuống dưới đùa nghịch ba bốn thứ.\n" +
                "\n" +
                "Tới rồi địa phương, Dương Phong dựa theo đơn tử điện thoại bát qua đi.\n" +
                "\n" +
                "“Ngươi hảo, ngươi cơm hộp tới rồi, ngươi…”\n" +
                "\n" +
                "Lời nói còn chưa nói xong, điện thoại kia đầu truyền đến một trận tiếng gầm gừ: “Ngươi tm chính mình nhìn xem vài giờ, ngươi tm chính mình ăn đi!”\n" +
                "\n" +
                "“Ta…”\n" +
                "\n" +
                "Đô đô đô…\n" +
                "\n" +
                "“Ai ~”\n" +
                "\n" +
                "Dương Phong thở dài, nhìn nhìn cơm hộp đơn, mức còn không nhỏ, điểm 95 đồng tiền, này nếu là lui nói, lại là chính mình mua đơn.\n" +
                "\n" +
                "Chính mình hiện tại một tháng tiền lương cũng liền 1500, hơn nữa tiền thưởng 300 đồng tiền liền 1800 khối.\n" +
                "\n" +
                "Buổi sáng tiền thưởng đã bị khấu, này lại khấu một trăm đồng tiền, kia tháng này trừ bỏ sinh hoạt phí, liền tiền thuê nhà đều giao không nổi.\n" +
                "\n" +
                "Nghĩ vậy, Dương Phong căng da đầu, xách theo cơm hộp liền hướng trên lầu chạy tới.\n" +
                "\n" +
                "Đát… Lộc cộc.\n" +
                "\n" +
                "Dương Phong lễ phép gõ 302 cửa phòng môn.\n" +
                "\n" +
                "“Ai a?”\n" +
                "\n" +
                "“Ngươi hảo, ta là đưa cơm hộp.”\n" +
                "\n" +
                "“Lăn!”\n" +
                "\n" +
                "Lại thử hai lần, kia nam tử đem hắn mắng máu chó phun đầu.\n" +
                "\n" +
                "“Lại không lăn ta tm lộng chết ngươi!”\n" +
                "\n" +
                "Dương Phong không có cách nào, siêu khi, khách hàng không cần về tình cảm có thể tha thứ, hắn chỉ có thể dẫn theo cơm hộp đi xuống lâu đi, nhìn bầu trời kia như là muốn đem người nướng tiêu dạng thái dương hơi xuất thần, có chút mê mang.\n" +
                "\n" +
                "Trở lại trong tiệm, nhìn hắn đề trở về cơm hộp, mập mạp xem hắn ánh mắt như là muốn đem hắn ăn giống nhau.\n" +
                "\n" +
                "Chỉ là nơi này còn có khách nhân, không hảo phát hỏa, chờ hắn trở lại sau bếp, đổ ập xuống lại là một đốn mắng, tam câu nói không rời đi trừ tiền lương.\n" +
                "\n" +
                "Đang ở làm việc hai cái đầu bếp cùng một cái đoan mâm lại đây người phục vụ đều rụt rụt cổ, nhìn về phía Dương Phong ánh mắt mang theo đồng tình.\n" +
                "\n" +
                "“Thảo! Ngươi cái phế vật! Muốn ngươi có ích lợi gì!” Mập mạp lải nhải mà mắng, hôm nay đặc biệt nhiệt, hắn hỏa khí cũng tương đương đại.\n" +
                "\n" +
                "Dương Phong cả người run rẩy, nắm tay nhéo lại tùng, lỏng lại khẩn, đang mắng đến người nhà của hắn thời điểm, rốt cuộc nhịn không được, chỉ vào mập mạp cái mũi mắng: “Ngọa tào nima! Ngươi lại mắng một câu thử xem!”\n" +
                "\n" +
                "Bởi vì cảm xúc kích động, hắn thanh âm đều tiêm tế lên, có chút khàn cả giọng, trên cổ gân xanh hiện ra, mặt bộ sung huyết, đôi mắt tràn ngập tơ máu.\n" +
                "\n" +
                "“Ngươi…”\n" +
                "\n" +
                "Mã phi mắng đang ở cao hứng, thanh âm đột nhiên đột nhiên im bặt, trừng lớn đậu xanh giống nhau mắt nhỏ, không dám tin tưởng mà nhìn thay đổi một người dường như Dương Phong.\n" +
                "\n" +
                "Hắn như thế nào cũng không nghĩ tới, ngày thường vâng vâng dạ dạ, chiêu chi tức tới huy chi tức đi Dương Phong cũng dám như vậy cùng chính mình nói chuyện.\n" +
                "\n" +
                "Hắn chính là lão bản a, mà Dương Phong, chẳng qua là chính mình thuộc hạ một cái không chớp mắt tiểu công nhân thôi, thế nhưng còn dám mắng hắn.\n" +
                "\n" +
                "“Ngươi cái gì ngươi, cam lộ nương súng máy, lão tử không làm! Đem tiền lương kết cho ta.”\n" +
                "\n" +
                "Nhìn trước mặt cái này cái gọi là lão bản, Dương Phong một chút tình cảm đều không lưu trực tiếp khai mắng.\n" +
                "\n" +
                "Nghẹn ở trong lòng hồi lâu hờn dỗi, hôm nay cái này mắng xong, cảm giác thoải mái nhiều.\n" +
                "\n" +
                "Cái này quỷ hút máu, Chu Bái Bì, động bất động liền tăng ca, mỗi ngày thức khuya dậy sớm cho hắn công tác, sớm đã liền vượt qua nói tốt tám giờ.\n" +
                "\n" +
                "Phía trước nói tốt bao ăn bao ở, hiện tại cũng chỉ là bao ăn, tiền lương không trướng quá không nói, còn động bất động liền tìm lý do khấu.\n" +
                "\n" +
                "Vì có thể ở cái này thành thị trung sinh tồn đi xuống, hắn chỉ có thể vẫn luôn chịu đựng, nghĩ tích cóp điểm tiền, học môn tay nghề, về sau cũng có cái nhất nghệ tinh.\n" +
                "\n" +
                "Chính là Dương Phong quyết định lúc này đây không đành lòng, cùng với như vậy uất ức làm, còn không bằng về nhà trồng trọt.\n" +
                "\n" +
                "Lúc này, kia hai cái đầu bếp cùng phục vụ viên đều nhìn lại đây, đều ở trong lòng vỗ tay tỏ ý vui mừng.\n" +
                "\n" +
                "“Mắng hảo, xứng đáng, đây là một cái điển hình hiện đại bản Chu Bái Bì.”\n" +
                "\n" +
                "Bao gồm Dương Phong ở bên trong, đại gia mấy năm nay cấp mã phi kiếm lời không ít tiền, nhưng là tiền lương không trướng, ngược lại là không lý do liền khấu, công nhân cơm phóng điểm thịt bị hắn thấy được đều phải mắng.\n" +
                "\n" +
                "Ở chỗ này đi làm phần lớn là sinh hoạt bức bách, có muốn còn xe thải khoản vay mua nhà, hoặc là chính là trong nhà có lão bà hài tử chờ tiền chi tiêu, bằng không đã sớm phản kháng không làm.\n" +
                "\n" +
                "Dương Phong hiện tại chẳng qua là làm bọn họ vẫn luôn muốn làm mà chuyện không dám làm, nếu không phải sợ ném công tác, phỏng chừng đều có người vỗ tay vỗ tay.\n" +
                "\n" +
                "Mã phi nghe xong Dương Phong nói, khí dậm chân mắng: “Lập tức cút xéo cho ta! Ngươi còn dám muốn tiền lương!”\n" +
                "\n" +
                "“Hành, không cho đúng không, chờ ta cáo ngươi đi, ngươi cho ta chờ.”\n" +
                "\n" +
                "“Ngươi tm dám!”\n" +
                "\n" +
                "“Ngươi xem ta có dám hay không.”\n" +
                "\n" +
                "Nói, Dương Phong một chân đá bay trên mặt đất mâm, liền phải đi ra ngoài.\n" +
                "\n" +
                "Mã phi lại đột nhiên táo bạo lên, một chút vọt lại đây: “Ngươi dám đá ta mâm! Thảo!”\n" +
                "\n" +
                "“A!” Đang ở một bên yên lặng nhìn đầu bếp cùng phục vụ viên đều kêu sợ hãi ra tiếng.\n" +
                "\n" +
                "Dương Phong nghe được thanh âm, theo bản năng về phía trước một chạy.\n" +
                "\n" +
                "“Phanh!”\n" +
                "\n" +
                "Nắm tay nện ở hắn phía sau lưng thượng, mang hắn về phía trước vọt hai bước mới dừng lại tới, vốn là đối với hắn đầu tới.\n" +
                "\n" +
                "“Ngọa tào bùn mã! Ta lộng chết ngươi!”\n" +
                "\n" +
                "Dương Phong một chút liền tức giận, hồng con mắt liền vọt đi lên, cùng mã phi vặn đánh vào cùng nhau.\n" +
                "\n" +
                "Hoa lạp lách cách, phòng bếp vốn là không lớn không gian, đặt rau dưa đồ ăn cái giá cũng bị đánh ngã, rau dưa rơi rụng đầy đất.\n" +
                "\n" +
                "Mã phi thấy chính mình đồ ăn đều bị lộng hỏng rồi, khí nổi trận lôi đình, một chân hướng hắn đạp lại đây.\n" +
                "\n" +
                "Dương Phong ôm chặt hắn đá lại đây chân, dùng sức hướng về phía trước một hiên.\n" +
                "\n" +
                "“Bang!”\n" +
                "\n" +
                "Mã phi hai trăm cân thịt mỡ nặng nề mà ngã ở trên mặt đất.\n" +
                "\n" +
                "…\n" +
                "\n" +
                "Từ đồn công an ra tới sau, Dương Phong thất hồn lạc phách mà ở đầu đường thượng đi tới, nhìn này nghê hồng ma đô, trong ánh mắt tràn ngập mê mang, này nặc đại ma đô, thế nhưng không có hắn nơi dừng chân.\n" +
                "\n" +
                "“Đông.”\n" +
                "\n" +
                "Một cái đồ vật rơi xuống ở hắn chân bên, dọa hắn giật mình.\n" +
                "\n" +
                "“Dựa! Là ai trời cao vứt vật a!”");
    }
}
