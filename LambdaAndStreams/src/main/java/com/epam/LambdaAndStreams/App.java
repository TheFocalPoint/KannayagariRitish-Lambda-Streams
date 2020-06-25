package com.epam.LambdaAndStreams;
import java.util.*;
import java.util.function.Predicate;

interface FunctionalInterface
{
	public float averageLists(List<Integer> arrayList);
	
}

interface IPalindrome
{
	boolean isPalindrome(String s);
	
}

class PredicatePalindrome
{
	public static boolean palindrome(String s)
	{
		return new StringBuffer(s).reverse().toString().equals(s);
	}
}


public class App
{
	public static List<String> filterList(List<String> list, Predicate<String> predicate) {
		List<String> result = new ArrayList<String>();
		for(String s : list)
		{
			if(predicate.test(s))
				result.add(s);
		}
		return result;
		
	}
    public static void main( String[] args )
    {
      //Task 1 Average of a List of Integers
    	List<Integer> numbers = new ArrayList<Integer>();
    	numbers.add(5);
    	numbers.add(10);
    	numbers.add(34);
    	numbers.add(74);
    	numbers.add(38);
    	
    	FunctionalInterface averageInterface = (averageList) ->
    	{
    		int sum=0;
    		for(int i=0;i<averageList.size();i++)
    		{
    			sum+=averageList.get(i);
    		}
    		return sum/averageList.size();
    	};
    	
    	System.out.println("Average of List of Numbers is "+averageInterface.averageLists(numbers));
    	
    	//Task 2 Strings that start with letter A and exactly are of length 3;
    	
    	String[] words= {"Epam","corona","virus","aaa","abb","aam","abhsbdak"};
    	List<String> wordList = Arrays.asList(words);
    	List<String> afterFilter = filterList(wordList,(String s) -> s.length()==3 && s.startsWith('a'+""));
    	
    	System.out.println("After Filtering"+afterFilter);
    	
    	//Task 3 List of Palindromes
    	List<String> str = Arrays.asList("malayalam","madam","epam","maam","virus");
    	List<String> palindromes = new ArrayList<String>();
    	
    	for(String i: str)
    	{
    		IPalindrome predicate = PredicatePalindrome::palindrome;
    		if(predicate.isPalindrome(i))
    		{
    			palindromes.add(i);
    		}
    	}
    	System.out.println("Palindromes "+palindromes);
    }
}
