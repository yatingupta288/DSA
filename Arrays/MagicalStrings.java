class Solution{
    static String magicalString(String S){
        // code here
        char arr[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String str = "";
        for(int i = 0; i < S.length() ; i++){
            str += arr['z' - S.charAt(i)];
        }
        return str;
    }
}