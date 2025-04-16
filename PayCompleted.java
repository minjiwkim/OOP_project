// package org.example;

import javax.swing.*;
import java.awt.*;

public class PayCompleted extends JPanel {
    private JLabel pay_message;
    private JPanel pay_background;
    public PayCompleted() {
        setLayout(null);

        pay_message = new JLabel("<html><body><center>결제가 완료되었습니다<br>감사합니다</center></body></html>");
        pay_message.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        pay_message.setHorizontalAlignment(JLabel.CENTER);

        pay_background = new JPanel();
        pay_background.setLayout(new BorderLayout());
        pay_background.setBackground(Color.WHITE);
        pay_background.setSize(470, 610);
        pay_background.setLocation(0, 0);

        pay_background.add(pay_message, BorderLayout.CENTER);
        add(pay_background);
    }
}
