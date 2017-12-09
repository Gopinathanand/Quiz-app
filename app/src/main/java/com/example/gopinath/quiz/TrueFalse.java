package com.example.gopinath.quiz;

/**
 * Created by Gopinath on 09-12-2017.
 */

public class TrueFalse {
    private int mQuestionId;
    private Boolean mAnswer;

    public TrueFalse(int questionResourceId, Boolean trueorfalse){
        mQuestionId = questionResourceId;
        mAnswer = trueorfalse;
    }

    public int getmQuestionId() {
        return mQuestionId;
    }

    public void setmQuestionId(int mQuestionId) {
        this.mQuestionId = mQuestionId;
    }

    public Boolean getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(Boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
