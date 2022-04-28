package model;

import BG.Game;

public class FrameSummary {
    private int frameScore;
    private boolean isSpare;
    private boolean isStrike;

    public FrameSummary(Game f){
        this.frameScore = f.getFrameScore();
        this.isSpare = f.getIsSpare();
        this.isStrike = f.getIsStrike();
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int value) {
        this.frameScore = value;
    }

    public boolean getIsSpare() {
        return isSpare;
    }

    public void setIsSpare(boolean value) {
        this.isSpare = value;
    }

    public boolean getIsStrike() {
        return isStrike;
    }
    public void setIsStrike(boolean value) {
        this.isStrike = value;
    }
}
