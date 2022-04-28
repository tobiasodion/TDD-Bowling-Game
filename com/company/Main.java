package com.company;

import BG.BowlingGame;
import BG.Game;
import model.FrameSummary;

public class Main {

    public static void main(String[] args) {
	    BowlingGame myBowlingGame = new BowlingGame();

        do{
            Game myFrame = new Game();
            myFrame.roll();
            myFrame.strikeSpareCheck();

            if(myFrame.getIsStrike() == false){
                myFrame.roll();
                myFrame.strikeSpareCheck();
            }

            myFrame.score();

            FrameSummary myFrameSummary = new FrameSummary(myFrame);
            myBowlingGame.updateFrameHistory(myFrameSummary);
            myBowlingGame.nextFrame();

        }while(myBowlingGame.getFrameRemaining() != 0);

        int bonus = 0;
        myBowlingGame.bonusCheck();

        if(myBowlingGame.getIsSpareBonus()){
           bonus = 1;
        }

        if(myBowlingGame.getIsStrikeBonus()){
            bonus = 2;
        }

        for(int j=0; j<bonus; j++){
            Game myFrame = new Game();
            myFrame.roll();
            myFrame.score();
            FrameSummary myFrameSummary = new FrameSummary(myFrame);
            myBowlingGame.updateFrameHistory(myFrameSummary);
        }

        myBowlingGame.calculateTotalScore();
        System.out.println("\t\t" + myBowlingGame.getTotalScore());
    }
}
