public class 햄버거_만들기 {

    public boolean check (int[] arr, int p) {
        
        return 3 <= p &&
        arr[p-3] == 1 && arr[p-2] == 2 && arr[p-1] == 3 && arr[p] == 1;
    }

    public int solution(int[] ingredient) {

        int answer = 0;
        int pivot = -1;

        final int[] stack = new int[ingredient.length];
        
        for (int i: ingredient) {

            stack[++pivot] = i;
            
            if (check(stack, pivot)) {

                pivot -= 4; answer++;
            }
        }
        
        return answer;
    }
}
