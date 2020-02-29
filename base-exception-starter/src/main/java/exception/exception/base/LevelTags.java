package exception.exception.base;

public enum LevelTags {
    TO_EVENT(0),
    TO_DB(1),
    IGNORE(2),
    EXTEND(3);
    private Integer levelCode;

    LevelTags(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

}
