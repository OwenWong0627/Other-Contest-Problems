import java.util.Scanner;
public class RenAshbell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int RenAshbellRating = 0;
		boolean check = true;
		for (int i=0;i<t;i++) {
			int a = sc.nextInt();
			if (i==0) {
				RenAshbellRating = a;
			}
			if(RenAshbellRating > a && i != 0) {
				check = true;
			}
			else if (RenAshbellRating <= a && i != 0){
				check = false;
				break;
			}
		}
		if (check == true) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
