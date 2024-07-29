import java.util.*;
import java.util.LinkedList;
class Pair{
  int first;
  int second;
public   Pair(int first,int second){
      this.first=first;
      this.second=second;
      
  }
}

public class GraphsDSA {
    // public static void main(String args[]){
    //     int[] nums1={1,2,3};
    //     int nums2[]={4,5,6};
    //     int ans[]= new int[nums1.length+nums2.length];
    //     for(int i=0;i<ans.length;i++){
    //       if(i<nums1.length) ans[i]=nums1[i];
    //       else if(nums1.length<=i) ans[i]=nums2[i-nums1.length];
    //     }
    //     Arrays.sort(ans);
    //     for(int i=0;i<ans.length;i++){
    //         System.out.print(ans[i]+" ");
    //     }
    //     long sol=0;
    //    if(ans.length%2==0) sol=ans[(ans.length/2)]+ans[(ans.length/2)-1];
    // //    System.out.println();
    // //    System.out.println(ans[(ans.length/2)]+" "+ans[(ans.length/2)-1]);
    // //    System.out.println(sol/2);
    // long a=sol/2;
    // System.out.println(a);
    
    // }


    


  public static boolean solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {

          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;

              if (solveSudoku(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }

  
  public static void prac(){
    for(char i='A';i<='z';i++){
      System.out.print(i+" ");
    }
  }
  public static void represenation(){
    ArrayList<ArrayList<Integer>> al= new ArrayList<>();
    int n=3;
    for(int i=0;i<=n;i++){
      al.add(new ArrayList<>());
    } 
    al.get(0).add(1);
    al.get(1).add(0);
    al.get(1).add(2);
    al.get(2).add(1);
    al.get(2).add(3);
    al.get(3).add(2);
    al.get(0).add(3);
    al.get(3).add(0);

    for(int i=1;i<n;i++){
      for(int j=0;j<al.get(i).size();j++){
     
        System.out.print(al.get(i).get(j)+" ");
      }
      System.out.println();
    }
  }
  //--------------------bfs Of Graph=-------------------------------//

  public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

  ArrayList<Integer> bfs= new ArrayList<>();
  boolean[] vis= new boolean[V];
  Queue<Integer> q= new LinkedList<>();
  q.add(0);
  vis[0]=true;
  while(!q.isEmpty()){
      int temp=q.remove();
      bfs.add(temp);
      for(int i:adj.get(temp)){
          if(vis[i]==false){
              vis[i]=true;
              q.add(i);
          }
      }
  }
  return bfs;
}
//------------------Dfs  of graphs ------------------------------------//
public static void dfs(int temp,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ls){
  vis[temp]=true;
  ls.add(temp);
  for(int i: adj.get(temp)){
      if(vis[i]==false){
              dfs(i,vis,adj,ls);
      }
  }
}
public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  boolean vis[]=  new boolean[V];
  vis[0]=true;
  ArrayList<Integer> ls= new ArrayList<>();
  dfs(0,vis,adj,ls);
  return ls;
}
//-----------------topo Sort DFS()------------------------//
public static void dfs(int temp,boolean vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
  vis[temp]=true;
  for(int i:adj.get(temp)){
      if(vis[i]==false){
          dfs(i,vis,st,adj);
      }
  }
  st.push(temp);
}

static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
{
boolean vis[]= new boolean[V];
  Stack<Integer> st= new Stack<>();
  
  for(int i=0;i<V;i++){
      if(vis[i]==false){
          dfs(i,vis,st,adj);
      }
  }
  int al[]= new int[V];
  int i=0;
  while(!st.isEmpty()){
   al[i]=st.peek();
   i++;
   st.pop();
  }
  return al;
}
//--------------Number of provinces----------------------------//
public static void dfs(int temp, ArrayList<ArrayList<Integer>> adjLs,boolean vis[]){
  vis[temp]=true;
  for(int i:adjLs.get(temp)){
      if(vis[i]==false){
           dfs(i,adjLs,vis);
      }
  }
  
 }
 static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
     ArrayList<ArrayList<Integer>> adjLs= new ArrayList<>();
     for(int i=0;i<V;i++){
         adjLs.add(new ArrayList<Integer>());
     }
     for(int i=0;i<V;i++){
         for(int j=0;j<V;j++){
             if(adj.get(i).get(j)==1&& i!=j){
                 adjLs.get(i).add(j);
                 adjLs.get(j).add(i);
             }
         }
     }
     boolean vis[]= new boolean[V];
     int count=0;
   for(int i=0;i<V;i++){
       if(vis[i]==false){
           count++;
  
             dfs(i,adjLs,vis);
         }
     }
     return count;
 }
