class Solution {
    public int countVowelPermutation(int n) {
        long countA =1, countE =1 , countI =1, countO =1, countU =1;
        final int Mod = 1000000007;

        for(int i = 1;i < n; i++){
            long newcA = countE;
            long newcE = (countA + countI)%Mod;
            long newcI = (countA + countE + countO + countU )%Mod;
            long newcO = (countI + countU)%Mod;
            long newcU = countA;

            countA = newcA;
            countE = newcE;
            countI = newcI;
            countO = newcO;
            countU = newcU;
        } 

        long totalcount = (countA + countE + countI + countO + countU) % Mod;

        return (int) totalcount; 
    }
}