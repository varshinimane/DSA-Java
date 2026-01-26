class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < arr.length - 1;i++){
            int diff = arr[i + 1] - arr[i];
            if(diff < min){
                min = diff;
            }
        }
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i + 1] - arr[i] == min){
                res.add(Arrays.asList(arr[i],arr[i + 1]));
            }
        }
        return res;
    }
}