package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

class Point{
	int x;
	int y;
	char dir;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
		this.dir = 'N';
	}
}


public class Encircular {
	
	
	public List<String> isEncircleExist(String[] input) {
		List<String> modifiedInput = new ArrayList<>();
		for(String s :  input) {
			StringBuilder builder = new StringBuilder();
			for(int i=0; i< 4; i++) builder.append(s);
			modifiedInput.add(builder.toString());
		}
		List<String> results = new ArrayList<>();
		for(String s : modifiedInput) results.add(isPathEncirlce(s));
		return results;
	}
	
	
	private String isPathEncirlce(String input) {
		Point p = new Point(0, 0);
		for(int i=0; i < input.length(); i++) checkAndMove(p, input.charAt(i));
		if(p.x == 0 && p.y == 0) return "true";
		return "false";
	}
	
	//consider the chars are valid
	private void checkAndMove(Point current, char dir) {
		if(dir == 'G') {
			//reduce the lines of code
			if(current.dir == 'N') current.y++;
			else if(current.dir == 'E') current.x++;
			else if(current.dir == 'S') current.y--;
			else current.x--;
		}else if(dir == 'L') {
			if(current.dir == 'N') current.dir = 'W';
			else if(current.dir == 'E') current.dir = 'N';
			else if (current.dir == 'S') current.dir = 'E';
			else current.dir = 'S';
		}else{
			if(current.dir == 'N') current.dir = 'E';
			else if(current.dir == 'E') current.dir = 'S';
			else if (current.dir == 'S') current.dir = 'W';
			else current.dir = 'N';
		}
	}
	
	public static void main(String[] args) {
		String[] input = {"GGGGG", "GGL", "LRLRLRRLR", "LRG"};
		Encircular encircular = new Encircular();
		encircular.isEncircleExist(input).stream().forEach(System.out::println);
		
	}
}
