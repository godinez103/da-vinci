package filaPrioridade;

import java.util.Scanner;

public class Main {

  public static void main( String[] args ) {
    Heap H = new Heap();

    Scanner input = new Scanner( System.in );

    while ( input.hasNext() ) {
      String temp = input.next();

      if ( temp.equals( "quit" ) ) System.exit(0);
      if ( temp.equals( "get" ) )  System.out.println( H.get() );
      if ( temp.matches( "[0-9]+" ) ) H.put( Integer.parseInt( temp ) );
      if ( temp.equals( "sort" ) )   H.heapSort() ;

      H.print();
    }
  }
}