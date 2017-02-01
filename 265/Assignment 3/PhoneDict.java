// PhoneDict.java
// Dhantha Gunaratna


import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PhoneDict
{
	public static Map<String,List<String>> wordsDict = new HashMap<String,List<String>>();
	public static void main(String[] args)
	{
		// read the input file
		
		creatWordDict();
		 
		// read from stdin and split into an array 
		
		
		Scanner in = new Scanner(System.in);
		String line;
		while(in.hasNext())
		{
			line = in.nextLine();
			String[] splitArray = line.split("0");
		
			String finalString = "";
			String space = " ";		
			String unidenti = "*";
		
			for(int i=0;i<splitArray.length;i++)
			{
				if(wordsDict.get(splitArray[i]) != null)
				{
					// gets the word from the map 
					List<String> words = wordsDict.get(splitArray[i]);
									
					if(words.size() > 1)							
					{
						finalString = finalString + space + "(";
						for(int j=0;j<words.size();j++)
						{
							if(j+1 == words.size())
							{
								finalString = finalString + words.get(j);							
							}
							else
							{
								finalString = finalString + words.get(j) + "|";
							}						
						}
						finalString = finalString + ")" + space;					
					}
					else
					{
						finalString = finalString + space + words.get(0) + space;
					}
				}
				else
				{
					//print *** to match the strign length
					finalString = finalString + space;
					for(int k=0;k<splitArray[i].length();k++)
					{
						finalString = finalString + unidenti;
					}
					finalString = finalString + space;
				}
					
			}		
			System.out.println(finalString);
			
		}
		//String input = in.next();							
	}
	private static void creatWordDict()
	{
		try {
			File file = new File("words");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
				
			while ((line = bufferedReader.readLine()) != null) {
				
				if(line.length() > 0)
				{
					
					char[] keyArray = line.toLowerCase().toCharArray();
					String key = "";
					List<String> wordList;
					for(int i=0;i<keyArray.length;i++)
					{
						char letter = keyArray[i];
						//System.out.println(letter);
						switch(letter)
						{
							case 'a':
							case 'b':
							case 'c':
								key = key + '2';
								break;
							
							case 'd':
							case 'e':
							case 'f':
								key = key + '3';
								break;
							
							case 'g':
							case 'h':
							case 'i':
								key = key + '4';
								break;
							
							case 'j':
							case 'k':
							case 'l':
								key = key + '5';
								break;
							
							case 'm':
							case 'n':
							case 'o':
								key = key + '6';
								break;
							
							case 'p':
							case 'q':
							case 'r':
							case 's':
								key = key + '7';
								break;
							
							case 't':
							case 'u':
							case 'v':
								key = key + '8';
								break;
							
							case 'w':
							case 'x':
							case 'y':
							case 'z':
								key = key + '9'; //9623
								break;
						}
					}
					//if the key is already in append to the value arraylis
					//System.out.println(key);
					if(wordsDict.get(key) != null)
					{
						
						List<String> alreadyExists = new ArrayList<String>();	
						alreadyExists = wordsDict.get(key);						
						alreadyExists.add(line);
						wordsDict.put(key,alreadyExists);
						//alreadyExists.clear();
					}
					else
					{					
						List<String> addingNewWord = new ArrayList<String>();
						addingNewWord.add(line);						
						wordsDict.put(key,addingNewWord);
					}
				}				
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
