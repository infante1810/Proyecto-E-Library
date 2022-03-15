/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComboBoxCustom;
import javax.swing.JComboBox;

public class ComboBoxSugestion<E> extends JComboBox<E> {

    public ComboBoxSugestion() {
        setUI(new ComboBoxCustom());
    }
}
