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
    public static int showStart() {

        var text = "Pense em um prato que gosta";
        var frame = new JFrame();
        Object[] options = {"Ok"};

        return JOptionPane.showOptionDialog(frame, text, "MM Gourmet", JOptionPane.YES_NO_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    public static int showBinary(int yes, int no) {

        Object[] options = {"Sim", "Não"};

        var text = "Qual opção...";
        var frame = new JFrame();

        int choice = JOptionPane.showOptionDialog(frame, text, "MM",
                       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        return choice;
    }

    public static Object showInput(int param) {

        // TODO: 04/07/2021 Alterar o label deste pop-up, pois está em inglês...

        var text = "Qual nome dessa comida";
        var frame = new JFrame();

        Object answer = JOptionPane.showInputDialog(frame, text, "Desisto", JOptionPane.QUESTION_MESSAGE, null, null, null);

        return answer;
    }

}
