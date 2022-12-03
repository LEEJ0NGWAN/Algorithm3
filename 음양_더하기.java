public class 음양_더하기 {

    class Solution {

        public int solution(int[] nums, boolean[] signs) {
    
            int count = 0;
            for(int i = 0; i < nums.length; count += signs[i]? nums[i++]: -(nums[i++]));
    
            return count;
        }
    }
}
