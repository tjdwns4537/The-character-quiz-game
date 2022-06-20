import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mydialog extends JDialog {
    JButton button = new JButton("종료");
    public Mydialog(JFrame jFrame) {
        super(jFrame);
        setTitle("축하드립니다.");
        setSize(100,100);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
