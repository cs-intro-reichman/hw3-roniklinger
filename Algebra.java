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
   		System.out.println(pow(-3,5));      // 3^5 
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

	// Returns +x1
	public static int neg_to_pos(int x1) {
		int count = 0;
        while (x1 < 0) {
            x1++;
            count++;
        }
		return count;
	}

	// Returns -x1
	public static int pos_to_neg(int x1) {
		int count = 0;
        while (x1 > 0) {
            x1--;
            count--;
        }
		return count;
	}

	// Returns abs(x1)
	public static int abs(int x1) {
        if (x1 < 0) {
            x1 = neg_to_pos(x1);
        }
        return x1;
    }

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0){
			return 0;
		}

		int abs_x1 = abs(x1);
		int abs_x2 = abs(x2);
		int num2 = abs_x2;
		
		for (int i=1;i<abs_x1;i++){
			num2 = plus(num2, abs_x2);
		}
		if((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)){
			num2 = pos_to_neg(num2);
		}
		return num2;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num = times(x,x);
		int abs_x = abs(x);
		if (n == 0){
			return 1;
		}
		for (int i=2;i<n;i++){
			num = times(num,abs_x);	
		}
		if(mod(n, 2) != 0 && x < 0){
			num = pos_to_neg(num);
		}
		return num;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {

		int abs_x1 = abs(x1), abs_x2 = abs(x2);
		int num2 = abs_x2, count = 0;

		while (abs_x1 >= num2){
			abs_x1 = minus(abs_x1, abs_x2);
			count++;
		}	
		if((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)){
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