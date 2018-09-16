/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting_application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 20iyerd
 */
public class FileExport
{
    private ArrayList<Integer> teamNumbers = new ArrayList<>(); //done
    private ArrayList<Integer> matchNumbers = new ArrayList<>(); //done
    private ArrayList<Integer> autoSwitchCubes = new ArrayList<>(); //done
    private ArrayList<Integer> autoScaleCubes = new ArrayList<>(); //done
    private ArrayList<Boolean> switchReaches = new ArrayList<>(); //done
    private ArrayList<Boolean> scaleReaches = new ArrayList<>(); //done
    private ArrayList<Boolean> baselineReaches = new ArrayList<>(); //done
    //=====================================================
    
    //===================tele vars=========================
    private ArrayList<Integer> teleSwitchCubes = new ArrayList<>(); //done
    private ArrayList<Integer> teleScaleCubes = new ArrayList<>(); //done
    private ArrayList<Integer> teleExchCubes = new ArrayList<>(); //done
    
    private ArrayList<Boolean> climbs = new ArrayList<>(); //done
    private ArrayList<Boolean> platforms = new ArrayList<>(); //done

    //=====================================================
    private static ArrayList<String> titles = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> allData = new ArrayList<>();
    
    public FileExport(
        ArrayList teamNumbers,
        ArrayList matchNumbers,
        ArrayList autoSwitchCubes,
        ArrayList autoScaleCubes,
        ArrayList switchReaches,
        ArrayList scaleReaches,
        ArrayList baselineReaches,
        ArrayList teleSwitchCubes,
        ArrayList teleScaleCubes,
        ArrayList teleExchCubes,
        ArrayList climbs,
        ArrayList platforms,
        ArrayList<ArrayList<Integer>> allData
    )
    {
        this.teamNumbers=teamNumbers;
        this.matchNumbers=matchNumbers;
        this.autoSwitchCubes=autoSwitchCubes;
        this.autoScaleCubes=autoScaleCubes;
        this.switchReaches=switchReaches;
        this.scaleReaches=scaleReaches;
        this.baselineReaches=baselineReaches;
        this.teleSwitchCubes=teleSwitchCubes;
        this.teleScaleCubes=teleScaleCubes;
        this.teleExchCubes=teleExchCubes;
        this.climbs=climbs;
        this.platforms=platforms;
        
        this.allData=allData;
    }
    /**
     * converts the array of booleans into
     * an array of 1 and 0 integers
     * 
     * @param arr
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> toInts(ArrayList<Boolean> arr)
    {
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) == true)
            {
                newArr.add(1);
            }
            else if(arr.get(i) == null || arr.get(i) == false)
            {
                newArr.add(0);
            }
        }
        return newArr;
    }
    /**
     * adds all the existing data contained
     * within the ArrayLists to a 2d 
     * ArrayList
     * @return ArrayList<ArrayList<Integer>>
     */
    public ArrayList<ArrayList<Integer>> get2DArr()
    {        
        allData.add(teamNumbers);
        allData.add(matchNumbers);
        allData.add(autoSwitchCubes);
        allData.add(autoScaleCubes);
        allData.add(toInts(switchReaches));
        allData.add(toInts(scaleReaches));
        allData.add(toInts(baselineReaches));
        allData.add(teleSwitchCubes);
        allData.add(teleScaleCubes);
        allData.add(teleExchCubes);
        allData.add(toInts(climbs));
        allData.add(toInts(platforms));
        return allData;
    }
    
    /**
     * outputs a CSV file containing
     * data from the ArrayList allData
     * throws an Exception if the filename
     * is not valid or if the data type
     * is not valid
     * @param list
     * @param fileName
     * @throws Exception 
     */    
    public static void getIntCSV(ArrayList<ArrayList<Integer>> list, String fileName) throws Exception
    {
        PrintWriter writer = null;
        
        try
        {
            writer = new PrintWriter(new FileWriter(fileName));
            
            for(ArrayList<Integer> i : list) //parse through each ArrayList in the 2d arraylist
            {
                for(Integer j : i) //parse through each integer in the array
                {
                    writer.write(j.toString());
                    writer.append(','); //append commas because of CSV file
                }
                
                writer.append('\n'); //separate each arraylist within the file
                
            }
            writer.close();
        }
        catch(IOException ex) //writing strings to a printwriter throws IOException ex
        {
            System.out.print("Invalid data type or filename" + ex.getMessage());
        }		
    }
    
}
