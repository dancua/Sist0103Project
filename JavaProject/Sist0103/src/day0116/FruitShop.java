package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FruitShop {
	
	public static void fruit() throws FileNotFoundException,IOException
	{
		String fileName ="C:\\sist0103\\file\\fruitShop.txt";
		FileReader fr = null;
		BufferedReader br = null;
		int cnt = 0;
		
		fr = new FileReader(fileName);
		System.out.println("**과일입고 목록**");
		System.out.println("번호\t과일명\t수량\t단가\t총금액");
		System.out.println("==========================================");
		
		br = new BufferedReader(fr);
		
		while(true)
		{
			String n = br.readLine();
			
			if(n==null)
				break;
			StringTokenizer st = new StringTokenizer(n,",");
			cnt++;
		 String name = st.nextToken();
		 int su = Integer.parseInt(st.nextToken());
		 int dan = Integer.parseInt(st.nextToken());
		 int total = su*dan;
		 
	System.out.println(cnt +"\t"+ name +"\t"+ su + "\t"+dan+"\t"+ total);
		}
		
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		try {
			fruit();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

