import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Roman To Integer");
            System.out.println("2. Shuffle Array");
            System.out.println("3. Pangram Check");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    RomanToInteger.roman();
                    break;
                case 2:
                    ShuffleArray.arrayShuffle();
                    break;
                case 3:
                    PangramCheck.pangram();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


class RomanToInteger {
    public static void roman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Roman number");
        String roman1 = scanner.next();
        String roman = roman1.toUpperCase();
        int intVal = romanToInteger(roman);
        System.out.println("The integer value of "+roman+" is "+intVal);
    }
    public static int romanToInteger(String s) {
        int result = 0;
        for (int i=0;i<s.length();i++) {
            int val=getValue(s.charAt(i));
            if (i+1<s.length()) {
                int nextVal = getValue(s.charAt(i+1));
                if (val < nextVal) {
                    result =result - val;
                } else {
                    result =result + val;
                }
            } else {
                result = result + val;
            }
        }
        return result;
    }
    private static int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}

class PangramCheck {
    public static void pangram() {
        System.out.println("Enter the Sentence");
        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        if (pangramCheck(str)){
            System.out.println("Pangram");
        }
        else {
            System.out.println("not pangram");
        }
    }
    static boolean pangramCheck(String str){
        str= str.toLowerCase();
        if (str.length()<26){
            return false;
        }
        else {
            for (char ch='a';ch<='z';ch++){
                if (str.indexOf(ch)<0){
                    return false;
                }
            }
            return true;
        }
    }

}


class ShuffleArray {
    public static void arrayShuffle() {
        System.out.println("enter number of elements in array");
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[] array=new int[n];
        System.out.println("enter array elements");
        for(int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }
        shuffleArray(array);
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
    public static void shuffleArray(int[] array) {
        int n = array.length;
        for (int i=n-1;i>0;i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

}


