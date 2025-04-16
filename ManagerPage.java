// package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class ManagerPage extends JFrame {

    JFrame jf;

    JPanel NaviBarTopPanel;
    JPanel categoryPanel;
    JPanel SellSoldOutSelect;
    JPanel ProductPanel;
    JPanel StatusPanel;
    JPanel ContourPanel;

    JButton BackButton;
    JButton coffeeButton;
    JButton decafButton;
    JButton beverageButton;

    JLabel BackButtonletter;
    JLabel snowcoffeelabel;
    JLabel productlabel;
    JLabel statuslabel;
    JLabel drinkLabel;

    // 클릭 상태를 저장할 변수들
    boolean isSellClicked = false;
    boolean isSoldOutClicked = false;

    // 기본 생성자
    public ManagerPage() {
        this("관리자 창");
    }

    // 파라미터를 받는 생성자
    public ManagerPage(String msg) {

        // 홈 화면 설정
        jf = new JFrame(msg);
        jf.setSize(500, 800);
        jf.setLayout(null);

        // 상단 노란 패널 설정
        NaviBarTopPanel = new JPanel();
        NaviBarTopPanel.setBackground(Color.decode("#FFE664"));
        NaviBarTopPanel.setBounds(0, 0, 500, 100);
        NaviBarTopPanel.setLayout(null);
        jf.add(NaviBarTopPanel);

        snowcoffeelabel = new JLabel("스노우 커피");
        Font panelfont = new Font("맑은 고딕", Font.PLAIN, 50);
        snowcoffeelabel.setFont(panelfont);
        snowcoffeelabel.setBounds(100, 20, 300, 50);
        NaviBarTopPanel.add(snowcoffeelabel);

        // 홈화면으로 돌아가기 버튼
        BackButton = new ImageButton(".C:\\OOP\\KioskProject\\img\\BackButton.png");
        BackButton.setBounds(410, 15, 50, 50);
        BackButton.setBackground(Color.decode("#FFE664"));
        NaviBarTopPanel.add(BackButton);

        BackButtonletter = new JLabel("돌아가기");
        Font BackButtonletterfont = new Font("맑은 고딕", Font.BOLD, 17);
        BackButtonletter.setFont(BackButtonletterfont);
        BackButtonletter.setBounds(400, 50, 100, 50);
        NaviBarTopPanel.add(BackButtonletter);

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NaviBar 인스턴스 생성 및 표시
                CoffeeContentHome gohome = new CoffeeContentHome("스노우 커피 홈 화면");
                gohome.setVisible(true); // 홈창을 보이게 함

                // 현재 창을 숨김 (또는 dispose()를 호출하여 완전히 닫을 수 있음)
                jf.setVisible(false); // 또는 jf.dispose();
            }
        });

        // 카테고리 패널 설정
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(1, 3)); // 1행 3열 그리드 레이아웃
        categoryPanel.setBounds(0, 100, 490, 60); // 위치와 크기 설정
        jf.add(categoryPanel);

        // 각 카테고리 버튼 생성 및 추가
        coffeeButton = createButton("커피");
        decafButton = createButton("디카페인");
        beverageButton = createButton("음료");

        categoryPanel.add(coffeeButton);
        categoryPanel.add(decafButton);
        categoryPanel.add(beverageButton);

        // 구분선 패널
        ContourPanel = new JPanel();
        ContourPanel.setBackground(Color.BLACK);
        ContourPanel.setBounds(0, 160, 490, 2);
        ContourPanel.setLayout(null);
        jf.add(ContourPanel);

        // 관리자 페이지 "제품명" 패널
        ProductPanel = new JPanel();
        ProductPanel.setBackground(Color.LIGHT_GRAY);
        ProductPanel.setBounds(0, 162, 245, 38);
        ProductPanel.setBorder(new LineBorder(Color.WHITE));
        ProductPanel.setLayout(null);
        jf.add(ProductPanel);

        productlabel = new JLabel("제품명");
        Font productFont = new Font("맑은 고딕", Font.BOLD, 15);
        productlabel.setFont(productFont);
        productlabel.setBounds(100, 3, 50, 30);
        ProductPanel.add(productlabel);

        // 관리자 페이지 "상태" 패널
        StatusPanel = new JPanel();
        StatusPanel.setBackground(Color.LIGHT_GRAY);
        StatusPanel.setBounds(245, 162, 245, 38);
        StatusPanel.setBorder(new LineBorder(Color.WHITE));
        StatusPanel.setLayout(null);
        jf.add(StatusPanel);

        statuslabel = new JLabel("상태");
        Font statusFont = new Font("맑은 고딕", Font.BOLD, 15);
        statuslabel.setFont(statusFont);
        statuslabel.setBounds(110, 3, 30, 30);
        StatusPanel.add(statuslabel);

        // 판매 or 품절 표시 선택 레이블
        SellSoldOutSelect = new JPanel();
        SellSoldOutSelect.setLayout(new GridBagLayout());//9행 3열 그리드
        SellSoldOutSelect.setBounds(0,200,490,400);
        jf.add(SellSoldOutSelect);

        // 음료 이름 배열
        String[] drinks = {
                "아메리카노", "라벤더라떼", "바닐라더블", "바닐라라떼", "사케라또",
                "카라멜 마키아또", "카페라떼", "카페모카", "카푸치노"
        };

        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;

        // 각 행에 음료 이름과 버튼 추가
        for (String drink : drinks) {
            JLabel drinkName = new JLabel(drink, SwingConstants.CENTER);
            Font drinknameFont = new Font("맑은 고딕", Font.BOLD, 15);
            drinkName.setFont(drinknameFont);
            g.gridx = 0;
            g.weightx = 1.0;
            g.weighty = 1.0;
            SellSoldOutSelect.add(drinkName, g);

            // "판매" 버튼 생성
            JButton sellButton = new JButton("판매");
            sellButton.setBackground(Color.WHITE);
            g.gridx = 1;
            g.weightx = 0.5;
            sellButton.setBorder(new LineBorder(Color.WHITE, 2));
            SellSoldOutSelect.add(sellButton, g);

            // "품절" 버튼 생성
            JButton soldOutButton = new JButton("품절");
            soldOutButton.setBackground(Color.WHITE);
            g.gridx = 2;
            g.weightx = 0.5;
            soldOutButton.setBorder(new LineBorder(Color.WHITE, 2));
            SellSoldOutSelect.add(soldOutButton, g);

            // "판매" 버튼 클릭 처리
            sellButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isSellClicked = true; // 클릭 상태 저장
                    sellButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2)); // 테두리 색상 변경
                    soldOutButton.setBorder(null); // 다른 버튼의 테두리 초기화
                }
            });

            // "품절" 버튼 클릭 처리
            soldOutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean isSoldOutClicked = true; // 클릭 상태 저장
                    soldOutButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2)); // 테두리 색상 변경
                    sellButton.setBorder(null); // 다른 버튼의 테두리 초기화
                }
            });
        }

        // 나중에 클릭 상태를 확인할 수 있습니다
        // 예를 들어, 다른 곳에서 사용할 때:
        if (isSellClicked) {
            // "판매" 버튼이 클릭되었을 때의 동작
        }

        if (isSoldOutClicked) {
            // "품절" 버튼이 클릭되었을 때의 동작
        }

        // "수량 체크" 버튼 생성
        JButton reloadButton = new JButton("수량 체크");
        reloadButton.setBackground(Color.BLACK);
        reloadButton.setForeground(Color.WHITE); // 글자색을 흰색으로 설정
        reloadButton.setBorder(new LineBorder(Color.BLACK, 2));
        reloadButton.setBounds(80, 620, 150, 30);
        jf.add(reloadButton);

        // "저장" 버튼 생성
        JButton saveButton = new JButton("저장");
        saveButton.setBackground(Color.ORANGE);
        saveButton.setBorder(new LineBorder(Color.ORANGE, 2));
        saveButton.setBounds(250, 620, 150, 30);
        jf.add(saveButton);

        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runApplication();
            }
        });

        // "저장" 버튼 클릭 처리
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 음료에 대해 현재 클릭 상태를 저장
                for (Component component : SellSoldOutSelect.getComponents()) {
                    if (component instanceof JButton) {
                        JButton button = (JButton) component;
                        if (button.getText().equals("판매")) {
                            if (button.getBorder() != null && button.getBorder().equals(BorderFactory.createLineBorder(Color.ORANGE, 2))) {
                                // "판매" 버튼이 선택된 상태
                                // 판매 상태 저장 처리
                                // 예를 들어, 해당 음료의 판매 상태를 데이터베이스에 저장하는 코드 작성
                            }
                        } else if (button.getText().equals("품절")) {
                            if (button.getBorder() != null && button.getBorder().equals(BorderFactory.createLineBorder(Color.ORANGE, 2))) {
                                // "품절" 버튼이 선택된 상태
                                // 품절 상태 저장 처리
                                // 예를 들어, 해당 음료의 품절 상태를 데이터베이스에 저장하는 코드 작성
                            }
                        }
                    }
                }
                // 저장 완료 메시지 혹은 처리 로직 추가 가능
            }
        });

        jf.setVisible(true);
    }

    // Helper method for button creation
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        if (label.equals("당류 함량")) {
            button.setBackground(Color.decode("#E8E8E8")); // 당류 함량 버튼의 배경색을 회색으로 설정
        } else {
            button.setBackground(Color.ORANGE); // 다른 버튼의 배경색을 주황색으로 설정
        }
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // 하얀색 얇은 테두리 설정
        return button;
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

    public static void runApplication() {
        // 데이터베이스 연결 및 데이터 조회 호출
        Scanner scanner = new Scanner(System.in);
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine(); // 비밀번호 입력 받기
        scanner.close();

        // 데이터 가져오기 및 GUI 표시
        data dataFetcher = new data();
        java.util.List<Product> products = dataFetcher.fetchData(password);

        // GUI 생성 및 데이터 표시
        SwingUtilities.invokeLater(() -> createAndShowPopup(products));

    }

    private static void createAndShowPopup(List<Product> products) {
        // 팝업 다이얼로그 생성
        JDialog dialog = new JDialog();
        dialog.setTitle("제품 정보");
        dialog.setModal(true); // 모달 다이얼로그로 설정 (다이얼로그 외의 부분 클릭 불가)
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(400, 300); // 다이얼로그 크기 설정

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 수직 박스 레이아웃 설정

        // 패널에 제품 데이터 추가
        for (Product product : products) {
            JLabel label = new JLabel("ID: " + product.getId() + ", 이름: " + product.getName() + ", 수량: " + product.getQuantity() + ", 가격: " + product.getPrice());
            panel.add(label);
        }

        // 패널을 다이얼로그에 추가
        dialog.add(new JScrollPane(panel)); // 스크롤 가능하도록 JScrollPane으로 감싸기

        // 다이얼로그를 화면 중앙에 위치시키기
        dialog.setLocationRelativeTo(null);

        // 다이얼로그를 화면에 표시
        dialog.setVisible(true);
    }
}
