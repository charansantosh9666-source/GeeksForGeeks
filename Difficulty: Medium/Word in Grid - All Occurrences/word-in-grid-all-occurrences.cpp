class Solution {
  public:
    int X[8]={-1, -1, -1, 0, 1, 1, 1, 0};
    int Y[8]={-1, 0, 1, 1, 1, 0, -1, -1};

    virtual bool findWord(int i, int j, int k, vector<vector<char>> &mat, string &word){
      int wi=0;
      int wn=word.size();

      int n=mat.size();
      int m=mat[0].size();      

      while(wi<wn){
        if(mat[i][j]!=word[wi]) return false;
        wi++;
        i+=X[k];
        j+=Y[k];

        if(wi==wn) return true; 
        if(i<0 || j<0 || i>=n || j>=m) return false;

      }

      return true;
    }

    virtual vector<vector<int>> searchWord(vector<vector<char>> &mat, string &word){
      vector<vector<int>> ans;

      int n=mat.size();
      int m=mat[0].size();
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){

          if(word[0] == mat[i][j]){
            bool isFound=false;
            for(int k=0; k<8; k++){
              isFound=findWord(i, j, k, mat, word);
              if(isFound){
                vector<int> t;
                t.push_back(i); t.push_back(j);
                ans.push_back(t);
                break;
              }
            }
          }


        }  
      }



      return ans;

    }
};