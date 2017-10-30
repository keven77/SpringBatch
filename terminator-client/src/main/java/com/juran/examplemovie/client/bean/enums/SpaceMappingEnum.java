package com.juran.examplemovie.client.bean.enums;

/**
 * 3D空间映射关系
 */
public enum SpaceMappingEnum {

    BATHROOM("卫生间", "BATHROOM", 13),
    BEDROOM("卧室", "BEDROOM", 5),
    DININGROOM("餐厅", "DININGROOM", 3),
    KIDSROOM("儿童房", "KIDSROOM", 6),
    KITCHEN("厨房", "KITCHEN", 12),
    LIVINGROOM("客厅", "LIVINGROOM", 2),
    OFFICE("办公室", "OFFICE", 31),

    OTHERROOM("其他房间", "OTHERROOM", 60),
    OUTDOORS("户外", "OUTDOORS", 33),
    PUBLICEXTERIOR("商用/公用室外区域", "PUBLICEXTERIOR", 34),
    PUBLICINTERIOR("商用/公用室内区域", "PUBLICINTERIOR", 35),
    RESIDENTIALEXTERIOR("住宅室外区域", "RESIDENTIALEXTERIOR", 36),
    ENTRANCEHALLWAY("入口和过厅", "ENTRANCEHALLWAY", 37),
    PRODUCTSHOWCASE("产品展示柜", "PRODUCTSHOWCASE", 38),
    FLOORPLAN("平面图", "FLOORPLAN", 39),
    STUDIO("工作室", "STUDIO", 40),
    BASEMENT("地下室", "BASEMENT", 41),

    HOMECINEMA("家庭影院", "HOMECINEMA", 42),
    LIBRARY("书房", "LIBRARY", 7),
    DEN("小房间", "DEN", 43),
    SKETCH("草图", "SKETCH", 44),
    LIVINGDININGROOM("客厅及餐厅", "LIVINGDININGROOM", 1),
    HALLWAY("门厅", "HALLWAY", 16),
    BALCONY("阳台", "BALCONY", 15),

    MASTERBEDROOM("主卧", "MASTERBEDROOM", 4),
    SECONDBEDROOM("次卧", "SECONDBEDROOM", 5),
    ELDERLYROOM("老人房", "ELDERLYROOM", 46),
    LOUNGE("休闲厅", "LOUNGE", 10),
    AUDITORIUM("影视厅", "AUDITORIUM", 11),
    NANNYROOM("保姆间", "NANNYROOM", 47),

    LAUNDRYROOM("洗衣间", "LAUNDRYROOM", 14),
    STORAGEROOM("储藏间", "STORAGEROOM", 9),
    CLOAKROOM("衣帽间", "CLOAKROOM", 8),
    MASTERBATHROOM("主卫", "MASTERBATHROOM", 48),
    SECONDBATHROOM("次卫", "SECONDBATHROOM", 49),
    STAIRWELL("楼梯间", "STAIRWELL", 17),

    AISLE("过道", "AISLE", 19),
    CORRIDOR("走廊", "CORRIDOR", 18),
    PORCHBALCONY("玄关和阳台", "PORCHBALCONY", 50),

    UNKNOW("其他", "UNKNOW", 60);

    private String designName;// 3d空间名称
    private String value;// 3d空间KEY
    private Integer sort;// 排序

    SpaceMappingEnum(String designName, String value, Integer sort) {
        this.designName = designName;
        this.value = value;
        this.sort = sort;
    }

    /**
     * 获取展示名称
     *
     * @param value
     * @return
     */
    public static String designName(String value) {
        for (SpaceMappingEnum en : SpaceMappingEnum.values()) {
            if (value.equalsIgnoreCase(en.getValue())) {
                return en.getDesignName();
            }
        }
        return UNKNOW.getDesignName();
    }

    /**
     * 通过value获取枚举
     *
     * @param value
     * @return
     */
    public static SpaceMappingEnum getEnumByValue(String value) {
        for (SpaceMappingEnum en : SpaceMappingEnum.values()) {
            if (value.equalsIgnoreCase(en.getValue())) {
                return en;
            }
        }
        return UNKNOW;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
