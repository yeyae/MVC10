package hello;
import java.util.Scanner;
public class Hello {
   public static void main(String[] args) {
	   final int num=10;
	   double num2;
	   num2=20;
	   
	   System.out.println("num="+num);
	   System.out.println("num2="+num2);
	   int result=0;
	      Scanner sc= new Scanner(System.in);
	      System.out.println("i 값 입력 :");
	      int i = 0;
	      i=sc.nextInt();
	      System.out.println("j 값 입력 :");
	      int j = 0;
	      j=sc.nextInt();
	   System.out.print("사칙연산 뭐할거임?");
	   char a ='+';
	   a=sc.next().charAt(0);
	   switch (a) {
		   case '+':
			   result=add(i,j);
			   System.out.println("i"+a+"j="+result);
			   break;
		   case '-':
			   result=sub(i,j);
			   System.out.println("i"+a+"j="+result);
			   break;
		   case '*':
			   result=multi(i,j);
			   System.out.println("i"+a+"j="+result);
			   break;
		   case '/':
			   result=divide(i, j);
			   System.out.println("i"+a+"j="+result);
			   break;
		   default:
				System.out.println("+,-,*,/ 중에 하나 입력하셈 ㅡ.ㅡ");   
	   }
	  
//      System.out.print("입력받은 값:");
//      System.out.println(i);
      
      
      
//      int mun =main2("문자열");
//      System.out.println(mun);
      
     
   }
   
   public static int main2(String string) {
	   System.out.println(string);
	   return 5;
   }
 
   public static int add(int a, int b){
		return a+b;
	}
   public static int divide(int a, int b){
		return a/b;
	}
   public static int sub(int a, int b){
		return a-b;
	}
   public static int multi(int a, int b){
		return a*b;
	}
}




