import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Double> x = new ArrayList<Double>();
    List<Double> y = new ArrayList<Double>();
    System.out.println("Step Size?");
    double stepSize = Double.parseDouble(in.nextLine());
    System.out.println("Starting point?");
    String toParse = in.nextLine();
    toParse = toParse.substring(1, toParse.length() - 1);
    x.add(Double.parseDouble(toParse.substring(0, toParse.indexOf(','))));
    y.add(Double.parseDouble(toParse.substring(toParse.indexOf(',') + 1, toParse.length()))); 
  }

  
}