package com.aryan.hallofstreaks.tracker;
import java.util.*;
import java.io.*;
public class stats{
    double vocab=0, grammar=0, flow=0, impact=0;
    double v,g,f,i; double gS,vS, fS, iS;
    public void compute() throws IOException{
        boolean eof = false;
        DataInputStream Input = new DataInputStream(new FileInputStream("Rating.dat"));
        while(!eof){
          try{
            g= Input.readDouble();
            v= Input.readDouble();
            f= Input.readDouble();
            i = Input.readDouble();
          }
          catch(EOFException el){
              eof= true;
          }
        }
        Input.close();
    }

    public double getGrammar(){ return g; }

    public double getVocabulary(){ return v; }

    public double getFlow(){ return f; }

    public double getImpact(){ return i; }

    public void enterGrammar(double g){ grammar = g; }

    public void enterVocabulary(double v){ vocab = v; }

    public void enterFlow(double f){ flow = f; }

    public void enterImpact(double i){ impact = i; }

    public void enter() throws IOException{
        boolean eof = false; int DM=0, DW =0;
        DataInputStream Input = new DataInputStream(new FileInputStream("Rating.dat"));
        while(!eof){
          try{
            g= Input.readDouble();
            v= Input.readDouble();
            f= Input.readDouble();
            i = Input.readDouble();
          }
          catch(EOFException el){
              eof= true;
          }
        }
        Input.close();
        
        boolean E = false;
        DataInputStream I = new DataInputStream(new FileInputStream("StreakStat.dat"));
        while(!E){
          try{
            DW = I.readInt();
            DM= I.readInt();
          }
          catch(EOFException el){
              E= true;
          }
        }
        I.close();
        
        boolean EOF = false;
        DataInputStream In = new DataInputStream(new FileInputStream("RatingAVG.dat"));
        while(!EOF){
          try{
            gS= In.readDouble();
            vS= In.readDouble();
            fS= In.readDouble();
            iS = In.readDouble();
          }
          catch(EOFException el){
              EOF= true;
          }
        }
        In.close();
        
        DataOutputStream dat = new DataOutputStream(new FileOutputStream("Rating.dat"));
        dat.writeDouble(grammar);
        dat.writeDouble(vocab);
        dat.writeDouble(flow);
        dat.writeDouble(impact);
        dat.close();
        
        gS += grammar;
        vS += vocab;
        fS += flow;
        iS += impact;
        DataOutputStream d = new DataOutputStream(new FileOutputStream("RatingAVG.dat"));
        d.writeDouble(gS);
        d.writeDouble(vS);
        d.writeDouble(fS);
        d.writeDouble(iS);
        d.close();
    }
}