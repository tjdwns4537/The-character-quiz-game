import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.Timer;


public class MainFrame extends JFrame {

    HashMap<Integer,String> ImageList = new HashMap<>();

    private Container con = this.getContentPane();
    private JTextField input = new JTextField();
    private JButton ok = new JButton("제출");
    private JLabel lb = new JLabel("Score: ");
    private JLabel score = new JLabel("0");
    private JLabel TimerText = new JLabel("0");
    private JLabel img;
    private JButton jButton = new JButton("시작");

    static Integer limitcount = 60;

    public MainFrame(String title){
        this.init();

        setBackground(Color.WHITE);
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle(title);
    }

    public void init() {
        // Timer 설정
        TimerFunc();

        // imagelist 할당
        ImageList.put(1,"/Users/parksungjun/Desktop/김하온.png");
        ImageList.put(2,"/Users/parksungjun/Desktop/이영자.png");
        ImageList.put(3,"/Users/parksungjun/Desktop/유재석.png");

        //랜덤변수 생성
        Integer IValue = (Integer) randomValue();

        //이미지 화면에 출력
        ImageIcon image = new ImageIcon(String.valueOf(ImageList.remove(IValue)));
        JLabel img = new JLabel(image);

        //화면위쪽 설정
        JPanel north = new JPanel(new GridLayout());
        JPanel center = new JPanel(new FlowLayout());
        JPanel south = new JPanel(new BorderLayout());

        con.setLayout(new BorderLayout(2,4));

        // 보더박스 설정
        Border border = new BevelBorder(BevelBorder.RAISED);
        north.setBorder(border);

        // north / center / south 설정 시작

        // score, timer 설정 박스
        north.add(lb);
        north.add(score);
        north.add(TimerText);
        north.add("East",jButton);
        con.add("North", north);

        // 이미지설정
        center.add("North",img);
        con.add("Center", center);

        //답 입력 설정
        south.add("Center", input);
        south.add("East", ok);
        con.add("South", south);
        Integer temp = -1;

        //답 제출에 대한 이벤트 리스너
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String inpText = input.getText();
                while(true){
                    switch (inpText){
                        case "김하온":
                            if(IValue == 1){
                                System.out.println("정답");
                                Integer inputImgIndex = randomValue();
                                JLabel NewImg = new JLabel();
                                //NewImg.setIcon(ChangeImg(inputImgIndex));
                                center.remove(img);
                                img.setIcon(ChangeImg(inputImgIndex));
                                center.add("North",NewImg);

                            } else{
                                System.out.println("오답입니다. 다시 입력해주세요.");
                            }
                            break;
                        case "이영자":
                            if(IValue == 2){
                                System.out.println("정답");
                                Integer inputImgIndex = randomValue();
                                JLabel NewImg = new JLabel();
                                NewImg.setIcon(ChangeImg(inputImgIndex));
                                center.remove(img);
                                center.add("North",NewImg);
                            } else{
                                System.out.println("오답입니다. 다시 입력해주세요.");
                            }
                            break;
                        case "유재석":
                            if(IValue == 3){
                                System.out.println("정답");
                                Integer inputImgIndex = randomValue();
                                JLabel NewImg = new JLabel();
                                NewImg.setIcon(ChangeImg(inputImgIndex));
                                center.remove(img);
                                center.add("North",NewImg);
                            } else{
                                System.out.println("오답입니다. 다시 입력해주세요.");
                            }
                            break;
                    }
                }
            }
        });
    }

    public void TimerFunc(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TimerText.setText(Integer.toString(limitcount));
                limitcount--;
                if(limitcount == 0) System.exit(0);
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public ImageIcon ChangeImg(Integer _inputImgIndex){
        ImageIcon image = new ImageIcon(String.valueOf(ImageList.remove(_inputImgIndex)));
        return image;
    }

    public Integer randomValue(){
        int randomV = 0;
        double temp = 0.0;
        System.out.println(ImageList.size());
        for (int i = 1; i < ImageList.size(); i++) {
            temp = Math.random();
            randomV = (int) (temp*10) % ImageList.size()+1;
            System.out.println(randomV);
        }
        Integer IValue = (Integer) randomV;
        return IValue;
    }
}
