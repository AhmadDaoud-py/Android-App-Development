package com.example.accountapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.accountapp.R;
import com.example.accountapp.logic.Logic;
import com.example.accountapp.logic.LogicInterface;

/**
 * Main UI for the App.
 */
public class MainActivity
        extends AppCompatActivity
        implements OutputInterface {

    /**
     * String for LOGGING.
     */
    private final static String LOG_TAG =
            MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * EditText that stores the output.
     */
    private TextView mOutput;

    /**
     * Button the user presses to perform the computation.
     */
    private Button mProcessButton;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components.
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Initialize the views.
        mOutput = findViewById(R.id.outputET);
        mProcessButton = findViewById(R.id.button);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process();
    }

    /**
     * Add @a string to the EditText.
     */
    private void addToEditText(String string){
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * Reset the on-screen output (EditText box).
     */
    @Override
    public void resetText() {
        mOutput.setText("");
    }

    /**
     * Prints the string representation of the passed Java Object or primitive type.
     *
     * @param obj a String, int, double, float, boolean or any Java Object.
     */
    @Override
    public void print(Object obj) {
        String text = (obj != null ? obj.toString() : "null");
        addToEditText(text);
        String debug = text.replace("\n", "\\n");
        Log.d(LOG_TAG, "print(" + debug + ")");
    }

    /**
     * Allow Logic to print Log statements without requiring
     * dependency.
     */
    @Override
    public void log(String logtext) {
        Log.d(Logic.TAG, logtext);
    }
}
