package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

// 차 관리 페이지
public class carIntro extends JFrame {
	
    JButton btnIntro;

    public carIntro() {
        super("차 관리 페이지");

        ImageIcon imageIcon = new ImageIcon("C:\\sist0103\\image\\carImage\\image.jpg");
        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();

        this.setSize(imageWidth, imageHeight);

        initDesign();
        this.setVisible(true);
    }

    public void initDesign() {
        JLabel background = new JLabel(new ImageIcon("C:\\sist0103\\image\\carImage\\image.jpg"));
        background.setBounds(0, 0, getWidth(), getHeight()); 

        btnIntro = new JButton("프로그램 시작");
        
        btnIntro.setPreferredSize(new Dimension(120, 30));
        
        btnIntro.setBounds(getWidth() / 2 - 60, getHeight() - 50, 120, 30); 
        btnIntro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new carListForm();
            }
        });

        background.add(btnIntro);
        this.add(background);
    }

    public static void main(String[] args) {
        new carIntro();
    }
}
