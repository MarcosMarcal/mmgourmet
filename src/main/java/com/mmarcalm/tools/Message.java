package com.mmarcalm.tools;

import javax.swing.*;

/**
 *  Class responsible for displaying the specific dialog for each invocation.
 *
 * @author  Marçal, Marcos
 * @version 1.0
 * @since   2021-07-04
 */

public abstract class Message {

    /** Representation of binary dialogue responses. */
    public static final int YES = 0;

    /** Representation of binary dialogue responses. */
    public static final int NO = 1;

    /** Representation of binary dialogue responses. */
    public static final int CLOSE = -1;

    /**
     * This is the method that presents an informative dialog.
     * @return int Return tap on OK button.
     */
    protected int showInfoDialog(String title, String text) {

        var frame = new JFrame();
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(frame, text, title, JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    /**
     * This is the method that presents a binary question.
     * @return int - Returns 0 when "yes", returns 1 when "no" and returns -1 when closes dialog.
     */
    protected int showBinary(String title, String text) {

        var frame = new JFrame();
        Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(frame, text, title,
                                 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    /**
     * This is the method that presents a text box for response.
     * @return String - Returns the answer typed in the box.
     */
    protected Object showInput(String title, String text) {

        var frame = new JFrame();
        return JOptionPane.showInputDialog(frame, text, title, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

}