//--------------- number of islands-------------------//

// class Pair{
//   int first;
//   int second;
//   Pair(int first,int second){
//     this.first=first;
//     this.second=second;
//   }
// }

public static void bfs(int i,int j,int[][]vis,char[][]grid){
  vis[i][j]=1;
  Queue<Pair> q= new LinkedList<>();
  int n= grid.length;
  int m= grid[0].length;
  q.add(new Pair(i,j));
  while(!q.isEmpty()){
      int row=q.peek().first;
      int col=q.peek().second;
      q.remove();
      for(int drow=-1;drow<=1;drow++){
          for(int dcol=-1;dcol<=1;dcol++){
              int nrow=drow+row;
              int ncol=dcol+col;
              if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]=='1'){
                  vis[nrow][ncol]=1;
                  q.add(new Pair(nrow,ncol));
              }
          }
      }
      
  }
}

public int numIslands(char[][] grid) {
   int n= grid.length;
   int m= grid[0].length;
   int vis[][]= new int[n][m];
   int count=0;
   for(int i=0;i<n;i++){
       for(int j=0;j<m;j++){
           if(vis[i][j]==0 && grid[i][j]=='1'){
               bfs(i,j,vis,grid);
               count++;
           }
       }
   }
   return count;
}
//----------------flood fill------------------------------//
public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
  int oldColor = image[sr][sc];
  if (oldColor != newColor) {
      dfs(image, sr, sc, oldColor, newColor);
  }
  return image;
}

private static void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
  // Check boundaries and if the current pixel is of the old color
  if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
      return;
  }
  
  // Change the color of the current pixel
  image[sr][sc] = newColor;
  
  // Recursively call dfs for the 4-directionally connected pixels
  dfs(image, sr + 1, sc, oldColor, newColor);
  dfs(image, sr - 1, sc, oldColor, newColor);
  dfs(image, sr, sc + 1, oldColor, newColor);
  dfs(image, sr, sc - 1, oldColor, newColor);
}
//-----------------Rotten Oranges------------------------//
class Pair {
  int first;
  int second;
  int tm;

  public Pair(int first, int second, int tm) {
      this.first = first;
      this.second = second;
      this.tm = tm;
  }
}


public int orangesRotting(int[][] a) {
  int n = a.length;
  int m = a[0].length;
  int fresh = 0;
  Queue<Pair> q = new LinkedList<>();
   int vis[][] = new int[n][m];
  for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (a[i][j] == 2) {
                  vis[i][j] = 2;
                  q.add(new Pair(i, j, 0));
              } else {
                  vis[i][j] = 0;
              }
              if (a[i][j] == 1) fresh++;
          }
      }

      int tm = 0;
      int drow[] = {-1, 0, 1, 0};
      int dcol[] = {0, 1, 0, -1};
      int cnt = 0;

      while (!q.isEmpty()) {
          int row = q.peek().first;
          int col = q.peek().second;
          int t = q.peek().tm;
          tm = Math.max(tm, t);
          q.remove();

          for (int i = 0; i < 4; i++) {
              int nrow = row + drow[i];
              int ncol = col + dcol[i];
              if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && a[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                  q.add(new Pair(nrow, ncol, t + 1));
                  vis[nrow][ncol] = 2;  // Mark as visited by rotten
                  cnt++;
              }
          }
      }

      if (cnt != fresh) return -1;
      return tm;
  }
