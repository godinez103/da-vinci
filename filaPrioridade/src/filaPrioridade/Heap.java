package filaPrioridade;

public class Heap {

  private int v[];
  private int size;

  public Heap() {
    size = 0;
    v = new int[100];
  }

  private int left ( int i )   { return 2 * i + 1; }
  private int right ( int i )  { return 2 * i + 2; }
  private int parent ( int i ) { return (i-1) / 2; }

  private void sift_up ( int pos ) {
	  if(size==1) return;
	  if(v[pos]>v[parent(pos)]){
		  int aux = v[pos];
		  v[pos]=v[parent(pos)];
		  v[parent(pos)]= aux;
		  sift_up(parent(pos));
	  }
  }

  public void put( int data ) {
	  v[size] = data;
	  sift_up( size );
	  size++;
  }

  private void sift_down ( int pos ) {
	  if(v[left(pos)]==0)return;
	  if(v[right(pos)]>0){
		if(v[right(pos)]>v[left(pos)]){
			int aux=v[pos];
			v[pos]=v[right(pos)];
			v[right(pos)]= aux;
			sift_down(right(pos));
		} else{
			int aux=v[pos];
			v[pos]=v[left(pos)];
			v[left(pos)]= aux;
			sift_down(left(pos));
		}
	  } else{
		  int aux=v[pos];
		  v[pos]=v[left(pos)];
		  v[left(pos)]= aux;
	  }
  }

  public int get( ) {
    int res = v[0];
    v[0] = v[--size];
    sift_down( 0 );
    return res;
  }

  private void print( int b, int elem, int sp )  {
    int i, j;

    System.out.println( "" );
    for( j = 0; j < size; j++ ) System.out.print( v[j] + " " );
    System.out.println( "" );

    while ( true ) {
      for( j = 0; j <= sp / 2; j++ ) System.out.print( " " );
      for( i = b; i < b + elem; i++ ) {
        if ( i == size ) return;
        System.out.print( v[i] );
        for( j = 0; j < sp; j++ ) System.out.print( " " );
      }
      System.out.println( "" );
      b = b + elem;
      elem = 2 * elem;
      sp = sp / 2;
    }
  }

  public void print( )  {
    System.out.println( "" );
    print( 0, 1, 32 );
    System.out.println( "" );
  }

}