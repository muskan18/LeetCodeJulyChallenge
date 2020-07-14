/*
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
*/

class Solution {
    public double angleClock(int hour, int minutes) {
       
        double minangle = minutes*6;
        double hourangle = hour*30 + (((double) minutes)/60)*30;   
        if (hourangle > 360)           
            hourangle -= 360;

        double angle;
        if (minangle > hourangle)
            angle = minangle-hourangle;
        else
            angle = hourangle-minangle;

        if (angle > 180)
            angle = 360-angle;
        return angle;
       
    }
}
