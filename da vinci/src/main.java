import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main {
	
	private static String mFilename = "t2b.txt";
	private static String wFilename = "t2bImage.txt";
	private static int p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(mFilename));
		File arquivo = new File(wFilename);
		FileWriter fileW = new FileWriter(arquivo);
		BufferedWriter buffW = new BufferedWriter(fileW);
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
		buffW.write("<svg xmlns="+"\"http://www.w3.org/2000/svg\""+" width="+"\""+tamanho+"cm\""+" height="+"\""+tamanho+"cm\""+" viewBox="+"\"0 0 8 8\""+"> <g style="+"\"stroke-width:.05; stroke:black\""+">");
		buffW.newLine();
		line = br.readLine();
		System.out.println(line.length());
		br.close();
		int i = 0;
		int tamanhoAtual=0;
		
		i = lerletra1(arquivo, i, tamanho, line, tamanhoAtual, fileW, buffW);
		System.out.println(p);
		buffW.close();
	}
	
	public static int lerletra(File arquivo, int tamanho, int i, int tamanhoAtual, String line, FileWriter fileW, BufferedWriter buffW) throws IOException{
		if(line.charAt(i)=='c'){
			buffW.newLine();
			buffW.newLine();
			tamanhoAtual = tamanhoAtual /2;			
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			buffW.newLine();
		} else if(line.charAt(i)=='b'){
			buffW.write("<rect x="+"\""+(tamanho-tamanhoAtual)+"\""+" y="+"\""+(tamanho-tamanhoAtual)+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:white\""+"/>");
		} else if(line.charAt(i)=='p'){
			buffW.write("<rect x="+"\""+(tamanho-tamanhoAtual)+"\""+" y="+"\""+(tamanho-tamanhoAtual)+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:black\""+"/>");
			p = p + tamanhoAtual *2;			
		}
		return i;
	}
	
	public static int lerletra1(File arquivo,int i, int tamanho, String line, int tamanhoAtual,FileWriter fileW, BufferedWriter buffW) throws IOException{
		if(line.charAt(i)=='c'){
			tamanhoAtual = tamanho /2;		
			buffW.newLine();
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
			i++;
			i=lerletra(arquivo, tamanho, i, tamanhoAtual, line, fileW, buffW);
		} else if(line.charAt(i)=='b'){
			buffW.write("<rect x="+"\""+(tamanho-tamanhoAtual)+"\""+" y="+"\""+(tamanho-tamanhoAtual)+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:white\""+"/>");
			i++;
		} else if(line.charAt(i)=='p'){
			buffW.write("<rect x="+"\""+(tamanho-tamanhoAtual)+"\""+" y="+"\""+(tamanho-tamanhoAtual)+"\""+" width="+"\""+tamanhoAtual+"\""+" height="+"\""+tamanhoAtual+"\""+" style="+"\"fill:black\""+"/>");
			p = p + tamanho *2;
			i++;
		}
		return i;
	}
	
}
