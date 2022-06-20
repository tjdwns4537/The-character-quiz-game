import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {

    static int flag = 0;
    private JButton start = new JButton("게임 시작");
    private JButton Category = new JButton("카테고리");
    private JButton exit = new JButton("종료");
    private JPanel p;

    public MenuPage(){
        ImageIcon icon = new ImageIcon("/Users/parksungjun/Desktop/7.png");
        p = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(icon.getImage(), 0, 50, null);
                //setOpaque(false);
                super.paintComponents(g);
            }
        };

        p.setLayout(null);

        //setBackground(Color.WHITE);
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("인물 퀴즈");

        this.init();
        add(p);
        setVisible(true);
    }

    public void init() {
        // 버튼 이미지 설정
        //Border border = new BevelBorder(BevelBorder.LOWERED);
        //start.setBorder(border);
        //description.setBorder(border);
        //exit.setBorder(border);

        start.setSize(100,100);
        start.setBackground(Color.DARK_GRAY);
        Category.setSize(100,100);
        Category.setBackground(Color.DARK_GRAY);
        exit.setSize(100,100);
        exit.setBackground(Color.DARK_GRAY);

        p.add(start);
        p.add(Category);
        p.add(exit);

        start.setBounds(110,85,95,30);
        Category.setBounds(110,135,95,30);
        exit.setBounds(110,185,95,30);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag == 0){
                    new AngelJava(0);
                    setVisible(false);
                }
                if(flag == 1){
                    new AngelJava(1);
                    setVisible(false);
                }
                if(flag == 2){
                    new AngelJava(2);
                    setVisible(false);
                }
            }
        });

        Category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CategoryPage();
                setVisible(false);
            }
        });
    }
}
