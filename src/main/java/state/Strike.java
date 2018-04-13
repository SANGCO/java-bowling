package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;

public class Strike implements State {

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
		frameInfo.setFirstRoll(new Pins(10));
		return frameInfo;
	}
	
	@Override
	public TotalScore getTotalScore() {
		return new TotalScore(Pins.MAX, 2);
	}
	
	@Override
	public TotalScore addNextFrameScore(TotalScore totalScore) {
		totalScore = totalScore.addRoll(Pins.MAX);
		
		if (totalScore.canCalculateScore()) {
			return totalScore;
		}
		return totalScore;
	}

	@Override
	public boolean isFrameEnd() {
		return true;
	}

}
