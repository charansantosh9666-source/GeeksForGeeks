class Solution {
  public:
    int maxDiffSum(vector<int>& arr) {
        // code here
        int n = arr.size();

          if (n <= 1)
          return 0;

         int low = 0, high = 0;

         for (int i = 1; i < n; i++) {

                int newLow = max(low, high + abs(arr[i - 1] - 1));     // when arr[i] is changed to 1

                int newHigh = max(low + abs(arr[i] - 1), high + abs(arr[i] - arr[i - 1]));     // when arr[i] is not changed to  1

                low = newLow;
                high = newHigh;
         }
        return max(low, high);
    }
};