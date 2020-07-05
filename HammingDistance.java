/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

*/

class Solution {
    public int hammingDistance(int x, int y) {
        
        int xr=x^y;   
        int count=0;  
        while(xr!=0)
        {          
            count=count + (xr&1); 
            xr=xr>>1;       
        }
        return count; 
    }
}
