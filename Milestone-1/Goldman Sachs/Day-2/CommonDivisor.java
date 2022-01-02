1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Code:


class Solution {
    public String gcdOfStrings(String str1, String str2) {
    /*
    T: O(n/m* (n-m)) or O(n/m)
    S: O(n/m)
    */
        int size1 = str1.length();
        int size2 = str2.length();
        if(size2>size1)  return gcdOfStrings(str2,str1);
        if(size1 == size2){
            if(str1.equals(str2)) return str1;
            else return "";
        }
        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()),str2);
        } else return "";
    }
}