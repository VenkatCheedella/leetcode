package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkyLine {
	public List<int[]> getSkyline(int[][] buildings) {
        Map<PointX, PointX> reference = new HashMap<>();
        List<PointX> PointXs = getPointXs(buildings, reference);
        Collections.sort(PointXs, (p1, p2) -> {
        	if(p1.getX() != p2.getX()) return p1.getX() - p2.getX() ;
        	else {
        		if(p1.getSore() != p2.getSore()) return p2.getSore() -p1.getSore();
        		else if(p1.getSore() == 's') return p2.getY() - p1.getY();
        		else {
        			return p1.getY() - p2.getY();
        		}
        	}
        	
        });
        
        Queue<PointX> q = new PriorityQueue<>((P1, P2) -> { return P2.getY() - P1.getY();});
        List<int[]> referencePointXs = new ArrayList<>();
        q.offer(new PointX(0, 0, 's'));
        for(PointX P : PointXs){
            PointX top = q.peek();
            if(P.getSore() == 's'){
                if(P.getY() > top.getY()) referencePointXs.add(new int[]{P.getX(), P.getY()});
                q.offer(P);
            }else{
                PointX oldTop = q.peek();
                PointX start = reference.get(P);
                q.remove(start);
                PointX newTop = q.peek();
                if(oldTop.getY() <= newTop.getY()) continue;
                if(oldTop.getY() > newTop.getY()){
                    referencePointXs.add(new int[] {P.getX(), q.peek().getY()});
                }
            }
        }
        return referencePointXs;
    }
    
    private List<PointX> getPointXs(int[][] buildings, Map<PointX, PointX> reference){
        List<PointX> PointXs = new ArrayList<>();
        for(int[] building : buildings){
            PointX P1 = new PointX(building[0], building[2], 's');
            PointX P2 = new PointX(building[1], building[2], 'e');
            PointXs.add(P1);
            PointXs.add(P2);
            reference.put(P2, P1);
        }
        return PointXs;
    }
    
    
    public static void main(String[] args) {
    	SkyLine skyLine = new SkyLine();
    	int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12}, {15,20,10}, {19,24,8}};
    	buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12}};
//    	buildings = new int[][] {{0,2,3},{2,5,3}};
//    	buildings = new int[][] {{1,2,1}, {1,2,2}, {1,2,3}};
    	List<int[]> skyLinePoints = skyLine.getSkyline(buildings);
    	for(int[] point : skyLinePoints) {
    		System.out.println(point[0] + "," + point[1]);
    	}
    }
    
}

class PointX{
    private int x;
    private int y;
    private char sore;
    
    public PointX(int x, int y, char sore){
        this.x= x;
        this.y = y;
        this.sore = sore;
    }
    
    public int hashCode(){
        int hash = 7;
        int hashValue =  31*hash*x;
        hashValue = 31*hash*hashValue*y;
        hashValue = 31*hash*hashValue*(int)sore;
        return hashValue;
    }
    
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof PointX)) return false;
        PointX p = (PointX)o;
        if(p.x != this.x || p.y != this.y || p.sore != this.sore) return false;
        return true;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getSore() {
		return sore;
	}

	public void setSore(char sore) {
		this.sore = sore;
	}
    
    
}
