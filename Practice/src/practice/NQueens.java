

package practice;

public class NQueens {
    
    static class resolveNQ{
        
        private int[][] queens;
        private final int dimensions;
        private int col;
        
        public resolveNQ(int dimensions)
        {
            this.dimensions = dimensions;
            queens = new int[dimensions][dimensions];
            col = 0;
        }
        
        //inicializar la matriz en 0
        private void initM()
        {
            System.out.println(dimensions);
            for(int i = 0; i < dimensions;i++ )
                for(int j = 0; j < dimensions; j++)
                    queens[i][j] = 0;
        }
        
        
        private boolean check(int row, int col)
        {
            
            //System.out.println(col);
            for(int i = 0; i < col; i++)
                if (queens[row][i] == 1)
                    return false;
            
            for(int i = row, j = col; i >= 0 && j >= 0; i--,j--)
                if (queens[i][j] == 1)
                    return false;
            
            for (int i = row, j = col; i < dimensions && j >= 0; i++, j--) 
		if (queens[i][j] == 1) 
                    return false;
            
            return true;
        }
        
        public boolean solution(int col)
        {
            if (col >= dimensions)
                return true;
            
            for (int i = 0; i < dimensions; i++)
            {
                if (check(i,col))
                {
                    queens[i][col] = 1;
                    
                    if(solution(col + 1))
                        return true;
                    
                    queens[i][col] = 0;
                }
            }
            
            return false;
        }
        
        public void show()
        {
            for(int i = 0; i < dimensions; i++)
            {
                for(int j = 0; j < dimensions; j++)
                {
                    if (queens[i][j] == 1)
                        System.out.print(" Q ");
                    else System.out.print(" . ");
                }
                System.out.print("\n");
            }
        }
        
        public int[][] getQueens() {
            return queens;
        }

        public int getDimensions() {
            return dimensions;
        }
        
        
    }
    
    public static void main(String[] args) {
        resolveNQ nQueens = new resolveNQ(100);
        
        nQueens.initM();
        nQueens.solution(0);
        //nQueens.shownumber();
        System.out.println("\n\n\n");
        nQueens.show();
        //int[][] show = nQueens.getQueens();
        
        /*
        
        */
    }
  
}
