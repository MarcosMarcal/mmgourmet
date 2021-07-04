package com.mmarcalm.tools;

import javax.swing.*;

/**
 *  Class responsible for displaying the specific dialog for each invocation.
 *
 * @author  Marçal, Marcos
 * @version 1.0
 * @since   2021-07-04
 */
public class Message {

    private Message() {}

    /**
     * This is the method which rise up the initial dialog.
     * @return int Return tap on OK button.
     */
    public static int showStart(String title, String text) {

        var frame = new JFrame();
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(frame, text, title, JOptionPane.YES_NO_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    public static int showBinary(String text, String currentValue) {

        Object[] options = {"Sim", "Não"};
        var frame = new JFrame();
        return JOptionPane.showOptionDialog(frame, text, "Comfirme",
                                 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    public static Object showInput(String title, String text) {

        var frame = new JFrame();
        return JOptionPane.showInputDialog(frame, text, title, JOptionPane.QUESTION_MESSAGE, null, null, null);

    }

    public static int showCorrectAnswer(String text) {

        var frame = new JFrame();
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(frame, text, "MM Gourmet", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

}
