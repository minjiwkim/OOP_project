// package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FontSizeAdjuster extends JPanel {
    private JButton upButton;
    private JButton downButton;
    private static final int MAX_ADJUSTMENT = 4;
    private static final int MIN_ADJUSTMENT = -4;
    private Map<Component, Integer> baseFontSizes;

    public FontSizeAdjuster(Container container) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        baseFontSizes = new HashMap<>();
        storeBaseFontSizes(container);

        // 글씨 크기 키우는 버튼 생성
        ImageIcon upButtonIcon = new ImageIcon("C:\\OOP\\KioskProject\\img\\upButton.png");
        Image upButtonImage = upButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledUpButtonIcon = new ImageIcon(upButtonImage);

        upButton = new JButton(scaledUpButtonIcon);
        upButton.setPreferredSize(new Dimension(25, 25));
        upButton.setBorder(null);
        upButton.setBackground(Color.WHITE);

        // 글씨 크기 줄이는 버튼 생성
        ImageIcon downButtonIcon = new ImageIcon("C:\\OOP\\KioskProject\\img\\downButton.png");
        Image downButtonImage = downButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledDownButtonIcon = new ImageIcon(downButtonImage);

        downButton = new JButton(scaledDownButtonIcon);
        downButton.setPreferredSize(new Dimension(25, 25));
        downButton.setBorder(null);
        downButton.setBackground(Color.WHITE);

        // 버튼 리스너 추가
        upButton.addActionListener(new FontSizeChanger(2, container)); // 폰트 크기 2 증가
        downButton.addActionListener(new FontSizeChanger(-2, container)); // 폰트 크기 2 감소

        // 패널에 버튼 추가
        add(upButton);
        add(downButton);
    }

    private void storeBaseFontSizes(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JLabel || component instanceof JButton) {
                Font font = component.getFont();
                baseFontSizes.put(component, font.getSize());
            } else if (component instanceof Container) {
                storeBaseFontSizes((Container) component); // 재귀적으로 모든 컨테이너 탐색
            }
        }
    }

    private class FontSizeChanger implements ActionListener {
        private int change;
        private Container container;

        public FontSizeChanger(int change, Container container) {
            this.change = change;
            this.container = container;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            adjustFontSize(container);
        }

        private void adjustFontSize(Container container) {
            for (Component component : container.getComponents()) {
                if (component instanceof JLabel) {
                    adjustComponentFont((JLabel) component);
                } else if (component instanceof JButton) {
                    adjustComponentFont((JButton) component);
                } else if (component instanceof Container) {
                    adjustFontSize((Container) component); // 재귀적으로 모든 컨테이너 탐색
                }
            }
        }

        private void adjustComponentFont(JComponent component) {
            Font currentFont = component.getFont();
            Integer baseSize = baseFontSizes.get(component);

            // baseSize가 null인 경우 기본값 설정
            if (baseSize == null) {
                baseSize = currentFont.getSize();
                baseFontSizes.put(component, baseSize);
            }

            int newSize = currentFont.getSize() + change;

            // 폰트 크기를 기존 크기에서 최대 +4, 최소 -4로 제한
            if (newSize > baseSize + MAX_ADJUSTMENT) {
                newSize = baseSize + MAX_ADJUSTMENT;
            } else if (newSize < baseSize + MIN_ADJUSTMENT) {
                newSize = baseSize + MIN_ADJUSTMENT;
            }

            component.setFont(new Font(currentFont.getName(), currentFont.getStyle(), newSize));
        }
    }
}
