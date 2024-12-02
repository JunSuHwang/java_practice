public class Main {
    public static void main(String[] args) {
        String s = "x";
        int n = 3;
        System.out.println((solution(s, n)));
    }

    public static String solution(String s, int n) {
        char[] arr = s.toCharArray();
        char[] result = new char[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z') {
                if(arr[i] + n < 'a'+26) {
                    result[i] = (char) (arr[i] + n);
                } else {
                    result[i] = (char) ((arr[i] + n - 'a') % 26 + 'a');
                }
            } else if(arr[i] >= 'A' && arr[i] <= 'Z'){
                if(arr[i] + n < 'A'+26) {
                    result[i] = (char) (arr[i] + n);
                } else {
                    result[i] = (char) ((arr[i] + n - 'A') % 26 + 'A');
                }
            } else {
                result[i] = arr[i];
            }
        }
        return String.valueOf(result);
    }
}