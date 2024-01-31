package Project;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// 		2번째 화면 


public class carListForm extends JFrame{
	
	carDAO dao = new carDAO();
	ImageDraw draw = new ImageDraw();
	String imageName;
	
//	테이블
	DefaultTableModel model;
	JTable table;
	Vector<carDTO> list;

	public carListForm()
	{
		super("자동차 목록");
		this.setBounds(220, 100, 850, 420);
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		this.setLayout(null);
		list = dao.select();
		
//		table
		String [] title = {"번호","자동차명","가격","연비","연료","차급","외형","정비이력"};
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(30, 60, 600, 300);
		this.add(js);
		
//		이미지 위치
		draw.setBounds(520, 50, 160, 220);
		this.add(draw);
		
//		데이터 출력해주는 메서드
		this.dataWrite();
		
		
//		출력된 데이터 이벤트..익명내부클래스
		table .addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				행번호얻기
				int row = table.getSelectedRow();
				
//				list에서 rw에 해당하는 dto를 꺼내서 거기에서 이미지명을 얻는다				
				imageName = list.get(row).getCarImage();
				
				draw.repaint();
				super.mouseClicked(e);
			}
		});		
	}
	
//		데이터 출력해주는 메서드
	public void dataWrite()
	{
		
//			테이블 기존데이터 삭제
		model.setRowCount(0);
		
//		테이블에 데이터 추가
		for(carDTO dto : list) {
			Vector<String> data= new Vector<String>();
			
			data.add(dto.getNum());
			data.add(dto.getC_name());
			data.add(String.valueOf(dto.getC_price())+" 만원");
			data.add(String.valueOf(dto.getC_fe())+"km/ℓ");
			data.add(dto.getC_fuel());
			data.add(dto.getC_level());
			data.add(dto.getC_ap());
			data.add(dto.getC_maintain());
			
//			테이블 모델에 추가
			model.addRow(data);
		}
	}
	
	class ImageDraw extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			if(imageName != null)
			{
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image,0,0,100, 100,this);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new carListForm();
	}

}
