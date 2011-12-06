package com.linkedin.clustermanager.alerts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class Tuple<T> {
	List<T> elements;
	
	public Tuple() 
	{
		elements = new LinkedList<T>();
	}
	
	public int size()
	{
		return elements.size();
	}

	public void add(T entry)
	{
		elements.add(entry);
	}
	
	public void addAll(Tuple<T> incoming)
	{
		elements.addAll(incoming.getElements());
	}
	
	public Iterator<T> getIterator()
	{
		return elements.listIterator();
	}
	
	public List<T> getElements()
	{
		return elements;
	}
	
	public void clear() 
	{
		elements.clear();
	}
	
	public static Tuple<String> fromString(String in) 
	{
		Tuple<String> tup = new Tuple<String>();
		if (in.length() > 0) {
			String[] elements = in.split(",");
			for (String element : elements) {
				tup.add(element);
			}
		}
		return tup;
	}
	
	public String toString() 
	{
		StringBuilder out = new StringBuilder();
		Iterator<T> it = getIterator();
		boolean outEmpty=true;
		while (it.hasNext()) {
			if (!outEmpty) {
				out.append(",");
			}
			out.append(it.next());
			outEmpty = false;
		}
		return out.toString();
	}
}