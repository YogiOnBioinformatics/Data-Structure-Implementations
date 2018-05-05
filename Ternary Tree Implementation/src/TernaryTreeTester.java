
import java.util.*;
public class TernaryTreeTester{
	
	public static void main(String[] args){

	TernaryTree<Integer> twentytwo = new TernaryTree<Integer>(22);
	TernaryTree<Integer> twentyone = new TernaryTree<Integer>(21, twentytwo, null, null);
	TernaryTree<Integer> twenty = new TernaryTree<Integer>(20);
	TernaryTree<Integer> nineteen = new TernaryTree<Integer>(19);
	TernaryTree<Integer> eighteen = new TernaryTree<Integer>(18);
	TernaryTree<Integer> seventeen = new TernaryTree<Integer>(17);
	TernaryTree<Integer> sixteen = new TernaryTree<Integer>(16);
	TernaryTree<Integer> fiveteen = new TernaryTree<Integer>(15);
	TernaryTree<Integer> fourteen = new TernaryTree<Integer>(14, twentyone, null, null);
	TernaryTree<Integer> thirteen = new TernaryTree<Integer>(13);
	TernaryTree<Integer> twelve = new TernaryTree<Integer>(12);
	TernaryTree<Integer> eleven = new TernaryTree<Integer>(11);
	TernaryTree<Integer> ten = new TernaryTree<Integer>(10);
	TernaryTree<Integer> nine = new TernaryTree<Integer>(9,twenty,null,null);
	TernaryTree<Integer> eight = new TernaryTree<Integer>(8,nineteen, null, null);
	TernaryTree<Integer> seven = new TernaryTree<Integer>(7, eighteen, null, null);
	TernaryTree<Integer> six = new TernaryTree<Integer>(6,seventeen, null, null);
	TernaryTree<Integer> five = new TernaryTree<Integer>(5,fourteen,fiveteen,sixteen);
	TernaryTree<Integer> four = new TernaryTree<Integer>(4,eleven,twelve,thirteen);
	TernaryTree<Integer> three = new TernaryTree<Integer>(3,eight, nine, ten);
	TernaryTree<Integer> two = new TernaryTree<Integer>(2,five,six,seven);
	TernaryTree<Integer> one = new TernaryTree<Integer>(1,two,three,four);

	TernaryTree<Integer> unreal = new TernaryTree<Integer>();
	
	System.out.println(one.getNumberOfNodes());
	
	System.out.println(twentytwo.isEmpty());
	System.out.println(one.getHeight()); 
	
	
 	TernaryTree<String> s = new TernaryTree<String>("s");
	TernaryTree<String> r = new TernaryTree<String>("r");
	TernaryTree<String> q = new TernaryTree<String>("q");
	TernaryTree<String> p = new TernaryTree<String>("p");
	TernaryTree<String> o = new TernaryTree<String>("o");
	TernaryTree<String> n = new TernaryTree<String>("n");
	TernaryTree<String> m = new TernaryTree<String>("m");
	TernaryTree<String> l = new TernaryTree<String>("l");
	TernaryTree<String> k = new TernaryTree<String>("k");
	TernaryTree<String> j = new TernaryTree<String>("j");
	TernaryTree<String> i = new TernaryTree<String>("i");
	TernaryTree<String> h = new TernaryTree<String>("h");
	TernaryTree<String> g = new TernaryTree<String>("g");
	TernaryTree<String> f = new TernaryTree<String>("f",q,r,s);
	TernaryTree<String> e = new TernaryTree<String>("e",n,o,p);
	TernaryTree<String> d = new TernaryTree<String>("d",k,l,m);
	TernaryTree<String> c = new TernaryTree<String>("c",h,i,j);
	TernaryTree<String> b = new TernaryTree<String>("b",e,f,g);
	TernaryTree<String> a = new TernaryTree<String>("a",b,c,d);
	TernaryTree<String> useless = new TernaryTree<String>();
	TernaryTree<String> unimportant = new TernaryTree<String>(null); 
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
}