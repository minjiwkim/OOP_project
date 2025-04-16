// package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectQuantity extends JFrame {
    private static SelectQuantity instance; // 싱글톤 인스턴스

    JFrame jf;
    JPanel left_menu;
    JPanel left_num;
    JPanel left_price;
    JPanel bigJp;
    JPanel NaviBarTopPanel;
    JPanel rightJp;
    JPanel blackJp;
    JPanel whitePanel;

    ImagePanel card;
    JButton pay_button;
    JButton HomeButton;
    JButton ManagerButton;

    JLabel menu;
    JLabel num;
    JLabel price;
    JLabel totalnum;
    JLabel pay;
    JLabel HomeButtonletter;
    JLabel ManagerButtonletter;
    JLabel snowcoffeelabel;
    JLabel FontSize;

    Itemnum itemnum;

    private List<Product> productList;

    private SelectQuantity(String msg, String ProductName) {
        initializeUI(msg, ProductName);
    }

    public static SelectQuantity getInstance(String msg, String ProductName) {
        if (instance == null) {
            instance = new SelectQuantity(msg, ProductName);
        } else {
            instance.jf.setVisible(true);
            instance.updateItem(ProductName);
        }
        return instance;
    }

    private void initializeUI(String msg, String ProductName) {
        // 홈 화면
        jf = new JFrame(msg);
        jf.setSize(500, 800);
        jf.setLayout(null);

        productList = new ArrayList<>();

        // 아이템넘 추가
        itemnum = new Itemnum(ProductName);
        itemnum.setSize(400, 400);
        itemnum.setLocation(50, 200);
        itemnum.setNaviBar(this);
        jf.add(itemnum);

        // 메인 하단 회색 패널
        bigJp = new JPanel();
        bigJp.setLayout(null);
        bigJp.setSize(500, 180);
        bigJp.setBackground(Color.decode("#E8E8E8"));
        bigJp.setLocation(0, 590);

        // 왼쪽 패널 메뉴, 수량, 가격 3개 패널로 쪼개기
        left_menu = new JPanel();
        left_menu.setLayout(new BoxLayout(left_menu, BoxLayout.Y_AXIS));
        left_menu.setSize(150, 160);
        left_menu.setBackground(Color.WHITE);
        left_menu.setLocation(10, 10);

        left_num = new JPanel();
        left_num.setLayout(new BoxLayout(left_num, BoxLayout.Y_AXIS));
        left_num.setSize(80, 160);
        left_num.setBackground(Color.WHITE);
        left_num.setLocation(160, 10);

        left_price = new JPanel();
        left_price.setLayout(new BoxLayout(left_price, BoxLayout.Y_AXIS));
        left_price.setSize(120, 160);
        left_price.setBackground(Color.WHITE);
        left_price.setLocation(240, 10);

        // 1열. 메뉴, 수량, 가격
        menu = new JLabel("메뉴");
        num = new JLabel("수량");
        price = new JLabel("가격");

        Font letterfont = new Font("맑은 고딕", Font.BOLD, 17);
        menu.setFont(letterfont);
        num.setFont(letterfont);
        price.setFont(letterfont);

        left_menu.add(menu);
        left_num.add(num);
        left_price.add(price);

        bigJp.add(left_menu);
        bigJp.add(left_num);
        bigJp.add(left_price);

        // Add bigJp to JFrame
        jf.add(bigJp);

        // 오른쪽 패널 회색
        rightJp = new JPanel();
        rightJp.setLayout(null);
        rightJp.setSize(100, 160);
        rightJp.setBackground(Color.decode("#D9D9D9"));
        rightJp.setLocation(370, 10);

        // 총 수량
        totalnum = new JLabel("총 수량");
        totalnum.setForeground(Color.BLACK);
        Font totalnumfont = new Font("맑은 고딕", Font.BOLD, 16);
        totalnum.setFont(totalnumfont);
        totalnum.setSize(100, 20);
        totalnum.setLocation(15, 5);
        rightJp.add(totalnum);

        // 오른쪽 패널 안에 검은 패널
        blackJp = new JPanel();
        blackJp.setLayout(null);
        blackJp.setSize(100, 130);
        blackJp.setBackground(Color.BLACK);
        blackJp.setLocation(0, 30);

        // 검은 패널 내부 상단 카드 아이콘
        card = new ImagePanel("C:\\OOP\\KioskProject\\img\\card.png");
        card.setSize(80, 80);
        card.setLocation(10, 10);
        card.setBackground(Color.BLACK);
        blackJp.add(card);

        // 검은 패널 내부 하단 '결제하기' 버튼
        pay_button = new JButton("결제하기");
        pay_button.setSize(100, 20);
        pay_button.setLocation(0, 100);
        blackJp.add(pay_button);
        // 결제 완료(PayCompleted) panel 안 보이도록 JFrame에 추가
        PayCompleted pay = new PayCompleted();
        pay.setLocation(10, 150);
        pay.setSize(470, 610);
        pay.setVisible(false);
        jf.add(pay);

        // 결제 완료 panel 보이게 만드는 버튼 설정
        pay_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pay.setVisible(true);
                rightJp.setVisible(false);
                blackJp.setVisible(false);
                itemnum.setVisible(false);
                jf.revalidate();
                jf.repaint();
            }
        });

        rightJp.add(blackJp);
        bigJp.add(rightJp);
        jf.add(bigJp);

        // 상단에 노란 패널
        NaviBarTopPanel = new JPanel();
        NaviBarTopPanel.setBackground(Color.decode("#FFE664"));
        NaviBarTopPanel.setBounds(0, 0, 500, 150);
        NaviBarTopPanel.setLayout(null);
        jf.add(NaviBarTopPanel);

        // 노란 패널 내부 "스노우 커피" 글자 삽입
        snowcoffeelabel = new JLabel("스노우 커피");
        Font panelfont = new Font("맑은 고딕", Font.PLAIN, 50);
        snowcoffeelabel.setFont(panelfont);
        snowcoffeelabel.setBounds(100, 20, 300, 50);
        NaviBarTopPanel.add(snowcoffeelabel);

        // 노란 패널 내부 왼쪽 홈버튼과 "홈버튼" 텍스트
        ImageIcon HomeButtonIcon = new ImageIcon("C:\\OOP\\KioskProject\\img\\HomeButton.png");
        Image HomeButtonimage = HomeButtonIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledHomeButtonIcon = new ImageIcon(HomeButtonimage);

        HomeButton = new JButton(scaledHomeButtonIcon);
        HomeButton.setBounds(20, 20, 50, 50);
        HomeButton.setBackground(Color.decode("#FFE664"));
        HomeButton.setBorder(null);
        NaviBarTopPanel.add(HomeButton);

        HomeButtonletter = new JLabel("홈화면");
        Font HomeButtonletterfont = new Font("맑은 고딕", Font.BOLD, 17);
        HomeButtonletter.setFont(HomeButtonletterfont);
        HomeButtonletter.setBounds(20, 55, 100, 50);
        NaviBarTopPanel.add(HomeButtonletter);

        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NaviBar 인스턴스 생성 및 표시
                CoffeeContentHome gohome = new CoffeeContentHome("스노우 커피 홈 화면");
                gohome.setVisible(true); // 홈창을 보이게 함

                // 현재 창을 숨김 (또는 dispose()를 호출하여 완전히 닫을 수 있음)
                jf.setVisible(false); // 또는 jf.dispose();
            }
        });

        // 노란 패널 내부 오른쪽 관리자 모드 아이콘과 "관리자 모드" 텍스트
        ImageIcon ManagerButtonIcon = new ImageIcon("C:\\OOP\\KioskProject\\img\\manager.png");
        Image ManagerButtonimage = ManagerButtonIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledManagerButtonIcon = new ImageIcon(ManagerButtonimage);

        ManagerButton = new JButton(scaledManagerButtonIcon);
        ManagerButton.setBounds(402, 17, 60, 60);
        ManagerButton.setBackground(Color.decode("#FFE664"));
        ManagerButton.setBorder(null);
        NaviBarTopPanel.add(ManagerButton);

        ManagerButtonletter = new JLabel("관리자");
        Font ManagerButtonletterfont = new Font("맑은 고딕", Font.BOLD, 18);
        ManagerButtonletter.setFont(ManagerButtonletterfont);
        ManagerButtonletter.setBounds(405, 63, 100, 50);
        NaviBarTopPanel.add(ManagerButtonletter);

        // 관리자 모드 버튼 이벤트
        ManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NaviBar 인스턴스 생성 및 표시
                ManagerPage m = new ManagerPage("관리자 창");
                m.setVisible(true); // 홈창을 보이게 함

                // 현재 창을 숨김 (또는 dispose()를 호출하여 완전히 닫을 수 있음)
                jf.setVisible(false); // 또는 jf.dispose();
            }
        });

        // 패널 내의 모든 글씨 크기 조절
        FontSizeAdjuster fontSizeAdjuster = new FontSizeAdjuster(jf.getContentPane());
        fontSizeAdjuster.setBounds(410, 110, 120, 60);
        jf.add(fontSizeAdjuster);

        // "글씨 크기" 텍스트
        FontSize = new JLabel("글씨 크기");
        Font FontSizefont = new Font("맑은 고딕", Font.BOLD, 18);
        FontSize.setFont(FontSizefont);
        FontSize.setBounds(320, 102, 150, 50);
        NaviBarTopPanel.add(FontSize);

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setLayout(null);
        whitePanel.setBounds(312, 110, 170, 35);
        NaviBarTopPanel.add(whitePanel);

        jf.setVisible(true);
    }

    private void updateItem(String productName) {
        jf.remove(itemnum); // 기존 itemnum 제거
        itemnum = new Itemnum(productName); // 새로운 itemnum 생성
        itemnum.setSize(400, 400);
        itemnum.setLocation(50, 200);
        itemnum.setNaviBar(this);
        jf.add(itemnum);
        jf.revalidate();
        jf.repaint();
    }

    public void addProduct(Product product) {
        boolean found = false;

        // 기존 제품 업데이트 또는 새 제품 추가
        for (Product p : productList) {
            if (p.getName().equals(product.getName())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                p.setPrice(p.getPrice() + product.getPrice());
                found = true;
                break;
            }
        }

        if (!found) {
            productList.add(product);
        }

        updateUI();
    }

    private void updateUI() {
        left_menu.removeAll();
        left_num.removeAll();
        left_price.removeAll();

        for (Product product : productList) {
            JLabel menuLabel = new JLabel(product.getName());
            JLabel quantityLabel = new JLabel(Integer.toString(product.getQuantity()));
            JLabel priceLabel = new JLabel(Integer.toString(product.getPrice()));

            JPanel menuPanel = new JPanel();
            menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
            menuPanel.add(menuLabel);

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.Y_AXIS));
            quantityPanel.add(quantityLabel);

            JPanel pricePanel = new JPanel();
            pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));
            pricePanel.add(priceLabel);

            left_menu.add(menuPanel);
            left_num.add(quantityPanel);
            left_price.add(pricePanel);
        }

        left_menu.revalidate();
        left_menu.repaint();
        left_num.revalidate();
        left_num.repaint();
        left_price.revalidate();
        left_price.repaint();
    }
}




