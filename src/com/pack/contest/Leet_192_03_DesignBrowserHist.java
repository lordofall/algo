package com.pack.contest;

import java.util.ArrayList;
import java.util.List;

/*
Design Browser History
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 */
public class Leet_192_03_DesignBrowserHist {
	
	List<String> urls = null;
	int currentIndex = -1;
	public static void main(String[] args) {
		

	}
	
	public Leet_192_03_DesignBrowserHist(String homepage) {
        urls = new ArrayList<String>();
        currentIndex++;
        urls.add(homepage);
    }
    
    public void visit(String url) {
    	currentIndex++;
        urls.add(currentIndex, url);
        List<String> urlsTmp = new ArrayList<>();
        for(int i = 0; i <= currentIndex; i++)
        	urlsTmp.add(urls.get(i));
        urls.clear();
        urls = new ArrayList<>(urlsTmp);
    }
    
    public String back(int steps) {
        currentIndex = currentIndex - steps;
        if(currentIndex < 0) currentIndex = 0;
        return urls.get(currentIndex);
    }
    
    public String forward(int steps) {
    	currentIndex = currentIndex + steps;
    	if(currentIndex  >= urls.size())
    		currentIndex = urls.size()-1;
    	return urls.get(currentIndex);
    }

}
