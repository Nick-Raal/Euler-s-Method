import java.util.*;

class Main {
  static List<Double> x = new ArrayList<Double>();
  static List<Double> y = new ArrayList<Double>();
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Step Size?");
    double stepSize = Double.parseDouble(in.nextLine());
    System.out.println("Starting point?");
    String toParse = in.nextLine();
    toParse = toParse.substring(1, toParse.length() - 1);
    x.add(Double.parseDouble(toParse.substring(0, toParse.indexOf(','))));
    y.add(Double.parseDouble(toParse.substring(toParse.indexOf(',') + 1, toParse.length()))); 
    System.out.println("End x?");
    double endPoint = in.nextDouble(); 
    System.out.println(thing(x.get(0), y.get(0), endPoint, stepSize));
  }

  private static double thing (double X, double Y, double endPoint, double stepSize){
    x.add(X + stepSize);
    y.add(y.get(y.size() - 1) + stepSize * equation(x.get(x.size() - 2), y.get(y.size() - 1)));
    System.out.println("(" + x.get(x.size() - 1) + ", " + y.get(y.size() - 1) + ")");
    if((endPoint >= 0 && x.get(x.size() - 1) >= endPoint) || (endPoint < 0 && x.get(x.size() - 1) <= endPoint)){
      return y.get(y.size() - 1);
    }
    return thing(x.get(x.size() - 1), y.get(y.size() - 1), endPoint, stepSize);
  }

  private static double equation(double x, double y){
    return x * y;
  }
}