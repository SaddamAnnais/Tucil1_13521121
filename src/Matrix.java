import java.util.*;

public class Matrix {
    
    // Deklarasi variabel baris, kolom, dan data matrix
    protected int row;
    protected int col;
    public double data[][];

    // Konstruktor
    public Matrix(int row, int col) {       
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
    }

    /* *** SELEKTOR *** */
    public void setELMT(int i, int j, double val) {         
        this.data[i][j] = val;
    }

    public double getELMT(int i, int j) {               
        return this.data[i][j];
    }

    public double[][] getData(){
        return this.data;
    }

    public int getLastIdxRow()               
    {
        return this.row-1;
    }
    
    /* Mengirimkan Index kolom terbesar m */
    public int getLastIdxCol()                
    {
        return this.col-1;
    }

    public void displayMatrix() {
      for (int i = 0; i<=getLastIdxRow(); i++) {
          for (int j = 0; j<=getLastIdxCol(); j++) {
              System.out.print(String.format("%.4f", getELMT(i, j)));
              if (j!=getLastIdxCol()) {
                  System.out.print(" ");
              }
          }
          System.out.print("\n");   
      }     
  }

  public Matrix push(Matrix M, int val)                
  {
      for (int i = 0; i<=getLastIdxRow(); i++) {
        for (int j = 0; j<=getLastIdxCol(); j++) {
            setELMT(i, j, val);
        }
      }
    this.row = this.row + 1;
    return M;
  }
}