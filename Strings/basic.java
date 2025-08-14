class basic{

    // Check if a string is a palindrome
    public static boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    // Given a route containing 'N', 'S', 'E', 'W', Find the shortest path to reach the destination
    public static float shortestPath(String route) {
        int x = 0, y = 0;
        for (char direction : route.toCharArray()) {
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
        }
        return (float) Math.sqrt(x * x + y * y);
    }

    // For a given string convert each first letter of each word to uppercase
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && i + 1 < str.length()) {
                sb.append(' ');
                ch = Character.toUpperCase(str.charAt(i + 1));
                sb.append(ch);
                i++; // Skip the next character since it's already processed
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}