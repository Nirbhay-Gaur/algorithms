/* *****************************************************************************
 *  Name:              Nirbhay Gaur
 *  Coursera User ID:  696969
 *  Last modified:     November 30, 2022
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int size;
    private boolean[][] lattice;
    private WeightedQuickUnionUF quickUnion;
    private WeightedQuickUnionUF quickUnionIsFull;
    private int openSites = 0;
    private int virtualTop;
    private int virtualBottom;

    // create n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // handle zero or negative value of n
        if (n <= 0) {
            throw new IllegalArgumentException("Enter positive number");
        }

        size = n;
        lattice = new boolean[n][n];
        quickUnion = new WeightedQuickUnionUF((n * n) + 2);
        quickUnionIsFull = new WeightedQuickUnionUF((n * n) + 1);

        virtualTop = 0;
        virtualBottom = n * n + 1;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(Integer.parseInt(args[0]));

        while (!percolation.percolates()) {
            int x = StdRandom.uniformInt(percolation.getSize()) + 1;
            int y = StdRandom.uniformInt(percolation.getSize()) + 1;

            percolation.open(x, y);
        }

        double open = percolation.numberOfOpenSites();
        double sizeSquared = (double) percolation.getSize() * percolation.getSize();
        double threshold = open / sizeSquared;

        StdOut.println("Open sites: " + open);
        StdOut.println("Total sites: " + sizeSquared);
        StdOut.println("Percolation threshold: " + threshold);
    }

    // does the system percolates?
    public boolean percolates() {
        return quickUnion.find(virtualTop) == quickUnion.find(virtualBottom);
    }

    private int getSize() {
        return this.size;
    }

    //  open the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateInput(row, col);

        if (!this.isOpen(row, col)) {
            int fieldIndex = getFieldIndex(row, col);

            if (row == 1) {
                quickUnion.union(virtualTop, fieldIndex);
                quickUnionIsFull.union(virtualTop, fieldIndex);
            }

            if (row == size) {
                quickUnion.union(virtualBottom, fieldIndex);
            }

            connectIfOpen(fieldIndex, row + 1, col);
            connectIfOpen(fieldIndex, row - 1, col);
            connectIfOpen(fieldIndex, row, col + 1);
            connectIfOpen(fieldIndex, row, col - 1);

            lattice[row - 1][col - 1] = true;
            ++openSites;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    private void validateInput(int x, int y) {
        if (x < 1 || x > size)
            throw new IllegalArgumentException("Enter co ordinates in range (1 to n)");
        if (y < 1 || y > size)
            throw new IllegalArgumentException("Enter co ordinates in range (1 to n)");
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateInput(row, col);
        return lattice[row - 1][col - 1];
    }

    private int getFieldIndex(int x, int y) {
        return (x - 1) * size + y;
    }

    private void connectIfOpen(int fieldIndex, int x, int y) {
        try {
            if (isOpen(x, y)) {
                int neighbourFieldIndex = getFieldIndex(x, y);
                quickUnion.union(neighbourFieldIndex, fieldIndex);
                quickUnionIsFull.union(neighbourFieldIndex, fieldIndex);
            }
        }
        catch (IllegalArgumentException error) {
            // do not connect
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateInput(row, col);
        if (isOpen(row, col)) {
            int fieldIndex = getFieldIndex(row, col);
            return quickUnionIsFull.find(virtualTop) == quickUnionIsFull.find(fieldIndex);
        }
        return false;
    }
}
