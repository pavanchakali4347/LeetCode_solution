class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arr1 = new ArrayList<>();
        for (int n : nums1) {
            arr1.add(n);
        }
        for (int n : nums2) {
            arr1.add(n);
        }
        Collections.sort(arr1);
        int res = arr1.size();
        if (res % 2 == 1) {
            return arr1.get(res / 2);
        } else {
            return (arr1.get(res / 2 - 1) + arr1.get(res / 2))/2.0;
        }
    }
}