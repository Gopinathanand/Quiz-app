package com.example.gopinath.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.gopinath.quiz.R.id.true_button;

public class MainActivity extends Activity {


    // TODO: Declare member variables here:
    Button mTruebutton;
    Button mFalsebutton = (Button) findViewById(R.id.false_button);
    TextView mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
    int mindex;
    int mquestion;
    TextView mScoreView = (TextView) findViewById(R.id.score);
    ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    int mscore;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int  Pro_inc =(int) Math.ceil(100.0 / mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTruebutton = (Button) findViewById(true_button);

        mquestion = mQuestionBank[mindex].getmQuestionId();
        mQuestionTextView.setText(mquestion);

        mTruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(true);
                updateQuestion();
            }
        });

        mFalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(false);
                updateQuestion();
            }
        });

        TrueFalse exampleQuestion = new TrueFalse(R.string.question_1, true);

        Random randomNumberGenerator = new Random();
    }

    private void updateQuestion(){

        mindex = (mindex + 1) % mQuestionBank.length;

        if (mindex == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You Scored" + mscore + "Points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
        mquestion = mQuestionBank[mindex].getmQuestionId();
        mQuestionTextView.setText(mquestion);
        mScoreView.setText("Score" + mscore + "/" + mQuestionBank.length);
        mProgressBar.incrementProgressBy(Pro_inc);
    }

    private void CheckAnswer(Boolean userselection){
        boolean correctAnswer = mQuestionBank[mindex].getmAnswer();

        if (userselection == correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        } else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
}
