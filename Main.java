import java.util.*;
import java.lang.Math;

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
    x.add(x.get(0) - stepSize);
    y.add(y.get(0) - stepSize);
    thing(x.get(0), y.get(0), -endPoint, -stepSize);
    // System.out.println(x);
    // System.out.println(y);

    graph();
    in.close();
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

  //modify this to change diff eq
  //figure out how to parse for equations
  private static double equation(double x, double y){
    return x + y;
  }

  private static void graph(){

  //can't graph negative values
    
  //   double[][] mat = new double[(int)Math.round(x.get(x.size() - 1) > x.get(0) ?  x.get(x.size() - 1) - x.get(0) : x.get(0) - x.get(x.size() - 1))][(int)Math.round(y.get(y.size() - 1) > y.get(0) ?  y.get(y.size() - 1) - y.get(0) : y.get(0) - y.get(y.size() - 1))];
  double maX = x.get(0);
  double minX = x.get(0);
  for(int i = 1; i < x.size(); i++){
    if (x.get(i) > maX){
      maX = x.get(i);
    }else if (x.get(i) < minX){
      minX = x.get(i);
    }
  }

  double maxY = y.get(0);
  double minY = y.get(0); 
  for(int i = 1; i < y.size(); i++){
    if (y.get(i) > maxY){
      maxY = y.get(i);
    }else if (y.get(i) < minY){
      minY = y.get(i);
    }
  }
  // boolean negY = minY < 0;
  // boolean negX = minX < 0;
    double[][] mat = new double[(int)Math.round(maxY - minY) + 1][(int)Math.round(maX - minX) + 1];
    for(int i = 0; i < mat.length; i++){
      for(int j = 0; j < mat[0].length; j++){
        if(Math.round(i-minY) == 0){
          mat[i][j] = 2;
        }else if(Math.round(j-minX) == 0){
          mat[i][j] = 2;
        }else{
          mat[i][j] = 0;
        }
      }
    }
    for(int i = 0; i < x.size(); i++){
      // System.out.println("\nthingy1: " + y.get(i));
      // System.out.println("thingy2: " + minY);
      // System.out.println( "thingy: " + (y.get(i) -minY));
      //mat[negY ? (int)(Math.round(y.get(i)) -minY) : (int)Math.round(y.get(i))][negX ? (int)(Math.round(x.get(i)) - minX) : (int)Math.round(x.get(i))] = 1;
      mat[(int)(Math.round(y.get(i)) - minY)][(int)(Math.round(x.get(i)) - minX)] = 1;
    }

    // System.out.println(x.size());
    // System.out.println(y.size());

    // System.out.println(mat.length);
    // System.out.println(mat[0].length);
    
    for(int i = mat.length - 1; i >= 0; i--){
      String s = "";
      for(int j = 0; j < mat[0].length; j++){
        s += mat[i][j] == 0 ? "-" : mat[i][j] == 2 ? 
          "0" : "+";
      }
      System.out.println(s);
    }
    
  }
}