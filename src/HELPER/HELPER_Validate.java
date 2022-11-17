/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

/**
 *
 * @author CherryCe
 */
public class HELPER_Validate {

    public static void validateString(javax.swing.JTextField txt) {
        txt.setText(txt.getText().replaceAll("[1234567890[*/+-]]", ""));
    }

    public static void validateNumber(javax.swing.JTextField txt) {
        txt.setText(txt.getText().replaceAll("[abcdefghijklmnopqrstuvwxyz[*/-]]", ""));
    }
}
