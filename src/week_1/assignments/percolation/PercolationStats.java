/* *****************************************************************************
 *  Name:              Nirbhay Gaur
 *  Coursera User ID:  123456
 *  Last modified:     November 30, 2022
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONSTANT_1_96 = 1.96;
    private double[] thresholds;
    private int globaltrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Enter positive number only ");
        }
        globaltrials = trials;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                int x = StdRandom.uniformInt(n) + 1;
                int y = StdRandom.uniformInt(n) + 1;

                percolation.open(x, y);
            }

            double open = percolation.numberOfOpenSites();
            double sizeSquared = (double) n * n;
            double threshold = open / sizeSquared;

            thresholds[i] = threshold;
        }
    }

    // test client
    public static void main(String[] args) {
        int n = 10;
        int t = 10;
        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }

        PercolationStats percolationStats = new PercolationStats(n, t);
        percolationStats.printResult();
    }

    private void printResult() {
        StdOut.println("mean                    = " + this.mean());
        StdOut.println("stddev                  = " + this.stddev());
        StdOut.println(
                "95% confidence interval = [" + this.confidenceLo() + ", " + this.confidenceHi()
                        + ']');
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - ((CONSTANT_1_96 * this.stddev()) / Math.sqrt(this.globaltrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + ((CONSTANT_1_96 * this.stddev()) / Math.sqrt(this.globaltrials));
    }
}
