package day0118;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * 8번 참고
 * 패널위에 5개의 버튼 생성
 * 각각의 버튼명은 미리 라벨로 배열로 작성해 놓는다.
 * 색상또한 배열처리해논다.(Color.RED....)
 * 버튼의 색상은 해당색상의 글자색을 갖는다.
 * 프레임에 안녕하세요 라는 글자를 굵게 30으로 잡는다.
 * 위의 5개 버튼을 누를 때마다 안녕하세요 글자색상은 버튼을 누른 해당 색상으로 바뀐다.
 * 
 */

public class Quiz_11 extends JFrame implements ActionListener{
	
	Container cp;
	JButton [] btn= new JButton[5];
	String[] btnLabel = {"Red","Green","Blue","Magenta","Yellow"};
	Color[] btnColors = {Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.YELLOW};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//로직 작성
		
	}

}
