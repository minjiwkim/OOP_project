// package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Itemnum extends JPanel {
    private JButton plusButton, minusButton, orderButton;
    private JLabel quantityLabel;
    private int quantity = 0;
    private int price = 0;
    private String productName; // 상품명 필드 추가

    private SelectQuantity select;

    public Itemnum(String productName) {
        this.productName = productName; // 생성자에서 상품명 설정
        setLayout(new BorderLayout());

        // 이미지 설정
        ImageIcon productIcon = getProductIcon(productName);
        Image productImage = productIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledProductIcon = new ImageIcon(productImage);
        JLabel productLabel = new JLabel(scaledProductIcon);

        JPanel imagePanel = new JPanel();
        imagePanel.add(productLabel);

        // 수량 조절 버튼 패널
        minusButton = new JButton("-");
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (quantity > 0) {
                    quantity--;
                    updatePrice();
                }
            }
        });

        quantityLabel = new JLabel(Integer.toString(quantity));

        plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quantity++;
                updatePrice();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(minusButton);
        buttonPanel.add(quantityLabel);
        buttonPanel.add(plusButton);

        // 주문 담기 버튼
        orderButton = new JButton("주문 담기");
        orderButton.setEnabled(false);
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProductInfo(); // 주문 담기 버튼 클릭 시 제품 정보를 추가하는 메서드 호출
            }
        });

        // 제품 정보와 주문 버튼을 담은 패널
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(buttonPanel, BorderLayout.CENTER);
        controlPanel.add(orderButton, BorderLayout.SOUTH);

        add(imagePanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);

        updatePrice(); // 초기 가격 설정
    }

    // 상품명에 따른 아이콘 반환 메서드
    private ImageIcon getProductIcon(String productName) {
        String imagePathPng = "C:\\OOP\\KioskProject\\img\\" + productName + ".png";
        String imagePathJpg = "C:\\OOP\\KioskProject\\img\\" + productName + ".jpg";

        // 먼저 PNG 이미지가 있는지 확인 후 반환
        File filePng = new File(imagePathPng);
        if (filePng.exists()) {
            return new ImageIcon(imagePathPng);
        }

        // PNG 이미지가 없으면 JPG 이미지 반환
        File fileJpg = new File(imagePathJpg);
        if (fileJpg.exists()) {
            return new ImageIcon(imagePathJpg);
        }

        // 기본적으로 아이콘이 없을 경우 null 반환 또는 기본 아이콘 등을 처리할 수 있습니다.
        return null;
    }

    // NaviBar1 객체 설정
    public void setNaviBar(SelectQuantity select) {
        this.select = select;
    }


    private void updatePrice() {
        // 상품명에 따른 가격 설정 (임의의 예시)
        switch (productName) {
            case "아메리카노":
                price = quantity * 3000; // 가격은 임의로 설정
                break;
            case "카푸치노":
                price = quantity * 3500; // 다른 상품에 대한 가격 설정 예시
                break;
            case "복숭아아이스티":
                price = quantity * 3500; // 다른 상품에 대한 가격 설정 예시
                break;
            case "쿨라임피지오":
                price = quantity * 5500; // 다른 상품에 대한 가격 설정 예시
                break;
            case "딸기딜라이트요거트블렌디드":
                price = quantity * 6000; // 다른 상품에 대한 가격 설정 예시
                break;
            case "망고주스":
                price = quantity * 6000; // 다른 상품에 대한 가격 설정 예시
                break;
        }

        quantityLabel.setText(Integer.toString(quantity));
        orderButton.setEnabled(quantity > 0); // 주문 수량이 0 이상일 때 주문 담기 버튼 활성화
    }

    private void addProductInfo() {
        if (select != null) {
            Product product = new Product(0, productName, quantity, price); // 임시로 ID를 0으로 설정
            select.addProduct(product);
        } else {
            System.out.println("SelectQuantity object is null.");
        }

        resetOrder();
    }

    private void resetOrder() {
        quantity = 0;
        updatePrice();
    }
}
