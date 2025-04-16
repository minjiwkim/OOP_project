// package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DecafContentHome extends JFrame {

    JFrame jf;

    LeftJp left_menu;
    LeftJp left_num;
    LeftJp left_price;

    JPanel bigJp;
    JPanel NaviBarTopPanel;
    JPanel rightJp;
    JPanel blackJp;
    JPanel whitePanel;
    JPanel categoryPanel;
    JPanel decafJP;
    JScrollPane scrollPane;

    ImagePanel card;

    JButton pay_button;
    JButton HomeButton;
    JButton ManagerButton;
    JButton coffeeButton;
    JButton decafButton;
    JButton beverageButton;
    JButton sugarButton;

    JLabel menu;
    JLabel num;
    JLabel price;
    JLabel totalnum;
    JLabel pay;
    JLabel HomeButtonletter;
    JLabel ManagerButtonletter;
    JLabel snowcoffeelabel;
    JLabel FontSize;
    JLabel firstLevel;
    JLabel secondLevel;
    JLabel thirdLevel;
    JLabel c1,c2,c3,c4,c5,c6,c7,c8,c9;

    // 기본 생성자
    public DecafContentHome() {
        this("디카페인");
    }

    // 파라미터를 받는 생성자
    public DecafContentHome(String msg) {
        // 홈 화면 설정
        jf = new JFrame(msg);
        jf.setSize(500, 800);
        jf.setLayout(null);

        // 메인 하단 회색 패널
        bigJp = new JPanel();
        bigJp.setLayout(null);
        bigJp.setSize(500, 180);
        bigJp.setBackground(Color.decode("#E8E8E8"));
        bigJp.setLocation(0, 590);

        // 왼쪽 패널 설정
        left_menu = new LeftJp();
        left_menu.setSize(150, 160);
        left_menu.setBackground(Color.WHITE);
        left_menu.setLocation(10, 10);

        left_num = new LeftJp();
        left_num.setSize(80, 160);
        left_num.setBackground(Color.WHITE);
        left_num.setLocation(160, 10);

        left_price = new LeftJp();
        left_price.setSize(120, 160);
        left_price.setBackground(Color.WHITE);
        left_price.setLocation(240, 10);

        // 레이블 설정
        menu = new JLabel("메뉴");
        num = new JLabel("수량");
        price = new JLabel("가격");

        Font letterfont = new Font("맑은 고딕", Font.BOLD, 17);
        menu.setFont(letterfont);
        num.setFont(letterfont);
        price.setFont(letterfont);

        left_menu.add(menu, BorderLayout.CENTER);
        left_num.add(num, BorderLayout.CENTER);
        left_price.add(price, BorderLayout.CENTER);

        // 오른쪽 패널 설정
        rightJp = new JPanel();
        rightJp.setLayout(null);
        rightJp.setSize(100, 160);
        rightJp.setBackground(Color.decode("#D9D9D9"));
        rightJp.setLocation(370, 10);

        totalnum = new JLabel("총 수량");
        totalnum.setForeground(Color.BLACK);
        Font totalnumfont = new Font("맑은 고딕", Font.BOLD, 16);
        totalnum.setFont(totalnumfont);
        totalnum.setSize(100, 20);
        totalnum.setLocation(15, 5);
        rightJp.add(totalnum);

        // 검은 패널 설정
        blackJp = new JPanel();
        blackJp.setLayout(null);
        blackJp.setSize(100, 130);
        blackJp.setBackground(Color.BLACK);
        blackJp.setLocation(0, 30);

        card = new ImagePanel("C:\\OOP\\KioskProject\\img\\card.png");
        card.setSize(80, 80);
        card.setLocation(10, 10);
        card.setBackground(Color.BLACK);
        blackJp.add(card);

        pay_button = new JButton("결제하기");
        pay_button.setSize(100, 20);
        pay_button.setLocation(0, 100);

        blackJp.add(pay_button);
        bigJp.add(left_menu);
        bigJp.add(left_num);
        bigJp.add(left_price);
        rightJp.add(blackJp);
        bigJp.add(rightJp);
        jf.add(bigJp);

        // 상단 노란 패널 설정
        NaviBarTopPanel = new JPanel();
        NaviBarTopPanel.setBackground(Color.decode("#FFE664"));
        NaviBarTopPanel.setBounds(0, 0, 500, 150);
        NaviBarTopPanel.setLayout(null);
        jf.add(NaviBarTopPanel);

        snowcoffeelabel = new JLabel("스노우 커피");
        Font panelfont = new Font("맑은 고딕", Font.PLAIN, 50);
        snowcoffeelabel.setFont(panelfont);
        snowcoffeelabel.setBounds(100, 20, 300, 50);
        NaviBarTopPanel.add(snowcoffeelabel);

        HomeButton = new ImageButton("C:\\OOP\\KioskProject\\img\\HomeButton.png");
        HomeButton.setBounds(20, 20, 50, 50);
        HomeButton.setBackground(Color.decode("#FFE664"));
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

        // 카테고리 패널 설정
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(1, 4)); // 1행 4열 그리드 레이아웃
        categoryPanel.setBounds(0, 150, 490, 60); // 위치와 크기 설정
        jf.add(categoryPanel);

        // 각 카테고리 버튼 생성 및 추가
        coffeeButton = createButton("커피");
        decafButton = createButton("디카페인");
        beverageButton = createButton("음료");
        sugarButton = createButton("당류 함량");

        categoryPanel.add(coffeeButton);
        categoryPanel.add(decafButton);
        categoryPanel.add(beverageButton);
        categoryPanel.add(sugarButton);

        //상품
        // 1행 패널
        decafJP = new JPanel();
        decafJP.setLayout(new GridLayout(1,3));//1행 3열

        decafJP.setBounds(0,210,490,126);
        jf.add(decafJP);

        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\딸기딜라이트요거트블렌디드.jpg", "딸기요거트블렌디드"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\망고바나나블랜디드.jpg", "망고바나나블랜디드"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\복숭아아이스티.jpg", "복숭아아이스티"));

        // 2행 패널
        decafJP = new JPanel();
        decafJP.setLayout(new GridLayout(1,3));//1행 3열
        decafJP.setBounds(0,336,490,126);
        jf.add(decafJP);

        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\망고주스.jpg", "망고주스"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\한라봉주스.jpg", "한라봉주스"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\쿨라임피지오.jpg", "쿨라임피지오"));

        // 3행 패널
        decafJP = new JPanel();
        decafJP.setLayout(new GridLayout(1,3));//1행 3열
        decafJP.setBounds(0,462,490,126);
        jf.add(decafJP);

        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\유스베리티.jpg", "유스베리티"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\유자민트티.jpg", "유자민트티"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\얼그레이티.jpg", "얼그레이티"));

        //4행 패널
        decafJP = new JPanel();
        decafJP.setLayout(new GridLayout(1,3));//1행 3열
        decafJP.setBounds(0,585,490,126);
        jf.add(decafJP);

        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\아이스유스베리티.jpg", "아이스유스베리티"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\아이스유자민트티.jpg", "아이스유자민트티"));
        decafJP.add(createImagePanelWithText("C:\\OOP\\KioskProject\\img\\아이스얼그레이티.jpg", "아이스얼그레이티"));

        jf.add(decafJP);

        // 스크롤 패널 설정
        scrollPane = new JScrollPane(decafJP);
        scrollPane.setBounds(0, 210, 500, 380);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 수평 스크롤 막기
        jf.add(scrollPane);

        // "커피" 버튼에 ActionListener 추가
        coffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // CoffeeContentHome 창을 열기
                CoffeeContentHome coffeeContentHome = new CoffeeContentHome();
                coffeeContentHome.setVisible(true); // 화면에 표시
            }
        });

        // "디카페인" 버튼에 ActionListener 추가
        decafButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // DecafContentHome 창을 열기
                DecafContentHome decafContentHome = new DecafContentHome();
                decafContentHome.setVisible(true); // 화면에 표시
            }
        });

        // "음료" 버튼에 ActionListener 추가
        beverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // BeverageContentHome 창을 열기
                BeverageContentHome beverageContentHome = new BeverageContentHome();
                beverageContentHome.setVisible(true); // 화면에 표시
            }
        });

        // "당류 함량" 버튼에 ActionListener 추가
        sugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SugarContentHome 창을 열기
                SugarContentHome sugarContentHome = new SugarContentHome();
                sugarContentHome.setVisible(true); // 화면에 표시
            }
        });

        jf.setVisible(true);
    }

    // Helper method for button creation
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        if (label.equals("디카페인")) {
            button.setBackground(Color.decode("#E8E8E8")); // 디카페인 버튼의 배경색을 회색으로 설정
        } else {
            button.setBackground(Color.ORANGE); // 다른 버튼의 배경색을 주황색으로 설정
        }
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // 하얀색 얇은 테두리 설정
        return button;
    }

    private JPanel createImagePanelWithText(String imgPath, String text) {
        JPanel panel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon, SwingConstants.CENTER);
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        textLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.SOUTH);

        // 마우스 리스너 추가
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 이미지가 아메리카노인 경우 SelectQuantity 창 열기
                if (imgPath.contains("망고주스")) {
                    openNaviBar1("망고주스");
                }
                else if(imgPath.contains("딸기딜라이트요거트블렌디드")) {
                    openNaviBar1("딸기딜라이트요거트블렌디드");
                }
            }
        });
        return panel;
    }


    private void openNaviBar1(String productName) {
        // 상품명을 인자로 받아 SelectQuantity 인스턴스 생성 및 표시
        SelectQuantity selectQuantity = SelectQuantity.getInstance("수량", productName);
        selectQuantity.setVisible(true);
    }


    public class ImageButton extends JButton {
        private Image image;

        public ImageButton(String imgPath) {
            this.image = new ImageIcon(imgPath).getImage();
            setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
            setContentAreaFilled(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
