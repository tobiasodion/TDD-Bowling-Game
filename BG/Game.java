package BG;

public class Game {
    private int remainingTry;
    private int knockedPins;
    private int remainingPins;
    private int frameScore;
    private boolean isStrike;
    private boolean isSpare;

    public int getRemainingTry(){
        return this.remainingTry;
    }

    public void setRemainingTry(int value){
        this.remainingTry = value;
    }

    public int getKnockedPins(){
        return this.knockedPins;
    }

    public void setKnockedPins(int value){
        this.knockedPins = value;
    }

    public int getRemainingPins(){
        return this.remainingPins;
    }

    public void setRemainingPins(int value){
        this.remainingPins = value;
    }

    public int getFrameScore(){
       return this.knockedPins;
    }

    public void setFrameScore(int value){
        this.frameScore = value;
    }

    public boolean getIsStrike(){
        return this.isStrike;
    }

    public void setIsStrike(boolean value){
        this.isStrike = value;
    }

    public boolean getIsSpare(){
        return this.isSpare;
    }

    public void setIsSpare(boolean value){
        this.isSpare = value;
    }

    public Game(){
        this.remainingTry = 2;
        this.knockedPins = 0;
        this.remainingPins = 10;
        this.frameScore = 0;
        this.isStrike = false;
        this.isSpare = false;
    }

    public void roll(){
        if(isStrike != true){
            knockedPins += Utility.getRandomNumber(1, remainingPins);
            remainingPins = 10 - knockedPins;
            remainingTry--;
        }
    }

    public void strikeSpareCheck(){
        if((knockedPins == 10) && (remainingTry == 1)){
            isStrike = true;
        }

        if((knockedPins == 10) && (remainingTry == 0)){
            isSpare = true;
        }
    }

    public void score(){
        if(isStrike || isSpare){
            frameScore = 10;
        }
        else{
            frameScore = knockedPins;
        }
    }
}
