import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main {
	
	private static String mFilename = "t2b.txt";
	private static int p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(mFilename));
		char ch;
		String line="";
		int index=100;
		int tamanho=0;
		String atual;
		while ( (ch = (char) br.read()) != ' '){
	           System.out.println(ch);
	           atual=""+ch;
	           tamanho = tamanho + (Integer.parseInt(atual))*index;
	           index=index/10;
	        }
		System.out.println(tamanho);
		line = br.readLine();
		System.out.println(line.length());
		br.close();
		int i = 0;
		
		
		i = lerletra1(i, tamanho, line);
		
		System.out.println(p);
	}
	
	public static int lerletra(int i, int tamanhoAtual, String line){
		if(line.charAt(i)=='c'){
			tamanhoAtual = tamanhoAtual /2;			
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
		} else if(line.charAt(i)=='b'){
			
		} else if(line.charAt(i)=='p'){
			
			p = p + tamanhoAtual *2;			
		}
		return i;
	}
	
	public static int lerletra1(int i, int tamanho, String line){
		if(line.charAt(i)=='c'){
			int	tamanhoAtual = tamanho /2;			
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
			System.out.println(i);
			i++;
			i=lerletra(i, tamanhoAtual, line);
		} else if(line.charAt(i)=='b'){
			
			System.out.println(i);
			i++;
		} else if(line.charAt(i)=='p'){
			
			p = p + tamanho *2;
			System.out.println(i);
			i++;
		}
		return i;
	}
	
}
