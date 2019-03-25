/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonBeans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;

/**
 *
 * @author alejandrohd
 */
@Singleton
@LocalBean
public class StatisticsApp {

    private Map<String, Integer> userStatistics = new LinkedHashMap<>();
    private Map<String, Integer> pagesStatistics = new LinkedHashMap<>();
    String url = "/Users/alejandrohd/Documents/Universidad/AS/P2Files/statistics.txt";

    public void addUserKey(String key) {
        if (key != null) {
            userStatistics.put(key, 0);
        }
    }

    public int getValue(String key) {
        if (key == null) {
            return 0;
        }
        return userStatistics.get(key);
    }

    public void addUserValue(String key, int value) {
        if (key != null) {
            userStatistics.put(key, value);
        }
    }

    public void addAccess(String key) {
        if (pagesStatistics.containsKey(key)) {
            pagesStatistics.put(key, pagesStatistics.get(key) + 1);
        } else {
            pagesStatistics.put(key, 1);
        }
    }

    public void addUserAcces(String key) {
        if (pagesStatistics.containsKey(key)) {
            pagesStatistics.put(key, pagesStatistics.get(key) + 1);
        } else {
            pagesStatistics.put(key, 1);
        }
    }

    public String viewStatisticsUser() {
        String datas = "\n****** Por usuarios *********\n";
        if (!userStatistics.isEmpty()) {
            Iterator it = userStatistics.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                datas += e.getKey() + ":" + e.getValue() + " || ";
            }
            return datas;
        }
        return "Nada que mostrar sobre los usuarios";
    }

    public String viewStatisticPages() {
        String datas = "\n------------------------------------------\n";
        if (!pagesStatistics.isEmpty()) {
            Iterator it = pagesStatistics.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                if (!e.getValue().equals(0)) {
                    datas += e.getKey() + ":" + e.getValue() + "\n";
                }
            }
            return datas;
        }
        return "Nada que mostrar sobre lo visitado\n";
    }

    public void statisticsDoc() throws IOException {
        String textStatistics = viewStatisticPages() + viewStatisticsUser();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(url, true))) {
            bw.write(textStatistics);
            bw.newLine();
        }
    }

    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void saveStatisticsDisk() {
        try {
            statisticsDoc();
        } catch (IOException ex) {
            Logger.getLogger(StatisticsApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
