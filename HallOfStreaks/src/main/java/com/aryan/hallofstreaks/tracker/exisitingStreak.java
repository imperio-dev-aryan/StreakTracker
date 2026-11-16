package com.aryan.hallofstreaks.tracker;
import java.util.*;
import java.io.*;
public class exisitingStreak{
    Scanner sc = new Scanner(System.in);
    String name1, startDate1,habit1,nick1,frequency1;
    int d1,m1,y1;
    int streak,totalWords;
    double XP;
    //Streak Stat Calculation
    int daysWritten, daysMissed,longestStreak;
    int compare;
    double xpFilled;
    double maxXp;
    double rankXp;
    public void execute(){
        try{
            readData();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void readData() throws IOException{
        boolean EOF = false;
        DataInputStream fileInput = new DataInputStream(new FileInputStream("StreakInfo.dat"));
        while(!EOF){
          try{
            name1= fileInput.readUTF();
            startDate1= fileInput.readUTF();
            habit1= fileInput.readUTF();
            nick1= fileInput.readUTF();
            frequency1= fileInput.readUTF();
          }
          catch(EOFException el){
              EOF= true;
          }
        }
        fileInput.close();
        boolean eof = false;
        DataInputStream Input = new DataInputStream(new FileInputStream("Date.dat"));
        while(!eof){
          try{
            d1= Input.readInt();
            m1= Input.readInt();
            y1= Input.readInt();
            streak = Input.readInt();
          }
          catch(EOFException el){
              eof= true;
          }
        }
        Input.close();
        boolean Eof = false;
        DataInputStream In = new DataInputStream(new FileInputStream("Words.dat"));
        while(!Eof){
          try{
            totalWords = In.readInt();
            XP= In.readDouble();
          }
          catch(EOFException el){
              Eof= true;
          }
        }
        In.close();


        boolean E = false;
        DataInputStream I = new DataInputStream(new FileInputStream("StreakStat.dat"));
        while(!E){
          try{
            daysWritten = I.readInt();
            daysMissed= I.readInt();
          }
          catch(EOFException el){
              E= true;
          }
        }
        I.close();
        boolean EE =false;
        DataInputStream Im = new DataInputStream(new FileInputStream("LongestStreak.dat"));
        try{
            while(!EE){
                int longS = Im.readInt();
                if(compare<longS){
                    compare = longS;
                }
            }
        }
        catch(EOFException e){
            EE = true;
        }
        compare = Math.max(compare, streak);
    }

    public String getNickName() {
        return nick1;
    }

    public String getName() { return name1; }

    public String getStartDate() { return startDate1; }

    public int getTotalWords() { return totalWords; }

    public double getXP() {
        String formatted = String.format("%.2f%n", XP);
        XP = Double.parseDouble(formatted);
        return XP;
    }

    public int getAvgWords() throws IOException{
        daysCal O = new daysCal(); 
        int sd = Integer.parseInt(startDate1.substring(0,2)); 
        int sm = Integer.parseInt(startDate1.substring(3,5));
        int sy = Integer.parseInt(startDate1.substring(6,10));
        O.dd1 = sd;
        O.mm1 = sm;
        O.yy1 = sy;  O.Cal();
        int day = O.days+1;
        return ((int)totalWords/day);
    }

    public int getCurrentStreak() {
        return streak;
    }

    public int getDaysWritten() {
        return daysWritten;
    }

    public int getDaysMissed() {
        return daysMissed;
    }

    public int getLongestStreak() {
        return compare;
    }

    public double getCRate() throws IOException{
        daysCal O = new daysCal(); 
        int sd = Integer.parseInt(startDate1.substring(0,2)); 
        int sm = Integer.parseInt(startDate1.substring(3,5));
        int sy = Integer.parseInt(startDate1.substring(6,10));
        O.dd1 = sd;
        O.mm1 = sm;
        O.yy1 = sy;  O.Cal();
        int day = O.days+1;
        double cRate = ((double)daysWritten/day)*100;
        return cRate;
    }

    public String getRank() throws IOException{
        xpFilled = 0;
        String str ="";
        if(XP>=0 && XP<=500){
            rankXp =  XP;
            maxXp = 500;
            xpFilled = (rankXp / maxXp)*100;
            str = "Bronze Scribe";
        }
        else if(XP>500 && XP<=1000){
            rankXp =  XP-500;
            maxXp = 500;
            xpFilled = (rankXp / maxXp)*100;
            str = "Silver Oracle";
        }
        else if(XP>1000 && XP<=1500){
            rankXp =  XP -1000;
            maxXp = 500;
            xpFilled = (rankXp / maxXp)*100;
            str = "Gold Arcanist";
        }
        else if(XP>1500 && XP<=2000){
            rankXp =  XP -1500;
            maxXp = 500;
            xpFilled = (rankXp / maxXp)*100;
            str = "Platinum Paladin";
        }
        else if(XP>2000 && XP<=3000){
            rankXp =  XP -2000;
            maxXp = 1000;
            xpFilled = (rankXp / maxXp)*100;
            str = "Emerald Envoy";
        }
        else if(XP>3000 && XP<=4000){
            rankXp =  XP -3000;
            maxXp = 1000;
            xpFilled = (rankXp / maxXp)*100;
            str = "Sapphire Sorcerer";
        }
        else if(XP>4000 && XP<=5000){
            rankXp =  XP -4000;
            maxXp = 1000;
            xpFilled = (rankXp / maxXp)*100;
            str = "Ruby Regent";
        }
        else{
            rankXp =  XP -5000;
            maxXp = 3000;
            xpFilled = (rankXp / maxXp)*100;
            str = "Diamond Deity";
        }
        return str;
    }

    public double getXpFilled(){
        String formatted = String.format("%.2f%n", xpFilled);
        xpFilled = Double.parseDouble(formatted);
        return xpFilled;
    }
    public double getTotalXP(){
        return maxXp;
    }
    public double getRankXp(){
        String formatted = String.format("%.2f%n", rankXp);
        rankXp = Double.parseDouble(formatted);
        return rankXp;
    }

    public void resumeStreak(String dailyPara) throws IOException{
        stats OB = new stats();
        StringTokenizer data = new StringTokenizer(dailyPara);
        totalWords = totalWords+data.countTokens();
        XP = totalWords/50.0;

        DataOutputStream dat = new DataOutputStream(new FileOutputStream("Words.dat"));
        dat.writeInt(totalWords);
        dat.writeDouble(XP);
        dat.close();

        streakCal();
        OB.enter();
    }

    public void streakCal() throws IOException{
        daysCal obbj = new daysCal();
        obbj.dd1 =d1; obbj.mm1 = m1; obbj.yy1 = y1; 
        obbj.Cal();
        if(obbj.days ==1){
            streak =streak+1;
            DataOutputStream dat = new DataOutputStream(new FileOutputStream("Date.dat"));
            dat.writeInt(obbj.dd2);
            dat.writeInt(obbj.mm2);
            dat.writeInt(obbj.yy2);
            dat.writeInt(streak);
            dat.close();
            
            daysWritten += 1;
            
            DataOutputStream dd  = new DataOutputStream(new FileOutputStream("StreakStat.dat"));
            dd.writeInt(daysWritten);
            dd.writeInt(daysMissed);
            dd.close();
        }
        else if(obbj.days >1){
            DataOutputStream l = new DataOutputStream(new FileOutputStream("LongestStreak.dat",true));
            l.writeInt(streak);
            l.close();
            streak =1;
            DataOutputStream dat = new DataOutputStream(new FileOutputStream("Date.dat"));
            dat.writeInt(obbj.dd2);
            dat.writeInt(obbj.mm2);
            dat.writeInt(obbj.yy2);
            dat.writeInt(1);
            dat.close();
            
            daysWritten +=1;
            daysMissed += (obbj.days-1);
            
            DataOutputStream dd  = new DataOutputStream(new FileOutputStream("StreakStat.dat"));
            dd.writeInt(daysWritten);
            dd.writeInt(daysMissed);
            dd.close();
            
        }
    }

}