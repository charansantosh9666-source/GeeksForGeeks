class Solution {
  public:
  int findsum(int n) {
          int res = 0;
          while (n) {
              res += (n % 10);
              n /= 10;
          }
          return res;
      }
      int concat(int a, int b) { return stoi(to_string(a) + to_string(b)); }
      int findMax(int n) {

          int res = n;
          int mini = findsum(n);

          int first = n;
          int last = 0;

          while (first) {

              if (first % 10 == 9) {

                  first /= 10;
                  last = stoi("9" + (last ? to_string(last) : ""));

                  int temp = concat(first, last);
                  int s = findsum(temp);

                  if (s > mini) {
                      mini = s;
                      res = temp;
                  }
                  else if (s == mini)
                      res = max(res, temp);

              } 
              else
                  while (first && first % 10 != 9)
                      first--;
          }

          return res;
    }
};
