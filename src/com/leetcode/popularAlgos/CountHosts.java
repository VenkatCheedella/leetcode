package com.leetcode.popularAlgos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class CountHosts {

    String outputFile = "records_hosts_access_log_00.txt";

    public void getHostNames(String filename) throws Exception {
        Map<String, Integer> hosts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String next = null;
        while((next = reader.readLine()) != null){
            int spaceIdx = next.indexOf(" ");
            String hostName = null;
            if(spaceIdx == -1) continue;
            hostName = next.substring(0, spaceIdx);
            hosts.put(hostName, hosts.getOrDefault(hostName,0)+1);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for(String hostname : hosts.keySet()){
            writer.write(hostname + " " + hosts.get(hostname));
        }
    }

    public static void main(String[] args) {
        StringBuffer buff = new StringBuffer();

    }
}
