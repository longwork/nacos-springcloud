package wimi.nacos.springboot.development.manual;

/**
 * @author Long
 * @date 13:31 2020-04-23 周四
 */
public enum SeasonEnum {
    /**
     * 春季
     */
    SPRING(1),
    /**
     * 夏季
     */
    SUMMER(2),
    /**
     * 秋季
     */
    AUTUMN(3),
    /**
     * 冬季
     */
    WINTER(4);

    private final int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }
}
