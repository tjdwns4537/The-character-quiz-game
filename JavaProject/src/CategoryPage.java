import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryPage extends JFrame {
    public CategoryPage() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());

        // 3개의 체크박스를 생성한다.
        JCheckBox a = new JCheckBox("운동선수");
        JCheckBox b = new JCheckBox("한국 배우", true);
        JCheckBox c = new JCheckBox("외국 배우");
        JButton jButton = new JButton("선택완료");

        con.add(a);
        con.add(b);
        con.add(c);
        con.add(jButton);

        setSize(250,150);
        setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a.isSelected()){
                    MenuPage.flag = 0;
                }
                if(b.isSelected()){
                    MenuPage.flag = 1;
                }
                if(c.isSelected()){
                    MenuPage.flag = 2;
                }
                new MenuPage();
                setVisible(false);

            }
        });
    }
}
