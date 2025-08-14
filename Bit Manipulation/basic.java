class basic {

    // Operation on bits
    public static int getBit(int n, int i) {
        int bitMask = 1 << i;
        return (n & bitMask) == 0 ? 0 : 1;
    }
    public static int setBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
    public static int clearBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }
    public static int updateBit(int n, int i, int newBit) {
        n = clearBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    // count set bits
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    // check if a number is power of 2
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
    public static void main(String[] args) {

    }
}