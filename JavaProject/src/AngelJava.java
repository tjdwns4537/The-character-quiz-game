import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class AngelJava extends JFrame{	
	
	public ArrayList<String> ImgArray = new ArrayList<String>(); // �̹��� ���
	public ArrayList<String> AnswerArray = new ArrayList<String>(); // ���� ����
	public ImageIcon ImgIC = new ImageIcon();
	
	public JButton JB = new JButton("����");
	public ImageIcon[] ImageArray = new ImageIcon[7];
	
	public JLabel ImageLabel = new JLabel(); // �̹��� �� ��
	public int a = 0; // �̹��� �ٲ��� ��Ʈī��Ʈ
	public JTextField TextField = new JTextField(10); //���� �Է��� �ؽ�Ʈ
	public JLabel TimerText = new JLabel(); //�ð�
	public JLabel Score = new JLabel("0"); // ���� ������ �ؽ�Ʈ
	public int BigScore = 0; // ���� int
	public static int limitcount = 300; // ī��Ʈ ������ �ð�


//	class MyDialog extends JDialog
//	{
//		JLabel NB = new JLabel("축하합니다");
//		JButton okButton = new JButton("종료");
//		public MyDialog(JFrame frame, String title){
//			super(frame,title);
//			sayLayout(new FlowLayout());
//			add(NB);
//			add(okButton);
//			setSize(150,150);
//			okButton.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.exit(0);
//				}
//			});
//		}
//	}

	class EndGame extends JFrame{

		public EndGame(){
			super("축하드립니다!!");
			JButton EndButton = new JButton("종료");
			EndButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			add(EndButton);
			setVisible(true);
			setSize(200,200);

		}

	}

	class UnderBar extends JPanel
	{
		JFrame jFrame;
		UnderBar()
		{
			jFrame = new JFrame();
			setBackground(Color.LIGHT_GRAY);
			setSize(200,100);
			JButton Answering = new JButton("제출"); //��ư ��ü ����
			Answering.setPreferredSize(new Dimension(100,40));
			TextField.setPreferredSize(new Dimension(100,40)); //TextField ũ�� ����

			Answering.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try{
						if(TextField.getText().equals(AnswerArray.get(a))){
							a++;
							if(a >= 7){
								System.out.println(a);
								Congra();
							}
							ImageLabel.setIcon(new ImageIcon(ImgArray.get(a)));
							TextField.setText("");
							BigScore++;
							Score.setText(Integer.toString(BigScore));
						}
					}
					catch(IndexOutOfBoundsException e1)
					{
						//JOptionPane.showMessageDialog(jFrame,"성공입니다!");
					}
					catch (Exception ea){

					}
				}
			});
			setVisible(true);
			//setPreferredSize(new Dimension(150,100));
			add(Answering);
			add(TextField);
		}

		public void Congra() {
			JOptionPane.showMessageDialog(jFrame,"성공입니다!");
			setVisible(false);
		}
	}


	class upBar extends JPanel
	{
		public upBar(){
		Container c = getContentPane();
		setLayout(new FlowLayout());

		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run()
			{
				TimerText.setText(Integer.toString(limitcount));
				limitcount--;
				if(limitcount == 0)
				{
					System.exit(0);
				}
			}
			
		};
		timer.schedule(task,0,1000);
		
		JLabel ScoreText = new JLabel("점수     :");
		ScoreText.setPreferredSize(new Dimension(50,25));
		Score.setPreferredSize(new Dimension(50,25));
		TimerText.setPreferredSize(new Dimension(50,25));
		
		add(ScoreText);
		add(Score);
		add(TimerText);
		setVisible(true);
		setSize(200,100);
		}	
		
	}
		
	
	AngelJava(int flag)
	{
		super("인물퀴즈");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		if(flag == 0){
			ImgArray.add("Source/Image/운동선수/김연경.jpg");
			ImgArray.add("Source/Image/운동선수/김연아.jpg");
			ImgArray.add("Source/Image/운동선수/박태환.jpg");
			ImgArray.add("Source/Image/운동선수/손흥민.jpg");
			ImgArray.add("Source/Image/운동선수/이용대.jpg");
			ImgArray.add("Source/Image/운동선수/조던.jpg");
			ImgArray.add("Source/Image/운동선수/페더러.jpg");

			ImageArray[0] = new ImageIcon(ImgArray.get(0));
			ImageArray[1] = new ImageIcon(ImgArray.get(1));
			ImageArray[2] = new ImageIcon(ImgArray.get(2));
			ImageArray[3] = new ImageIcon(ImgArray.get(3));
			ImageArray[4] = new ImageIcon(ImgArray.get(4));
			ImageArray[5] = new ImageIcon(ImgArray.get(5));
			ImageArray[6] = new ImageIcon(ImgArray.get(6));

			AnswerArray.add("김연경");
			AnswerArray.add("김연아");
			AnswerArray.add("박태환");
			AnswerArray.add("손흥민");
			AnswerArray.add("이용대");
			AnswerArray.add("조던");
			AnswerArray.add("페더러");
		}

		else if(flag == 1){
			ImgArray.add("Source/Image/한국배우/박보검.jpg");
			ImgArray.add("Source/Image/한국배우/박보영.jpg");
			ImgArray.add("Source/Image/한국배우/송강호.jpg");
			ImgArray.add("Source/Image/한국배우/송중기.jpg");
			ImgArray.add("Source/Image/한국배우/송혜교.jpg");
			ImgArray.add("Source/Image/한국배우/이병헌.jpg");
			ImgArray.add("Source/Image/한국배우/전여빈.jpg");
			for(int i=0; i<7; i++){
				ImageArray[i] = new ImageIcon(ImgArray.get(i));
			}
			AnswerArray.add("박보검");
			AnswerArray.add("박보영");
			AnswerArray.add("송강호");
			AnswerArray.add("송중기");
			AnswerArray.add("송혜교");
			AnswerArray.add("이병헌");
			AnswerArray.add("젼여빈");
		}

		else if(flag == 2){
			ImgArray.add("Source/Image/외국배우/디카프리오.jpg");

			ImgArray.add("Source/Image/외국배우/모건프리먼.jpg");

			ImgArray.add("Source/Image/외국배우/아만다.jpg");

			ImgArray.add("Source/Image/외국배우/앤드류.jpg");

			ImgArray.add("Source/Image/외국배우/앰마스톤.jpg");

			ImgArray.add("Source/Image/외국배우/윌스미스.jpg");

			ImgArray.add("Source/Image/외국배우/졸리.jpg");

			for(int i=0; i<7; i++){
				ImageArray[i] = new ImageIcon(ImgArray.get(i));
			}
			AnswerArray.add("디카프리오"); AnswerArray.add("모건프리먼");
			AnswerArray.add("아만다"); AnswerArray.add("앤드류");
			AnswerArray.add("앰마스톤"); AnswerArray.add("윌스미스");
			AnswerArray.add("졸리");
		}

		upBar UB = new upBar();
		UnderBar UBr = new UnderBar();
		ImageLabel.setIcon(new ImageIcon(ImgArray.get(0)));
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageLabel.setPreferredSize(new Dimension(350,180));
		
		UB.setPreferredSize(new Dimension(100,55));
		
		UBr.setPreferredSize(new Dimension(100,70));
		
		c.add(UB,BorderLayout.NORTH);
		c.add(ImageLabel,BorderLayout.CENTER);
		c.add(UBr ,BorderLayout.SOUTH);
		
		setVisible(true);
		//setResizable(false);
		setSize(400,400); // ���μ���
		
	}
}
