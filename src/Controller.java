import java.util.List;

public class Controller {
    private Cart cart = new Cart();
    private List<Menu> menuList = List.of(
            new Menu(1, "불고기버거", 4000, "버거", "맛있는 불고기버거입니다.", 2),
            new Menu(2, "치즈버거", 4000, "버거", "맛있는 치즈버거입니다.", 2),
            new Menu(3, "한우불고기버거", 4000, "버거", "맛있는 한우불고기버거입니다.", 2),
            new Menu(4, "감자튀김", 4000, "사이드메뉴", "맛있는 감자튀김.", 2));
    private Panel panel;

    void setPanel(Panel panel) {
        this.panel = panel;
    }

    void powerOn() {
        panel.printPowerOn();
    }

    void powerOff() {
        panel.printPowerOff();
    }

    int run() {
        int option = panel.printStartOption();
        switch (option) {
            case 1:
                startOrder();
                break;
            case 2:
                showCart();
                break;
            case 3:
                panel.print("결제하기 로직");
                break;
            case 4:
                powerOff();
                break;
        }
        return option;
    }

    private void startOrder() {
        panel.print("------메뉴판------");
        for (Menu menu: menuList) {
            panel.print(menu.showMenuInfo());
        }
        panel.print("----------------");

        while (true) {
            panel.print("[메뉴 담기] 어떤 메뉴를 담으시겠어요?\n담으려는 메뉴의 번호를 입력해주세요. 그만 담으려면 0을 눌러주세요.");
            int option = panel.getInput();
            if (option == 0) {
                break;
            } else if ((option <= menuList.size()) && (option > 0)) {
                Menu selectedMenu = menuList.get(option-1);
                if (selectedMenu.checkStock()) {
                    cart.addMenu(selectedMenu);
                    panel.print("✅ 상품을 정상적으로 담았습니다.");
                } else {
                    panel.print("❌ 죄송합니다. 해당 상품은 품절되었습니다.");
                }
            } else {
                panel.print("❌ 잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private void showCart(){
        StringBuilder cartList = cart.showCartInfo();
        panel.print("------------------------");
        panel.print(String.valueOf(cartList));
    }

}

