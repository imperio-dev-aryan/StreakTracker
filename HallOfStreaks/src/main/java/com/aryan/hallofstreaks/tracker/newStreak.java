package com.aryan.hallofstreaks.tracker;
import java.util.*;
import java.io.*;
public class newStreak{
    String habit, name, nick, startDate,frequency;
    public void nickname(int n){
        switch(n){
            case 1: 
                nick = "MomentumMaverick";
                break;
            case 2: 
                nick = "AuroraTrail";
                break;
            case 3: 
                nick = "CrystalNomad";
                break;
            case 4: 
                nick = "NebulaPulse";
                break;
            case 5: 
                nick = "ZenChronos";
                break;
            case 6: 
                nick = "ObsidianSpark";
                break;
            case 7: 
                nick = "AetherVoyager";
                break;
            case 8: 
                nick = "ZenithPulse";
                break;
        }
    }
    public void space(){
        System.out.println();
    }
    public void newAcc(){
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, User \nFor what purpose do you wish to use this tracker For: ");
        habit = sc.nextLine();
        System.out.println("Enter Name: ");
        name = sc.nextLine();
        System.out.println("Enter Start Date: ");
        startDate = sc.nextLine();
        System.out.println("How Frequent Do You Commit To This Cause: ");
        frequency = sc.nextLine();
        nickname(ran.nextInt(1,9));
        System.out.println("Congratulations, \nYour Account is successfully created and for connecting with us we reward you with a special NICKNAME, \n"+ nick);
        space();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        space();
        space();
        System.out.println("                ✨━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━✨");
        space();
        System.out.println("                           Welcome, Seeker of Streaks...");
        System.out.println("   Your essence has been bound to the ledger of time and the scroll of streaks reveals your path.");
        System.out.println(" ");
        System.out.println("                             ✧ Username: " + nick);
        System.out.println("                             ✧ Goal: " + habit);
        System.out.println("                             ✧ Frequency: " + frequency);
        System.out.println("                             ✧ Start Date: " + startDate);
        System.out.println(" ");
        System.out.println("               May your resolve be eternal, May your journey be unbroken,");
        System.out.println("               and your streak burn brighter with each passing day...");
        space();
        System.out.println("              🌙━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🌙");
        space();
        try{
            storeData();
            storePara();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void storeData() throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("StreakInfo.dat"));
        out.writeUTF(name);
        out.writeUTF(startDate);
        out.writeUTF(habit);
        out.writeUTF(nick);
        out.writeUTF(frequency);
        out.close();
    }
    public void storePara() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("              📜══════════════════════════════════════════════════════════📜");
        System.out.println("                     Speak now, and let your daily English paragraph");
        System.out.println("                        be etched into the Chronicle of Streaks.");
        System.out.print("                                ➤ Enter your paragraph here: \n");
        String dailyPara = sc.nextLine();
        System.out.println(" ");
        System.out.println("                 🖋️ Your words have been sealed into the ledger of time...");
        System.out.println("                    May your streak grow stronger with each inscription.");
        System.out.println("               📜══════════════════════════════════════════════════════════📜");
        Calendar cs = Calendar.getInstance();
        int d= cs.get(Calendar.DATE);
        int m= cs.get(Calendar.MONTH)+1;
        int y= cs.get(Calendar.YEAR);
        DataOutputStream dat = new DataOutputStream(new FileOutputStream("Date.dat"));
        dat.writeInt(d);
        dat.writeInt(m);
        dat.writeInt(y);
        dat.writeInt(1);
        dat.close();
        StringTokenizer data = new StringTokenizer(dailyPara);
        double XP =0; int totalWords =0;
        
        totalWords = data.countTokens();
        XP = totalWords/50.0;
        DataOutputStream Words = new DataOutputStream(new FileOutputStream("Words.dat"));
        Words.writeInt(totalWords);
        Words.writeDouble(XP);
        Words.close();
        
        DataOutputStream dd  = new DataOutputStream(new FileOutputStream("StreakStat.dat"));
        dd.writeInt(1);
        dd.writeInt(0);
        dd.close();
        
        DataOutputStream d3  = new DataOutputStream(new FileOutputStream("LongestStreak.dat"));
        d3.writeInt(1);
        d3.close();
        
        double vocab,grammar,flow,impact;
        System.out.println("✨━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━✨");
        System.out.println("✧ Chronicle the Scroll of Judgment (View Grammar, Vocabulary, Flow & Impact)");
        System.out.println("   1. Weigh the Tongue (Grammar)");
        grammar = sc.nextDouble();
        System.out.println("   2. Sip the Chalice (Vocabulary)");
        vocab = sc.nextDouble();
        System.out.println("   3. Hear the River’s Song (Flow)");
        flow = sc.nextDouble();
        System.out.println("   4. Witness the Sparks (Impact)");
        impact = sc.nextDouble();
        System.out.println("✨━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━✨");
        
        DataOutputStream dat1 = new DataOutputStream(new FileOutputStream("Rating.dat"));
        dat1.writeDouble(grammar);
        dat1.writeDouble(vocab);
        dat1.writeDouble(flow);
        dat1.writeDouble(impact);
        dat1.close();
        DataOutputStream d5 = new DataOutputStream(new FileOutputStream("RatingAVG.dat"));
        d5.writeDouble(grammar);
        d5.writeDouble(vocab);
        d5.writeDouble(flow);
        d5.writeDouble(impact);
        d5.close();
    }
}