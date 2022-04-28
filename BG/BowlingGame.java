package BG;

import model.FrameSummary;

public class BowlingGame {
    private int totalScore;
    private int frameRemaining;
    private int frameCount;
    private boolean isSpareBonus;
    private boolean isStrikeBonus;
    private FrameSummary[] frameHistory = new FrameSummary[12];

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int value) {
        this.totalScore = value;
    }

    public int getFrameRemaining(){
        return this.frameRemaining;
    }

    public void setFrameRemaining(int value) {
        this.frameRemaining = value;
    }

    public int getFrameCount(){
        return this.frameCount;
    }

    public void setFrameCount(int value) {
        this.frameCount = value;
    }

    public boolean getIsSpareBonus(){
        return this.isSpareBonus;
    }

    public void setIsSpareBonus(boolean value) {
        this.isSpareBonus = value;
    }

    public boolean getIsStrikeBonus(){
        return this.isStrikeBonus;
    }

    public void setIsStrikeBonus(boolean value) {
        this.isSpareBonus = value;
    }


    public BowlingGame(){
        this.totalScore = 0;
        this.frameRemaining = 10;
        this.frameCount = 0;
        this.isSpareBonus = false;
        this.isStrikeBonus = false;
    }
    public void nextFrame(){
        frameRemaining--;
    }

    public void updateFrameHistory(FrameSummary fs){
        frameHistory[frameCount] = fs;
        frameCount++;
    }

    public void bonusCheck(){
       if (frameRemaining == 0 && frameHistory[9].getIsStrike() == true){
           isStrikeBonus = true;
       }

        if (frameRemaining == 0 && frameHistory[9].getIsSpare() == true){
            isSpareBonus = true;
        }
    }

    public void calculateTotalScore(){
        System.out.print("Frame\tscore\tStrike\tSpare\n");
        for(int i=0; i<frameCount; i++){
            FrameSummary frame = frameHistory[i];
            totalScore += frame.getFrameScore();

            if(frame.getIsSpare() == true){
                totalScore += frameHistory[i+1].getFrameScore();
            }

            if(frame.getIsStrike() == true){
                totalScore += frameHistory[i+1].getFrameScore();
                totalScore += frameHistory[i+2].getFrameScore();
            }

            System.out.print(i+1 + "\t\t");

            System.out.print(frame.getFrameScore()+"\t\t");
            if (frame.getIsStrike()){
                System.out.print("yes\t\t");
            }

            if (frame.getIsSpare()){
                System.out.print("yes\t\t");
            }

            System.out.print("\n");
        }
    }
}
