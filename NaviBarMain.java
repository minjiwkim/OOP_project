// package org.example;

public class NaviBarMain {
    public static void main(String[] args) {
        CoffeeContentHome coffee = new CoffeeContentHome();
    }

    public static void navigateToNaviBar() {
        // NaviBar 화면 생성
        CoffeeContentHome coffee = new CoffeeContentHome("키오스크");
        coffee.setVisible(true);
    }
}