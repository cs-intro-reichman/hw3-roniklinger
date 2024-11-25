// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(-25,-7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while(x1 != 0){
			x2++;
			x1--;
		}
		return x2;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while(x2 != 0){
			x1--;
			x2--;
		}
		return x1;
	}

	public static int neg_to_pos(int x1) {
		x1 = plus(0, minus(0, x1));
		return x1;
	}

	public static int pos_to_neg(int x1) {
		x1 = minus(0, x1);
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num2 = x2, count = x2;
		boolean x1_pos = true, x2_pos = true;
		if(x1 < 0){
			x1 = neg_to_pos(x1);				
			x1_pos = false;
		}
		if(x2 < 0){
			x2 = neg_to_pos(x2);
			num2 = x2;
			x2_pos = false;
		}
		for (int i=1;i<x1;i++){
			x2 = count;
			while(x2 != 0){
				num2++;
				x2--;
			}
		}
		if(x1_pos != x2_pos){
			num2 = pos_to_neg(num2);
		}
		return num2;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num = times(x,x);
		for (int i=2;i<n;i++){
			num = times(num,x);	
		}
		return num;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num2 = x2, count = 0;
		boolean x1_pos = true, x2_pos = true;
		if(x1 < 0){
			//x1 = plus(minus(x1,x1), minus(0, x1));
			x1 = neg_to_pos(x1);
			x1_pos = false;
		}
		if(x2 < 0){
			x2 = neg_to_pos(x2);
			num2 = x2;
			x2_pos = false;
		}
		while (x1 >= num2){
			x2 = num2;
			while(x2 != 0){
				x1--;
				x2--;
			}	
			count++;
		}	
		if(x1_pos != x2_pos){
			//count = minus(count, times(count,2));
			count = pos_to_neg(count);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int num2 = x2, count = 0;
		while (x1 != 0 && x1 >= num2){
			x2 = num2;
			while(x2 != 0){
				x1--;
				x2--;
			}	
			count++;
		}		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int count = 0;
		while (times(count, count) <= x) {
            count++;  
        }
		count--;
		return count; 
	}	  	  
}