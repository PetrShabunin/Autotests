package work.home.data;

public enum MenuButtonsData {
    MAIN("Главная"), BONUSES("Бонусы");

    private final String desc;
    MenuButtonsData(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
}

