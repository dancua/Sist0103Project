package day0108;

public class For_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		for(; i<=10;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\nfor문 빠져나온 i의 값: "+ i);
		
		int a = 10;
		for(;a <=50;a+=5)
			System.out.print(a+"  ");
			System.out.println("\n빠져나온 a값: "+ a);
			
		System.out.println("1~10까지 숫자중에서 짝수만 출력");
		for(int n=1;n<=10; n++)
		{
			if(n%2==0)
				System.out.println(n +" ");
		}
		System.out.println();
		
		System.out.println("1~10까지 숫자중에서 짝수만 출력");
		for(i = 1; i<=10; i++) {
			if(i%2==1)
				continue;
		System.out.print(i+ " ");
		}
	}

}
