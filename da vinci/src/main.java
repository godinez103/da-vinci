import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.table.TableColumnModel;

import java.io.FileNotFoundException;

public class main {
	
	private static String mFilename = "t2z.txt";
	private static String wFilename = "t2zImage.txt";
	private static int p;
	
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(mFilename));
		File arquivo = new File(wFilename);
		FileWriter fileW = new FileWriter(arquivo);
		BufferedWriter buffW = new BufferedWriter(fileW);
		char ch;
		String line="";
		int index=100;
		int tamanho = 0;
		String atual;
		while ( (ch = (char) br.read()) != ' '){
	           System.out.println(ch);
	           atual=""+ch;
	           tamanho = tamanho + (Integer.parseInt(atual))*index;
	           index=index/10;
	        }
		line = br.readLine();
		System.out.println(line);
		
		
		
		buffW.write("<svg xmlns="+"\"http://www.w3.org/2000/svg\""+" width="+"\""+tamanho+"cm\""+" height="+"\""+tamanho+"cm\""+" viewBox="+"\"0 0 "+tamanho+" "+tamanho+"\""+"> <g style="+"\"stroke-width:.05; stroke:black\""+">");
		buffW.newLine();
		br.close();
		int i = 0;
		int tamanhoAtual=tamanho;
		
		i = lerletra1(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW);
		System.out.println(p);
		buffW.close();
		long elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
	}
	
	public static int lerletra(File arquivo, int tamanho, int i, String line, int tamanhoAtual, FileWriter fileW, BufferedWriter buffW, int x, int y) throws IOException{
		if(line.charAt(i)=='c'){
			buffW.newLine();
			buffW.newLine();
			tamanhoAtual = tamanhoAtual /2;
			int xi=x+tamanhoAtual;
			int yi=y;
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, xi, yi);
			xi=x;
			yi=y;
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, xi, yi);
			xi=x;
			yi=y+tamanhoAtual;
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, xi, yi);
			xi=x+tamanhoAtual;
			yi=y+tamanhoAtual;
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, xi, yi);
			buffW.newLine();
		} else if(line.charAt(i)=='b'){
			buffW.write("<rect x="+"\""+x+"\""+" y="+"\""+y+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:white\""+"/>");
		} else if(line.charAt(i)=='p'){
			buffW.write("<rect x="+"\""+x+"\""+" y="+"\""+y+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:black\""+"/>");
			p = p + tamanhoAtual * tamanhoAtual;			
		}
		return i;
	}
	
	public static int lerletra1(File arquivo,int tamanho, int i, String line, int tamanhoAtual,FileWriter fileW, BufferedWriter buffW) throws IOException{
		if(line.charAt(i)=='c'){
			buffW.newLine();
			buffW.newLine();
			tamanhoAtual = tamanhoAtual /2;	
			int x = tamanho-tamanhoAtual;
			int y = 0;
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, x, y);
			x=0;
			y=0;
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, x, y);
			x=0;
			y=tamanho-tamanhoAtual;
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, x, y);
			x=tamanho - tamanhoAtual;
			y=tamanho - tamanhoAtual;
			i++;
			i=lerletra(arquivo, tamanho, i, line, tamanhoAtual, fileW, buffW, x, y);
		} else if(line.charAt(i)=='b'){
			buffW.write("<rect x="+"\""+0+"\""+" y="+"\""+0+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:white\""+"/>");
			i++;
		} else if(line.charAt(i)=='p'){
			buffW.write("<rect x="+"\""+0+"\""+" y="+"\""+0+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:black\""+"/>");
			p = p + 1;
			i++;
		}
		return i;
	}
	
}