//-------------------detect loop in cycle (graphs)-------------------------//
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


  // Function to detect cycle in an undirected graph.
  public static boolean cycle(int temp, boolean vis[], ArrayList<ArrayList<Integer>> adj, int V) {
      vis[temp] = true;
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(temp, -1));

      while (!q.isEmpty()) {
          int node = q.peek().first;
          int parent = q.peek().second;
          q.remove();

          for (int i : adj.get(node)) {
              if (!vis[i]) {
                  vis[i] = true;
                  q.add(new Pair(i, node));
              } else if (parent != i) {
                  return true;
              }
          }
      }
      return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean vis[] = new boolean[V];
      Arrays.fill(vis, false);

      for (int i = 0; i < V; i++) {
          if (vis[i]==false) {
              if (cycle(i, vis, adj, V)) {
                  return true;
              }
          }
      }
      return false;
  }
  //--------------dfs-----(cycle undirected graph)------------//
  public static boolean dfs(int temp, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
    vis[temp] = true; // Mark the current node as visited
    for (int i : adj.get(temp)) {
        if (!vis[i]) {
            if (dfs(i, temp, vis, adj)) {
                return true; // If a cycle is found, return true
            }
        } else if (i != parent) {
            return true; // If an adjacent node is visited and it's not the parent, a cycle is detected
        }
    }
    return false; // No cycle found
}

