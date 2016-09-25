/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

import java.util.*;
public class HouseRobber {
	public int rob(int[] nums){
		if(nums.length==0){ //Edge case
			return 0;
		}
		if(nums.length==1){ //If there is one house, we return only its value
            return nums[0];
        }
		int[] profit = new int[nums.length]; //New array for profit
		profit[0] = nums[0]; //First number is the first house
		profit[1] = Math.max(nums[0],nums[1]); //Second profit is the best of the first and second house
		for(int i = 2;i<profit.length;i++){ //We start from 2
			profit[i] = Math.max(profit[i-2]+nums[i], profit[i-1]); //Take the max between the profit of 2 days ago and the house, or profit of last day
		}
		return profit[profit.length-1]; //We return the last number, which is the accumulation of all profits
	}
	
	public static void main(String args[]){ //an example
		int[] nums = {1,2,3,4,5,7,8,9,11,15};
		System.out.println(new HouseRobber().rob(nums));
	}
}