// Function to check if there is a cycle in the graph
public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V]; // Initialize the visited array
    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            if (dfs(i, -1, vis, adj)) {
                return true; // If a cycle is found, return true
            }
        }
    }
    return false; // No cycle found in the graph
}
class Pair{
  int first;
  int second;
  int third;
  Pair(int first,int second,int third){
      this.first=first;
      this.second=second;
      this.third=third;
  }
}
//----------nearest distance for 1 b/w 0/1--------------------//
class Solution
{
  //Function to find distance of nearest 1 in the grid for each cell.
  public int[][] nearest(int[][] grid)
  {
      // Code here
      Queue<Pair>q= new LinkedList<>();
      int n=grid.length;
      int m=grid[0].length;
      int vis[][]=new int[n][m];
      int ret[][]=new int[n][m];
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==1){
                  vis[i][j]=1;
                  q.add(new Pair(i,j,0));
              }
              else{
                  vis[i][j]=0;
                  
              }
              
          }
          
      }
      int drow[]={-1,0,1,0};
      int dcol[]={0,1,0,-1};
      while(!q.isEmpty()){
          int row=q.peek().first;
          int col=q.peek().second;
          int steps=q.peek().third;
          ret[row][col]=steps;
          q.remove();
          for(int i=0;i<4;i++){
              int nrow=row+drow[i];
              int ncol=col+dcol[i];
              if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0){
                  vis[nrow][ncol]=1;
                  q.add(new Pair(nrow,ncol,steps+1));
              }
          }
      }
      return ret;
  }
}
//--------------number of enclaves--------------------//
class Solution {
  public static void dfs(int row,int col,boolean[][]vis,int drow[],int dcol[],int[][] grid){
      vis[row][col]=true;
       int n=grid.length;
      int m=grid[0].length;
      for(int i=0;i<4;i++){
          int nrow=row+drow[i];
          int ncol=col+dcol[i];
          if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==false&&grid[nrow][ncol]==1){
              dfs(nrow,ncol,vis,drow,dcol,grid);
          }
      }
      
  }

  int numberOfEnclaves(int[][] grid) {

      // Your code here
      int n=grid.length;
      int m=grid[0].length;
      int drow[]={-1,0,1,0};
      int dcol[]={0,1,0,-1};
      boolean[][]vis= new boolean[n][m];
      for(int j=0;j<m;j++){
          if(grid[0][j]==1 && vis[0][j]==false){
              dfs(0,j,vis,drow,dcol,grid);
          }
          if(grid[n-1][j]==1 && vis[n-1][j]==false){
              dfs(n-1,j,vis,drow,dcol,grid);
          }
      }
      for(int i=0;i<n;i++){
          if(grid[i][0]==1 && vis[i][0]==false){
              dfs(i,0,vis,drow,dcol,grid);
          }
          if(grid[i][m-1]==1 && vis[i][m-1]==false){
              dfs(i,m-1,vis,drow,dcol,grid);
          }
      }
      int count=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
            if(vis[i][j]==false && grid[i][j]==1)count++;
          }
      }
      return count;
      
      }
}
//--------------Bipertite graph (BFS)----------//
class Solution
{
    public static boolean biper(int temp,ArrayList<ArrayList<Integer>>adj, int col[]){
        Queue<Integer> q= new LinkedList<>();
        q.add(temp);
        col[temp]=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int i:adj.get(node)){
                if(col[i]==-1){
                    col[i]=1-col[node];
                    q.add(i);
                }
                else if(col[i]==col[node])return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int col[]=new int[V];
        for(int i=0;i<V;i++)col[i]=-1;
        for(int i=0;i<V;i++){
                if(col[i]==-1){
                   if(biper(i,adj,col)==false)return false;
                }
            }
        return true;
    }
}
//---------------cycle detection in (Directed graph)----(DFS)------------//
class Solution {
    // Function to detect cycle in a directed graph.
    public static boolean dfs(int temp,  int vis[],  int pvis[],ArrayList<ArrayList<Integer>> adj){
        vis[temp]=1;
        pvis[temp]=1;
        for(int i:adj.get(temp)){
            if(vis[i]==0){
                if(dfs(temp,vis,pvis,adj))return true;
            }
            else if(pvis[i]==1){
                 return true;
            }
        }
        pvis[temp]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[]= new int[V];
        int pvis[]= new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pvis,adj))return true;
            }
        }
         return false;
    }
   
}
//-------------TOPO SORT(DFS)----------------------//
class Solution
{
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        st.push(node); 
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) { 
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            result[i] = st.pop(); 
        }
        return result;
    }
    //----------------khans Algo----------------//
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[]= new int[V];
    for(int i=0;i<V;i++){
        for(int it:adj.get(i)){
            indegree[it]++;
        }
    }
    Queue<Integer> q= new LinkedList<>();
    for(int i=0;i<V;i++){
        if(indegree[i]==0){
            q.add(i);
        }
    }
    int topo[]= new int[V];
    int i=0;
    while(!q.isEmpty()){
        int node=q.peek();
        q.remove();
        topo[i++]=node;
        for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }
        }
    }
    return topo;
}

}
//---------------Word Ladder I--------------------------------// 
class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            String temp = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (temp.equals(targetWord)) {
                return steps;
            }
            for (int i = 0; i < temp.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] repArray = temp.toCharArray();
                    repArray[i] = ch;
                    String repWord = new String(repArray);
                    if (st.contains(repWord)) {
                        st.remove(repWord);
                        q.add(new Pair(repWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
//---------------
  public static void main(String[] args) {
  // prac();
  // represenation();
  
  ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
  bfsOfGraph(4,adj);

    // char[][] board= {
    //                  {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
    //                  {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
    //                  {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
    //                  {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
    //                  {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
    //                  {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
    //                  {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
    //                  {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
    //                  {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
    //                  };
    //  solveSudoku(board);
 
    //  for (int i = 0; i < 9; i++) {
    //    for (int j = 0; j < 9; j++)
    //      System.out.print(board[i][j] + " ");
    //    System.out.println();
    //  }
   }
}
